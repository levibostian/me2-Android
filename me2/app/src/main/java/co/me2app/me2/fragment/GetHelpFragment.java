package co.me2app.me2.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import co.me2app.me2.R;
import co.me2app.me2.adapter.GetHelpListViewAdapter;
import co.me2app.me2.vo.NeedHelpVo;

import java.util.ArrayList;

public class GetHelpFragment extends Fragment {

    private ListView mHelpList;
    private GetHelpListViewAdapter mListAdapter;

    private ArrayList<NeedHelpVo> mHelpData;

    public static GetHelpFragment newInstance() {
        GetHelpFragment fragment = new GetHelpFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        mHelpList.setAdapter(mListAdapter);
    }
}