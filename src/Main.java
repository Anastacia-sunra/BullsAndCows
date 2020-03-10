import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Input a 4-digit string:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        try {
            Validator.validateString(input);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }
}
