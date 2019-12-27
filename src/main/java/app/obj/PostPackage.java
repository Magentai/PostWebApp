package app.obj;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "PACKAGE")
public class PostPackage {

    private Long id;
    private String sender_name;
    private String sender_addr;
    private String dest_name;
    private String dest_addr;
    private int package_type;
    private Timestamp send_date;
    private double weight;
    private double COD;

    public PostPackage() {
    }

    public PostPackage(Long id, String sender_name, String sender_addr, String dest_name, String dest_addr, Timestamp send_date, int package_type, double weight, double COD) {
        this.id = id;
        this.sender_name = sender_name;
        this.sender_addr = sender_addr;
        this.dest_name = dest_name;
        this.dest_addr = dest_addr;
        this.send_date = send_date;
        this.package_type = package_type;
        this.weight = weight;
        this.COD = COD;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "SENDER_NAME", length = 400)
    public String getSender_name() {
        return sender_name;
    }

    public void setSender_name(String sender_name) {
        this.sender_name = sender_name;
    }

    @Column(name = "SENDER_ADDR", length = 200)
    public String getSender_addr() {
        return sender_addr;
    }

    public void setSender_addr(String sender_addr) {
        this.sender_addr = sender_addr;
    }

    @Column(name = "DEST_NAME", length = 400)
    public String getDest_name() {
        return dest_name;
    }

    public void setDest_name(String dest_name) {
        this.dest_name = dest_name;
    }

    @Column(name = "DEST_ADDR", length = 200)
    public String getDest_addr() {
        return dest_addr;
    }

    public void setDest_addr(String dest_addr) {
        this.dest_addr = dest_addr;
    }

    @Column(name = "SEND_DATE")
    public Timestamp getSend_date() {
        return send_date;
    }

    public void setSend_date(Timestamp send_date) {
        this.send_date = send_date;
    }

    @Column(name = "PACKAGE_TYPE")
    public int getPackage_type() {
        return package_type;
    }

    public void setPackage_type(int package_type) {
        this.package_type = package_type;
    }

    @Column(name = "WEIGHT")
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Column(name = "COD")
    public double getCOD() {
        return COD;
    }

    public void setCOD(double COD) {
        this.COD = COD;
    }

    @Override
    public String toString() {
        return "PostPackage{" +
                "id=" + id +
                ", sender_name='" + sender_name + '\'' +
                ", sender_addr='" + sender_addr + '\'' +
                ", dest_name='" + dest_name + '\'' +
                ", dest_addr='" + dest_addr + '\'' +
                ", package_type=" + package_type +
                ", send_date=" + send_date +
                ", weight=" + weight +
                ", COD=" + COD +
                '}';
    }
}