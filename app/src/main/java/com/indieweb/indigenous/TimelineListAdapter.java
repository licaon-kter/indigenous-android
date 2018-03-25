package com.indieweb.indigenous;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Event list adapter.
 */
public class TimelineListAdapter extends BaseAdapter implements OnClickListener {

    private final Context context;
    private final List<TimelineItem> items;

    public TimelineListAdapter(Context context, List<TimelineItem> items) {
        this.context = context;
        this.items = items;
    }

    public int getCount() {
        return items.size();
    }

    public TimelineItem getItem(int position) {
        return items.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public void onClick(View view) {

    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.timeline_list_item, null);
        }

        final TimelineItem item = items.get(position);
        if (item != null) {

            // Change color of row.
            assert convertView != null;
            String color = ((position % 2) == 0) ? "#f8f7f1" :  "#ffffff";
            final LinearLayout row = convertView.findViewById(R.id.timeline_item_row);
            row.setBackgroundColor(Color.parseColor(color));

            // Author.
            final TextView author = convertView.findViewById(R.id.timeline_author);
            author.setText(item.getAuthorName());

            // Name.
            final TextView name = convertView.findViewById(R.id.timeline_name);
            name.setText(item.getName());

            // Content.
            final TextView content = convertView.findViewById(R.id.timeline_content);
            content.setText(item.getContent());

            // Image.
            /*final ImageView image = convertView.findViewById(R.id.timeline_image);
            if (item.getPhoto().length() > 0) {
                Glide.with(context).load(item.getPhoto()).into(image);
            }*/

        }

        return convertView;
    }
}