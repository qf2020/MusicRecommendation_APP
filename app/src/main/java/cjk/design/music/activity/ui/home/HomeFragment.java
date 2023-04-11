package cjk.design.music.activity.ui.home;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiaoyouProject.searchbox.SearchFragment;
import com.xiaoyouProject.searchbox.custom.IOnSearchClickListener;

import java.util.ArrayList;
import java.util.List;

import cjk.design.music.R;
import cjk.design.music.ScrollPicker.bean.ImageContent;
import cjk.design.music.activity.Recommendation.RecommendationFirstActivity;
import cjk.design.music.activity.Recommendation.RecommendationSecondActivity;
import cjk.design.music.activity.Recommendation.RecommendationThirdActivity;
import cjk.design.music.activity.SearchMusicActivity;
import cjk.design.music.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment implements View.OnClickListener{

    private FragmentHomeBinding binding;
    public static final int FRAGMENT_COUNT = 4;
    private ImageView mBackImageView;
    private TextView mTitleView;
    private ImageButton imageButton;
    private LinearLayoutManager linearLayoutManager;//布局管理器
    private HomeRecycleViewAdapter recycleviewAdapter;//适配器
    SearchFragment<String> searchFragment;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        HomeViewModel homeViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(HomeViewModel.class);
        //viewModel主要的作用是保持数据长久存在，可以在后续开发中思考使用

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        initView();
        initData();
        initClick();

        //报错中，DrawerLayout的父布局中长宽必须设定一下，之前闪退报错，是因为父布局的fragment的height设置为0

        //明日任务：
        //个人界面（完成小部分）
        //完成状态栏颜色的调整(已经美化一部分）
        //美化侧边栏显示(已经美化一部分）
        //完成歌词展示(歌词切换bug解决了，但是是利用父布局进行点击事件解决的）,歌词展示雏形完成
        //完成新歌速递的界面和搜索界面
        //优化歌曲背景加载导致缓慢，我们不一定需要里面加载出来，优先加载默认图片，等待正在图片加载出来后显示就行，只要不出现加载错误现象就行。（不急着实现）

        //homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.home_menu:
                if(binding.homeDrawer.isDrawerOpen(GravityCompat.START)){
                    binding.homeDrawer.closeDrawer(GravityCompat.START);
                }else{
                    binding.homeDrawer.openDrawer(GravityCompat.START);
                }
                break;

            case R.id.home_nest_tab:
                searchFragment.showFragment(getActivity().getSupportFragmentManager(),SearchFragment.TAG);
                break;
            default:
                break;
        }
    }


    private void initClick(){
        imageButton.setOnClickListener(this);
        binding.homeNestTab.setOnClickListener(this);

        searchFragment.setOnSearchClickListener(new IOnSearchClickListener<String>() {
            /**
             *  点击搜索按钮时触发
             * @param keyword 搜索的关键词
             */
            @Override
            public void onSearchClick(String keyword) {
                //searchInfo.setText(keyword);
                //Intent intent = new Intent(getActivity(), MusicPlayActivity.class);
                Intent intent = new Intent(getActivity(), SearchMusicActivity.class);
                intent.putExtra("keyword",keyword);
                startActivity(intent);
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
    private void initView(){
        //TopView中的组件
        mBackImageView = binding.getRoot().findViewById(R.id.iv_back);
        mTitleView = binding.getRoot().findViewById(R.id.tv_title);
        imageButton = binding.getRoot().findViewById(R.id.home_menu);
        imageButton.setColorFilter(getResources().getColor(R.color.black));
        //搜索框初始化
        searchFragment= SearchFragment.newInstance();
       // initToolBar(R.drawable.logo, 0);
    }
    private void initData() {

        //初始化recycleview中的数据
        List<String> tDatas = new ArrayList<>();
        tDatas.add("为你推荐");
        tDatas.add("新歌速递");
        tDatas.add("排行榜");

        System.out.println(tDatas);
        List<List<ImageContent>> sDatas = new ArrayList<>();
        List<ImageContent> list_recommendation = new ArrayList<ImageContent>();
        list_recommendation.add(new ImageContent("",getResources().getDrawable(R.drawable.recommendation_1)));
        list_recommendation.add(new ImageContent("",getResources().getDrawable(R.drawable.recommendation_2)));
        list_recommendation.add(new ImageContent("",getResources().getDrawable(R.drawable.recommendation_3)));
        sDatas.add(list_recommendation);
        List<ImageContent> list_music_list = new ArrayList<ImageContent>();
        list_music_list.add(new ImageContent("",getResources().getDrawable(R.drawable.music_list_1)));
        list_music_list.add(new ImageContent("",getResources().getDrawable(R.drawable.music_list_2)));
        list_music_list.add(new ImageContent("",getResources().getDrawable(R.drawable.music_list_3)));
        sDatas.add(list_music_list);
        sDatas.add(list_music_list);

        linearLayoutManager = new LinearLayoutManager(getContext());//初始化布局管理器
        binding.slRecycle.setLayoutManager(linearLayoutManager);//设置布局管理器
        binding.slRecycle.setItemAnimator(new DefaultItemAnimator());//设置动画
        recycleviewAdapter = new HomeRecycleViewAdapter(getContext(),tDatas,sDatas);//初始化适配器
        recycleviewAdapter.setItemListener(new HomeRecycleViewAdapter.ItemListener() {
            @Override
            public void ItemClick(int position, int ScrollPosition) {
                switch (position){
                    case 0 :
                        //这里是调用推荐歌单的
                        if (ScrollPosition == 0){
                            Intent intent = new Intent(getActivity(), RecommendationFirstActivity.class);
                            startActivity(intent);
                            //这里是美好的约会
                        }else if(ScrollPosition == 1){
                            Intent intent = new Intent(getActivity(), RecommendationSecondActivity.class);
                            startActivity(intent);
                        }else{
                            Intent intent = new Intent(getActivity(), RecommendationThirdActivity.class);
                            startActivity(intent);
                        }

                        break;
                    case 1:
                        //这里是新歌速递
                        break;
                    case 2:
                        //这里是排行榜
                        break;
                    default:
                        break;
                }
            }
        });
        binding.slRecycle.setAdapter(recycleviewAdapter);//设置适配器


//        binding.sickLayout.setScrollChangeListener(new NestedScrollingParent2Layout.ScrollChangeListener() {
//            @Override
//            public void onScroll(float moveRatio) {
//                initToolBar(R.drawable.logo, moveRatio);
//            }
//        });
    }


    private void initToolBar(@DrawableRes int backResId, float moveRatio) {
        mBackImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ArgbEvaluator argbEvaluator = new ArgbEvaluator();
        int color = (int) argbEvaluator.evaluate(moveRatio, Color.BLACK, Color.GREEN);
        Drawable wrapDrawable = DrawableCompat.wrap(getResources().getDrawable(backResId));
        DrawableCompat.setTint(wrapDrawable, color);

        mBackImageView.setImageDrawable(wrapDrawable);
        mTitleView.setAlpha(moveRatio);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}