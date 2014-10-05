package co.me2app.me2.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import co.me2app.me2.R;

public class GetHelpFragment extends Fragment {

    public static GetHelpFragment newInstance() {
        GetHelpFragment fragment = new GetHelpFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_get_help, container, false);
        return rootView;
    }
}
