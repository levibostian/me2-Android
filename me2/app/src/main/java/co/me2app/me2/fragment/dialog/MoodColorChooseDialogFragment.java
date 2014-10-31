package co.me2app.me2.fragment.dialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import co.me2app.me2.R;
import co.me2app.me2.enums.Mood;
import co.me2app.me2.view.MoodColorChanger;

import java.io.Serializable;

public class MoodColorChooseDialogFragment extends DialogFragment implements MoodColorChanger.MoodColorSelectedListener {

    private static final String MOOD_KEY = "giveHelpDetailsDialogFragment.moodKey";

    private MoodColorChooserListener mListener;

    private Serializable mCurrentMood;

    public interface MoodColorChooserListener {
        public void moodColorSelected(Mood mood);
    }

    public static MoodColorChooseDialogFragment newInstance(Mood currentMood) {
        MoodColorChooseDialogFragment fragment = new MoodColorChooseDialogFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable(MOOD_KEY, currentMood);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCurrentMood = getArguments().getSerializable(MOOD_KEY);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        getDialog().setTitle(getString(R.string.set_mood));
        View view = inflater.inflate(R.layout.fragment_mood_color_change_dialog, container);

        final MoodColorChanger orange = (MoodColorChanger) view.findViewById(R.id.orange);
        final MoodColorChanger yellow = (MoodColorChanger) view.findViewById(R.id.yellow);
        final MoodColorChanger green = (MoodColorChanger) view.findViewById(R.id.green);
        final MoodColorChanger pink = (MoodColorChanger) view.findViewById(R.id.pink);
        final MoodColorChanger blue = (MoodColorChanger) view.findViewById(R.id.blue);
        final MoodColorChanger gray = (MoodColorChanger) view.findViewById(R.id.gray);
        final MoodColorChanger purple = (MoodColorChanger) view.findViewById(R.id.purple);
        final MoodColorChanger black = (MoodColorChanger) view.findViewById(R.id.black);
        final MoodColorChanger red = (MoodColorChanger) view.findViewById(R.id.red);

        orange.setMood(Mood.AWESOME);
        yellow.setMood(Mood.GOOD);
        green.setMood(Mood.AVERAGE);
        pink.setMood(Mood.LOVING);
        blue.setMood(Mood.SAD);
        gray.setMood(Mood.LONELY);
        purple.setMood(Mood.FEAR);
        black.setMood(Mood.HURT);
        red.setMood(Mood.ANGRY);

        orange.setMoodColorSelectedListener(this);
        yellow.setMoodColorSelectedListener(this);
        green.setMoodColorSelectedListener(this);
        pink.setMoodColorSelectedListener(this);
        blue.setMoodColorSelectedListener(this);
        gray.setMoodColorSelectedListener(this);
        purple.setMoodColorSelectedListener(this);
        black.setMoodColorSelectedListener(this);
        red.setMoodColorSelectedListener(this);

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
    public void onMoodColorSelected(Mood mood) {
        mCurrentMood = mood;

        mListener.moodColorSelected(mood);

        getDialog().cancel();
    }
}
