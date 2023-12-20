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
public class Controller_UnGroup {
    private ShapeManager data;

    public Controller_UnGroup(ShapeManager data) {
        this.data = data;
    }

    public void control(int[] selectedIndices) {
        if (selectedIndices == null || selectedIndices.length == 0) {
            return;
        }

        for (int index : selectedIndices) {
            Shape[] selectedShapes = data.select(index - 1); 
            if (selectedShapes != null && selectedShapes.length == 2) {
                Shape selectedShape = selectedShapes[0];
                Group parentGroup = (Group) selectedShapes[1];

                if (parentGroup != null && selectedShape instanceof Group) {
                    Group groupToUngroup = (Group) selectedShape;

                    for (Shape child : groupToUngroup.getChildren()) {
                        parentGroup.add(child);
                    }

                    parentGroup.getChildren().remove(groupToUngroup);
                }
            }
        }

        
    }
}
