package cn.niit.shougongke.entity;

public class User {
    private Integer id;
    private Integer isDel;
    private String name;
    private String img;
    private String password;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", isDel=" + isDel +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
