package co.me2app.me2.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import co.me2app.me2.R;
import co.me2app.me2.enums.Mood;

public class MoodColorChanger extends RelativeLayout {

    private ImageView mMoodColorImageView;

    private Mood mMood;

    private MoodColorSelectedListener mListener;

    public interface MoodColorSelectedListener {
        public void onMoodColorSelected(Mood mood);
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

    public void setMood(Mood mood) {
        mMood = mood;

        populateView();
    }

    public void setMoodColorSelectedListener(MoodColorSelectedListener listener) {
        mListener = listener;

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onMoodColorSelected(mMood);
            }
        });
    }

    private void populateView() {
        if (mMood == null) {
            throw new IllegalStateException("You did not set mood.");
        }

        mMoodColorImageView.setBackgroundColor(mMood.accept(new Mood.Visitor<Integer>() {
            @Override
            public Integer visitAwesome() {
                return getResources().getColor(R.color.awesome);
            }

            @Override
            public Integer visitGood() {
                return getResources().getColor(R.color.good);
            }

            @Override
            public Integer visitAverage() {
                return getResources().getColor(R.color.average);
            }

            @Override
            public Integer visitLoving() {
                return getResources().getColor(R.color.loving);
            }

            @Override
            public Integer visitSad() {
                return getResources().getColor(R.color.sad);
            }

            @Override
            public Integer visitLonely() {
                return getResources().getColor(R.color.lonely);
            }

            @Override
            public Integer visitScared() {
                return getResources().getColor(R.color.scared);
            }

            @Override
            public Integer visitHurt() {
                return getResources().getColor(R.color.hurt);
            }

            @Override
            public Integer visitAngry() {
                return getResources().getColor(R.color.angry);
            }
        }));

        mMoodColorImageView.setImageDrawable(mMood.accept(new Mood.Visitor<Drawable>() {
            @Override
            public Drawable visitAwesome() {
                return getResources().getDrawable(R.drawable.awesome);
            }

            @Override
            public Drawable visitGood() {
                return getResources().getDrawable(R.drawable.good);
            }

            @Override
            public Drawable visitAverage() {
                return getResources().getDrawable(R.drawable.average);
            }

            @Override
            public Drawable visitLoving() {
                return getResources().getDrawable(R.drawable.loving);
            }

            @Override
            public Drawable visitSad() {
                return getResources().getDrawable(R.drawable.sad);
            }

            @Override
            public Drawable visitLonely() {
                return getResources().getDrawable(R.drawable.lonely);
            }

            @Override
            public Drawable visitScared() {
                return getResources().getDrawable(R.drawable.scared);
            }

            @Override
            public Drawable visitHurt() {
                return getResources().getDrawable(R.drawable.hurt);
            }

            @Override
            public Drawable visitAngry() {
                return getResources().getDrawable(R.drawable.angry);
            }
        }));
    }

    private void initialize(Context context, AttributeSet attrs, int defStyle) {
        LayoutInflater.from(context).inflate(R.layout.view_mood_color_changer, this, true);

        mMoodColorImageView = (ImageView) findViewById(R.id.mood_color);
    }

}
