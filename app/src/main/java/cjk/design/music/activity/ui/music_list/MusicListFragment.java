package cjk.design.music.activity.ui.music_list;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavArgument;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cjk.design.music.activity.PlayList.PlayListActivity;
import cjk.design.music.activity.lazy.WowContract;
import cjk.design.music.activity.lazy.WowPresenter;
import cjk.design.music.activity.ui.personal_information.MusicListLikeBean;
import cjk.design.music.base.BaseFragment;
import cjk.design.music.databinding.FragmentMusicListBinding;
import cjk.design.music.http.HttpCallback;
import cjk.design.music.http.HttpClient;
import cjk.design.music.onLineMusicBean.PlaylistBean;

public class MusicListFragment extends BaseFragment<WowPresenter> implements WowContract.View {

    private FragmentMusicListBinding binding;
    private PlayListAdapter adapter;

    private PlaylistBean playlist = new PlaylistBean();
    private GridLayoutManager manager;

    //每行加载3个
    private static final int INIT_LOAD_LINE = 3;
    //总共加载30行
    private static final int TOTAL_LOAD_LINE = 30;
    private int totalPage = 3;
    List<PlaylistBean.PlaylistsBean> list = new ArrayList<>();
    private int userId;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MusicListViewModel musicListViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MusicListViewModel.class);

        binding = FragmentMusicListBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Map<String, NavArgument> map = NavHostFragment.findNavController(this).getGraph().getArguments();
        NavArgument navArgument = map.get("userId");
        userId = (int) navArgument.getDefaultValue();

        //还需美化
        // 懒加载还没实现出来。
        //自定义了一个playlistRecommendationscrollview，解决滑动冲突的
        SearchPlayList();
        initView();

        return root;
    }

    private void initView(){

    }

    private void SearchPlayList(){
        HttpClient.getPlayList(new HttpCallback<PlaylistBean>() {
            @Override
            public void onSuccess(PlaylistBean playlistBean) {
                if (playlistBean == null || playlistBean.getPlaylists() == null) {
                    System.out.println("进入了这里吗2");
                    onFail(null);
                    return;
                }
                playlist = playlistBean;
                System.out.println("进入了这里吗1");
                initData(playlist);
                addInfoToPager(playlist);
                hideDialog();
                lazyLoadPlayList(3);
            }

            @Override
            public void onFail(Exception e) {

            }
        });

    }

    protected void initData(PlaylistBean playlistBean) {

        showDialog();
        adapter = new PlayListAdapter(getContext());
        adapter.setType(2);
        adapter.setListener(listener);
        manager = new GridLayoutManager(getContext(), 3);
        binding.musicCommonList.setLayoutManager(manager);
        binding.musicCommonList.addOnScrollListener(new EndlessRecyclerOnScrollListener(manager) {
            @Override
            public void onLoadMore(int currentPage) {
                showDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {//延迟是模仿网络获取数据的，到时候看看接口是否支持，支持则进行更改
                    @Override
                    public void run() {
                        lazyLoadPlayList(3);
                        hideDialog();
                    }
                }, 2000);
            }
        });

        binding.musicCommonList.setHasFixedSize(true);
        binding.musicCommonList.setAdapter(adapter);


    }
    private PlayListAdapter.OnPlayListClickListener listener = position -> {
        if (playlist.getPlaylists() != null || !playlist.getPlaylists().isEmpty()){

            HttpClient.getMusicLikeList(String.valueOf(userId),new HttpCallback<MusicListLikeBean>() {
                @Override
                public void onSuccess(MusicListLikeBean playlistBean) {
                    if (playlistBean == null || playlistBean.getRows() == null) {
                        onFail(null);
                        return;


                    }
                    Intent intent = new Intent(getActivity(), PlayListActivity.class);
                    intent.putExtra("playListId",String.valueOf(playlist.getPlaylists().get(position+3).getId()));
                    intent.putExtra("playListCover",playlist.getPlaylists().get(position+3).getCoverImgUrl());
                    intent.putExtra("playListName",playlist.getPlaylists().get(position+3).getName());
                    intent.putExtra("playListDescription",playlist.getPlaylists().get(position+3).getDescription());
                    intent.putExtra("userId",userId);
                    for (int i = 0;i<playlistBean.getRows().size();i++){
                        if (playlistBean.getRows().get(i).getMusicListId() == playlist.getPlaylists().get(position+3).getId()){
                            intent.putExtra("isLove",1);
                        }
                    }
                    startActivity(intent);

                }

                @Override
                public void onFail(Exception e) {
                    System.out.println(e);
                }
            });

        }

    };
    private void addInfoToPager(PlaylistBean playlistBean) {
        for (int i = 0; i < 3; i++) {
            PlayListCover cover = new PlayListCover(getContext());
            cover.setCover(playlistBean.getPlaylists().get(i).getCoverImgUrl());
            cover.setText(playlistBean.getPlaylists().get(i).getName());
            binding.musicListRecommendation.setClickListener(playlistClickListener);
            binding.musicListRecommendation.addView(cover);
            MusicListRecommendationPager.RikkaLayoutParams lp = (MusicListRecommendationPager.RikkaLayoutParams) cover.getLayoutParams();
            lp.setFrom(i);
            lp.setTo(i);
            lp.setIndex(i);
        }

    }
    MusicListRecommendationPager.OnPlayListClickListener playlistClickListener = position -> {
        if (playlist.getPlaylists() != null || !playlist.getPlaylists().isEmpty()){
            Intent intent = new Intent(getActivity(), PlayListActivity.class);
            intent.putExtra("playListId",String.valueOf(playlist.getPlaylists().get(position).getId()));
            intent.putExtra("playListCover",playlist.getPlaylists().get(position).getCoverImgUrl());
            intent.putExtra("playListName",playlist.getPlaylists().get(position).getName());
            intent.putExtra("playListDescription",playlist.getPlaylists().get(position).getDescription());
            intent.putExtra("isLove",3);
            intent.putExtra("userId",userId);
            startActivity(intent);
        }
    };
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void lazyLoadPlayList(int page) {
        if (playlist.getPlaylists().size() == 0 || totalPage >= 48) {
            return;
        }
        list.addAll(playlist.getPlaylists().subList(totalPage,totalPage+page * INIT_LOAD_LINE));
        totalPage += page * INIT_LOAD_LINE;
        adapter.notifyDataSetChanged(list);
    }


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    public WowPresenter onCreatePresenter() {
        return null;
    }

    @Override
    protected void initVariables(Bundle bundle) {

    }

    @Override
    public void onClick(View view) {

    }
}