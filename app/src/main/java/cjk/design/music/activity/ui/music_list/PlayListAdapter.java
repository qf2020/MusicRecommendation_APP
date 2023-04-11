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
import cjk.design.music.onLineMusicBean.PlaylistBean;

public class PlayListAdapter extends BaseAdapter<RecyclerView.ViewHolder, PlaylistBean.PlaylistsBean> {
    private static final String TAG = "PlayListAdapter";
    private List<PlaylistBean.PlaylistsBean> dataList = new ArrayList<>();
    private Context mContext;
    private OnPlayListClickListener listener;
    private int type;

    public PlayListAdapter(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public void notifyDataSetChanged(List<PlaylistBean.PlaylistsBean> dataList) {
        this.dataList = dataList;
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
            PlaylistBean.PlaylistsBean playlistsBean = dataList.get(i);
            vh.setPlayListInfo(mContext, playlistsBean);
            vh.onSetListClickListener(listener, i);
        }
    }

    public void setType(int type) {
        this.type = type;
    }

    //type == 1 展示6个  type == 2 展示3个
    @Override
    public int getItemCount() {
        return dataList == null ? 0 : type == 1 ? 6 : dataList.size();
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

        void setPlayListInfo(Context context, PlaylistBean.PlaylistsBean bean) {
            Glide.with(context)
                    .load(bean.getCoverImgUrl())
                    .transition(new DrawableTransitionOptions().crossFade())
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(50)))
                    .into(imgPlayList);
            tvPlayListName.setText(bean.getName());
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
