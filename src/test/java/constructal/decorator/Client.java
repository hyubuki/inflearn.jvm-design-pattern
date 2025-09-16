package constructal.decorator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class Client {

  @Test
  public void practice() {
    try(FileReader fileReader = new FileReader("src/test/java/constructal/decorator/hello.txt")) {
      int ch;
      while((ch = fileReader.read()) != -1) {
        char character = (char) ch;
        System.out.print(character);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void decoratePractice() {
    try (FileReader fileReader = new FileReader("src/test/java/constructal/decorator/hello.txt"); BufferedReader br = new BufferedReader(fileReader);){
      System.out.println(br.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void calCoffee() {
    Beverage beverage = new Americano();
    System.out.println(beverage);

    beverage = new SugarOption(beverage);
    System.out.println(beverage);

    beverage = new ShotOption(beverage);
    System.out.println(beverage);
  }
}