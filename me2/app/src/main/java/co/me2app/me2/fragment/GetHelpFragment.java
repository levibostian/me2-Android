package co.me2app.me2.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import co.me2app.me2.R;
import co.me2app.me2.adapter.GetHelpListViewAdapter;
import co.me2app.me2.fragment.dialog.PostSituationDialogFragment;
import co.me2app.me2.vo.MockSupportVos;
import co.me2app.me2.vo.SupportVo;

import java.util.ArrayList;

public class GetHelpFragment extends Fragment {

    private static final String DETAILS_DIALOG_TAG = "getHelpFragment.detailsDialogTag";

    private ListView mHelpList;
    private ImageView mPostSituation;
    private GetHelpListViewAdapter mListAdapter;

    private ArrayList<SupportVo> mHelpData;

    public static GetHelpFragment newInstance() {
        GetHelpFragment fragment = new GetHelpFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mHelpData = new ArrayList<SupportVo>();
        mHelpData.add(MockSupportVos.getSupport1());
        mHelpData.add(MockSupportVos.getSupport2());
        mHelpData.add(MockSupportVos.getSupport3());
        mHelpData.add(MockSupportVos.getSupport4());
        mHelpData.add(MockSupportVos.getSupport5());

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
        mPostSituation = (ImageView) view.findViewById(R.id.update_situation);

        mHelpList.setAdapter(mListAdapter);
        mPostSituation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPostSituationPrompt();
            }
        });
    }

    private void showPostSituationPrompt() {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
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

}
