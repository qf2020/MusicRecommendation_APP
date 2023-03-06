package cjk.design.music.activity.ui.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class HomeRecycleView extends RecyclerView {

    public HomeRecycleView(@NonNull Context context) {
        super(context);
    }

    public HomeRecycleView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HomeRecycleView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context, attrs);
    }
    private void initView(Context context, AttributeSet attrs) {
        addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        setLayoutManager(new LinearLayoutManager(context));
    }
}
