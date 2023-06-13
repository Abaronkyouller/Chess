package Pieces;
import Game.*;

import java.util.LinkedList;

public class King extends Piece{
    public King(int x, int y, Player player,LinkedList<Piece> ps){
        super(x,y,player,ps);
        this.type =Type.KING;
    }

    public boolean isValidPath(int finalX, int finalY){
        return true;
    }

}