package co.me2app.me2.fragment;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import co.me2app.me2.R;
import co.me2app.me2.adapter.GiveHelpListViewAdapter;
import co.me2app.me2.fragment.dialog.GiveHelpDetailsDialogFragment;
import co.me2app.me2.vo.MockSituationVos;
import co.me2app.me2.vo.SituationVo;

import java.util.ArrayList;

public class GiveHelpFragment extends Fragment {

    private static final String DETAILS_DIALOG_TAG = "giveHelpFragment.detailsDialogTag";

    private ListView mHelpList;
    private GiveHelpListViewAdapter mListAdapter;

    private ArrayList<SituationVo> mHelpData;

    public static GiveHelpFragment newInstance() {
        GiveHelpFragment fragment = new GiveHelpFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mHelpData = new ArrayList<SituationVo>();
        mHelpData.add(MockSituationVos.getSituation1());
        mHelpData.add(MockSituationVos.getSituation2());
        mHelpData.add(MockSituationVos.getSituation3());
        mHelpData.add(MockSituationVos.getSituation4());
        mHelpData.add(MockSituationVos.getSituation5());

        mListAdapter = new GiveHelpListViewAdapter(getActivity(), R.layout.give_help_row_layout, mHelpData);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_give_help, container, false);
        setupViews(rootView);

        return rootView;
    }

    private void setupViews(View view) {
        mHelpList = (ListView) view.findViewById(R.id.give_help_list);
        mHelpList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                Fragment previous = getFragmentManager().findFragmentByTag(DETAILS_DIALOG_TAG);

                if (previous != null) {
                    transaction.remove(previous);
                }
                transaction.addToBackStack(null);

                DialogFragment detailsDialog = GiveHelpDetailsDialogFragment.newInstance(mHelpData.get(position));
                detailsDialog.show(transaction, DETAILS_DIALOG_TAG);
            }
        });
        mHelpList.setAdapter(mListAdapter);
    }

}
