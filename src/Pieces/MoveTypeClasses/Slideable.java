package Pieces.MoveTypeClasses;

import Pieces.Piece;
import java.util.ArrayList;

public abstract class Slideable extends Piece {

    protected void generateMovemap() {
        for (Integer i = 0; i < 10; i++) {

            Integer[] position = convertNumToXY(i);
            Integer x = position[0];
            Integer y = position[1];

            ArrayList<Integer> nextLocations = new ArrayList<>();

            for (Integer[] direction : directions) {
                Integer xdiff = direction[0];
                Integer ydiff = direction[1];

                Integer iteration = 1;

                while (validPos(x + (iteration * xdiff), y + (iteration * ydiff))) {
                    nextLocations.add(convertXYtoNum(x + (iteration * xdiff), y + (iteration * ydiff)));
                    iteration++;
                }
            }

            moveMap.put(i, nextLocations);
        }
    }
    
}