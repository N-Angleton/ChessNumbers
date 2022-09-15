import java.util.Scanner;

import Pieces.Piece;
import Pieces.PieceClasses.Bishop;
import Pieces.PieceClasses.King;
import Pieces.PieceClasses.Knight;
import Pieces.PieceClasses.Pawn;
import Pieces.PieceClasses.Queen;
import Pieces.PieceClasses.Rook;

import java.util.HashMap;
import java.util.ArrayList;

public class App {

  static String inputLetter;
  static Piece piece;
  static Integer inputInt;
  static Integer solution = 0;
  static HashMap<Integer, Integer> solutions = new HashMap<Integer, Integer>();

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
      piece = new Pawn();
    } else if (inputLetter.equals("N")) {
      piece = new Knight();
    } else if (inputLetter.equals("B")) {
      piece = new Bishop();
    } else if (inputLetter.equals("R")) {
      piece = new Rook();
    } else if (inputLetter.equals("Q")) {
      piece = new Queen();
    } else {
      piece = new King();
    }
    
    System.out.println("\nYou selected a " + piece.toString());

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
    for (Integer position = 0; position < 10; position++) {
        solution += generateXNumbersFromPosY(inputInt - 1, position);
    }
  }

  public static Integer generateXNumbersFromPosY(Integer x, Integer y) {
    if (x < 1) return 1;

    Integer key = (y * (inputInt + 1)) + x;
    if (solutions.containsKey(key)) {
        return solutions.get(key);
    }

    Integer newSolutions = 0;
    ArrayList<Integer> newPositions = piece.getNextPositions(y);

    for (Integer position : newPositions) {
        newSolutions += generateXNumbersFromPosY(x - 1, position);
    }

    solutions.put(key, newSolutions);

    return newSolutions;
  }

  public static void printSolution() {
    if ("QK".contains(inputLetter)) {
        System.out.print("The ");
    } else {
        System.out.print("A ");
    }
    System.out.print(piece.toString() + " can produce " + solution + " numbers with " + inputInt + " digit");
    if (inputInt > 1) {
        System.out.print("s");
    }
    System.out.println("\n");
  }

}