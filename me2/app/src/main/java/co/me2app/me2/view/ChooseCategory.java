package co.me2app.me2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Spinner;
import co.me2app.me2.R;

public class ChooseCategory extends FrameLayout {

    private static final int DEFAULT_SITUATION_POSITION = 0;

    private Spinner mCategorySpinner;

    private int mCurrentSelectedPosition;

    public ChooseCategory(Context context) {
        this(context, null);
    }

    public ChooseCategory(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ChooseCategory(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        initialize(context, attrs, defStyle);
    }

    private void initialize(Context context, AttributeSet attrs, int defStyle) {
        LayoutInflater.from(context).inflate(R.layout.view_choose_category, this, true);

        mCategorySpinner = (Spinner) findViewById(R.id.category_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mCategorySpinner.setAdapter(adapter);
        mCategorySpinner.setSelection(DEFAULT_SITUATION_POSITION);

        mCategorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                mCurrentSelectedPosition = pos;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    public String getSelectedSituation() {
        String[] categories = getResources().getStringArray(R.array.categories);

        return categories[mCurrentSelectedPosition];
    }
}
