package co.me2app.me2.fragment.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import co.me2app.me2.R;
import co.me2app.me2.enums.Mood;
import co.me2app.me2.view.ChooseCategory;
import co.me2app.me2.view.MoodColorChanger;

public class PostSituationDialogFragment extends DialogFragment implements MoodColorChooseDialogFragment.MoodColorChooserListener {

    private static final String MOOD_COLOR_CHANGE_TAG = "postSituationDialogFragment.moodColorChangeTag";
    private static final Mood DEFAULT_MOOD = Mood.AVERAGE;

    private PostSituationListener mListener;

    private Mood mCurrentMood;

    private ImageView mUpButton;
    private EditText mSituation;
    private ChooseCategory mChooseCategory;
    private MoodColorChanger mMoodStatus;
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
        ((InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE)).toggleSoftInput(InputMethodManager.SHOW_FORCED,
                                                                                                            InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    @Override
    public void onPause() {
        super.onPause();

        ((InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(mSituation.getWindowToken(), 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post_situation_dialog, container, true);

        mUpButton = (ImageView) view.findViewById(R.id.up_button);
        mSituation = (EditText) view.findViewById(R.id.situation);
        mChooseCategory = (ChooseCategory) view.findViewById(R.id.choose_category);
        mMoodStatus = (MoodColorChanger) view.findViewById(R.id.mood_status);
        mPostSituation = (ImageView) view.findViewById(R.id.post_button);

        mSituation.requestFocus();
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        mUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(mSituation.getWindowToken(), 0);
                getDialog().cancel();
            }
        });
        mMoodStatus.setMood(DEFAULT_MOOD);
        mMoodStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(mSituation.getWindowToken(), 0);
                showMoodChangeDialog();
            }
        });
        mPostSituation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.situationPosted(mSituation.getText().toString(), mChooseCategory.getSelectedSituation());

                ((InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(mSituation.getWindowToken(), 0);
                getDialog().cancel();
            }
        });

        return view;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().getAttributes().windowAnimations = R.style.PostSituationDialogAnimation;
        return dialog;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    @Override
    public void onStart() {
        super.onStart();

        getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    private void showMoodChangeDialog() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        Fragment previous = getFragmentManager().findFragmentByTag(MOOD_COLOR_CHANGE_TAG);

        if (previous != null) {
            transaction.remove(previous);
        }
        transaction.addToBackStack(null);

        MoodColorChooseDialogFragment moodColorChooserDialog = MoodColorChooseDialogFragment.newInstance(mCurrentMood);
        moodColorChooserDialog.setMoodColorChooserListener(this);

        moodColorChooserDialog.show(transaction, MOOD_COLOR_CHANGE_TAG);
    }

    @Override
    public void moodColorSelected(Mood mood) {
        mCurrentMood = mood;

        mMoodStatus.setMood(mood);
    }

    public void setPostSituationListener(PostSituationListener listener) {
        mListener = listener;
    }

}
