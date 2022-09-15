package Pieces.PieceClasses;

import Pieces.DirectionInterfaces.Bishopeque;
import Pieces.MoveTypeClasses.Slidable;

public class Bishop extends Slidable implements Bishopeque {

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