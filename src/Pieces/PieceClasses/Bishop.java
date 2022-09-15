package Pieces.PieceClasses;

import Pieces.DirectionInterfaces.Bishopeque;
import Pieces.MoveTypeClasses.Slideable;

public class Bishop extends Slideable implements Bishopeque {

    public Bishop() {
        setDirections();
        generateMovemap();
    }

    protected void setDirections() {
        directions = bishopDirections;
    }

    public String toString() {
        return "Bishop";
    }

}