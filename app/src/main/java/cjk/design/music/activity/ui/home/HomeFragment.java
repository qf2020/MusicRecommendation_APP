package cjk.design.music.activity.ui.home;

import android.animation.ArgbEvaluator;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.List;

import cjk.design.music.R;
import cjk.design.music.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    public static final int FRAGMENT_COUNT = 4;
    private ImageView mBackImageView;
    private TextView mTitleView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        HomeViewModel homeViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(HomeViewModel.class);
        //viewModel主要的作用是保持数据长久存在，可以在后续开发中思考使用

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        mBackImageView = binding.getRoot().findViewById(R.id.iv_back);
        mTitleView = binding.getRoot().findViewById(R.id.tv_title);
       // final TextView textView = binding.textHome;
        initToolBar(R.drawable.ic_start_mid, 0);
        initData();

        //使用自定义组件，下面部分显示不全，并且不显示bottomview

        //homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
        /*
        TabFragment 作用是充当viewpaper中的Fragmennt
        TabFragemnt 调用了SimpleStringAdapter
        SimpleStringAdapyter是基于BaseRecyclerViewAdapter实现的
        BaseRecyclerViewAdapter 调用了RecycleViewHolder

        ViewPaper调用了BaseFragmentItemAdatpter的适配器

         */

    }
    private void initData() {
        binding.slViewpager.setAdapter(new BaseFragmentItemAdapter(getActivity().getSupportFragmentManager(), initFragments(), initTitles()));
        binding.slTab.setupWithViewPager(binding.slViewpager);
        binding.sickLayout.setScrollChangeListener(new NestedScrollingParent2Layout.ScrollChangeListener() {
            @Override
            public void onScroll(float moveRatio) {
                initToolBar(R.drawable.ic_start_mid, moveRatio);
            }
        });
    }
    private void initToolBar(@DrawableRes int backResId, float moveRatio) {
        mBackImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ArgbEvaluator argbEvaluator = new ArgbEvaluator();
        int color = (int) argbEvaluator.evaluate(moveRatio, Color.WHITE, Color.BLACK);
        Drawable wrapDrawable = DrawableCompat.wrap(getResources().getDrawable(backResId));
        DrawableCompat.setTint(wrapDrawable, color);

        mBackImageView.setImageDrawable(wrapDrawable);
        mTitleView.setAlpha(moveRatio);


    }

    private List<Fragment> initFragments() {
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < FRAGMENT_COUNT; i++) {
            fragments.add(TabFragment.newInstance("NestedScrolling2Demo"));
        }
        return fragments;
    }
    private List<String> initTitles() {
        List<String> titles = new ArrayList<>();
        titles.add("首页");
        titles.add("全部");
        titles.add("作者");
        titles.add("专辑");
        return titles;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}