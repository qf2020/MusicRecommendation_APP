package cjk.design.music.activity.ui.home;

import android.content.Context;

import java.util.List;

import cjk.design.music.R;

public class SimpleStringAdapter extends BaseRecyclerViewAdapter<String> {

    public SimpleStringAdapter(List<String> strs, Context context) {
        super(R.layout.item_single_text, strs, context);
    }

    @Override
    protected void bindData(RecyclerViewHolder holder, String text, int position) {
        holder.setText(R.id.tv_text, text);
    }
}
