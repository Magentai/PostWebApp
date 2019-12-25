package app.obj;

import javax.persistence.*;

@Entity
@Table(name = "OFFICE")
public class Office {

    int id;
    String index;
    String city;
    String addr;
    String phone;

    public Office() {
    }

    public Office(String index, String city, String addr, String phone) {
        this.index = index;
        this.city = city;
        this.addr = addr;
        this.phone = phone;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "INDEX", length = 6)
    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    @Column(name = "CITY", length = 100)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "ADDR", length = 200)
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Column(name = "PHONE", length = 11)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", index='" + index + '\'' +
                ", city='" + city + '\'' +
                ", addr='" + addr + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}