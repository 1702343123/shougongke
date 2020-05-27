package cn.niit.shougongke.entity;

public class Like {
    private int id;
    private int userId;
    private int momentId;
    private int isDel;

    @Override
    public String toString() {
        return "Like{" +
                "id=" + id +
                ", userId=" + userId +
                ", momentId=" + momentId +
                ", isDel=" + isDel +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMomentId() {
        return momentId;
    }

    public void setMomentId(int momentId) {
        this.momentId = momentId;
    }

    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }
}
