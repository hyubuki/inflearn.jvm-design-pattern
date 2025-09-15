package behavioral.strategy;

import behavioral.strategy.payment.CreditCardPaymentStrategy;
import behavioral.strategy.payment.TransferPaymentStrategy;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Client {

  private List<PaymentStrategy> strategies;
  private PaymentProcessor paymentProcessor;

  @BeforeEach
  public void setUp() {
    strategies = List.of(
        new CreditCardPaymentStrategy(),
        new TransferPaymentStrategy()
    );
    paymentProcessor = new PaymentProcessor(strategies);
  }


  @Test
  public void client() {
    PaymentRequest request = new PaymentRequest(
        "ORDER-1234",
        BigDecimal.valueOf(5000),
        "KRW",
        Map.of("cardNumber", "1234-5678-9012-3456", "expiryDate", "12/25", "cvv", "123")
    );

    PaymentContext context = new PaymentContext(
        PaymentType.CREDIT_CARD,
        "VISA",
        Map.of()
    );

    PaymentRequest request2 = new PaymentRequest(
        "ORDER-5678",
        BigDecimal.valueOf(15000),
        "KRW",
        Map.of("accountNumber", "987-654-3210", "accountHolder", "John Doe")
    );

    PaymentContext context2 = new PaymentContext(
        PaymentType.BANK_TRANSFER,
        "KB",
        Map.of()
    );

    PaymentResult result = paymentProcessor.process(context, request);
    System.out.println("Payment Success: " + result.success());
    System.out.println("Transaction ID: " + result.transactionId());
    System.out.println("Message: " + result.message());

    PaymentResult result2 = paymentProcessor.process(context2, request2);
    System.out.println("Payment Success: " + result2.success());
    System.out.println("Transaction ID: " + result2.transactionId());
    System.out.println("Message: " + result2.message());
  }
}