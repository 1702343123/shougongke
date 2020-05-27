package cn.niit.shougongke.entity;

public class Shopping {
    private int id;
    private int userId;
    private int isDel;
    private int commodityId;


    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Shopping{" +
                "id=" + id +
                ", userId=" + userId +
                ", isDel=" + isDel +
                ", commodityId=" + commodityId +
                '}';
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

    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }
}
