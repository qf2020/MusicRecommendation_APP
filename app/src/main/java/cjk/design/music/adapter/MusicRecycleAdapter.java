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
import cjk.design.music.model.Music;

public class MusicRecycleAdapter extends RecyclerView.Adapter<MusicRecycleAdapter.MusicViewHolder>{

    private List<Music> mDatas = new ArrayList<>();
    private Context context;
    private ItemListener itemListener;
    private LoveListener loveListener;
    private int mode;

    public MusicRecycleAdapter(Context context, List<Music> sDatas, int mode){
        this.context = context;
        mDatas.addAll(sDatas);
        this.mode = mode;
    }
    @NonNull
    @Override
    public MusicRecycleAdapter.MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_music_list_vertical,parent,false);
        return new MusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicRecycleAdapter.MusicViewHolder  holder, int position) {

        Glide.with(context).load(mDatas.get(position).getCoverPath())
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .error(Drawable.createFromPath("#00000000"))
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(50)))
                .into(holder.musciCover);
        holder.musicName.setText(mDatas.get(position).getTitle());
        holder.musicArtist.setText(mDatas.get(position).getArtist());

        holder.musicListCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                itemListener.ItemOnClick(position);
            }
        });
        if (mDatas.get(position).getIsLove() == 1){
            holder.musicLove.setTag("selected");
            switch (mode){
                case 1:
                    holder.musicLove.setColorFilter(Color.parseColor("#6D44B5"));
                    break;
                case 2:
                    holder.musicLove.setColorFilter(Color.parseColor("#26A69A"));
                    break;
                case 3:
                    holder.musicLove.setColorFilter(Color.parseColor("#5E35B1"));
                    break;
                case 4:
                    holder.musicLove.setColorFilter(Color.parseColor("#EAA135"));
                    break;
            }
        }else{
            holder.musicLove.clearColorFilter();
            holder.musicLove.setTag("unselected");
        }
        holder.musicLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (holder.musicLove.getTag().equals("unselected")){

                    //奇怪现象，只能调用Color,调用R.color的值会失败
                    switch (mode){
                        case 1:
                            holder.musicLove.setColorFilter(Color.parseColor("#6D44B5"));
                            break;
                        case 2:
                            holder.musicLove.setColorFilter(Color.parseColor("#26A69A"));
                            break;
                        case 3:
                            holder.musicLove.setColorFilter(Color.parseColor("#5E35B1"));
                            break;
                        case 4:
                            holder.musicLove.setColorFilter(Color.parseColor("#EAA135"));
                            break;
                    }
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



    public interface ItemListener{
        void ItemOnClick(int position);
    }
    public interface LoveListener{
        void ItemOnClick(String tag,int position);
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
