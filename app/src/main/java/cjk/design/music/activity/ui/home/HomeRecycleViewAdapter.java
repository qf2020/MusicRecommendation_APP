package cjk.design.music.activity.ui.home;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cjk.design.music.R;
import cjk.design.music.ScrollPicker.adapter.ScrollPickerAdapter;
import cjk.design.music.ScrollPicker.bean.ImageContent;
import cjk.design.music.ScrollPicker.view.ScrollPickerView;

public class HomeRecycleViewAdapter extends RecyclerView.Adapter<HomeRecycleViewAdapter.ItemHolder>{

    private Context mContext;
    private List<String> tDatas = new ArrayList<>();
    private List<List<ImageContent>> sDatas = new ArrayList<>();

    public HomeRecycleViewAdapter(Context context,List<String> Data1,List<List<ImageContent>> Data2) {
        mContext = context;
        tDatas.addAll(Data1);
        sDatas.addAll(Data2);

    }

    @NonNull
    @Override
    public HomeRecycleViewAdapter.ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ItemHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_home_recycleview,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeRecycleViewAdapter.ItemHolder itemHolder, int i) {

        itemHolder.textView.setText(tDatas.get(i));

        ScrollPickerAdapter.ScrollPickerAdapterBuilder<ImageContent> builder =
                new ScrollPickerAdapter.ScrollPickerAdapterBuilder<ImageContent>(mContext)
                        .setDataList(sDatas.get(i))
                        .selectedItemOffset(0)
                        .setSize(800,400)
                        .setCorrect(true)
                        .visibleItemNumber(0)
                        .setDivideLineColor("#E5E5E5")
                        .setItemViewProvider(null);
//                        .setOnClickListener(new ScrollPickerAdapter.OnItemClickListener() {
//                            @Override
//                            public void onItemClick(View v,int position) {
//                                Intent intent = new Intent(getContext(), PerformenceActivity.class);
//                                switch (position){
//                                    case 0:
//                                        intent.putExtra("sifu", "汪天稳");
//                                        break;
//                                    case 1:
//                                        intent.putExtra("sifu", "朱国强");
//                                        break;
//                                    case 2:
//                                        intent.putExtra("sifu", "刘勇周");
//                                        break;
//                                }
//                                startActivity(intent);
//
//                            }
//                        });
        ScrollPickerAdapter mScrollPickerAdapter = builder.build();
        itemHolder.scrollPickerView.setAdapter(mScrollPickerAdapter);

    }

    @Override
    public int getItemCount() {
        return 3;
    }//这个影响了是否显示，具体原因得再看看

    class ItemHolder extends RecyclerView.ViewHolder{
        ScrollPickerView scrollPickerView;
        TextView textView;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            scrollPickerView = itemView.findViewById(R.id.scroll_picker);
            scrollPickerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            textView = itemView.findViewById(R.id.test_1);
        }
    }
}
