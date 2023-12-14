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

    ArrayList<Shape> shapes;
    
    public ShapeManager()
    {
        shapes = new ArrayList<>();
    }
    
    public void init() {
    Group g1 = new Group(new Point(0, 0), Color.BLACK); // Point et couleur pour le groupe
    add(g1);
    g1.add(new Circle(new Point(200, 100), Color.BLUE));
    g1.add(new Square(new Point(400, 200), Color.RED));

    Group g2 = new Group(new Point(0, 0), Color.BLACK); // Un autre groupe
    g2.add(new Square(new Point(100, 300), Color.YELLOW));
    g2.add(new Square(new Point(100, 200), Color.GREEN));
    add(g2);

    add(new Circle(new Point(20, 200), Color.MAGENTA));
}


    
    public void add(Shape shape)
    {
        shapes.add(shape);

        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Data{\n" + "  shape{\n" + shapes.toString() + "  }\n}";
    }

    public void draw(Graphics graphics) {
        for (Shape shape : shapes)
            shape.draw(graphics);
    }
    
    public DefaultTreeModel getTreeModel() {
        
        DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode("Circles");
        
        for (Shape shape : shapes)
            treeNode.add(shape.getJTreeNodes());
        
        return new DefaultTreeModel(treeNode);
    }
}
