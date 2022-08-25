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

Of the variety of ways this problem could be solved, one direct method is using iterative matrix multiplication. Consider the following 10x1 matrix:

<p align="center">
[ 1 ]<br>
[ 1 ]<br>
[ 1 ]<br>
[ 1 ]<br>
[ 1 ]<br>
[ 1 ]<br>
[ 1 ]<br>
[ 1 ]<br>
[ 1 ]<br>
[ 1 ]<br>
</p>

We can think of this as representing the ten possible starting positions, with the rows being numbered from 0 to 9. If we multiply this matrix by a 10x10 matrix that corresponds to the moves of the designated piece we can produce a new 10x1 matrix representing the weighted possible states after one move. It will be weighted in the sense that each row's value will represent how many distinct paths lead to that row. We can multiply by the 10x10 matrix as many times as needed to reach the desired length. Interestingly, if we wanted to designate specific starting squares, we only need to set the row values of the excluded squares to 0.

As an example, the 10x10 matrix for a knight is as follows:

<p align="center">
[ 0, 0, 0, 0, 1, 0, 1, 0, 0, 0 ]<br>
[ 0, 0, 0, 0, 0, 0, 1, 0, 1, 0 ]<br>
[ 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 ]<br>
[ 0, 0, 0, 0, 1, 0, 0, 0, 1, 0 ]<br>
[ 1, 0, 0, 1, 0, 0, 0, 0, 0, 1 ]<br>
[ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ]<br>
[ 1, 1, 0, 0, 0, 0, 0, 1, 0, 0 ]<br>
[ 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 ]<br>
[ 0, 1, 0, 1, 0, 0, 0, 0, 0, 0 ]<br>
[ 0, 0, 1, 0, 1, 0, 0, 0, 0, 0 ]<br>
</p>

Now, given that many of the matrix values are 0, the actual approach taken with the program is to represent only the 1s using a HashMap from Integer values to ArrayLists that contain the corresponding possible new positions. This minimizes unnecessary multiplication by zero, but the overall idea is the same.

To construct these HashMaps, one option would be to take an object-oriented approach and build a robust model of the different piece types and the keypad as a 4x3 board, and then calculate legal moves. Instead, for the sake of computational speed and because the board is manageably small, this program primarily uses a more brute force approach:

```java
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
```

While effective, the approach does lack a little in elegance and could be an opportunity for refactoring.
