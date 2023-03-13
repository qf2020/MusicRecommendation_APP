package cjk.design.music.activity.ui.music_list;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import cjk.design.music.R;
import cjk.design.music.base.BaseAdapter;

public class PlayListAdapter extends BaseAdapter<RecyclerView.ViewHolder, PlaylistBean> {
    private static final String TAG = "PlayListAdapter";

    private List<PlaylistBean> list = new ArrayList<>();
    private Context mContext;
    private OnPlayListClickListener listener;
    private int type;

    public PlayListAdapter(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public void notifyDataSetChanged(List<PlaylistBean> dataList) {
//        list = dataList;
        PlaylistBean playlistBean = new PlaylistBean();
        playlistBean.setPlaylistCoverUrl("http://p2.music.126.net/oS3ZLQ66uGPMnnOJDzDlBw==/19093019417022416.jpg");
        playlistBean.setPlaylistName("论钢琴的交响性：管弦乐名作及其钢琴改编");
        for (int i = 0;i<20;i++){
            list.add(playlistBean);
        }
        System.out.println("是否有数据"+playlistBean.getPlaylistCoverUrl());
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(getInflater().inflate(R.layout.item_playlist, viewGroup, false));
    }

//onBindHolder
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof ViewHolder) {
            ViewHolder vh = (ViewHolder) viewHolder;
            PlaylistBean bean = list.get(i);

            vh.setPlayListInfo(mContext, bean);
            vh.onSetListClickListener(listener, i);
        }
    }

    public void setType(int type) {
        this.type = type;
    }

    //type == 1 展示6个  type == 2 展示3个
    @Override
    public int getItemCount() {
        return list == null ? 0 : type == 1 ? 6 : list.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        private RelativeLayout rlPlayList;
        private ImageView imgPlayList;
        private TextView tvPlayListName;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            rlPlayList = itemView.findViewById(R.id.rl_playlist);
            imgPlayList = itemView.findViewById(R.id.iv_playlist);
            tvPlayListName = itemView.findViewById(R.id.tv_playlist_name);
        }

        void setPlayListInfo(Context context, PlaylistBean bean) {
            Glide.with(context)
                    .load(bean.getPlaylistCoverUrl())
                    .transition(new DrawableTransitionOptions().crossFade())
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(50)))
                    .into(imgPlayList);
            tvPlayListName.setText(bean.getPlaylistName());
        }

        void onSetListClickListener(OnPlayListClickListener listener, int position) {
            rlPlayList.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onClickListener(position);
                }
            });
        }
    }

    public interface OnPlayListClickListener {
        void onClickListener(int position);
    }

    public void setListener(OnPlayListClickListener listener) {
        this.listener = listener;
    }
}
