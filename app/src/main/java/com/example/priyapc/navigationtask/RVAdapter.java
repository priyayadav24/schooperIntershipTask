package com.example.priyapc.navigationtask;

/**
 * Created by PriyaPC on 03-04-2017.
 */

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import gsonStructures.NoticeGSON;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.NoticeViewHolder> {

    public static class NoticeViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView addedAtTextView;
        TextView titleTextView;
        TextView descriptionTextView;

        NoticeViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            addedAtTextView = (TextView)itemView.findViewById(R.id.addedAtTV);
            titleTextView = (TextView)itemView.findViewById(R.id.titleTV);
            descriptionTextView = (TextView) itemView.findViewById(R.id.descriptionTV);
        }
    }

    List<NoticeGSON> notices;

    RVAdapter(List<NoticeGSON> notices){
        this.notices = notices;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public NoticeViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        NoticeViewHolder pvh = new NoticeViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(NoticeViewHolder noticeViewHolder, int i) {
        noticeViewHolder.addedAtTextView.setText(notices.get(i).getAdded_at());
        noticeViewHolder.titleTextView.setText(notices.get(i).getTitle());
        final Pattern pattern = Pattern.compile("<p>(.+?)</p>");
        final Matcher matcher = pattern.matcher(notices.get(i).getDescription());
        matcher.find();
        noticeViewHolder.descriptionTextView.setText(matcher.group(1));
    }

    @Override
    public int getItemCount() {  return notices.size();  }
}
