package pl.sda.customers;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Customer {
    private static AtomicInteger sequenceGenerator = new AtomicInteger();
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private BigDecimal salary;
    private List<WishItem> wishList;

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
        return wishList; //todo
    }

    public void addToWishList(WishItem wishItem) {
        if(wishList == null){
            wishList = new ArrayList<>();
        }
        wishList.add(wishItem);
        //todo
    }

    public Integer getId() {
        return id;
    }
}
