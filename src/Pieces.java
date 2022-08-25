import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class Pieces {

  public static HashMap<Integer, ArrayList<Integer>> getPrevPositions(String firstLetter) {
    if (firstLetter.equals("P")) {
      return pawnMoves();
    } else if (firstLetter.equals("N")) {
      return knightMoves();
    } else if (firstLetter.equals("B")) {
      return bishopMoves();
    } else if (firstLetter.equals("R")) {
      return rookMoves();
    } else if (firstLetter.equals("Q")) {
      return queenMoves();
    } else {
      return kingMoves();
    }
  }

  private static HashMap<Integer, ArrayList<Integer>> pawnMoves() {
    HashMap<Integer, ArrayList<Integer>> moves = new HashMap<Integer, ArrayList<Integer>>();

    for (int i = 0; i <= 9; i++) {
      ArrayList<Integer> moveSubset = new ArrayList<Integer>();
      if (i < 7 && i != 0) {
        moveSubset.add(i + 3);
      } else if (i == 8) {
        moveSubset.add(0);
      }
      moves.put(i, moveSubset);
    }
    
    return moves;
  }

  private static HashMap<Integer, ArrayList<Integer>> knightMoves() {
    HashMap<Integer, ArrayList<Integer>> moves = new HashMap<Integer, ArrayList<Integer>>();

    moves.put(0, new ArrayList<>(Arrays.asList(4,6)));
    moves.put(1, new ArrayList<>(Arrays.asList(6,8)));
    moves.put(2, new ArrayList<>(Arrays.asList(7,9)));
    moves.put(3, new ArrayList<>(Arrays.asList(4,8)));
    moves.put(4, new ArrayList<>(Arrays.asList(0,3,9)));
    moves.put(5, new ArrayList<>(Arrays.asList()));
    moves.put(6, new ArrayList<>(Arrays.asList(0,1,7)));
    moves.put(7, new ArrayList<>(Arrays.asList(2,6)));
    moves.put(8, new ArrayList<>(Arrays.asList(1,3)));
    moves.put(9, new ArrayList<>(Arrays.asList(2,4)));

    return moves;
  }

  private static HashMap<Integer, ArrayList<Integer>> bishopMoves() {
    HashMap<Integer, ArrayList<Integer>> moves = new HashMap<Integer, ArrayList<Integer>>();

    moves.put(0, new ArrayList<>(Arrays.asList(7,9)));
    moves.put(1, new ArrayList<>(Arrays.asList(5,9)));
    moves.put(2, new ArrayList<>(Arrays.asList(4,6)));
    moves.put(3, new ArrayList<>(Arrays.asList(5,7)));
    moves.put(4, new ArrayList<>(Arrays.asList(2,8)));
    moves.put(5, new ArrayList<>(Arrays.asList(1,3,7,9)));
    moves.put(6, new ArrayList<>(Arrays.asList(2,8)));
    moves.put(7, new ArrayList<>(Arrays.asList(0,3,5)));
    moves.put(8, new ArrayList<>(Arrays.asList(4,6)));
    moves.put(9, new ArrayList<>(Arrays.asList(0,1,5)));

    return moves;
  }

  private static HashMap<Integer, ArrayList<Integer>> rookMoves() {
    HashMap<Integer, ArrayList<Integer>> moves = new HashMap<Integer, ArrayList<Integer>>();
    
    moves.put(0, new ArrayList<>(Arrays.asList(2,5,8)));
    moves.put(1, new ArrayList<>(Arrays.asList(2,3,4,7)));
    moves.put(2, new ArrayList<>(Arrays.asList(0,1,3,5,8)));
    moves.put(3, new ArrayList<>(Arrays.asList(1,2,6,9)));
    moves.put(4, new ArrayList<>(Arrays.asList(1,5,6,7)));
    moves.put(5, new ArrayList<>(Arrays.asList(0,2,4,6,8)));
    moves.put(6, new ArrayList<>(Arrays.asList(2,8)));
    moves.put(7, new ArrayList<>(Arrays.asList(0,3,5)));
    moves.put(8, new ArrayList<>(Arrays.asList(4,6)));
    moves.put(9, new ArrayList<>(Arrays.asList(0,1,5)));

    return moves;
  }

  private static HashMap<Integer, ArrayList<Integer>> queenMoves() {
    HashMap<Integer, ArrayList<Integer>> bishopMoves = bishopMoves();
    HashMap<Integer, ArrayList<Integer>> rookMoves = rookMoves();

    for (int i = 0; i < 10; i++) {
      bishopMoves.get(i).addAll(rookMoves.get(i));
    }
    
    return bishopMoves;
  }

  private static HashMap<Integer, ArrayList<Integer>> kingMoves() {
    HashMap<Integer, ArrayList<Integer>> moves = new HashMap<Integer, ArrayList<Integer>>();
    
    moves.put(0, new ArrayList<>(Arrays.asList(7,8,9)));
    moves.put(1, new ArrayList<>(Arrays.asList(2,4,5)));
    moves.put(2, new ArrayList<>(Arrays.asList(1,3,4,5,6)));
    moves.put(3, new ArrayList<>(Arrays.asList(2,5,6)));
    moves.put(4, new ArrayList<>(Arrays.asList(1,2,5,7,8)));
    moves.put(5, new ArrayList<>(Arrays.asList(1,2,3,4,6,7,8,9)));
    moves.put(6, new ArrayList<>(Arrays.asList(2,3,5,8,9)));
    moves.put(7, new ArrayList<>(Arrays.asList(0,4,5,8)));
    moves.put(8, new ArrayList<>(Arrays.asList(0,4,5,6,7,9)));
    moves.put(9, new ArrayList<>(Arrays.asList(0,5,6,8)));
    
    return moves;
  }
}