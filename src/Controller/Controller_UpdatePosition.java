/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Shape;
import Model.ShapeManager;
import java.awt.Point;

/**
 *
 * @author chris
 */
public class Controller_UpdatePosition {
    private ShapeManager data;

    public Controller_UpdatePosition(ShapeManager data) {
        this.data = data;
    }

    public void control(int selectedIndex, int newX, int newY) {
        if (selectedIndex < 0) {
            return;
        }

        Shape[] selectedShapes = data.select(selectedIndex);
        if (selectedShapes != null && selectedShapes[0] != null) {
            Shape selectedShape = selectedShapes[0];
            selectedShape.setCentre(new Point(newX, newY));
            data.notifyObservers(); 
        }
    }
}
