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
public class RectangleShape extends Shape {
    private int width;
    private int height;

    public RectangleShape(Point centre, Color color) {
        super(centre, color);
        this.width = 100;  // Largeur fixée à 100
        this.height = 200; // Hauteur fixée à 200
    }

    @Override
    public Rectangle getBox() {
        return new Rectangle(centre.x - width / 2, centre.y - height / 2, width, height);
    }

    @Override
    public String getType() {
        return "Rectangle";
    }

    @Override
    public DefaultMutableTreeNode getJTreeNodes() {
        return new DefaultMutableTreeNode(getType() + " (Centre: [" + centre.x + ", " + centre.y + "], Width: " + width + ", Height: " + height + ")");
    }


    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(centre.x - width / 2, centre.y - height / 2, width, height);
        g.setColor(Color.black);
        g.drawRect(centre.x - width / 2, centre.y - height / 2, width, height);
    }

    @Override
    public String toString(int padding) {
    // Cette méthode est utilisée pour l'affichage du nœud dans le JTree.

        String str = new String();
        
        str += getType() + " (Centre: [" + centre.x + ", " + centre.y + "], Width: " + width + ", Height: " + height + ")";
        
        return str;
    
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
