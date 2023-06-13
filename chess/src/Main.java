import Game.Player;
import Game.Type;
import Pieces.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;


public class Main {
    public static LinkedList<Piece> ps = new LinkedList<>();
    public static Piece selectedPiece;
    public static void main(String[] args) throws IOException {
        BufferedImage allPiece = ImageIO.read(new File("D:\\nam2\\Study\\1st Semester\\Project\\chess\\src\\Picture\\piece.png"));
        Image imgs[] = new Image[12];
        int ind =0;
        for(int y =0; y<2;y++){
            for(int x = 0;x<6; x++){
                imgs[ind]= allPiece.getSubimage(x*200,y*200,200,200).getScaledInstance(64,64,BufferedImage.SCALE_SMOOTH);
                ind++;
            }
        }

        Piece wPawn1 = new Pawn(0,6,Player.WHITE,ps);
        Piece wPawn2 = new Pawn(1,6,Player.WHITE,ps);
        Piece wPawn3 = new Pawn(2,6,Player.WHITE,ps);
        Piece wPawn4 = new Pawn(3,6,Player.WHITE,ps);
        Piece wPawn5 = new Pawn(4,6,Player.WHITE,ps);
        Piece wPawn6 = new Pawn(5,6,Player.WHITE,ps);
        Piece wPawn7 = new Pawn(6,6,Player.WHITE,ps);
        Piece wPawn8 = new Pawn(7,6,Player.WHITE,ps);
        Piece bPawn1 = new Pawn(0,1,Player.BLACK,ps);
        Piece bPawn2 = new Pawn(1,1,Player.BLACK,ps);
        Piece bPawn3 = new Pawn(2,1,Player.BLACK,ps);
        Piece bPawn4 = new Pawn(3,1,Player.BLACK,ps);
        Piece bPawn5 = new Pawn(4,1,Player.BLACK,ps);
        Piece bPawn6 = new Pawn(5,1,Player.BLACK,ps);
        Piece bPawn7 = new Pawn(6,1,Player.BLACK,ps);
        Piece bPawn8 = new Pawn(7,1,Player.BLACK,ps);
        Piece wRook1 = new Rook(0,7,Player.WHITE,ps);
        Piece wRook2 = new Rook(7,7,Player.WHITE,ps);
        Piece bRook1 = new Rook(0,0,Player.BLACK,ps);
        Piece bRook2 = new Rook(7,0,Player.BLACK,ps);
        Piece wKnight1 = new Knight(1,7,Player.WHITE,ps);
        Piece wKnight2 = new Knight(6,7,Player.WHITE,ps);
        Piece bKnight1 = new Knight(1,0,Player.BLACK,ps);
        Piece bKnight2 = new Knight(6,0,Player.BLACK,ps);
        Piece wBishop1 = new Bishop(2,7,Player.WHITE,ps);
        Piece wBishop2 = new Bishop(5,7,Player.WHITE,ps);
        Piece bBishop1 = new Bishop(2,0,Player.BLACK,ps);
        Piece bBishop2 = new Bishop(5,0,Player.BLACK,ps);
        Piece wQueen = new Queen(3,7,Player.WHITE,ps);
        Piece bQueen = new Queen(3,0,Player.BLACK,ps);
        Piece wKing = new King(4,7,Player.WHITE,ps);
        Piece bKing = new King(4,0,Player.BLACK,ps);

        JFrame frame = new JFrame();
        frame.setBounds(10,10,512,512);
        frame.setUndecorated(true);
        JPanel pn = new JPanel(){
            public void paint(Graphics g){
                boolean white = true;
                for(int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        if(white){
                            g.setColor(new Color(235,235, 208));
                        }
                        else {
                            g.setColor(new Color(119, 148, 85));
                        }
                        g.fillRect(j*64,i*64,64,64);
                        white=!white;
                    }
                    white =!white;
                }
                for (Piece p:ps){
                    int ind =0;
                    if(p.getType()== Type.KING){
                        ind = 0;
                    }
                    if(p.getType()== Type.QUEEN){
                        ind = 1;
                    }
                    if(p.getType()== Type.BISHOP){
                        ind = 2;
                    }
                    if(p.getType()== Type.KNIGHT){
                        ind = 3;
                    }
                    if(p.getType()== Type.ROOK){
                        ind = 4;
                    }
                    if(p.getType()== Type.PAWN){
                        ind = 5;
                    }
                    if(p.player==Player.BLACK){
                        ind = ind +6;
                    }
                    g.drawImage(imgs[ind],p.x*64,p.y*64,this);
                }
            }
        };
        frame.add(pn);
        frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(selectedPiece != null){
                    selectedPiece.x=e.getX()/64;
                    selectedPiece.y=e.getY()/64;
                    frame.repaint();
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (selectedPiece==null){
                    selectedPiece = getPiece(e.getX(),e.getY());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                selectedPiece = getPiece(e.getX(),e.getY());
//                System.out.println(selectedPiece.getType().toString()+selectedPiece.player.toString());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(selectedPiece==null){
                    return;
                }
                if(getPiece(e.getX(),e.getY()) != null && getPiece(e.getX(),e.getY()).player != selectedPiece.player){
                    ps.remove(getPiece(e.getX(),e.getY()));
                }
                frame.repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }

    public static Piece getPiece(int a, int b){
        int x = a/64;
        int y = b/64;
        for(Piece p:ps){
            if(p.x==x && p.y ==y && p != selectedPiece){
                return p;
            }
        }
        return null;
    }
}