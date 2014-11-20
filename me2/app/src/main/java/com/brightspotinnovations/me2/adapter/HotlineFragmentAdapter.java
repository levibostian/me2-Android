package com.brightspotinnovations.me2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.brightspotinnovations.me2.R;
import com.brightspotinnovations.me2.vo.HotlineVo;

import java.util.ArrayList;
import java.util.List;

public class HotlineFragmentAdapter extends ArrayAdapter<HotlineVo> {

    private ArrayList<HotlineVo> mHelplineData;
    private Context mContext;

    private HotlineFragmentListener mListener;

    public interface HotlineFragmentListener {
        public void phoneIconSelected(long phoneNumber);
        public void websiteLinkSelected(String website);
    }

    public void setHotlineFragmentListener(HotlineFragmentListener listener) {
        mListener = listener;
    }

    public HotlineFragmentAdapter(Context context, int resource, List<HotlineVo> objects) {
        super(context, resource, objects);

        mHelplineData = (ArrayList<HotlineVo>) objects;
        mContext = context;
    }

    static class ViewHolder {
        public TextView hotlineName;
        public TextView description;
        public ImageView callButton;
        public TextView website;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.hotline_fragment_row, parent, false);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.hotlineName = (TextView) rowView.findViewById(R.id.hotline_name);
            viewHolder.description = (TextView) rowView.findViewById(R.id.description);
            viewHolder.callButton = (ImageView) rowView.findViewById(R.id.call_button);
            viewHolder.website = (TextView) rowView.findViewById(R.id.website);

            rowView.setTag(viewHolder);
        }

        ViewHolder viewHolder = (ViewHolder) rowView.getTag();

        final HotlineVo helpData = mHelplineData.get(position);

        viewHolder.hotlineName.setText(helpData.name);
        viewHolder.description.setText(helpData.description);
        viewHolder.website.setText(helpData.website);
        viewHolder.website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.websiteLinkSelected(helpData.website);
            }
        });
        viewHolder.callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.phoneIconSelected(helpData.phone);
            }
        });

        return rowView;
    }
}
