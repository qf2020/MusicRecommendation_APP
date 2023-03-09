package cjk.design.music.ScrollPicker.provider;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;


import cjk.design.music.R;
import cjk.design.music.ScrollPicker.IViewProvider;
import cjk.design.music.ScrollPicker.adapter.ScrollPickerAdapter;
import cjk.design.music.ScrollPicker.bean.ImageContent;

public class DefaultItemViewProvider implements IViewProvider<ImageContent> {

    private ScrollPickerAdapter.OnItemClickListener mOnItemClickListener;

    @Override
    public int resLayout() {
        return R.layout.scroll_picker_default_item_layout;
    }

    @Override
    public void onBindView(@NonNull View view, @Nullable ImageContent imageContent, ScrollPickerAdapter.OnItemClickListener cjk, int position, int width, int height) {
        ImageButton imageButton = view.findViewById(R.id.selectImage);
        TextView imageText = view.findViewById(R.id.selectImageText);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(imageButton.getLayoutParams());
        lp.width = width;
        lp.height = height;
        imageButton.setLayoutParams(lp);

        //System.out.println(text+"链接");
        if (imageContent == null){
            imageButton.setVisibility(View.INVISIBLE);
        }
        else{
            if (imageContent.getImageUrl() != null){
                Glide.with(view.getContext()).load(imageContent.getImageUrl())
                        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                        .error(Drawable.createFromPath("#00000000"))
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(50)))
                        .into(imageButton);
            }
            if (imageContent.getImageText() != null){
                imageText.setText(imageContent.getImageText());
            }

        }
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cjk.onItemClick(view,position);
            }
        });
    }

    @Override
    public void updateView(@NonNull View itemView, boolean isSelected) {
        ImageButton imageButton = itemView.findViewById(R.id.selectImage);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(imageButton.getLayoutParams());
        lp.width = 700;
        lp.height = 400;
        FrameLayout.LayoutParams lp1 = new FrameLayout.LayoutParams(imageButton.getLayoutParams());
        lp1.width = 800;
        lp1.height = 450;
        imageButton.setLayoutParams(isSelected ? lp1 : lp);
        if (isSelected){
            imageButton.setEnabled(true);
        }else{
            imageButton.setEnabled(false);
        }
    }
}
