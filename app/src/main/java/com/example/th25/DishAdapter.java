package com.example.th25;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.th25.R;

import java.util.List;

public class DishAdapter extends BaseAdapter {
    private Context context;
    private List<Dish> dishList;

    public DishAdapter(Context context, List<Dish> dishList) {
        this.context = context;
        this.dishList = dishList;
    }

    @Override
    public int getCount() {
        return dishList.size();
    }

    @Override
    public Object getItem(int position) {
        return dishList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_dish, parent, false);
            holder = new ViewHolder();
            holder.imgDish = convertView.findViewById(R.id.imgDish);
            holder.txtDishName = convertView.findViewById(R.id.txtDishName);
            holder.imgPromotion = convertView.findViewById(R.id.imgPromotion);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Dish dish = dishList.get(position);
        holder.txtDishName.setText(dish.getName());
        holder.imgDish.setImageResource(dish.getImg());

        // Nếu có khuyến mãi, hiển thị ngôi sao, ngược lại ẩn đi
        holder.imgPromotion.setVisibility(View.GONE);

        if (dish.isPromotion()) {
            holder.imgPromotion.setVisibility(View.VISIBLE);
        }

        return convertView;
    }


    static class ViewHolder {
        ImageView imgDish;
        TextView txtDishName;
        LinearLayout imgPromotion;
    }
}
