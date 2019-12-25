package app.obj;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PACKAGE")
public class PostPackage {

    int id;
    String sender_name;
    String sender_addr;
    String dest_name;
    String dest_addr;
    Date send_date;
    int package_type;
    double weight;
    double COD;

    public PostPackage() {
    }

    public PostPackage(int id, String sender_name, String sender_addr, String dest_name, String dest_addr, Date send_date, int package_type, double weight, double COD) {
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    public Date getSend_date() {
        return send_date;
    }

    public void setSend_date(Date send_date) {
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
}