import java.util.Scanner;
import java.util.random.RandomGenerator;

public class NumberGame {

    public static void main(String[] args) {

        Integer number = RandomGenerator.getDefault().nextInt(1, 100);
        System.out.println(number);
        int maxGuesses = 10;
        int guesses = 1;
        int rounds = 0, score =0;
        Scanner input = new Scanner(System.in);
        while ( true){
            System.out.print("Enter your Guess: ");
            Integer guess = input.nextInt();
            if (guess.equals(number)){
                System.out.println("Yess You got it in "+ guesses+ " guesses");
                score++;
                System.out.print("press 1 if you want to play again: ");
                int choice = input.nextInt();
                rounds++;
                if (choice==1){
                    number = RandomGenerator.getDefault().nextInt(1, 100);
                    guesses = 0;
                }
                else {
                    System.out.print("Your score is "+ score + " after "+ rounds +" rounds.");
                    break;}
            } else if (guess>number) {
                System.out.println("Thats High Try lower number ");
            }
            else {
                System.out.println("Thats Low try a higher number");
            }
            guesses++;
            if (guesses >= maxGuesses){
                System.out.println("You've run out of guesses");
                System.out.println("press 1 if you want to play again: ");
                int choice = input.nextInt();
                rounds++;
                if (choice==1){
                    number = RandomGenerator.getDefault().nextInt(1, 100);
                    guesses = 0;
                }
                else {
                    System.out.print("Your score is "+ score + " after "+ rounds +" rounds.");
                    break;
                }
            }
        }
    }
}