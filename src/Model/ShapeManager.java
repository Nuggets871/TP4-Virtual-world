/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author adrien.peytavie
 */
public class ShapeManager extends Observable {
    Shape root;
    Shape selected;
    public static int compteur = 0;

    public ShapeManager() {
        root = null;
        selected = null;
    }

    
    public void init() {
    Group rootGroup = new Group();

    Group group1 = new Group();
    Group group2 = new Group();

    group1.add(new Circle(new Point(200, 100), Color.BLUE));
    group1.add(new Square(new Point(400, 200), Color.RED));

    group2.add(new Square(new Point(100, 300), Color.YELLOW));
    group2.add(new Square(new Point(100, 200), Color.GREEN));

    rootGroup.add(group1);
    rootGroup.add(group2);
    rootGroup.add(new Circle(new Point(20, 200), Color.MAGENTA));

    add(rootGroup);
}
    
    public void add(Shape shape)
    {
        if(root == null){
            root = shape;
            setChanged();
            
            
        }
        else if(root instanceof Group ){
            ((Group)root).add(shape);
            setChanged();
        }
        else{
            Group group = new Group();
            group.add(root);
            group.add(shape);
            
            root = group;
            setChanged();
        }
       
        notifyObservers();
         
    }
    
    public Shape[] select(int indice) {
        compteur = 0;
        
        Shape[] res = new Shape[2];
        
        if(indice == 0) {
            res[0] = root;
            res[1] = null;
            return res;
        }
        else if (root instanceof Group) {
            res = root.select(indice, (Group)root);
        }
        return res;
    }

    public String toString(int padding) {
        return root.toString(padding);
    }

    public void draw(Graphics graphics) {
    if (root != null) {
        root.draw(graphics);
    }
}


    public DefaultTreeModel getTreeModel() {
        DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode("Group");
        treeNode.add(root.getJTreeNodes());
        return new DefaultTreeModel(treeNode);
    }

    public boolean remove(int indice) {
        if (indice < 0 || root == null) {
            return false; // Indice invalide ou arbre vide
        }

        if (indice == 0) {
            // Ne pas supprimer la racine
            return false;
        }

        Shape[] selectedShapes = select(indice);
        Shape shapeToRemove = selectedShapes[0];
        Group parentGroup = (Group) selectedShapes[1];

        if (shapeToRemove != null && parentGroup != null) {
            // Supprimer la forme du groupe parent
            parentGroup.getChildren().remove(shapeToRemove);
            setChanged();
            notifyObservers();
            return true;
        }

        return false;
    }

    
    
}
