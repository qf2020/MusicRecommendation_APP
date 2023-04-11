package cjk.design.music.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;

import com.xiaoyouProject.searchbox.SearchFragment;
import com.xiaoyouProject.searchbox.custom.IOnSearchClickListener;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import cjk.design.music.R;
import cjk.design.music.adapter.OnMoreClickListener;
import cjk.design.music.adapter.SearchMusicAdapter;
import cjk.design.music.databinding.ActivitySearchMusicBinding;
import cjk.design.music.enums.LoadStateEnum;
import cjk.design.music.executor.DownloadSearchedMusic;
import cjk.design.music.executor.PlaySearchedMusic;
import cjk.design.music.executor.ShareOnlineMusic;
import cjk.design.music.http.HttpCallback;
import cjk.design.music.http.HttpClient;
import cjk.design.music.model.Music;
import cjk.design.music.model.SearchMusic;
import cjk.design.music.model.SearchMusic1;
import cjk.design.music.service.AudioPlayer;
import cjk.design.music.utils.FileUtils;
import cjk.design.music.utils.ToastUtils;
import cjk.design.music.utils.ViewUtils;
import cjk.design.music.utils.binding.Bind;

public class SearchMusicActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener{

    private List<SearchMusic1.ResultBean.SongsBean> searchMusicList = new ArrayList<>();
    private SearchMusicAdapter mAdapter = new SearchMusicAdapter(searchMusicList);
    private ActivitySearchMusicBinding binding;
    private SearchFragment<String> searchFragment;
    private LinearLayout llLoading;
    private LinearLayout llLoadFail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchMusicBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        String keyword = intent.getStringExtra("keyword");
        searchMusic(keyword);
        //这个通过baseActivity调用没有效果，放在这才不闪退
        //点击搜索框，原来的布局下沉
        //点击效果还没设置
        llLoading = binding.getRoot().findViewById(R.id.ll_loading);
        llLoadFail = binding.getRoot().findViewById(R.id.ll_load_fail);
        searchFragment= SearchFragment.newInstance();
        initClick();
    }


    private void initClick(){

        binding.searchNestTab.setOnClickListener(this);

        searchFragment.setOnSearchClickListener(new IOnSearchClickListener<String>() {
            /**
             *  点击搜索按钮时触发
             * @param keyword 搜索的关键词
             */
            @Override
            public void onSearchClick(String keyword) {
                searchMusic(keyword);
                //searchInfo.setText(keyword);
                //Intent intent = new Intent(getActivity(), MusicPlayActivity.class);
//                Intent intent = new Intent(getActivity(), SearchMusicActivity.class);
//                startActivity(intent);
            }

            /**
             *  点击关键词预测链接时触发
             * @param data 链接携带的数据
             */
            @Override
            public void onLinkClick(String data) {
                //searchInfo.setText(data);
            }

            /**
             *  当搜索框内容改变时触发
             * @param keyword 搜索的关键词
             */
            @Override
            public void onTextChange(String keyword) {
                // 数据初始化
//                List<CustomLink<String>> data = new ArrayList<>();
//                data.add(new CustomLink<>("链接1","数据1"));
//                data.add(new CustomLink<>("链接2","数据2"));
//                data.add(new CustomLink<>("链接3","数据3"));
//                // 这里我们设置关键词预测显示的内容
//                searchFragment.setLinks(data);
            }
        });
    }

    //这里进行了listview和adapter之间的绑定
    //在baseActivity初始化的时候就调用了
    @Override
    protected void onServiceBound() {

        binding.lvSearchMusicList.setAdapter(mAdapter);

        TextView tvLoadFail = binding.getRoot().findViewById(R.id.tv_load_fail_text);
        tvLoadFail.setText(R.string.search_empty);
        binding.toolbar.setTitle("");


        binding.lvSearchMusicList.setOnItemClickListener(this);
//        mAdapter.setOnMoreClickListener(this);




    }

    @Override
    protected int getDarkTheme() {
        return R.style.AppThemeDark_Search;
    }

    //这是创建菜单的，视情况删除，看是否需要保存toolbar
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_search_music, menu);
//        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
//        searchView.setMaxWidth(Integer.MAX_VALUE);
//        searchView.onActionViewExpanded();
//        searchView.setQueryHint(getString(R.string.search_tips));
//        searchView.setOnQueryTextListener(this);
//        searchView.setSubmitButtonEnabled(true);
//        try {
//            Field field = searchView.getClass().getDeclaredField("mGoButton");
//            field.setAccessible(true);
//            ImageView mGoButton = (ImageView) field.get(searchView);
//            mGoButton.setImageResource(R.drawable.ic_menu_search);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return super.onCreateOptionsMenu(menu);
//    }

    //这是searchview的回车事件
