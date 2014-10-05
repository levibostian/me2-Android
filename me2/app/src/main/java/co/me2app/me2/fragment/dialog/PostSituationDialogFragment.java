package co.me2app.me2.fragment.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import co.me2app.me2.R;
import co.me2app.me2.util.KeyboardUtil;
import co.me2app.me2.view.ChooseCategory;

public class PostSituationDialogFragment extends DialogFragment {

    private PostSituationListener mListener;

    private EditText mSituation;
    private ChooseCategory mChooseCategory;
    private Button mPostSituation;

    public interface PostSituationListener {
        public void situationPosted(String situation, String category);
    }

    public static PostSituationDialogFragment newInstance() {
        PostSituationDialogFragment fragment = new PostSituationDialogFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        getDialog().setTitle(getString(R.string.post_situation));
        View view = inflater.inflate(R.layout.fragment_post_situation_dialog, container);

        mSituation = (EditText) view.findViewById(R.id.situation);
        mChooseCategory = (ChooseCategory) view.findViewById(R.id.choose_category);
        mPostSituation = (Button) view.findViewById(R.id.post_button);

        mPostSituation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.situationPosted(mSituation.getText().toString(), mChooseCategory.getSelectedSituation());

                KeyboardUtil.closeKeyboard(getActivity(), mSituation);
                getDialog().cancel();
            }
        });

        KeyboardUtil.openKeyboard(getActivity());

        return view;
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        KeyboardUtil.closeKeyboard(getActivity(), mSituation);

        super.onCancel(dialog);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getDialog().getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    public void setPostSituationListener(PostSituationListener listener) {
        mListener = listener;
    }

}
