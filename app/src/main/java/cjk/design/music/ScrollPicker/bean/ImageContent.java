package cjk.design.music.ScrollPicker.bean;

import android.graphics.drawable.Drawable;

/**
 * @author: cjk
 * @date: 2022/2/16
 * @func:
 * @para:
 * @return:
 */
public class ImageContent {
    private String imageText;
    private Drawable imageUrl;

    public ImageContent(String imageText,Drawable imageUrl) {
        this.imageText = imageText;
        this.imageUrl = imageUrl;
    }

    public String getImageText() {
        return imageText;
    }

    public void setImageText(String imageText) {
        this.imageText = imageText;
    }

    public Drawable getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Drawable imageUrl) {
        this.imageUrl = imageUrl;
    }
}
