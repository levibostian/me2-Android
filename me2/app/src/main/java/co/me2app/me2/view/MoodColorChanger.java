package co.me2app.me2.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import co.me2app.me2.R;

public class MoodColorChanger extends RelativeLayout {

    private ImageView mMoodColorImageView;
    private TextView mMoodDefinition;

    private int mMoodColor;

    private MoodColorSelectedListener mListener;

    public interface MoodColorSelectedListener {
        public void onMoodColorSelected(int color);
    }

    public MoodColorChanger(Context context) {
        this(context, null);
    }

    public MoodColorChanger(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MoodColorChanger(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        initialize(context, attrs, defStyle);
    }

    public void setMoodColorSelectedListener(MoodColorSelectedListener listener) {
        mListener = listener;
    }

    private void initialize(Context context, AttributeSet attrs, int defStyle) {
        LayoutInflater.from(context).inflate(R.layout.view_mood_color_changer, this, true);

        mMoodColorImageView = (ImageView) findViewById(R.id.mood_color);
        mMoodDefinition = (TextView) findViewById(R.id.mood_definition);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MoodColorChanger);

        mMoodColor = typedArray.getColor(R.styleable.MoodColorChanger_mood_color, android.R.color.white);

        mMoodColorImageView.setBackgroundColor(mMoodColor);
        mMoodDefinition.setText(typedArray.getString(R.styleable.MoodColorChanger_mood_definition));

        typedArray.recycle();

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onMoodColorSelected(mMoodColor);
            }
        });
    }

}
