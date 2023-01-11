package net.codejava;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Use{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private int age;

    private String address;

    private  Date date;


    protected Use()
    {
    }

    protected Use(Long id, String name, int age, String address, Date date)
    {
        super();
        this.id = id;
        this.name = name;
        this.age=age;
        this.address=address;
        this.date=date;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Use [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address
                + ",date=" + date + "]";
    }

}
