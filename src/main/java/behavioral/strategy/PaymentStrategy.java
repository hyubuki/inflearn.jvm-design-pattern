package behavioral.strategy;

public interface PaymentStrategy {

  boolean supports(PaymentContext ctx);
  PaymentType getSupportedType();
  PaymentResult pay(PaymentRequest request);
}
