package constructal.decorator;

public class SugarOption extends AddOptionDecorator {

  public SugarOption(Beverage beverage) {
    super(beverage);
  }

  @Override
  public String getIngredient() {
    return beverage.getIngredient() + ", Sugar";
  }

  @Override
  public int cost() {
    return beverage.cost() + 1;
  }
}
