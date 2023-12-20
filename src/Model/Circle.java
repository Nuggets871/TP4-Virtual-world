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
 * @author adrien.peytavie
 */
public class Circle extends Shape{
    private double radius;

    
    public Circle(Point centre, Color color){
        super(centre,color);
       this.radius = 50;
    }
    
    @Override
    public Rectangle getBox() {
        return new Rectangle((int)(centre.x - radius), (int)(centre.y - radius), (int)(2 * radius), (int)(2 * radius));
    }

    @Override
    public String getType() {
        return "Circle";
    }

    @Override
    public DefaultMutableTreeNode getJTreeNodes() {
       return new DefaultMutableTreeNode(getType() + " (Center[" + centre.x + ", " + centre.y + "], R[" + radius + "])");
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int)(centre.x - radius), (int)(centre.y - radius), (int)(2 * radius), (int)(2 * radius));
        g.setColor(Color.black);
        g.drawOval((int)(centre.x - radius), (int)(centre.y - radius), (int)(2 * radius), (int)(2 * radius));
            
    }

    @Override
    public String toString(int padding) {
        String str = new String();
        
        str += getType() + "(" + centre +")";
        
        return str;
    }
    
    @Override
    public Shape[] select(int indice,Group pere){
        Shape[] res = null;
        if (indice == ShapeManager.compteur){
            res=new Shape[2];
            res[0]=this;
            res[1]=pere;
        }
        return res;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
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
