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
import co.me2app.me2.fragment.dialog.PostSituationDialogFragment;
import co.me2app.me2.vo.SupportVo;

import java.util.ArrayList;

public class GetHelpFragment extends Fragment implements MoodColorChooseDialogFragment.MoodColorChooserListener {

    private static final String MOOD_COLOR_CHANGE_TAG = "getHelpFragment.moodColorChangeTag";
    private static final String DETAILS_DIALOG_TAG = "getHelpFragment.detailsDialogTag";

    private ListView mHelpList;
    private ImageView mMoodStatus;
    private Button mPostSituation;
    private GetHelpListViewAdapter mListAdapter;

    private int mCurrentMoodColor;

    private ArrayList<SupportVo> mHelpData;

    public static GetHelpFragment newInstance() {
        GetHelpFragment fragment = new GetHelpFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCurrentMoodColor = getResources().getColor(android.R.color.holo_green_light);

        mHelpData = new ArrayList<SupportVo>();
        mHelpData.add(new SupportVo());
        mHelpData.add(new SupportVo());
        mHelpData.add(new SupportVo());

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
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        Fragment previous = getFragmentManager().findFragmentByTag(DETAILS_DIALOG_TAG);

        if (previous != null) {
            transaction.remove(previous);
        }
        transaction.addToBackStack(null);

        PostSituationDialogFragment detailsDialog = PostSituationDialogFragment.newInstance();
        detailsDialog.setPostSituationListener(new PostSituationDialogFragment.PostSituationListener() {
            @Override
            public void situationPosted(String situation, String category) {
                // TODO change all of this depending on if user wants to update their situation or post new.
                Toast.makeText(getActivity(), getString(R.string.situation_posted), Toast.LENGTH_LONG).show();
            }
        });
        detailsDialog.show(transaction, DETAILS_DIALOG_TAG);
    }

    @Override
    public void moodColorSelected(int color) {
        mCurrentMoodColor = color;

        setCurrentColorMood();
    }
}
