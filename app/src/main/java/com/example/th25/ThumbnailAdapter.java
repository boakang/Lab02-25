package com.example.th25;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ThumbnailAdapter extends BaseAdapter {
    private Context context;
    private List<ThumbnailType> thumbnails;

    public ThumbnailAdapter(Context context, List<ThumbnailType> thumbnails) {
        this.context = context;
        this.thumbnails = thumbnails;
    }

    @Override
    public int getCount() {
        return thumbnails.size();
    }

    @Override
    public Object getItem(int position) {
        return thumbnails.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_thumbnail, parent, false);
            holder = new ViewHolder();
            holder.imgThumbnail = convertView.findViewById(R.id.imgThumbnail);
            holder.txtThumbnailName = convertView.findViewById(R.id.txtThumbnailName);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ThumbnailType thumbnail = thumbnails.get(position);
        holder.imgThumbnail.setImageResource(thumbnail.getImg());
        holder.txtThumbnailName.setText(thumbnail.getName());

        return convertView;
    }
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_thumbnail, parent, false);
            holder = new ViewHolder();
            holder.imgThumbnail = convertView.findViewById(R.id.imgThumbnail);
            holder.txtThumbnailName = convertView.findViewById(R.id.txtThumbnailName);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ThumbnailType thumbnail = thumbnails.get(position);
        holder.imgThumbnail.setImageResource(thumbnail.getImg());
        holder.txtThumbnailName.setText(thumbnail.getName());

        return convertView;
    }
    static class ViewHolder {
        ImageView imgThumbnail;
        TextView txtThumbnailName;
    }
}
