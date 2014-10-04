package co.me2app.me2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import co.me2app.me2.R;
import co.me2app.me2.vo.NeedHelpVo;

import java.util.ArrayList;
import java.util.List;

public class NeedsHelpListViewAdapter extends ArrayAdapter<NeedHelpVo> {

    private ArrayList<NeedHelpVo> mNeedsHelpData;
    private Context mContext;

    public NeedsHelpListViewAdapter(Context context, int resource, List<NeedHelpVo> objects) {
        super(context, resource, objects);

        mNeedsHelpData = (ArrayList<NeedHelpVo>) objects;
        mContext = context;
    }

    static class ViewHolder {
        public ImageView statusColor;
        public TextView username;
        public TextView struggle;
        public TextView date;
        public ImageView userGender;
        public ImageView locationMarker;
        public TextView location;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        
        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.need_help_row_layout, parent, false);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.statusColor = (ImageView) rowView.findViewById(R.id.status_color);
            viewHolder.username = (TextView) rowView.findViewById(R.id.username);
            viewHolder.struggle = (TextView) rowView.findViewById(R.id.struggle);
            viewHolder.date = (TextView) rowView.findViewById(R.id.date);
            viewHolder.userGender = (ImageView) rowView.findViewById(R.id.user_gender);
            viewHolder.locationMarker = (ImageView) rowView.findViewById(R.id.location_marker);
            viewHolder.location = (TextView) rowView.findViewById(R.id.location);

            rowView.setTag(viewHolder);
        }

        ViewHolder viewHolder = (ViewHolder) rowView.getTag();

        NeedHelpVo helpData = mNeedsHelpData.get(position);

        viewHolder.statusColor.setBackgroundColor(mContext.getResources().getColor(helpData.statusColor));
        viewHolder.username.setText(helpData.username);
        viewHolder.date.setText(helpData.date);
        viewHolder.struggle.setText(helpData.struggle);
        viewHolder.locationMarker.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_action_place));
        viewHolder.userGender.setImageDrawable(mContext.getResources().getDrawable(helpData.userGender));
        viewHolder.location.setText(helpData.location);

        return rowView;
    }
}
