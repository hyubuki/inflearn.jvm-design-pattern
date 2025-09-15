package behavioral.strategy.payment;

import behavioral.strategy.PaymentContext;
import behavioral.strategy.PaymentRequest;
import behavioral.strategy.PaymentResult;
import behavioral.strategy.PaymentStrategy;
import behavioral.strategy.PaymentType;
import java.util.UUID;

public class CreditCardPaymentStrategy implements PaymentStrategy {

  // TODO : PaymentContext 기반 supports 여부 재정의
  @Override
  public boolean supports(PaymentContext ctx) {
    return ctx.type() == PaymentType.CREDIT_CARD;
  }

  @Override
  public PaymentType getSupportedType() {
    return PaymentType.CREDIT_CARD;
  }

  @Override
  public PaymentResult pay(PaymentRequest request) {

    // 유효성 검증
    if(false) {
      return new PaymentResult(false, null, "카드 정보가 올바르지 않습니다");
    }
    return new PaymentResult(true, "CC-" + UUID.randomUUID().toString().replaceAll("-", ""), "카드 결제가 완료됐습니다");
  }
}
