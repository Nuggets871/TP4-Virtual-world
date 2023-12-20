/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Circle;
import Model.RectangleShape;
import Model.Shape;
import Model.ShapeFactory;
import Model.ShapeManager;
import Model.Square;
import java.awt.Color;
import java.awt.Point;
import java.util.Random;

/**
 *
 * @author adrien.peytavie
 */
public class Controller_Add {
    private final ShapeManager data;
    private final ShapeFactory factory;
    
    public Controller_Add(ShapeManager d) {
        data = d;
        factory = new ShapeFactory();
    }
    
    public void control(String shapeType, Color color) {
        Random rand = new Random();
        Point centre = new Point(rand.nextInt(400), rand.nextInt(400));
        Shape shape = factory.createShape(shapeType, centre, color);
        data.add(shape);
    }
}
