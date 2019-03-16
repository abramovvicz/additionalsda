package pl.sda.customers;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
public class CustomerNew {


    private static int counter = 1;
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private BigDecimal salary;

    {
        id = counter++;
    }


    public CustomerNew(String firstName, String lastName, int age, int salary) {
        this(firstName, lastName, age, BigDecimal.valueOf(salary)); //wywołanie konstrutkora w konstruktorze
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.age = age;
//        this.salary = BigDecimal.valueOf(salary);
    }

    public CustomerNew(String firstName, String lastName, int age, String salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = Optional.ofNullable(salary)
                .map(String::trim)
                .map(Integer::parseInt)
                .map(BigDecimal::valueOf)
                .orElse(null);

//to samo co wyżej
//        this.salary = salary == null ? null : BigDecimal.valueOf(Integer.parseInt(salary.trim()));
    }

    private CustomerNew(String firstName, String lastName, int age, BigDecimal salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public List<Customer> changeTheTableToList(Customer[] customers) {
        return Arrays.asList(customers);
    }

    public List<String> showListNames(Customer[] customers) {
        List<String> names = new ArrayList<>();
        for (Customer customer : customers) {
            names.add(customer.getLastName().trim() + " " + customer.getLastName().trim());
        }
        return names;
    }

    public List<String> showListNamesStream(Customer[] customers) {
        return Arrays.stream(customers).map(x -> x.getFirstName().trim() + " " + x.getLastName().trim()).collect(Collectors.toList());
    }

    public Map<String, Map<BigDecimal, Integer>> createMapOfMapsGroupByNameAndSalary(Customer[] customers) {
        Map<String, Map<BigDecimal, Integer>> resultMap = new HashMap<>();
        for (Customer customer : customers) {
            if (resultMap.containsKey(customer.getFirstName())) {
                Map<BigDecimal, Integer> innerMapNew = resultMap.get(customer.getFirstName());
                if (innerMapNew.containsKey(customer.getSalary())) {
                    Integer counter = innerMapNew.get(customer.getSalary());
                    innerMapNew.put(customer.getSalary(), counter++);
                } else {
                    Map<BigDecimal, Integer> innerMap = new HashMap<>();
                    innerMap.put(customer.getSalary(), 1);
                    resultMap.put(customer.getFirstName(), innerMap);
                }
            } else {
                Map<BigDecimal, Integer> innerMap = new HashMap<>();
                innerMap.put(customer.getSalary(), 1);
                resultMap.put(customer.getFirstName(), innerMap);
            }

        }
        return resultMap;
    }

    public Map<String, Map<BigDecimal, Long>> createMapOfMapsGroupByNameAndSalaryWithStream(Customer[] customers) {
        return Arrays.stream(customers)
                .collect(Collectors.groupingBy(c -> c.getFirstName().trim(),
                        Collectors.groupingBy(c -> c.getSalary(), Collectors.counting())));
    }
}