package app.coolweather.com.myapplication.model.util;

/**
 * Created by Administrator on 2017/10/23.
 */

public class ItemArticle {
    // 图片的 id
    private int index;
    // 图片 url
    private String imageUrl;

    public ItemArticle(int index, String imageUrl) {
        this.index = index;
        this.imageUrl = imageUrl;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
