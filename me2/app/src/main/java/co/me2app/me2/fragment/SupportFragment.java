package co.me2app.me2.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import co.me2app.me2.R;

public class SupportFragment extends Fragment {

    public static SupportFragment newInstance() {
        SupportFragment fragment = new SupportFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_support, container, false);
        return rootView;
    }
}
