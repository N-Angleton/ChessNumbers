package Pieces.PieceClasses;

import Pieces.DirectionInterfaces.Bishopeque;
import Pieces.DirectionInterfaces.Rookesque;
import Pieces.MoveTypeClasses.Stepable;

public class King extends Stepable implements Bishopeque, Rookesque {

    public King() {
        setDirections();
        generateMovemap();
    }
    
    protected void setDirections() {
        directions = new Integer[bishopDirections.length + rookDirections.length][];
        for (int i = 0; i < bishopDirections.length; i++) {
            directions[i] = bishopDirections[i];
        }
        for (int i = 0; i < rookDirections.length; i++) {
            directions[bishopDirections.length + i] = rookDirections[i];
        }
    }

    public String toString() {
        return "King";
    }
    
}