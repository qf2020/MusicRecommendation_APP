package cjk.design.music.ScrollPicker;

import android.view.View;

public interface IPickerViewOperation {
    int getSelectedItemOffset();

    int getVisibleItemNumber();

    int getLineColor();

    void updateView(View itemView, boolean isSelected);

    Boolean getCorrect();
}
