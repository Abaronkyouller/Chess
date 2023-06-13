package Pieces;
import Game.*;

import java.util.LinkedList;

public class Queen extends Piece{
    public Queen(int x, int y, Player player,LinkedList<Piece> ps){
        super(x,y,player,ps);
        this.type =Type.QUEEN;
    }

    public boolean isValidPath(int finalX, int finalY){
        return true;
    }

}