/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Circle;
import Model.RectangleShape;
import Model.Shape;
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
    
    public Controller_Add(ShapeManager d) {
        data = d;
    }
    
    public void control(String name, Color color) {
        Random rand = new Random(System.currentTimeMillis());
        Point centre = new Point(rand.nextInt(400), rand.nextInt(400));
        Shape shape;

        switch (name) {
            case "Circle":
                shape = new Circle(centre, color);
                break;
            case "Square":
                shape = new Square(centre, color); // Utilisation du constructeur mis à jour
                break;
            case "Rectangle":
                shape = new RectangleShape(centre, color); // Utilisation du constructeur mis à jour
                break;
            default:
                throw new IllegalArgumentException("Unknown shape type: " + name);
        }

        data.add(shape);
    }
}
