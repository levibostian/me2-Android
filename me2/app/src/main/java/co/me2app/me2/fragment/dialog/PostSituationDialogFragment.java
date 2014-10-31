package co.me2app.me2.fragment.dialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import co.me2app.me2.R;
import co.me2app.me2.view.ChooseCategory;

public class PostSituationDialogFragment extends DialogFragment {

    private PostSituationListener mListener;

    private EditText mSituation;
    private ChooseCategory mChooseCategory;
    private ImageView mPostSituation;

    public interface PostSituationListener {
        public void situationPosted(String situation, String category);
    }

    public static PostSituationDialogFragment newInstance() {
        PostSituationDialogFragment fragment = new PostSituationDialogFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setStyle(STYLE_NORMAL, R.style.AppTheme_PostSituationDialog);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post_situation_dialog, container, false);

        mSituation = (EditText) view.findViewById(R.id.situation);
        mChooseCategory = (ChooseCategory) view.findViewById(R.id.choose_category);
        mPostSituation = (ImageView) view.findViewById(R.id.post_button);

        mPostSituation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.situationPosted(mSituation.getText().toString(), mChooseCategory.getSelectedSituation());

                getDialog().cancel();
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    public void setPostSituationListener(PostSituationListener listener) {
        mListener = listener;
    }

}
