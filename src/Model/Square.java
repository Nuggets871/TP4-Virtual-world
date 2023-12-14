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
}
