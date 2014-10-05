package co.me2app.me2.fragment.dialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import co.me2app.me2.R;
import co.me2app.me2.vo.SituationVo;

public class GiveHelpDetailsDialogFragment extends DialogFragment {

    private static final String NEED_HELP_KEY = "giveHelpDetailsDialogFragment.needHelpKey";

    private SituationVo mNeedHelpData;

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
        ImageView statusColor = (ImageView) view.findViewById(R.id.status_color);
        TextView username = (TextView) view.findViewById(R.id.username);
        TextView struggle = (TextView) view.findViewById(R.id.struggle);
        TextView date = (TextView) view.findViewById(R.id.date);
        ImageView userGender = (ImageView) view.findViewById(R.id.user_gender);
        ImageView locationMarker = (ImageView) view.findViewById(R.id.location_marker);
        TextView location = (TextView) view.findViewById(R.id.location);
        Button me2button = (Button) view.findViewById(R.id.me_2_button);
        Button loveButton = (Button) view.findViewById(R.id.love_button);
        final EditText comment = (EditText) view.findViewById(R.id.comment);
        Button sendComment = (Button) view.findViewById(R.id.send_comment);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().cancel();
            }
        });
        statusColor.setBackgroundColor(getActivity().getResources().getColor(mNeedHelpData.statusColor));
        username.setText(mNeedHelpData.username);
        date.setText(mNeedHelpData.date);
        struggle.setText(mNeedHelpData.situation);
        locationMarker.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.ic_action_place));
        userGender.setImageDrawable(getActivity().getResources().getDrawable(mNeedHelpData.userGender));
        location.setText(mNeedHelpData.location);
        me2button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "me2", Toast.LENGTH_SHORT).show();
            }
        });
        loveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "love", Toast.LENGTH_SHORT).show();
            }
        });
        sendComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), comment.getText(), Toast.LENGTH_SHORT).show();
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
