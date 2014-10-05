package co.me2app.me2.fragment.dialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import co.me2app.me2.R;
import co.me2app.me2.view.MoodColorChanger;

public class MoodColorChooseDialogFragment extends DialogFragment implements MoodColorChanger.MoodColorSelectedListener {

    private static final String MOOD_KEY = "giveHelpDetailsDialogFragment.moodKey";

    private MoodColorChooserListener mListener;

    private int mCurrentMood;

    public interface MoodColorChooserListener {
        public void moodColorSelected(int color);
    }

    public static MoodColorChooseDialogFragment newInstance(int currentMood) {
        MoodColorChooseDialogFragment fragment = new MoodColorChooseDialogFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(MOOD_KEY, currentMood);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCurrentMood = getArguments().getInt(MOOD_KEY);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        getDialog().setTitle(getString(R.string.set_mood));
        View view = inflater.inflate(R.layout.fragment_mood_color_change_dialog, container);

        final MoodColorChanger green = (MoodColorChanger) view.findViewById(R.id.green);

        green.setMoodColorSelectedListener(this);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getDialog().getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    public void setMoodColorChooserListener(MoodColorChooserListener listener) {
        mListener = listener;
    }

    @Override
    public void onMoodColorSelected(int color) {
        mCurrentMood = color;

        mListener.moodColorSelected(color);

        getDialog().cancel();
    }
}
