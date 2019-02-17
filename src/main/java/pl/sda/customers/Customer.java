package pl.sda.customers;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Customer {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private BigDecimal salary;
    private List<WishItem> wishList;

    private static AtomicInteger sequenceGenerator = new AtomicInteger();

    public Customer(String firstName, String lastName, Integer age, BigDecimal salary) {
        this.id = sequenceGenerator.incrementAndGet();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public Customer(String firstName, String lastName, Integer age, String salary) {
        this(firstName, lastName, age, new BigDecimal(salary));
    }

    public Customer(String firstName, String lastName, Integer age, int salary) {
        this(firstName, lastName, age, new BigDecimal(salary));
    }

    public List<WishItem> getWishList() {
        return null; //todo
    }

    public void addToWishList(WishItem wishItem) {
        //todo
    }
}
