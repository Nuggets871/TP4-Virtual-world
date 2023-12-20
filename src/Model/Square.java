/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author chris
 */
public class Square extends Shape {
    private int sideLength;

    public Square(Point centre, Color color) {
        super(centre, color);
        this.sideLength = 100; // Longueur du côté fixée à 100
    }

    @Override
    public Rectangle getBox() {
        return new Rectangle(centre.x - sideLength / 2, centre.y - sideLength / 2, sideLength, sideLength);
    }

    @Override
    public String getType() {
        return "Square";
    }

    @Override
    public DefaultMutableTreeNode getJTreeNodes() {
        return new DefaultMutableTreeNode(getType() + " (Centre: [" + centre.x + ", " + centre.y + "], Side: " + sideLength + ")");
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(centre.x - sideLength / 2, centre.y - sideLength / 2, sideLength, sideLength);
        g.setColor(Color.black);
        g.drawRect(centre.x - sideLength / 2, centre.y - sideLength / 2, sideLength, sideLength);
    }

    @Override
    public String toString(int padding) {
        return String.format("%" + padding + "sSquare (Centre: [%d, %d], Side: %d)", "", centre.x, centre.y, sideLength);
    }

    @Override
    public Shape[] select(int indice, Group pere) {
        Shape[] res=null;
        if (indice==ShapeManager.compteur){
            res=new Shape[2];
            res[0]=this;
            res[1]=pere;
        }  
        return res;
     }

    @Override
    void setRadius(int radius) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    int count() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    Boolean isGroup() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    Boolean remove(int[] selectedIx) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    Boolean group(int[] selectedIx, int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    Boolean ungroup(int[] selectedIx, int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
