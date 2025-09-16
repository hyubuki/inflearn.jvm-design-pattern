package constructal.decorator;

public abstract class AddOptionDecorator implements Beverage {
  protected Beverage beverage;

  public AddOptionDecorator(Beverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public String toString() {
    return getIngredient() + " -> $" + cost();
  }
}
