package com.example.nick.myapplication;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GifTag {

    @Expose
    private String tag;
    @SerializedName("gif_count")
    @Expose
    private String gifCount;
    @SerializedName("page_current")
    @Expose
    private String pageCurrent;
    @SerializedName("page_count")
    @Expose
    private String pageCount;
    @Expose
    private List<Gif> gifs = new ArrayList<Gif>();

    /**
     *
     * @return
     * The tag
     */
    public String getTag() {
        return tag;
    }

    /**
     *
     * @param tag
     * The tag
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     *
     * @return
     * The gifCount
     */
    public String getGifCount() {
        return gifCount;
    }

    /**
     *
     * @param gifCount
     * The gif_count
     */
    public void setGifCount(String gifCount) {
        this.gifCount = gifCount;
    }

    /**
     *
     * @return
     * The pageCurrent
     */
    public String getPageCurrent() {
        return pageCurrent;
    }

    /**
     *
     * @param pageCurrent
     * The page_current
     */
    public void setPageCurrent(String pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    /**
     *
     * @return
     * The pageCount
     */
    public String getPageCount() {
        return pageCount;
    }

    /**
     *
     * @param pageCount
     * The page_count
     */
    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    /**
     *
     * @return
     * The gifs
     */
    public List<Gif> getGifs() {
        return gifs;
    }

    /**
     *
     * @param gifs
     * The gifs
     */
    public void setGifs(List<Gif> gifs) {
        this.gifs = gifs;
    }

}