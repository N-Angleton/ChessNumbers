package Pieces.MoveTypeClasses;

import Pieces.Piece;
import java.util.ArrayList;

public abstract class Stepable extends Piece {
    
    protected void generateMovemap() {
        for (Integer i = 0; i < 10; i++) {

            Integer[] position = convertNumToXY(i);
            Integer x = position[0];
            Integer y = position[1];

            ArrayList<Integer> nextLocations = new ArrayList<Integer>();

            for (Integer[] direction : directions) {
                Integer xdiff = direction[0];
                Integer ydiff = direction[1];

                if (validPos(x + xdiff, y + ydiff)) {
                    nextLocations.add(convertXYtoNum(x + xdiff, y + ydiff));
                }
            }

            moveMap.put(i, nextLocations);
        }
    }
    
}