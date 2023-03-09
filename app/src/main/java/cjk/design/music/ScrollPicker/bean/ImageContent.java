package cjk.design.music.ScrollPicker.bean;

/**
 * @author: cjk
 * @date: 2022/2/16
 * @func:
 * @para:
 * @return:
 */
public class ImageContent {
    private String imageText;
    private String imageUrl;

    public ImageContent(String imageText,String imageUrl) {
        this.imageText = imageText;
        this.imageUrl = imageUrl;
    }

    public String getImageText() {
        return imageText;
    }

    public void setImageText(String imageText) {
        this.imageText = imageText;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
