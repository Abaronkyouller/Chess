package Pieces;
import Game.*;

import java.util.LinkedList;

public class Pawn extends Piece{
    public Pawn(int x, int y, Player player,LinkedList<Piece> ps){
        super(x,y,player,ps);
        this.type =Type.PAWN;
    }

    public boolean isValidPath(int finalX, int finalY){
        boolean moveable = false;
        if((this.y==6 && this.player==Player.WHITE) || (this.y==1 && this.player==Player.BLACK)) {
            int up;
            if (this.player == Player.WHITE){
                up =2;
            }
            else{
                up =-2;
            }
            if(finalX==this.x && (this.y-finalY)==up){
                moveable=true;
            }
        }
        int up;
        if (this.player == Player.WHITE){
            up =1;
        }
        else{
            up =-1;
        }
        if(finalX==this.x && (this.y-finalY)==up){
            moveable=true;
        } else {
            for(Piece p : ps){
                if(Math.abs(this.x-finalX)==1 && (this.y-finalY)==up){
                    moveable=true;
                }
            }
        }
        return moveable;
    }

}