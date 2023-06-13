package Pieces;
import Game.*;

import java.util.LinkedList;

public abstract class Piece{
    public int x,y;
    public Player player;
    Type type;
    LinkedList<Piece> ps;
    public Piece(int x, int y, Player player,LinkedList<Piece> ps){
        this.x = x;
        this.y = y;
        this.player = player;
        ps.add(this);
    }

    public abstract boolean isValidPath(int finalX,int finalY);
//    public abstract int[][] drawPath(int startX, int startY, int finalX,int finalY);
    public Type getType(){
        return this.type;
    }
    public void move(int x, int y){
        this.x=x;
        this.y=y;
    }
    public void kill(){
        ps.remove(this);
    }

}