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
public abstract class Shape {
    protected Point centre;
    protected Color color;
    
    public Shape(Point centre, Color color){
        this.centre = centre;
        this.color = color;
    }

    public Point getCentre() {
        return centre;
    }

    public Color getColor() {
        return color;
    }
    
    
    
    public abstract Rectangle getBox(); 
    
    public abstract String getType(); 
    
    public abstract DefaultMutableTreeNode getJTreeNodes();
    
    public abstract void draw(Graphics g);
    
    public abstract String toString(int padding);
    public abstract Shape[] select(int indice,Group pere);
    public void setCentre(Point newCentre) {
        this.centre = newCentre;
    }
    
    abstract void setRadius (int radius);
    abstract int count();
    abstract Boolean isGroup();
    abstract Boolean remove(int[] selectedIx);
    abstract Boolean group(int[] selectedIx,int i);
    abstract Boolean ungroup (int[] selectedIx, int i);
    
}

    