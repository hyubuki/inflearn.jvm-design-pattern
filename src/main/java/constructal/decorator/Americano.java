package constructal.decorator;

public class Americano implements Beverage {

  @Override
  public String getIngredient() {
    return "Americano";
  }

  @Override
  public int cost() {
    return 10;
  }

  @Override
  public String toString() {
    return getIngredient() + " -> $" + cost();
  }
}
