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
        return String.format("%" + padding + "sRectangle (Centre: [%d, %d], Width: %d, Height: %d)", "", centre.x, centre.y, width, height);
    }
}
