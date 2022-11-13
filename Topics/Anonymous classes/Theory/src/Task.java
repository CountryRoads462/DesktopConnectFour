import java.util.Scanner;

public class Task {
  public static Runnable createRunnable(String text, int repeats) {
    return new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < repeats; i++) {
          System.out.println(text);
        }
      }
    };
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String text = scanner.nextLine();
    int repeats = Integer.parseInt(scanner.nextLine());
    Runnable forrest = createRunnable(text, repeats);
    forrest.run();
  }
}
