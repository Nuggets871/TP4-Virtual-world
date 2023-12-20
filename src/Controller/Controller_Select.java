/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Shape;
import Model.ShapeManager;
import View.Window;

/**
 *
 * @author chris
 */
public class Controller_Select {
    private ShapeManager data;
    private Window view;

    public Controller_Select(ShapeManager data, Window view) {
        this.data = data;
        this.view = view;
    }

    public void control(int selectedIndex) {
        if (selectedIndex < 0) {
            return;
        }

        Shape[] selectedShapes = data.select(selectedIndex);
        if (selectedShapes != null && selectedShapes[0] != null) {
            Shape selectedShape = selectedShapes[0];
            view.updateUI(selectedShape);
        }
    }
}
