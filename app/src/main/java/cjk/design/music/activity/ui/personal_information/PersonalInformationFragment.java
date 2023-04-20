package cjk.design.music.activity.ui.personal_information;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cjk.design.music.R;
import cjk.design.music.activity.PlayList.PlayListActivity;
import cjk.design.music.adapter.MusicListRecycleAdapter;
import cjk.design.music.adapter.MusicRecycleAdapter;
import cjk.design.music.databinding.FragmentPersonalInformationBinding;
import cjk.design.music.http.HttpCallback;
import cjk.design.music.http.HttpClient;
import cjk.design.music.model.Music;
import cjk.design.music.onLineMusicBean.PlaylistBean;
import cjk.design.music.onLineMusicBean.PlaylistDetailBean;
import cjk.design.music.onLineMusicBean.SongInfoBean;

public class PersonalInformationFragment extends Fragment {
    private long check = 0;
    private FragmentPersonalInformationBinding binding;
    private RecyclerView recyclerView;
    private List<Integer> delete = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PersonalInformationViewModel notificationsViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(PersonalInformationViewModel.class);

        binding = FragmentPersonalInformationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //其中喜欢的歌单里面的recycleview就是调用了list中的组件。
        initData("1");
        initView3();
        return root;
    }

    private void initData(String userId){
        HttpClient.getMusicLikeList(userId,new HttpCallback<MusicListLikeBean>() {
            @Override
            public void onSuccess(MusicListLikeBean playlistBean) {
                if (playlistBean == null || playlistBean.getRows() == null) {
                    onFail(null);
                    return;

                }
                initView(playlistBean);
            }

            @Override
            public void onFail(Exception e) {
                System.out.println(e);
            }
        });

        HttpClient.getMusicLike(userId,new HttpCallback<MusicLikeBean>() {
            @Override
            public void onSuccess(MusicLikeBean playlistBean) {
                if (playlistBean == null || playlistBean.getRows() == null) {
                    onFail(null);
                    return;
                }
                initView2(playlistBean);
            }

            @Override
            public void onFail(Exception e) {
                System.out.println(e);
            }
        });

    }
    private void initView2(MusicLikeBean playlistBean){
        binding.userLike.tvCount.setText(playlistBean.getRows().size()+"首");
        binding.userLike.clPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MusicLikeData.musicList.clear();
                for (int i  = 0;i<playlistBean.getRows().size();i++){
                    HttpClient.getMusicCover(String.valueOf(playlistBean.getRows().get(i).getMusicId()), new HttpCallback<SongInfoBean>() {
                        @Override
                        public void onSuccess(SongInfoBean songInfoBean) {
                            if (songInfoBean == null || songInfoBean.getSongs().size() == 0) {
                                onFail(null);
                                return;
                            }
                            Music music = new Music();
                            music.setCoverPath(songInfoBean.getSongs().get(0).getAl().getPicUrl());
                            music.setSongId(songInfoBean.getSongs().get(0).getId());
                            music.setArtist(songInfoBean.getSongs().get(0).getAr().get(0).getName());
                            music.setTitle(songInfoBean.getSongs().get(0).getName());
                            music.setType(Music.Type.ONLINE);
                            music.setIsLove(1);
                            MusicLikeData.musicList.add(music);
                        }

                        @Override
                        public void onFail(Exception e) {

                        }
                    });

                }
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(getActivity(), PlayLikeListActivity.class);
                        startActivity(intent);
                    }
                }, 500);

            }
        });
    }
    private void initView(MusicListLikeBean playlistBean){

        binding.playlistCollection.tvName.setText("收藏歌单("+playlistBean.getRows().size()+"个)");
        recyclerView = binding.getRoot().findViewById(R.id.personal_information_playlist);
        LinearLayoutManager  manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        MusicListRecycleAdapter adapter = new MusicListRecycleAdapter(getContext(),playlistBean.getRows(),1);

        adapter.setOnLoveListener(new MusicListRecycleAdapter.LoveListener() {
            @Override
            public void ItemOnClick(String tag,int position) {
                if(tag.equals("unselected")){
                    HttpClient.deleteMusicListLike(playlistBean.getRows().get(position).getUserMusiclistLikeId(), new HttpCallback<String>() {
                        @Override
                        public void onSuccess(String s) {
                            System.out.println("调用歌单删除成功！！！");
                        }
                        @Override
                        public void onFail(Exception e) {

                        }
                    });
                }
            }
        });
        adapter.setOnItemListener(new MusicListRecycleAdapter.ItemListener() {
            @Override
            public void ItemOnClick(int position) {

                HttpClient.getPlayListDetail(String.valueOf(playlistBean.getRows().get(position).getMusicListId()), new HttpCallback<PlaylistDetailBean>() {
                    @Override
                    public void onSuccess(PlaylistDetailBean playlistDetailBean) {
                        if (playlistDetailBean == null || playlistDetailBean.getPlaylist().getTracks() == null) {
                            onFail(null);
                            return;
                        }
                        Intent intent = new Intent(getActivity(), PlayListActivity.class);
                        intent.putExtra("isLove",3);
                        intent.putExtra("playListId",String.valueOf(playlistDetailBean.getPlaylist().getId()));
                        intent.putExtra("playListCover",playlistDetailBean.getPlaylist().getCoverImgUrl());
                        intent.putExtra("playListName",playlistDetailBean.getPlaylist().getName());
                        intent.putExtra("playListDescription",playlistDetailBean.getPlaylist().getDescription());
                        intent.putExtra("likeId",playlistBean.getRows().get(position).getUserMusiclistLikeId());
                        startActivity(intent);
                    }
                    @Override
                    public void onFail(Exception e) {

                    }
                });
            }
        });

        recyclerView.setAdapter(adapter);


    }
    private void initView3(){
        binding.userInfo.ivDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),PersonInfoActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}