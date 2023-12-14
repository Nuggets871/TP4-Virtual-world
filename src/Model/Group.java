/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author chris
 */
public class Group extends Shape {
    // Liste pour stocker les enfants qui sont des formes ou des groupes de formes.
    private ArrayList<Shape> children;

    public Group(Point centre, Color color) {
        super(centre, color);
        children = new ArrayList<>();
    }
    public Group() {
        super(new Point(0, 0), Color.BLACK); // Position et couleur par défaut, si nécessaire
        children = new ArrayList<>();
    }
    // Méthode pour ajouter des formes ou groupes au groupe actuel.
    public void add(Shape shape) {
        children.add(shape);
    }

    public ArrayList<Shape> getChildren() {
        return children;
    }

    public Point getCentre() {
        return centre;
    }

    public Color getColor() {
        return color;
    }
    
    @Override
    public Rectangle getBox() {
        if (children.isEmpty()) {
            return new Rectangle(centre.x, centre.y, 0, 0);
        }

        // Initialiser min et max points avec les valeurs du premier enfant
        int minX = children.get(0).getBox().x;
        int minY = children.get(0).getBox().y;
        int maxX = minX + children.get(0).getBox().width;
        int maxY = minY + children.get(0).getBox().height;

        // Calculer la boîte englobante en parcourant tous les enfants
        for (Shape child : children) {
            Rectangle childBox = child.getBox();
            minX = Math.min(minX, childBox.x);
            minY = Math.min(minY, childBox.y);
            maxX = Math.max(maxX, childBox.x + childBox.width);
            maxY = Math.max(maxY, childBox.y + childBox.height);
        }

        // Retourner la boîte englobante qui couvre tous les enfants
        return new Rectangle(minX, minY, maxX - minX, maxY - minY);
    }


    @Override
    public String getType() {
        return "Group";
    }

    @Override
public DefaultMutableTreeNode getJTreeNodes() {
    DefaultMutableTreeNode node = new DefaultMutableTreeNode(this); // Utilisez 'this' pour représenter le groupe

    for (Shape child : children) {
        node.add(child.getJTreeNodes());
    }

    return node;
}




    @Override
    public void draw(Graphics g) {
        // Dessine toutes les formes enfant.
        for (Shape child : children) {
            child.draw(g);
        }
    }

    @Override
    public String toString(int padding) {
        StringBuilder sb = new StringBuilder();
        String pad = " ".repeat(padding);
        sb.append(pad).append("Group:\n");
        for (Shape child : children) {
            sb.append(child.toString(padding + 2)).append("\n"); // Ajouter de l'indentation pour les enfants.
        }
        return sb.toString();
    }

}
