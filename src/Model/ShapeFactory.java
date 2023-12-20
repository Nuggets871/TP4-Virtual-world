/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author chris
 */
public class ShapeFactory {
     public static final String CIRCLE = "Circle";
    public static final String SQUARE = "Square";
    public static final String RECTANGLE = "Rectangle";
    
    // Méthode factory qui crée des formes en fonction du type
    public static Shape createShape(String type, Point centre, Color color) {
        switch (type) {
            case CIRCLE:
                return new Circle(centre, color);
            case SQUARE:
                return new Square(centre, color);
            case RECTANGLE:
                return new RectangleShape(centre, color);
            default:
                throw new IllegalArgumentException("Unknown shape type: " + type);
        }
    }
}
