package Pieces.PieceClasses;

import Pieces.MoveTypeClasses.Stepable;

public class Knight extends Stepable {

    public Knight() {
        setDirections();
        generateMovemap();
    }
    
    protected void setDirections() {
        Integer[][] knightMoves = {{1,2},{1,-2},{-1,2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};
        directions = knightMoves;
    }

    public String toString() {
        return "Knight";
    }

}
