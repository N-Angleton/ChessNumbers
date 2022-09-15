package Pieces;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Piece {

    protected Integer[][] directions;
    protected HashMap<Integer, ArrayList<Integer>> moveMap = new HashMap<Integer, ArrayList<Integer>>();
    
    public ArrayList<Integer> getNextPositions(Integer currentPosition) {
        return moveMap.get(currentPosition);
    };

    protected abstract void setDirections();
    protected abstract void generateMovemap();

    protected static Integer convertXYtoNum(Integer x, Integer y){
        if (y == 3) {
            return 0;
        }
        return ((3 * y) + x + 1);
    }
    
    // 1 => {0,0}, 2 => {1, 0}, 3 => {2,0}
    // 4 => {0,1}, 5 => {1, 1}, 6 => {2,1}
    // 7 => {0,2}, 8 => {2, 1}, 9 => {2,2}
    //             0 => {1, 3}
    protected static Integer[] convertNumToXY(Integer num) {
        if (num == 0) {
            Integer coordinates[] = {1,3};
            return coordinates;
        }
        Integer x = (num - 1) % 3;
        Integer y = (num - 1) / 3;
        Integer coordinates[] = {x, y};
        return coordinates;
    }

    protected static Boolean validPos(Integer x, Integer y) {
        if (x == 1 && y == 3) {
            return true;
        }

        if ((x >= 0 && x < 3) && (y >= 0 && y < 3)) {
            return true;
        }

        return false;
    }
    
}