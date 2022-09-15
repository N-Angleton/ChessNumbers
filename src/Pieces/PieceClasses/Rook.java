package Pieces.PieceClasses;

import Pieces.DirectionInterfaces.Rookesque;
import Pieces.MoveTypeClasses.Slideable;

public class Rook extends Slideable implements Rookesque {

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
