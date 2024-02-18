package lk.ijse.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer")

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private int id;
    @Column(name = "customer_name")
    private  String name;
    @Column(name = "customer_address")
    private String address;
    @Column(name = "custome_moNumber")
    private int moNumber;

    public Customer(){}

    public Customer(int id,String name, String address, String mobile) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.moNumber = Integer.parseInt(mobile);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMoNumber() {
        return moNumber;
    }

    public void setMoNumber(int moNumber) {
        this.moNumber = moNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", moNumber=" + moNumber +
                '}';
    }
}
