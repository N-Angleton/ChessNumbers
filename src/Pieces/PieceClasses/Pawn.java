package Pieces.PieceClasses;

import Pieces.MoveTypeClasses.Stepable;

public class Pawn extends Stepable {

    public Pawn() {
        setDirections();
        System.out.println(directions);
        generateMovemap();
        System.out.println(moveMap);
    }
    
    protected void setDirections() {
        Integer[][] pawnMoves = {{0,-1}};
        directions = pawnMoves;
    }

    public String toString() {
        return "Pawn";
    }

}
