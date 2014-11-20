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
import com.brightspotinnovations.me2.vo.LoveChoices;

public class LoveChooserDialogFragment extends DialogFragment {

    private LoveChooserListener mListener;

    public interface LoveChooserListener {
        public void loveChosen(String loveMessage);
    }

    public static LoveChooserDialogFragment newInstance() {
        LoveChooserDialogFragment fragment = new LoveChooserDialogFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        getDialog().setTitle(getString(R.string.how_can_you_help));
        View view = inflater.inflate(R.layout.fragment_love_chooser_dialog, container);

        ListView loveChooser = (ListView) view.findViewById(R.id.love_chooser);

        ArrayAdapter<String> loveChoicesAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, LoveChoices.getLoveChoices());
        loveChooser.setAdapter(loveChoicesAdapter);
        loveChooser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                mListener.loveChosen(LoveChoices.getLoveChoices().get(pos));

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

    public void setLoveChooserListener(LoveChooserListener listener) {
        mListener = listener;
    }
}
