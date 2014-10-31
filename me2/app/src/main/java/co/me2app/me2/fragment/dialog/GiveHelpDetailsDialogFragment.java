package co.me2app.me2.fragment.dialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import co.me2app.me2.R;
import co.me2app.me2.view.MoodColorChanger;
import co.me2app.me2.vo.SituationVo;

public class GiveHelpDetailsDialogFragment extends DialogFragment {

    private static final String NEED_HELP_KEY = "giveHelpDetailsDialogFragment.needHelpKey";

    private SituationVo mNeedHelpData;

    private GiveHelpDetailsListener mListener;

    public interface GiveHelpDetailsListener {
        public void me2ButtonClicked();
        public void loveButtonClicked();
    }

    public void setGiveHelpDetailsListener(GiveHelpDetailsListener listener) {
        mListener = listener;
    }

    public static GiveHelpDetailsDialogFragment newInstance(SituationVo needHelpData) {
        GiveHelpDetailsDialogFragment fragment = new GiveHelpDetailsDialogFragment();

        Bundle bundle = new Bundle();
        bundle.putParcelable(NEED_HELP_KEY, needHelpData);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mNeedHelpData = getArguments().getParcelable(NEED_HELP_KEY);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        View view = inflater.inflate(R.layout.fragment_get_help_details_dialog, container);

        final ImageView close = (ImageView) view.findViewById(R.id.close);
        MoodColorChanger statusColor = (MoodColorChanger) view.findViewById(R.id.status_color);
        TextView username = (TextView) view.findViewById(R.id.username);
        TextView struggle = (TextView) view.findViewById(R.id.struggle);
        TextView date = (TextView) view.findViewById(R.id.date);
        ImageView userGender = (ImageView) view.findViewById(R.id.user_gender);
        ImageView locationMarker = (ImageView) view.findViewById(R.id.location_marker);
        TextView location = (TextView) view.findViewById(R.id.location);
        ImageView me2button = (ImageView) view.findViewById(R.id.me_2_button);
        ImageView loveButton = (ImageView) view.findViewById(R.id.love_button);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().cancel();
            }
        });
        statusColor.setMood(mNeedHelpData.mood);
        username.setText(mNeedHelpData.username);
        date.setText(mNeedHelpData.date);
        struggle.setText(mNeedHelpData.situation);
        locationMarker.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.ic_action_place));
        userGender.setImageDrawable(getActivity().getResources().getDrawable(mNeedHelpData.userGender));
        location.setText(mNeedHelpData.location);
        me2button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.me2ButtonClicked();
            }
        });
        loveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.loveButtonClicked();
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getDialog().getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }
}
