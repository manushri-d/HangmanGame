package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner v = new Scanner(System.in);//importing the scanner to get their user input
        String val = "y";//having a variable to loop until stopped
        while(val.equals("y")){
            Hangman play = new Hangman();//creating Hangman object
            play.printBoard();//printing the board
            boolean p = true;//having a boolean variable for a loop to run through until the game is done
            while(p){
                System.out.println("Enter a letter for your guess");
                String g1 = v.next();//takes the user input in the form of a String
                while(g1.length()>1 || !play.noRepeats(g1)){//if there are repeats, we ask to re-enter a new letter
                    if(g1.length()>1){
                        System.out.println("You inputted more than one letter");
                    }else {
                        System.out.println("You already inputted that letter");
                    }
                    System.out.println("Enter a letter for your guess");
                    g1 = v.next();
                }
                if(play.isLetter(g1)){//if the letter is in the word we indicate that the guess is correct
                    System.out.println("Good guess!");
                    play.printBoard();
                }
                if(!play.isLetter(g1)){//if the letter is not in the word we print that it is wrong
                    System.out.println("Try again");
                    play.printBoard();
                }
                if(play.isWinner()){//if the isWinner method returns true, we print a congratulory statement
                    System.out.println("You won!");
                    p = false;
                }
                if(play.isLoser()){//if the isLoser method returns true, we indicate so.
                    System.out.println("You lost. The word was " + play.secretWord);
                    p = false;
                }
            }
            System.out.println("Want to play again? Press y for yes or n for no");
            val = v.next();//if the value is y, the while loop loops again, else it exits
        }
    }//end main()
}//end Main
