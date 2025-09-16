package behavioral.strategy.payment;

import behavioral.strategy.PaymentContext;
import behavioral.strategy.PaymentRequest;
import behavioral.strategy.PaymentResult;
import behavioral.strategy.PaymentStrategy;
import behavioral.strategy.PaymentType;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.UUID;

public class TransferPaymentStrategy implements PaymentStrategy {

  // TODO : PaymentContext 기반 supports 여부 재정의
  @Override
  public boolean supports(PaymentContext ctx) {
    return ctx.type() == PaymentType.BANK_TRANSFER;
  }

  @Override
  public PaymentType getSupportedType() {
    return PaymentType.BANK_TRANSFER;
  }

  @Override
  public PaymentResult pay(PaymentRequest request) {
    // 유효성 검증
    if(false) {
      return new PaymentResult(false, null, "계좌 이체 중 실패하였습니다.");
    }
    return new PaymentResult(true, "TRX-" + UUID.randomUUID().toString().replaceAll("-", ""), "계좌 이체가 완료됐습니다");
  }
}
