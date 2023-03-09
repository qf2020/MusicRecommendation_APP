package cjk.design.music.activity.ui.home;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
