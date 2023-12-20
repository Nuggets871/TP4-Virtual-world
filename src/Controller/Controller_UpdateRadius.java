/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Circle;
import Model.Shape;
import Model.ShapeManager;

/**
 *
 * @author chris
 */
public class Controller_UpdateRadius {
    private ShapeManager data;

    public Controller_UpdateRadius(ShapeManager data) {
        this.data = data;
    }

    public void control(int selectedIndex, double newRadius) {
        if (selectedIndex < 0) {
            System.out.println("Index invalide: " + selectedIndex);
            return;
        }

        Shape[] selectedShapes = data.select(selectedIndex);
        if (selectedShapes != null && selectedShapes[0] != null && selectedShapes[0] instanceof Circle) {
            Circle selectedCircle = (Circle) selectedShapes[0];
            selectedCircle.setRadius(newRadius);
            System.out.println("Rayon mis à jour: " + newRadius);
  
            data.notifyObservers(); 
        } else {
            System.out.println("Aucune forme circulaire sélectionnée ou forme non trouvée.");
        }
    }
}
