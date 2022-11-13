import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        String[] input = scanner.nextLine().split("");
        for (String s : input) {
            sum += Integer.parseInt(s);
        }
        System.out.println(sum);
    }
}