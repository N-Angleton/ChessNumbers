package Pieces.PieceClasses;

import Pieces.DirectionInterfaces.Rookesque;
import Pieces.MoveTypeClasses.Slidable;

public class Rook extends Slidable implements Rookesque {

    public Rook() {
        setDirections();
        generateMovemap();
    }
    
    protected void setDirections() {
        directions = rookDirections;
    }

    public String toString() {
        return "Rook";
    }

}