//    @Override
//    public boolean onQueryTextSubmit(String query) {
//        ViewUtils.changeViewState(lvSearchMusic, llLoading, llLoadFail, LoadStateEnum.LOADING);
//        searchMusic(query);
//        return false;
//    }
//
//    //这是searchview的搜索内容改变事件
//    @Override
//    public boolean onQueryTextChange(String newText) {
//        return false;
//    }

    //这里是调用okhttp接口，使用的是异步调用效果
    private void searchMusic(String keyword) {
        HttpClient.searchMusic(keyword, new HttpCallback<SearchMusic1>() {
            @Override
            public void onSuccess(SearchMusic1 response) {
                System.out.println("是否有数据"+response);
                if (response == null || response.getResult().getSongs() == null) {
                    System.out.println("调用了是失败返回吗？");
                    ViewUtils.changeViewState(binding.lvSearchMusicList, llLoading, llLoadFail, LoadStateEnum.LOAD_FAIL);
                    return;
                }
                ViewUtils.changeViewState(binding.lvSearchMusicList, llLoading, llLoadFail, LoadStateEnum.LOAD_SUCCESS);
                searchMusicList.clear();
                searchMusicList.addAll(response.getResult().getSongs());
                mAdapter.notifyDataSetChanged();//这个是用来刷新数据的
                binding.lvSearchMusicList.requestFocus();//这个是让listview获取焦点，不知道删除之后是否会有影响
                handler.post(() -> binding.lvSearchMusicList.setSelection(0));//这个是设置显示第一个到最顶上。handler不知道是干嘛的
            }

            @Override
            public void onFail(Exception e) {
                ViewUtils.changeViewState(binding.lvSearchMusicList, llLoading, llLoadFail, LoadStateEnum.LOAD_FAIL);
                //这个视图工具类主要用于表示调用接口是否成功还是失败。需要使用这个工具类
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.search_nest_tab:
                searchFragment.showFragment(getSupportFragmentManager(),SearchFragment.TAG);
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        Music music = new Music();
        music.setType(Music.Type.ONLINE);
        music.setSongId(searchMusicList.get(position).getId());
        music.setTitle(searchMusicList.get(position).getName());
        music.setArtist(searchMusicList.get(position).getArtists().get(0).getName());
        new PlaySearchedMusic(this, music) {
            @Override
            public void onPrepare() {
                showProgress();
            }

            @Override
            public void onExecuteSuccess(Music music) {
                cancelProgress();
                System.out.println("回调的时候是否有url"+music.getPath());
                AudioPlayer.get().addAndPlay(music);
                ToastUtils.show("已添加到播放列表");
            }

            @Override
            public void onExecuteFail(Exception e) {
                cancelProgress();
                ToastUtils.show(R.string.unable_to_play);
            }
        }.execute();

//        Intent intent = new Intent(this, MusicPlayActivity.class);
//        startActivity(intent);
    }


    //这个onMoreClick是自定义的接口。
//    @Override
//    public void onMoreClick(int position) {
//        final SearchMusic.Song song = searchMusicList.get(position);
//        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
//        dialog.setTitle(song.getSongname());
//        String path = FileUtils.getMusicDir() + FileUtils.getMp3FileName(song.getArtistname(), song.getSongname());
//        File file = new File(path);
//        int itemsId = file.exists() ? R.array.search_music_dialog_no_download : R.array.search_music_dialog;
//        dialog.setItems(itemsId, (dialog1, which) -> {
//            switch (which) {
//                case 0:// 分享
//                    share(song);
//                    break;
//                case 1:// 下载
//                    download(song);
//                    break;
//            }
//        });
//        dialog.show();
//    }

    private void share(SearchMusic.Song song) {
        new ShareOnlineMusic(this, song.getSongname(), song.getSongid()) {
            @Override
            public void onPrepare() {
                showProgress();
            }

            @Override
            public void onExecuteSuccess(Void aVoid) {
                cancelProgress();
            }

            @Override
            public void onExecuteFail(Exception e) {
                cancelProgress();
            }
        }.execute();
    }

    private void download(final SearchMusic.Song song) {
        new DownloadSearchedMusic(this, song) {
            @Override
            public void onPrepare() {
                showProgress();
            }

            @Override
            public void onExecuteSuccess(Void aVoid) {
                cancelProgress();
                ToastUtils.show(getString(R.string.now_download, song.getSongname()));
            }

            @Override
            public void onExecuteFail(Exception e) {
                cancelProgress();
                ToastUtils.show(R.string.unable_to_download);
            }
        }.execute();
    }
}
