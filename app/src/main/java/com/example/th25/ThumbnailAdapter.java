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

    // Hiển thị trên Spinner (mặc định) - Chỉ hiện tên
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_thumbnail_simple, parent, false);
        }
        TextView txtThumbnailName = convertView.findViewById(R.id.txtThumbnailName);
        txtThumbnailName.setText(thumbnails.get(position).getName());
        return convertView;
    }

    // Hiển thị khi mở dropdown - Hiện cả hình và tên
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_thumbnail_spinner, parent, false);
        }

        ImageView imgThumbnail = convertView.findViewById(R.id.imgThumbnail);
        TextView txtThumbnailName = convertView.findViewById(R.id.txtThumbnailName);

        ThumbnailType thumbnail = thumbnails.get(position);
        imgThumbnail.setImageResource(thumbnail.getImg());
        txtThumbnailName.setText(thumbnail.getName());

        return convertView;
    }
}
