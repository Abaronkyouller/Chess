package Pieces;
import Game.*;

import java.util.LinkedList;

public class Knight extends Piece{
    public Knight(int x, int y, Player player,LinkedList<Piece> ps){
        super(x,y,player,ps);
        this.type =Type.KNIGHT;
    }

    public boolean isValidPath(int finalX, int finalY){
        return true;
    }

}