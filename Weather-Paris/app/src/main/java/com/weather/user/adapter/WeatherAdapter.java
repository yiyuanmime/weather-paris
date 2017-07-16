package com.weather.user.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.weather.user.R;
import com.weather.user.bus.ApplicationBus;
import com.weather.user.bus.event.WeatherEvent;
import com.weather.user.model.WList;
import com.weather.user.util.CommonUtil;
import com.weather.user.util.PicassoProvider;

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
                .inflate(R.layout.weather_list_item, parent, false);

        WeatherAdapter.ViewHolder vh = new WeatherAdapter.ViewHolder(v);

        return vh;
    }


    @Override
    public void onBindViewHolder(WeatherAdapter.ViewHolder holder, int position) {
        WList wList = displayList.get(position);

        if (wList == null) return;

        if (wList.getWeather() != null && wList.getWeather().size() > 0)
            PicassoProvider.getInstance(holder.conditionIcon.getContext()).load("http://openweathermap.org/img/w/" + wList.getWeather().get(0).icon + ".png").fit().into(holder.conditionIcon);

        if (wList.getDt() != null)
            holder.date.setText(CommonUtil.formatDate(wList.getDt() * 1000L));

        if (wList.getTemp() != null)
            holder.temperature.setText(CommonUtil.round(wList.getTemp().getDay(), 1) + " " + context.getString(R.string.weather_label_degree));

        holder.cardView.setOnClickListener(v -> {
            WeatherEvent weatherEvent = new WeatherEvent(WeatherEvent.WeatherEventType.WEATHER_DETAIL_CLICK);
            weatherEvent.setWList(wList);
            ApplicationBus.getBus().post(weatherEvent);
        });

    }

    @Override
    public int getItemCount() {
        return displayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public CardView cardView;
        public ImageView conditionIcon;
        public TextView date;
        public TextView temperature;

        public ViewHolder(View v) {
            super(v);
            cardView = ButterKnife.findById(v, R.id.card_view);
            conditionIcon = ButterKnife.findById(v, R.id.conditionIcon);
            date = ButterKnife.findById(v, R.id.date);
            temperature = ButterKnife.findById(v, R.id.temperature);
        }
    }


}
