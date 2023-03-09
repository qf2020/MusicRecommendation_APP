package cjk.design.music.ScrollPicker;





import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;

import cjk.design.music.ScrollPicker.adapter.ScrollPickerAdapter;


public interface IViewProvider<T> {
    @LayoutRes
    int resLayout();

    void onBindView(@NonNull View view, @Nullable T itemData, ScrollPickerAdapter.OnItemClickListener mOnItemClickListener, int position, int width, int height);

    void updateView(@NonNull View itemView, boolean isSelected);
}
