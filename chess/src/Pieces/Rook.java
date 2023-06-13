package Pieces;
import Game.*;

import java.util.LinkedList;

public class Rook extends Piece{
    public Rook(int x, int y, Player player,LinkedList<Piece> ps){
        super(x,y,player,ps);
        this.type =Type.ROOK;
    }

    public boolean isValidPath(int finalX, int finalY){
        return finalX == this.x || finalY ==this.y;
    }

}