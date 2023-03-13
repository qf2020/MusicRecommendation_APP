package cjk.design.music.activity.ui.music_list;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import cjk.design.music.databinding.FragmentMusicListBinding;

public class MusicListFragment extends Fragment {

    private FragmentMusicListBinding binding;
    private PlayListAdapter adapter;

    private List<PlaylistBean> list = new ArrayList<>();
    private GridLayoutManager manager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MusicListViewModel musicListViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MusicListViewModel.class);

        binding = FragmentMusicListBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //还需美化
        // 懒加载还没实现出来。
        //自定义了一个playlistRecommendationscrollview，目前还不确定其作用，后续可以再看看
        initData();
        initView();
        addInfoToPager();

        return root;
    }

    private void initView(){

    }


    protected void initData() {
        list.clear();

        adapter = new PlayListAdapter(getContext());
        adapter.notifyDataSetChanged(list);
        adapter.setType(2);
        adapter.setListener(listener);
        manager = new GridLayoutManager(getContext(), 3);
        binding.musicCommonList.setLayoutManager(manager);
        binding.musicCommonList.addOnScrollListener(new EndlessRecyclerOnScrollListener(manager) {
            @Override
            public void onLoadMore(int currentPage) {
                //LogUtil.d(TAG, "onLoadMore");
            }
        });
        binding.musicCommonList.setHasFixedSize(true);
        binding.musicCommonList.setAdapter(adapter);


    }
    private PlayListAdapter.OnPlayListClickListener listener = position -> {
//        if (playlist != null || !playlist.isEmpty()) {
//            Intent intent = new Intent(getActivity(), PlayListActivity.class);
//            HighQualityPlayListBean.PlaylistsBean bean = playlist.get(position + 3);
//            String playlistName = bean.getName();
//            intent.putExtra(PLAYLIST_NAME, playlistName);
//            String playlistPicUrl = bean.getCoverImgUrl();
//            intent.putExtra(PLAYLIST_PICURL, playlistPicUrl);
//            String playlistCreatorNickName = bean.getCreator().getNickname();
//            intent.putExtra(PLAYLIST_CREATOR_NICKNAME, playlistCreatorNickName);
//            String playlistCreatorAvatarUrl = bean.getCreator().getAvatarUrl();
//            intent.putExtra(PLAYLIST_CREATOR_AVATARURL, playlistCreatorAvatarUrl);
//            long playlistId = bean.getId();
//            intent.putExtra(PLAYLIST_ID, playlistId);
//            startActivity(intent);
//        }
    };

    private void addInfoToPager() {
        for (int i = 0; i < 3; i++) {
            PlayListCover cover = new PlayListCover(getContext());
            cover.setCover("http://p2.music.126.net/oS3ZLQ66uGPMnnOJDzDlBw==/19093019417022416.jpg");
            cover.setText("论钢琴的交响性：管弦乐名作及其钢琴改编");
            binding.musicListRecommendation.addView(cover);
            MusicListRecommendationPager.RikkaLayoutParams lp = (MusicListRecommendationPager.RikkaLayoutParams) cover.getLayoutParams();
            lp.setFrom(i);
            lp.setTo(i);
            lp.setIndex(i);
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}