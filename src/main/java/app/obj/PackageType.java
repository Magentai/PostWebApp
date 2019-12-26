package app.obj;

import javax.persistence.*;

@Entity
@Table(name = "PACKAGETYPE")
public class PackageType {

    Long id;
    String name;
    double cost;

    public PackageType() {
    }

    public PackageType(Long id, String name, double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NAME", length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "COST")
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}