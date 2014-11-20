package com.brightspotinnovations.me2.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.brightspotinnovations.me2.R;
import com.brightspotinnovations.me2.adapter.HotlineFragmentAdapter;
import com.brightspotinnovations.me2.vo.HotlineVo;
import com.brightspotinnovations.me2.vo.MockHotlineVos;

import java.util.ArrayList;

public class HotlineFragment extends Fragment {

    private ArrayList<HotlineVo> mHotlineData;

    public static HotlineFragment newInstance() {
        HotlineFragment fragment = new HotlineFragment();
        return fragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_support, container, false);

        mHotlineData = MockHotlineVos.getHotlines();

        ListView hotlineList = (ListView) rootView.findViewById(R.id.hotline_list);
        hotlineList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String website = mHotlineData.get(position).website;
                long phoneNumber = mHotlineData.get(position).phone;

                if (website != null && !website.equals("")) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(mHotlineData.get(position).website));
                    startActivity(intent);
                } else if (phoneNumber > 0) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"+phoneNumber));
                    startActivity(intent);
                } else {
                    Toast.makeText(getActivity(), R.string.hotline_not_available, Toast.LENGTH_LONG).show();
                }
            }
        });
        HotlineFragmentAdapter adapter = new HotlineFragmentAdapter(getActivity(), R.layout.hotline_fragment_row, mHotlineData);
        hotlineList.setAdapter(adapter);
        adapter.setHotlineFragmentListener(new HotlineFragmentAdapter.HotlineFragmentListener() {
            @Override
            public void phoneIconSelected(long phoneNumber) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+phoneNumber));
                startActivity(intent);
            }

            @Override
            public void websiteLinkSelected(String website) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(website));
                startActivity(intent);
            }
        });

        return rootView;
    }
}
