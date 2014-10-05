package co.me2app.me2.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import co.me2app.me2.R;
import co.me2app.me2.adapter.GetHelpListViewAdapter;
import co.me2app.me2.fragment.dialog.MoodColorChooseDialogFragment;
import co.me2app.me2.vo.NeedHelpVo;

import java.util.ArrayList;

public class GetHelpFragment extends Fragment implements MoodColorChooseDialogFragment.MoodColorChooserListener {

    private static final String MOOD_COLOR_CHANGE_TAG = "getHelpFragment.moodColorChangeTag";

    private ListView mHelpList;
    private ImageView mMoodStatus;
    private Button mPostSituation;
    private GetHelpListViewAdapter mListAdapter;

    private int mCurrentMoodColor;

    private ArrayList<NeedHelpVo> mHelpData;

    public static GetHelpFragment newInstance() {
        GetHelpFragment fragment = new GetHelpFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCurrentMoodColor = getResources().getColor(android.R.color.holo_green_light);

        mHelpData = new ArrayList<NeedHelpVo>();
        mHelpData.add(new NeedHelpVo());
        mHelpData.add(new NeedHelpVo());
        mHelpData.add(new NeedHelpVo());

        mListAdapter = new GetHelpListViewAdapter(getActivity(), R.layout.get_help_row_layout, mHelpData);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_get_help, container, false);
        setupViews(rootView);

        return rootView;
    }

    private void setupViews(View view) {
        mHelpList = (ListView) view.findViewById(R.id.get_help_list);
        mMoodStatus = (ImageView) view.findViewById(R.id.mood_status);
        mPostSituation = (Button) view.findViewById(R.id.update_situation);

        mHelpList.setAdapter(mListAdapter);
        setCurrentColorMood();
        mMoodStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMoodChangeDialog();
            }
        });
        mPostSituation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPostSituationPrompt();
            }
        });
    }

    private void setCurrentColorMood() {
        mMoodStatus.setBackgroundColor(mCurrentMoodColor);
    }

    private void showMoodChangeDialog() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        Fragment previous = getFragmentManager().findFragmentByTag(MOOD_COLOR_CHANGE_TAG);

        if (previous != null) {
            transaction.remove(previous);
        }
        transaction.addToBackStack(null);

        MoodColorChooseDialogFragment moodColorChooserDialog = MoodColorChooseDialogFragment.newInstance(mCurrentMoodColor);
        moodColorChooserDialog.setMoodColorChooserListener(this);

        moodColorChooserDialog.show(transaction, MOOD_COLOR_CHANGE_TAG);
    }

    private void showPostSituationPrompt() {
        Toast.makeText(getActivity(), "post", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void moodColorSelected(int color) {
        mCurrentMoodColor = color;

        setCurrentColorMood();
    }
}
