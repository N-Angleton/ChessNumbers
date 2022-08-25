import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class App {

  static String inputLetter;
  static String piece;
  static Integer inputInt;
  static HashMap<Integer, ArrayList<Integer>> moves;
  static int[] permutations = {1,1,1,1,1,1,1,1,1,1};
  static int[] solutions;

  public static void main(String[] args) {
    retrieveInput();
    generateNumbers();
    printSolution();
  }

  public static void retrieveInput() {
    Scanner scanner = new Scanner(System.in);

    System.out.println(" ̲ ̲ ̲ ̲ ̲ ̲ ̲");
    System.out.println("  1 2 3  ");
    System.out.println("  4 5 6  ");
    System.out.println("  7 8 9  ");
    System.out.println("  * 0 #  ");
    System.out.println(" ̅ ̅ ̅ ̅ ̅ ̅ ̅");

    System.out.println("\nPlease select which piece you would like to calculate phone numbers for:");
    System.out.println("\nP for Pawn");
    System.out.println("N for Knight");
    System.out.println("B for Bishop");
    System.out.println("R for Rook");
    System.out.println("Q for Queen");
    System.out.println("K for King\n");

    inputLetter = scanner.nextLine().substring(0,1).toUpperCase();

    while (!("PNBRQK".contains(inputLetter))) {
      System.out.println("Please try again...\n");
      inputLetter = scanner.nextLine().substring(0,1).toUpperCase();
    }

    if (inputLetter.equals("P")) {
      piece = "Pawn";
    } else if (inputLetter.equals("N")) {
      piece = "Knight";
    } else if (inputLetter.equals("B")) {
      piece = "Bishop";
    } else if (inputLetter.equals("R")) {
      piece = "Rook";
    } else if (inputLetter.equals("Q")) {
      piece = "Queen";
    } else {
      piece = "King";
    }
    
    System.out.println("You selected a " + piece);

    moves = Pieces.getPrevPositions(inputLetter);

    System.out.println("\nPlease select the maximum length of a number to make (>= 1):\n");

    while(!scanner.hasNextInt()) {
      System.out.println("Please try a number...\n");
      scanner.next();
    }

    inputInt = scanner.nextInt();

    while (!(inputInt >= 1)) {
      System.out.println("Please try again...\n");
      while(!scanner.hasNextInt()) {
        System.out.println("Please try a number...\n");
        scanner.next();
      }
      if (scanner.hasNextInt()) {
        inputInt = scanner.nextInt();
      }
    }

    scanner.close();
  }

  public static void generateNumbers() {
    int count = 1;
    int[] temp = new int[10];
    solutions = new int[inputInt];
    solutions[0] = 10;

    while (count < inputInt) {
      for (int currentPosition = 0; currentPosition <= 9; currentPosition++) {
        ArrayList<Integer> possiblePriorPositions = moves.get(currentPosition);
        int value = 0;
        for (int priorSpot : possiblePriorPositions) {
          value += permutations[priorSpot];
        }
        temp[currentPosition] = value;
      }
      int sum = 0;
      for (int i = 0; i < temp.length; i++) {
        sum += temp[i];
      }
      solutions[count] = sum;
      permutations = temp.clone();
      count++;
    }
  }

  public static void printSolution() {
    System.out.println("\nLength of number: count of numbers of given length");
    for (int i = 0; i < solutions.length; i++) {
      System.out.println(i + 1 + ": " + solutions[i]);
    }
  }
}
