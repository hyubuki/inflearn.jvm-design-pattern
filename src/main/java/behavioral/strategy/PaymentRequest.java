package behavioral.strategy;

import java.math.BigDecimal;
import java.util.Map;

public record PaymentRequest(
  String orderId,
  BigDecimal amount,
  String currency,
  Map<String, String> meta
) {}
