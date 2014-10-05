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
import co.me2app.me2.adapter.NeedsHelpListViewAdapter;
import co.me2app.me2.fragment.dialog.GiveHelpDetailsDialogFragment;
import co.me2app.me2.vo.NeedHelpVo;

import java.util.ArrayList;

public class GiveHelpFragment extends Fragment {

    private static final String DETAILS_DIALOG_TAG = "giveHelpFragment.detailsDialogTag";

    private ListView mNeedsHelpList;
    private NeedsHelpListViewAdapter mNeedsHelpListAdapter;

    private ArrayList<NeedHelpVo> mNeedsHelpData;

    public static GiveHelpFragment newInstance() {
        GiveHelpFragment fragment = new GiveHelpFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mNeedsHelpData = new ArrayList<NeedHelpVo>();
        mNeedsHelpData.add(new NeedHelpVo());
        mNeedsHelpData.add(new NeedHelpVo());
        mNeedsHelpData.add(new NeedHelpVo());

        mNeedsHelpListAdapter = new NeedsHelpListViewAdapter(getActivity(), R.layout.need_help_row_layout, mNeedsHelpData);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_send_help, container, false);
        setupViews(rootView);

        return rootView;
    }

    private void setupViews(View view) {
        mNeedsHelpList = (ListView) view.findViewById(R.id.need_help_list);
        mNeedsHelpList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                Fragment previous = getFragmentManager().findFragmentByTag(DETAILS_DIALOG_TAG);

                if (previous != null) {
                    transaction.remove(previous);
                }
                transaction.addToBackStack(null);

                DialogFragment detailsDialog = GiveHelpDetailsDialogFragment.newInstance(mNeedsHelpData.get(position));
                detailsDialog.show(transaction, DETAILS_DIALOG_TAG);
            }
        });
        mNeedsHelpList.setAdapter(mNeedsHelpListAdapter);
    }

}
