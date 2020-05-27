package cn.niit.shougongke.entity;

public class Collect {
    private int id;
    private int commodityId;
    private int isDel;
    private int userId;

    @Override
    public String toString() {
        return "Collect{" +
                "id=" + id +
                ", commodityId=" + commodityId +
                ", isDel=" + isDel +
                ", userId=" + userId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
