package com.brightspotinnovations.me2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.brightspotinnovations.me2.R;
import com.brightspotinnovations.me2.view.MoodColorChanger;
import com.brightspotinnovations.me2.vo.SituationVo;

import java.util.ArrayList;
import java.util.List;

public class GiveHelpListViewAdapter extends ArrayAdapter<SituationVo> {

    private ArrayList<SituationVo> mHelpData;
    private Context mContext;

    private GiveHelpListListener mListener;

    public interface GiveHelpListListener {
        public void me2ButtonClicked();
        public void loveButtonClicked();
    }

    public void setGiveHelpListListener(GiveHelpListListener listener) {
        mListener = listener;
    }

    public GiveHelpListViewAdapter(Context context, int resource, List<SituationVo> objects) {
        super(context, resource, objects);

        mHelpData = (ArrayList<SituationVo>) objects;
        mContext = context;
    }

    static class ViewHolder {
        public MoodColorChanger statusColor;
        public TextView username;
        public TextView struggle;
        public TextView date;
        public ImageView me2Button;
        public ImageView loveButton;
        public ImageView userGender;
        public ImageView locationMarker;
        public TextView location;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        
        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.give_help_row_layout, parent, false);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.statusColor = (MoodColorChanger) rowView.findViewById(R.id.status_color);
            viewHolder.username = (TextView) rowView.findViewById(R.id.username);
            viewHolder.struggle = (TextView) rowView.findViewById(R.id.struggle);
            viewHolder.date = (TextView) rowView.findViewById(R.id.date);
            viewHolder.me2Button = (ImageView) rowView.findViewById(R.id.me_2_button);
            viewHolder.loveButton = (ImageView) rowView.findViewById(R.id.love_button);
            viewHolder.userGender = (ImageView) rowView.findViewById(R.id.user_gender);
            viewHolder.locationMarker = (ImageView) rowView.findViewById(R.id.location_marker);
            viewHolder.location = (TextView) rowView.findViewById(R.id.location);

            rowView.setTag(viewHolder);
        }

        ViewHolder viewHolder = (ViewHolder) rowView.getTag();

        SituationVo helpData = mHelpData.get(position);

        viewHolder.statusColor.setMood(helpData.mood);
        viewHolder.username.setText(helpData.username);
        viewHolder.date.setText(helpData.date);
        viewHolder.struggle.setText(helpData.situation);
        viewHolder.locationMarker.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_action_place));
        viewHolder.me2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.me2ButtonClicked();
            }
        });
        viewHolder.loveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.loveButtonClicked();
            }
        });
        viewHolder.userGender.setImageDrawable(mContext.getResources().getDrawable(helpData.userGender));
        viewHolder.location.setText(helpData.location);

        return rowView;
    }
}
