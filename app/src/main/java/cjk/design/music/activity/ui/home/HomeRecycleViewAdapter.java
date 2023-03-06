package cjk.design.music.activity.ui.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class HomeRecycleViewAdapter extends RecyclerView.Adapter<HomeRecycleViewAdapter.ItemHolder>{
    @NonNull
    @Override
    public HomeRecycleViewAdapter.ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //return new ItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false));
        return null;
        //这里用来绑定视图
    }

    @Override
    public void onBindViewHolder(@NonNull HomeRecycleViewAdapter.ItemHolder itemHolder, int i) {
        //这里用于填充数据
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ItemHolder extends RecyclerView.ViewHolder{
        //TextView tv_state;
        //...
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
           // tv_state = itemView.findViewById(R.id.tv_state);
            //...
        }
    }
}
