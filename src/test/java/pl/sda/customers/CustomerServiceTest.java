package pl.sda.customers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {
    private static final Customer[] people = new Customer[]{
            new Customer( "Anna", "Nowak   ", 33, "1200"),
            new Customer( "Beata", "Kowalska", 22, "1200"),
            new Customer( "Marek", " Nowak", 25, "1250"),
            new Customer( "Adam", "Twardowski", 33, "4100"),
            new Customer( "Monika  ", "Kos", 25, "2500"),
            new Customer( "Adam ", "Rudy", 45, "3333"),
            new Customer( "Marek", "Rudy", 15, 2210),
            new Customer( "Adam", "Madej", 15, 3333)
    };

    private CustomerService customerService = new CustomerService();

    @Test
    void eachCustomerShouldHaveAutoincrementedIdStartingFromOne() {
        Assertions.assertEquals(5, people[4].getId());
    }

    @Test
    void convertToListShouldHaveTheSameSize() {
        List<Customer> customers = customerService.convertToList(people);
        Assertions.assertEquals(8, customers.size());
    }

    @Test
    void convertToListShouldPreserveOrder() {
        List<Customer> customers = customerService.convertToList(people);
        Assertions.assertEquals(people[1], customers.get(1));
        Assertions.assertEquals(people[3], customers.get(3));
        Assertions.assertEquals(people[7], customers.get(7));
    }

   @Test
    void convertToListShouldReturnEmptyListOnNullArray() {
        List<Customer> customers = customerService.convertToList(null);
        Assertions.assertEquals(0, customers.size());
    }

    @Test
    void convertToListOfNamesReturnsListOfConcatenatedData(){
        List<String> listOfNames = customerService.convertToListOfNames(people);
        Assertions.assertEquals("Monika Kos", listOfNames.get(4));
    }

    @Test
    void convertToMapShouldReturnMapWithIdAsKey(){
        Map<Integer, Customer> customerMap = customerService.convertToMap(people);
        Assertions.assertEquals(8, customerMap.size());
        Assertions.assertEquals(people[4], customerMap.get(5));
    }
}