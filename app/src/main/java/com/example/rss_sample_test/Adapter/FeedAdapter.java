package com.example.rss_sample_test.Adapter;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rss_sample_test.Interface.ItemClickListner;
import com.example.rss_sample_test.Model.RSSObject;
import com.example.rss_sample_test.R;

class FeedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener
{

    public TextView txtTitle,txtPubdate;
    private ItemClickListner itemClickListener;

    public FeedViewHolder( View itemView)
    {
        super(itemView);

        txtTitle=(TextView)itemView.findViewById(R.id.txtTitle);
        txtPubdate=(TextView)itemView.findViewById(R.id.txtPubDate);


        //Set Event
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);

    }

    public void setItemClickListener(ItemClickListner itemClickListener)
    {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v)
    {
    itemClickListener.onClick(v,getAdapterPosition(),false);
    }
    @Override
    public boolean onLongClick(View v)
    {
        itemClickListener.onClick(v,getAdapterPosition(),true);
    return true;
    }
}
public class FeedAdapter extends  RecyclerView.Adapter<FeedViewHolder>
{
    private RSSObject rssObject;
    private Context mContext;
    private LayoutInflater inflater;

    public FeedAdapter(RSSObject rssObject, Context mContext) {
        this.rssObject = rssObject;
        this.mContext = mContext;
        inflater=LayoutInflater.from(mContext);
    }

    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView =inflater.inflate(R.layout.row,parent,false);
        return new FeedViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedViewHolder holder, int position)
    {
        holder.txtTitle.setText(rssObject.getItems().get(position).getTitle());
        holder.txtPubdate.setText(rssObject.getItems().get(position).getPubDate());


        holder.setItemClickListener(new ItemClickListner() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if(isLongClick)
                {
                    Intent browserIntent =new Intent(Intent.ACTION_VIEW, Uri.parse(rssObject.getItems().get(position).getLink()));
                    mContext.startActivity(browserIntent);
                }
            }
        });

    }

    @Override
    public int getItemCount()
    {
        return rssObject.items.size();
    }
}
