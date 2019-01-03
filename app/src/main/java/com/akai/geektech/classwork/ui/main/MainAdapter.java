package com.akai.geektech.classwork.ui.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.akai.geektech.classwork.R;
import com.akai.geektech.classwork.data.network.model.ApiVideo;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private OnItemClickListener mListener;
    private List<ApiVideo> mVideos = new ArrayList<>();

    MainAdapter(OnItemClickListener listener) {
        mListener = listener;
    }

    void onVideosUpdate(List<ApiVideo> videoList) {
        mVideos = videoList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ApiVideo video = mVideos.get(position);
        holder.videoTitle.setText(video.getPublicId());
        holder.itemView.setOnClickListener(view -> mListener.onItemClicked(video));
    }

    @Override
    public int getItemCount() {
        return mVideos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView videoTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            videoTitle = itemView.findViewById(R.id.tv_main_video_title);
        }
    }

    interface OnItemClickListener {

        void onItemClicked(ApiVideo video);
    }
}
