package cjk.design.music.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import cjk.design.music.R;
import cjk.design.music.activity.ui.personal_information.MusicListLikeBean;
import cjk.design.music.http.HttpCallback;
import cjk.design.music.http.HttpClient;
import cjk.design.music.model.Music;
import cjk.design.music.onLineMusicBean.PlaylistDetailBean;

public class MusicListRecycleAdapter extends RecyclerView.Adapter<MusicListRecycleAdapter.MusicViewHolder>{

    private List<MusicListLikeBean.RowsBean> mDatas = new ArrayList<>();
    private Context context;
    private ItemListener itemListener;
    private LoveListener loveListener;
    private int mode;

    public MusicListRecycleAdapter(Context context, List<MusicListLikeBean.RowsBean> sDatas, int mode){
        this.context = context;
        mDatas.addAll(sDatas);
        this.mode = mode;


    }
    @NonNull
    @Override
    public MusicListRecycleAdapter.MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_music_list_vertical,parent,false);
        return new MusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicListRecycleAdapter.MusicViewHolder  holder, int position) {

        HttpClient.getPlayListDetail(String.valueOf(mDatas.get(position).getMusicListId()), new HttpCallback<PlaylistDetailBean>() {
            @Override
            public void onSuccess(PlaylistDetailBean playlistDetailBean) {
                if (playlistDetailBean == null || playlistDetailBean.getPlaylist().getTracks() == null) {
                    onFail(null);
                    return;
                }
                holder.musicName.setText(playlistDetailBean.getPlaylist().getName());
                holder.musicArtist.setText(playlistDetailBean.getPlaylist().getDescription());
                Glide.with(context).load(playlistDetailBean.getPlaylist().getCoverImgUrl())
                        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                        .error(Drawable.createFromPath("#00000000"))
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(50)))
                        .into(holder.musciCover);
            }
            @Override
            public void onFail(Exception e) {
                holder.musicName.setText("无");
                holder.musicArtist.setText("无");
                Glide.with(context).load(Drawable.createFromPath("#00000000"))
                        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(50)))
                        .into(holder.musciCover);
            }
        });

        holder.musicListCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                itemListener.ItemOnClick(position);
            }
        });

        holder.musicLove.setTag("selected");
        holder.musicLove.setColorFilter(Color.parseColor("#F44336"));


        holder.musicLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (holder.musicLove.getTag().equals("unselected")){
                    holder.musicLove.setColorFilter(Color.parseColor("#F44336"));
                    holder.musicLove.setTag("selected");
                }else{
                    holder.musicLove.clearColorFilter();
                    holder.musicLove.setTag("unselected");
                }


                int position = holder.getAdapterPosition();
                loveListener.ItemOnClick(String.valueOf(holder.musicLove.getTag()),position);
            }
        });


    }


    public interface LoveListener{
        void ItemOnClick(String tag,int position);
    }
    public interface ItemListener{
        void ItemOnClick(int position);
    }

    public void setOnItemListener(ItemListener itemListener){
        this.itemListener = itemListener;
    }
    public void setOnLoveListener(LoveListener loveListener){
        this.loveListener = loveListener;
    }
    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class MusicViewHolder extends RecyclerView.ViewHolder{
        ImageView musciCover;
        ImageView musicLove;
        TextView musicName;
        TextView musicArtist;
        ConstraintLayout musicListCL;
        private MusicViewHolder(@NonNull View itemView) {
            super(itemView);
            musciCover = itemView.findViewById(R.id.music_cover);
            musicLove = itemView.findViewById(R.id.music_love);
            musicName = itemView.findViewById(R.id.music_name);
            musicArtist = itemView.findViewById(R.id.music_artist);
            musicListCL = itemView.findViewById(R.id.music_list_CL);
        }
    }
}
