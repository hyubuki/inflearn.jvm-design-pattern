package behavioral.strategy;

import java.util.Map;

public record PaymentContext(
   PaymentType type,
   String Provider,
   Map<String, String> meta
) {}
