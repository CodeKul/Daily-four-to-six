package com.codekul.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by aniruddha on 9/6/17.
 */

public class CustomAdapter extends BaseAdapter {

    private final Context context;
    private final List<Item> names;
    private LayoutInflater inflater;

    public CustomAdapter(Context context, List<Item> names) {
        this.context = context;
        this.names = names;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int position) {
        return names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.list_item, parent, false );
        ((ImageView)view.findViewById(R.id.imgLg)).setImageResource(names.get(position).img);
        ((TextView)view.findViewById(R.id.txtNm)).setText(names.get(position).nm);
        return view;
    }

    public void addItem(Item item) {
        names.add(item);
        notifyDataSetChanged();
    }
}
