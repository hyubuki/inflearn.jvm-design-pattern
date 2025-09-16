package constructal.decorator;

public class ShotOption extends AddOptionDecorator {

  public ShotOption(Beverage beverage) {
    super(beverage);
  }

  @Override
  public String getIngredient() {
    return beverage.getIngredient() + ", Shot";
  }

  @Override
  public int cost() {
    return beverage.cost() + 5;
  }
}
