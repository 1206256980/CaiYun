package com.gzqf.caiyun.model;

public class ZhaoBiaoListViewMsg {
    private String post;//职位
    private String name;//姓名
    private String imgUrl;//图片路径
    private Integer phone;//电话号码

    /**
     *
     * @param post 职位
     * @param name 职位
     * @param imgUrl 图片路径
     * @param phone 电话号码
     */
    public ZhaoBiaoListViewMsg(String post, String name, String imgUrl, Integer phone) {
        this.post = post;
        this.name = name;
        this.imgUrl = imgUrl;
        this.phone = phone;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }
}
