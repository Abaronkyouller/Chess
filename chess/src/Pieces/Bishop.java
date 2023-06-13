package Pieces;
import Game.*;

import java.util.LinkedList;

public class Bishop extends Piece {

    public Bishop(int x, int y, Player player,LinkedList<Piece> ps){
        super(x,y,player,ps);
        this.type = Type.BISHOP;
    }

    public boolean isValidPath(int finalX, int finalY){
        int diffX = finalX - this.x;
        int diffY = finalY - this.y;
        return 0== diffX-diffY || 0== diffX+diffY;
    }

//    public int[][] drawPath(int startX, int startY, int finalX,int finalY){
//        int pairs = Math.abs(finalX-startX);
//        int dirX = 1,dirY = 1;
//        if(finalX-startX<0){dirX=-1;}
//        if(finalY-startY<0){dirY=-1;}
//        int[][] path = new int[2][pairs-1];
//        if(pairs>1){
//            for(int i =0;i<pairs-1;i++){
//                path[0][i]=startX+dirX*1;
//                path[1][i]=startY+dirY*1;
//            }
//        }
//        return path;
//    }
}