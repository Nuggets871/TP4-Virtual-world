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

    @Override
    public Shape[] select(int indice, Group pere) {
        Shape[] res=null;
        if (indice==ShapeManager.compteur){
            res=new Shape[2];
            res[0]=this;
            res[1]=pere;
            return res;
        }
        else { //group est le nom de l'attribut arraylist
            for (int k = 0; k < children.size(); k++) {
                Shape _shape = children.get(k);
                ShapeManager.compteur++;
                res=_shape.select(indice,this);
                if (res!=null)    
                    return res;
            }


        }
        return null;
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
