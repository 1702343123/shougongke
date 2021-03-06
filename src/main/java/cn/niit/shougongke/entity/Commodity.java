package cn.niit.shougongke.entity;

public class Commodity {
    private Integer id;
    private String title;
    private Integer price;
    private String img;
    private int inCar;
    private int inCollect;

    public int getInCollect() {
        return inCollect;
    }

    public void setInCollect(int inCollect) {
        this.inCollect = inCollect;
    }

    public int getInCar() {
        return inCar;
    }

    public void setInCar(int inCar) {
        this.inCar = inCar;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", img='" + img + '\'' +
                '}';
    }
}
