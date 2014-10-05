package co.me2app.me2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import co.me2app.me2.R;
import co.me2app.me2.vo.NeedHelpVo;

import java.util.ArrayList;
import java.util.List;

public class GetHelpListViewAdapter extends ArrayAdapter<NeedHelpVo> {

    private ArrayList<NeedHelpVo> mHelpData;
    private Context mContext;

    public GetHelpListViewAdapter(Context context, int resource, List<NeedHelpVo> objects) {
        super(context, resource, objects);

        mHelpData = (ArrayList<NeedHelpVo>) objects;
        mContext = context;
    }

    static class ViewHolder {
        public ImageView statusColor;
        public TextView username;
        public TextView struggle;
        public TextView date;
        public Button me2Button;
        public Button loveButton;
        public ImageView userGender;
        public ImageView locationMarker;
        public TextView location;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.get_help_row_layout, parent, false);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.statusColor = (ImageView) rowView.findViewById(R.id.status_color);
            viewHolder.username = (TextView) rowView.findViewById(R.id.username);
            viewHolder.struggle = (TextView) rowView.findViewById(R.id.struggle);
            viewHolder.date = (TextView) rowView.findViewById(R.id.date);
            viewHolder.me2Button = (Button) rowView.findViewById(R.id.me_2_button);
            viewHolder.loveButton = (Button) rowView.findViewById(R.id.love_button);
            viewHolder.userGender = (ImageView) rowView.findViewById(R.id.user_gender);
            viewHolder.locationMarker = (ImageView) rowView.findViewById(R.id.location_marker);
            viewHolder.location = (TextView) rowView.findViewById(R.id.location);

            rowView.setTag(viewHolder);
        }

        ViewHolder viewHolder = (ViewHolder) rowView.getTag();

        NeedHelpVo helpData = mHelpData.get(position);

        viewHolder.statusColor.setBackgroundColor(mContext.getResources().getColor(helpData.statusColor));
        viewHolder.username.setText(helpData.username);
        viewHolder.date.setText(helpData.date);
        viewHolder.struggle.setText(helpData.struggle);
        viewHolder.locationMarker.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_action_place));
        viewHolder.me2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "me2", Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.loveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "love", Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.userGender.setImageDrawable(mContext.getResources().getDrawable(helpData.userGender));
        viewHolder.location.setText(helpData.location);

        return rowView;
    }
}
