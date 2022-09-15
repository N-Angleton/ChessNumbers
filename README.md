# Chess Numbers

## Description

The program calculates the total count of numbers that can be produced by a chess piece placed on a standard keypad using legal moves.
<p align="center">
1  2  3<br>
4  5  6<br>
7  8  9<br>
*  0  #<br>
</p>

It can be run in console using the ```main``` method in App.java. The user will be prompted to select the piece type and maximum length of number. The solution will then be printed out below.


## Approach

This program employs an object oriented approach to calculating the movements of chess pieces. Each piece type has its own class, but they all belong to an abstract ```Piece``` parent class, which primarily contains methods regarding positioning. Pieces are further divided into the abstract classes ```Stepable```, which is for the Pawn, Knight, and King, and ```Slidable```, which is for the Bishop, Rook, and Queen. The primary difference between these two abstract classes is that ```Slidable``` will iteratively check along the relevant movement directions until the piece goes out of bounds.

In addition to these classes, the program's modeling of chess makes use of two interfaces: ```Rookesque``` and ```Bishopesque```. These are essentially arrays that contain the move directions for the Bishop and Rook. Stating them as interfaces allows the Queen and King to also implement them.

Beyond the chess modeling, the main calculation takes place in Main.java with the method ```generateXNumbersFromPosY(Integer x, Integer y)```, which can be found below. This function is recursively called with ```x``` being decremented and ```y``` being adjusted for the position that has been moved to. This function makes use of memoization: it's values are stored in a HashMap called ```solutions```, which is a class variable. The intention here is to mitigate needless recalculation—if the same ```x``` and ```y``` pairing reoccurs, its value is immediately retrieved from ```solutions```.
  ```Java
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
  ```
