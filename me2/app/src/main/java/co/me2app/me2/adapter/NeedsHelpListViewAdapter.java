package co.me2app.me2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
        public TextView username;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        
        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.need_help_row_layout, parent, false);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.username = (TextView) rowView.findViewById(R.id.username);

            rowView.setTag(viewHolder);
        }

        ViewHolder viewHolder = (ViewHolder) rowView.getTag();

        // can get any view elements from row (viewholder) here.

        return rowView;
    }
}
