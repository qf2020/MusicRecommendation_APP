package cjk.design.music.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cjk.design.music.R;
import cjk.design.music.model.SearchMusic;
import cjk.design.music.model.SearchMusic1;
import cjk.design.music.utils.binding.Bind;
import cjk.design.music.utils.binding.ViewBinder;

/**
 */
public class SearchMusicAdapter extends BaseAdapter {
    private List<SearchMusic1.ResultBean.SongsBean> mData;
    private OnMoreClickListener mListener;

    public SearchMusicAdapter(List<SearchMusic1.ResultBean.SongsBean> data) {
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_music, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvTitle.setText(mData.get(position).getName());
        holder.tvArtist.setText(mData.get(position).getArtists().get(0).getName());
        holder.ivMore.setOnClickListener(v -> mListener.onMoreClick(position));
        holder.vDivider.setVisibility(isShowDivider(position) ? View.VISIBLE : View.GONE);
        return convertView;
    }

    private boolean isShowDivider(int position) {
        return position != mData.size() - 1;
    }

    public void setOnMoreClickListener(OnMoreClickListener listener) {
        mListener = listener;
    }

    private static class ViewHolder {
        @Bind(R.id.iv_cover)
        private ImageView ivCover;
        @Bind(R.id.tv_title)
        private TextView tvTitle;
        @Bind(R.id.tv_artist)
        private TextView tvArtist;
        @Bind(R.id.iv_more)
        private ImageView ivMore;
        @Bind(R.id.v_divider)
        private View vDivider;

        public ViewHolder(View view) {
            ViewBinder.bind(this, view);
            ivCover.setVisibility(View.GONE);
        }
    }
}
