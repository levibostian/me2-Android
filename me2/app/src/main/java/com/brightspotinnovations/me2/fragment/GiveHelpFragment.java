package com.brightspotinnovations.me2.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.brightspotinnovations.me2.R;
import com.brightspotinnovations.me2.adapter.GiveHelpListViewAdapter;
import com.brightspotinnovations.me2.fragment.dialog.GiveHelpDetailsDialogFragment;
import com.brightspotinnovations.me2.fragment.dialog.LoveChooserDialogFragment;
import com.brightspotinnovations.me2.fragment.dialog.Me2ChooserDialogFragment;
import com.brightspotinnovations.me2.vo.MockSituationVos;
import com.brightspotinnovations.me2.vo.SituationVo;

import java.util.ArrayList;

public class GiveHelpFragment extends Fragment implements GiveHelpListViewAdapter.GiveHelpListListener, GiveHelpDetailsDialogFragment.GiveHelpDetailsListener {

    private static final String DETAILS_DIALOG_TAG = "giveHelpFragment.detailsDialogTag";

    private ListView mHelpList;
    private GiveHelpListViewAdapter mListAdapter;

    private GiveHelpDetailsDialogFragment mDetailsFragment;

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
        mListAdapter.setGiveHelpListListener(this);
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

                mDetailsFragment = GiveHelpDetailsDialogFragment.newInstance(mHelpData.get(position));
                mDetailsFragment.setGiveHelpDetailsListener(GiveHelpFragment.this);

                mDetailsFragment.show(transaction, DETAILS_DIALOG_TAG);
            }
        });
        mHelpList.setAdapter(mListAdapter);
    }

    @Override
    public void me2ButtonClicked() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        Fragment previous = getFragmentManager().findFragmentByTag(DETAILS_DIALOG_TAG);

        if (previous != null) {
            transaction.remove(previous);
        }
        transaction.addToBackStack(null);

        final Me2ChooserDialogFragment me2ChooserDialogFragment = Me2ChooserDialogFragment.newInstance();
        me2ChooserDialogFragment.setMe2ChooserListener(new Me2ChooserDialogFragment.Me2ChooserListener() {
            @Override
            public void me2Chosen(String me2message) {
                Toast.makeText(getActivity(), R.string.me2_sent, Toast.LENGTH_LONG).show();
            }
        });

        me2ChooserDialogFragment.show(transaction, DETAILS_DIALOG_TAG);
    }

    @Override
    public void loveButtonClicked() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        Fragment previous = getFragmentManager().findFragmentByTag(DETAILS_DIALOG_TAG);

        if (previous != null) {
            transaction.remove(previous);
        }
        transaction.addToBackStack(null);

        final LoveChooserDialogFragment loveChooserDialogFragment = LoveChooserDialogFragment.newInstance();
        loveChooserDialogFragment.setLoveChooserListener(new LoveChooserDialogFragment.LoveChooserListener() {
            @Override
            public void loveChosen(String loveMessage) {
                Toast.makeText(getActivity(), R.string.love_sent, Toast.LENGTH_LONG).show();
            }
        });

        loveChooserDialogFragment.show(transaction, DETAILS_DIALOG_TAG);
    }
}
