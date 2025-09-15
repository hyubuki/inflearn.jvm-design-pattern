package behavioral.strategy;

public record PaymentResult(
    boolean success,
    String transactionId,
    String message
) {}
