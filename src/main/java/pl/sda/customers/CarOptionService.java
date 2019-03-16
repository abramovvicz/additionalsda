package pl.sda.customers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class CarOptionService {

    public Map<String, BigDecimal> convertToNamePriceMap(CarOption[] carOptions) {
        return Arrays.stream(carOptions)
                .collect(Collectors.toMap(e -> e.getName(), e -> BigDecimal.valueOf(e.getPrice())));
    }
}