package pl.sda.customers;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.math.BigDecimal.ZERO;
import static java.math.BigDecimal.valueOf;

public class CustomerService {

    public List<Customer> convertToList(Customer[] customers) {
        if (customers == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(customers);
    }

    public List<String> convertToListOfNames(Customer[] customers) {
        List<String> names = new ArrayList<>();
        for (Customer customer : customers) {
            names.add(customer.getFirstName().trim() + " " + customer.getLastName().trim());

        }
        return names;
    }


    public List<String> convertToListOfNamesWithStream(Customer[] customers) {
        return Arrays.stream(customers)
                .map(c -> c.getFirstName().trim() + " " + c.getLastName().trim()).collect(Collectors.toList());
    }


    //mapToObject - możemy z prymitywów przeorbić na duże inty
    public Map<Integer, Customer> convertToMap(Customer[] customers) {
        return Optional.ofNullable(customers)
                .map(ca -> Arrays.stream(ca)
                        .collect(Collectors.toMap(Customer::getId, Function.identity())))
                .orElse(Collections.emptyMap());
    }

    public BigDecimal computeAllWishItemsCost(Customer customer, Map<String, BigDecimal> carOptionNamePriceMap) {
        return customer.getWishList().stream()
                .map(wishItem -> valueOf(wishItem.getQuantity())
                        .multiply(carOptionNamePriceMap
                                .get(wishItem.getName())))//todo
                .reduce(ZERO, (p1, p2) -> p1.add(p2));
    }

    public List<WishItem> getAffordableItemsIncludingOrder(Customer customer, Map<String, BigDecimal> carOptionNamePriceMap) {
        return null; //todo
    }

    public List<WishItem> getAffordableItemsMaxQuantity(Customer customer, Map<String, BigDecimal> carOptionNamePriceMap) {
        return null; //todo
    }

    private BigDecimal getWishItemFinalPrice(Map<String, BigDecimal> carOptionNamePriceMap, WishItem wishItem) {
        return new BigDecimal(0); //todo
    }
}
