package com.brightspotinnovations.me2.fragment.dialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.brightspotinnovations.me2.R;
import com.brightspotinnovations.me2.vo.Me2Choices;

public class Me2ChooserDialogFragment extends DialogFragment {

    private Me2ChooserListener mListener;

    public interface Me2ChooserListener {
        public void me2Chosen(String me2message);
    }

    public static Me2ChooserDialogFragment newInstance() {
        Me2ChooserDialogFragment fragment = new Me2ChooserDialogFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        getDialog().setTitle(getString(R.string.how_do_you_relate));
        View view = inflater.inflate(R.layout.fragment_me2_chooser_dialog, container);

        ListView me2Chooser = (ListView) view.findViewById(R.id.me_2_chooser);

        ArrayAdapter<String> me2ChoicesAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Me2Choices.getMe2Choices());
        me2Chooser.setAdapter(me2ChoicesAdapter);
        me2Chooser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                mListener.me2Chosen(Me2Choices.getMe2Choices().get(pos));

                getDialog().cancel();
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getDialog().getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    public void setMe2ChooserListener(Me2ChooserListener listener) {
        mListener = listener;
    }

}
