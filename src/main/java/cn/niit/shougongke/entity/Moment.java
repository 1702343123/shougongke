package cn.niit.shougongke.entity;

import java.sql.Timestamp;

public class Moment {
    private Integer id;
    private Integer userId;
    private String content;
    private String img;
    private Timestamp createTime;
    private String time;
    private Integer isDel;
    private User user;
    private int inLike;

    public int getInLike() {
        return inLike;
    }

    public void setInLike(int inLike) {
        this.inLike = inLike;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public String toString() {
        return "Moment{" +
                "id=" + id +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", img='" + img + '\'' +
                ", createTime=" + createTime +
                ", time='" + time + '\'' +
                ", isDel=" + isDel +
                ", user=" + user +
                '}';
    }
}
