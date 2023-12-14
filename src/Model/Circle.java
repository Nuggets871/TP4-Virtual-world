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
        return String.format("%" + padding + "sCircle (Center: [%d, %d], Radius: %.1f)", "", centre.x, centre.y, radius);
    }
}
