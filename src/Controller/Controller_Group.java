/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Group;
import Model.Shape;
import Model.ShapeManager;
import java.util.Arrays;
import java.util.Collections;

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


        Integer[] sortedIndices = Arrays.stream(selectedIndices).boxed().toArray(Integer[]::new);
        Arrays.sort(sortedIndices, Collections.reverseOrder());

        Group newGroup = new Group();

        for (Integer index : sortedIndices) {
            Shape[] selectedShapes = data.select(index - 1);
            if (selectedShapes != null && selectedShapes[0] != null) {
                Shape selectedShape = selectedShapes[0];
                newGroup.add(selectedShape);

                controllerRemove.control(new int[]{index});
            }
        }

        if (!newGroup.getChildren().isEmpty()) {
            data.add(newGroup);
        }
    }
}
