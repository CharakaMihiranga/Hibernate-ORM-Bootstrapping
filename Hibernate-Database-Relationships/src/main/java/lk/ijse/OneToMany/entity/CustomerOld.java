package lk.ijse.OneToMany.entity;

import lk.ijse.OneToMany.embedded.MobileNumber;
import lk.ijse.OneToMany.embedded.NameIdentifier;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

//@Entity(name = "")
@Entity
@Table(name = "customer")
public class CustomerOld {

    @CreationTimestamp // To add time and Date to the Database
    private Timestamp  createdDateTime;

    @Id //tells Hibernate,that this is the Primary key of this table
//  @GeneratedValue(strategy = GenerationType.SEQUENCE) //to define a strategy
    @GeneratedValue(strategy = GenerationType.AUTO) //to define a strategy


    @Column(name = "customer_id")
    private int id;
    @Column(name = "customer_name")
    private NameIdentifier name;

    @Transient // Transiented attributes does not create when implementing the database
    @Column(name = "customer_address")
    private String address;

   @ElementCollection
   @CollectionTable(
           name = "customer_mobile_nos",
                   joinColumns = @JoinColumn(name = "customer_id")
                    )
    private List<MobileNumber> mobileNumbers
           = new ArrayList<>();

    public List<MobileNumber> getMobileNumbers() {
        return mobileNumbers;
    }

    public void setMobileNumbers(List<MobileNumber> mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }

    @Transient
    @Column(name = "customer_salary")
    private double salary;

    @Override
    public String toString() {
        return "Customer{" +
                "createdDateTime=" + createdDateTime +
                ", id=" + id +
                ", name=" + name +
                ", address='" + address + '\'' +
                ", mobileNumbers=" + mobileNumbers +
                ", salary=" + salary +
                '}';
    }

    public CustomerOld(int id, NameIdentifier name, String address, double salary, List<MobileNumber> mobileNumbers) {

        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.mobileNumbers = mobileNumbers;

    }
    public CustomerOld(){}

    public int getId() {
        return id;
    }

    public NameIdentifier getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(NameIdentifier name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
