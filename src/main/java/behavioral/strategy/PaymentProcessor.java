package behavioral.strategy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class PaymentProcessor {

  private final Map<PaymentType, List<PaymentStrategy>> registry;

  public PaymentProcessor(List<PaymentStrategy> strategies) {
    this.registry = new EnumMap<>(PaymentType.class);
    init(strategies);
  }

  private void init(List<PaymentStrategy> strategies) {
    for (PaymentStrategy strategy : strategies) {
      for(PaymentType paymentType : PaymentType.values()) {
        if(strategy.getSupportedType() == paymentType) {
          this.registry.computeIfAbsent(paymentType, k -> new ArrayList<>()).add(strategy);
        }
      }
    }
  }

  public PaymentResult process(PaymentContext ctx, PaymentRequest req) {

    if(!req.currency().equals("KRW")) return new PaymentResult(false, null, "외화는 지원하지 않습니다.");
    if(req.amount().compareTo(BigDecimal.ZERO) <= 0) return new PaymentResult(false, null, "결제 금액은 0원 이상이어야 합니다.");

    List<PaymentStrategy> candidates = this.registry.getOrDefault(ctx.type(), List.of());

    // TODO : 현재는 2가지 전략밖에 없어서 supports에서 meta 활용 x
    return candidates.stream()
        .filter(s -> s.supports(ctx))
        .findFirst()
        .map(s -> s.pay(req))
        .orElseGet(() -> new PaymentResult(false, null, "지원하지 않는 결제 수단입니다."));
  }

}
