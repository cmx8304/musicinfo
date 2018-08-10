package com.qingguatang.java5minute.course4.model;

import java.util.Date;

/**
 * 评论类
 * @author caomengxi 2018/8/8.
 * @version 1.0
 */
public class Comment {
    private String id;
    //头像
    private String icon;
    //昵称
    private String nickName;
    //内容
    private String content;
    //评论时间
    private Date commentTime;
    //点赞数
    private int likeNum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }
}
