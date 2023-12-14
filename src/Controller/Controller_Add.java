/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Circle;
import Model.ShapeManager;
import java.awt.Color;
import java.awt.Point;
import java.util.Random;

/**
 *
 * @author adrien.peytavie
 */
public class Controller_Add {
    private final ShapeManager data;
    
    public Controller_Add(ShapeManager d)
    {
        data = d;
    }
    
    public void control(String name, Color color)
    {
        Random rand= new Random(System.currentTimeMillis());
        Circle circle = new Circle(new Point(rand.nextInt(200), rand.nextInt(200)), color);
        
        data.add(circle);
    }
}
