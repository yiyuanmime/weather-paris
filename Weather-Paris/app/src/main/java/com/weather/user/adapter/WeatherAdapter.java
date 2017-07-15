package com.weather.user.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.weather.user.R;
import com.weather.user.model.WList;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by yi on 15/07/2017.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {

    private List<WList> displayList;
    private Context context;

    public WeatherAdapter(Context context, List<WList> displayList) {
        this.context = context;
        this.displayList = displayList;
    }

    public void populate(List<WList> list) {

        if (list == null) return;

        displayList.clear();
        displayList.addAll(list);
        notifyDataSetChanged();
    }

    public void reset() {
        displayList.clear();
        notifyDataSetChanged();
    }

    @Override
    public WeatherAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card_content_item, parent, false);

        WeatherAdapter.ViewHolder vh = new WeatherAdapter.ViewHolder(v);

        return vh;
    }


    @Override
    public void onBindViewHolder(WeatherAdapter.ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return displayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView mLeftImage;

        public ViewHolder(View v) {
            super(v);
            mLeftImage = ButterKnife.findById(v, R.id.leftImage);
        }
    }


}
