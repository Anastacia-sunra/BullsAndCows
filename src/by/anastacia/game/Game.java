package by.anastacia.game;

import by.anastacia.game.exception.ValidationException;
import by.anastacia.game.service.Herd;
import by.anastacia.game.service.Shepherd;
import by.anastacia.game.service.Vet;
import by.anastacia.game.validator.Validator;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        String again = "";
        do {
            System.out.println(again);
            System.out.println("If you want to finish press 0");
            System.out.println("Input \"1\" if you want to guess a number that was chosen by the computer" + '\n'
                    + "And any other key if you want to chose your own number");
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            if (input.equals("1")) {
                interrogateShepherd();
            } else {
                beInterrogated();
            }
            again = "Do you want to play again?";
        }
        while (true);
    }

    public static Shepherd hireShepherd() {
        Random random = new Random();
        char[] code = null;
        int rand = 0;
        do {
            rand = random.nextInt(9000) + 1000;
            try {
                code = Validator.validateString(String.valueOf(rand));
            } catch (ValidationException e) {
                continue;
            }
        }
        while (code == null);
        return new Shepherd(code);
    }

    public static void interrogateShepherd() {
        System.out.println("You can interrogate Shepherd");
        Shepherd shepherd = hireShepherd();
        int attempt = 0;
        do {
            attempt++;
        }
        while (!askShepherd(shepherd));
        System.out.println("Number of attempts is " + attempt);
    }

    public static boolean askShepherd(Shepherd shepherd) {
        System.out.println("Input a 4-digit string:");
        String input = scanner.nextLine().trim();
        char[] guess = null;
        Herd herd = null;
        try {
            guess = Validator.validateString(input);
            herd = shepherd.countHerd(guess);
            System.out.println(herd);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }

        if (herd != null && herd.getBulls() == 4) {
            System.out.println("Victory!");
            return true;
        }
        return false;
    }

    public static void beInterrogated() {
        System.out.println("Now you will be interrogated");
        Vet vet = new Vet();
        int attempt = 0;
        do {
            askMe(vet);
            attempt++;
        }
        while (vet.getVariants().size() > 1);
        if (vet.getVariants().size() == 1) {
            System.out.println("Your number is: " + String.valueOf(vet.getVariants().get(0)) + '\n'
                    + "Number of attempts is " + attempt);
        } else {
            System.out.println("You made a mistake");
        }
    }

    public static void askMe(Vet vet) {
        char[] code = vet.guessCode();
        System.out.println(Arrays.toString(code));
        System.out.print("Bulls: ");
        String reply = scanner.nextLine();
        int bulls = Integer.parseInt(reply);
        System.out.print("Cows: ");
        reply = scanner.nextLine();
        int cows = Integer.parseInt(reply);
        Herd herd = new Herd(bulls, cows);
        vet.deleteWrong(code, herd);
    }

}
