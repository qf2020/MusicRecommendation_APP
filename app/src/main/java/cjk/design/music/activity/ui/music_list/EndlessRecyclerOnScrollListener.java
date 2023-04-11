package cjk.design.music.activity.ui.music_list;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Adapter的懒加载
 */
public abstract class EndlessRecyclerOnScrollListener extends RecyclerView.OnScrollListener {
    private static final String TAG = "EndlessRecyclerOnScroll";

    //总加载数据
    public int previousTotal = 0;
    //是否提前加载
    private boolean loading = true;
    private int firstVisibleItem, visibleItemCount, totalItemCount,lastVisibleItem;
    private int currentPage = 1;
    private LinearLayoutManager mLinearLayoutManager;
    private GridLayoutManager mGridLayoutManager;
    int type;
    boolean isUpScroll = false;

    public EndlessRecyclerOnScrollListener(LinearLayoutManager linearLayoutManager) {
        this.mLinearLayoutManager = linearLayoutManager;
        type = 1;
    }

    public EndlessRecyclerOnScrollListener(GridLayoutManager gridLayoutManager) {
        mGridLayoutManager = gridLayoutManager;
        type = 2;
    }


    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();

        if (newState == RecyclerView.SCROLL_STATE_IDLE) { //当前未滑动

            if (type == 1) {
                visibleItemCount = recyclerView.getChildCount();
                totalItemCount = mLinearLayoutManager.getItemCount();
                firstVisibleItem = mLinearLayoutManager.findFirstVisibleItemPosition();
            } else if (type == 2) {
                visibleItemCount = recyclerView.getChildCount();
                totalItemCount = mGridLayoutManager.getItemCount();//总数
                firstVisibleItem = mGridLayoutManager.findFirstVisibleItemPosition();//第一个显示的位置
            }

            if (loading) {
                if (totalItemCount > previousTotal) {
                    loading = false;
                    previousTotal = totalItemCount;
                }
            }
            System.out.println(firstVisibleItem+"第一个显示的位置");
            System.out.println(visibleItemCount+"可以看的数量");
            System.out.println(totalItemCount+"总共的数量");
            if (!loading && !recyclerView.canScrollVertically(1)) {
                currentPage++;
                onLoadMore(currentPage);
                loading = true;
            }

        }
    }
    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        // 大于0表示正在向上滑动，小于等于0表示停止或向下滑动
        isUpScroll = dy > 0;
    }


    public abstract void onLoadMore(int currentPage);

    public void reset(int previousTotal, boolean loading) {
        this.previousTotal = previousTotal;
        this.loading = loading;
    }
}
