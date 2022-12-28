package com.company;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Hangman {
    String secretWord;
    String[] correctLetter;
    String[] incorrectLetter;
    String[] guess;
    int incorrectGuesses = 0;
    String incorrect = "";

    public Hangman() {
        Scanner nt = new Scanner(System.in);
        System.out.println("Welcome to Hangman!");
        System.out.println("Would you like an easy word or hard word? Enter 'e' for easy and 'h' for hard");
        String c = nt.next();
        while(!c.equals("e") && !c.equals("h")){
            System.out.println("Please enter 'e' for easy and 'h' for hard");
            c = nt.next();
        }
        Word n = new Word(c);
        secretWord = n.returnWord();
        correctLetter = new String[secretWord.length()];
        guess = new String[secretWord.length()];
        for (int i = 0; i < correctLetter.length; i++) {
            correctLetter[i] = secretWord.substring(i, i + 1);
            guess[i] = "_ ";
        }

    }

    public Boolean isLetter(String s) {
        Boolean rv = true;
        for (int i = 0; i < correctLetter.length; i++) {
            if (correctLetter[i].equals(s)) {
                guess[i] = s;
            }
        }

        if (!secretWord.contains(s)) {
            if(noRepeats(s)) {
                incorrect = incorrect + s + ", ";
            }
            rv = false;
            int l;
            incorrectGuesses++;
            if (incorrectLetter == null) {
                l = 1;
                incorrectLetter = new String[l];
            } else {
                l = incorrectLetter.length+1;

            }

            String[] copy = new String[l];
            for (int j = 0; j < incorrectLetter.length; j++) {
                copy[j] = incorrectLetter[j];
            }
            copy[incorrectLetter.length-1] = s;
            incorrectLetter = copy;
        }
        //printBoard();
        return rv;

    }


    public boolean isWinner(){
        boolean value = false;
        int x = secretWord.length();//having a value be the length of the letters in the word
        int g = 0;
        for (int i = 0; i <guess.length ; i++) {
            if(!guess[i].equals("_ ")){
                g++;//we increment g each time a letter is guessed
            }
        }
        if(g == x){//if the length of how many letters guessed equals the amount of letters in the word, we return true, to signify that there is, in fact a winner.
            value = true;
        }
        return value;
    }//end isWinner()

    public boolean isLoser(){
        boolean value = false;
        if(incorrectGuesses-3>=4){//if the amount of guesses surpasses the amount of tries allowed, return true so that we know that the game is completed
            value = true;
        }
        return value;
    }//end isLoser()

    public boolean noRepeats(String a){
        boolean rv=true;
        if(incorrectLetter!=null) {
            List<String> list = Arrays.asList(incorrectLetter);//we list the incorrect letter array as a list
            if(list.contains(a)){//if the list of the letters has the letter that we inputted, we returned false.
                rv = false;
            }
            if (incorrect.contains(a)) {
                rv = false;
            }
        }
        return rv;
    }//end noRepeats()


    public void printBoard(){
        String s = "";
        for (int i = 0; i <guess.length ; i++) {
            s = s + guess[i];
        }

        if (incorrectGuesses == 0) { // for picture 1
            System.out.println("         ____________");
            System.out.println("        |      |     |          Incorrect Letters: " +incorrect );
            System.out.println("        |            |");
            System.out.println("        |            |");
            System.out.println("        |            |");
            System.out.println("        |            |");
            System.out.println("         ____________");
            System.out.println("                           " + s);
            System.out.print("\n");
        }

        if (incorrectGuesses-1 == 1) { // for picture 1
            System.out.println("         ____________");
            System.out.println("        |      |     |          Incorrect Letters: " +incorrect );
            System.out.println("        |      O     |");
            System.out.println("        |            |");
            System.out.println("        |            |");
            System.out.println("        |            |");
            System.out.println("         ____________");
            System.out.println("                            "+ s);
            System.out.print("\n");
        } else if (incorrectGuesses-2 == 2) { // for picture 2
            System.out.println("         ____________");
            System.out.println("        |      |     |          Incorrect Letters: " +incorrect );
            System.out.println("        |      O     |");
            System.out.println("        |      |     |");
            System.out.println("        |            |");
            System.out.println("        |            |");
            System.out.println("         ____________");
            System.out.println("                            " + s);
            System.out.print("\n");
        } else if (incorrectGuesses-3 == 3) { // for picture 3
            System.out.println("         ____________");
            System.out.println("        |      |     |          Incorrect Letters: " +incorrect );
            System.out.println("        |      O     |");
            System.out.println("        |     -|-    |");
            System.out.println("        |            |");
            System.out.println("        |            |");
            System.out.println("         ____________");
            System.out.println("                            " + s);
            System.out.print("\n");
        } else if (incorrectGuesses-4== 4) { // for picture 4
            System.out.println("         ____________");
            System.out.println("        |      |     |          Incorrect Letters: " +incorrect );
            System.out.println("        |      O     |");
            System.out.println("        |     -|-    |");
            System.out.println("        |     | |    |");
            System.out.println("        |            |");
            System.out.println("         ____________");
            System.out.println("                            " + s);
            System.out.print("\n");
        }


    }


}


