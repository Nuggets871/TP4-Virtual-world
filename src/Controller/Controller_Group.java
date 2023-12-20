/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Group;
import Model.Shape;
import Model.ShapeManager;

/**
 *
 * @author chris
 */
public class Controller_Group {

   private ShapeManager data;
    private Controller_Remove controllerRemove;

    public Controller_Group(ShapeManager data) {
        this.data = data;
        this.controllerRemove = new Controller_Remove(data);
    }

    public void control(int[] selectedIndices) {
        if (selectedIndices == null || selectedIndices.length == 0) {
            return;
        }

        Group newGroup = new Group();

        for (int index : selectedIndices) {
            Shape[] selectedShapes = data.select(index - 1);
            if (selectedShapes != null && selectedShapes[0] != null) {
                Shape selectedShape = selectedShapes[0];

                // Ajouter la forme au nouveau groupe
                newGroup.add(selectedShape);

                // Utiliser Controller_Remove pour retirer la forme de son emplacement actuel
                controllerRemove.control(new int[]{index});
            }
        }

        // Ajouter le nouveau groupe au ShapeManager si ce n'est pas vide
        if (!newGroup.getChildren().isEmpty()) {
            data.add(newGroup);
        }
    }
}
