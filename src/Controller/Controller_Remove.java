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
public class Controller_Remove {
    private ShapeManager data;

    public Controller_Remove(ShapeManager data) {
        this.data = data;
    }

    public void control(int[] selectedIndices) {
        if (selectedIndices == null || selectedIndices.length == 0) {
            return;
        }
        
        Integer[] sortedIndices = Arrays.stream(selectedIndices).boxed().toArray(Integer[]::new);
        Arrays.sort(sortedIndices, Collections.reverseOrder());
      
        for (Integer index : sortedIndices) {
            boolean isRemoved = data.remove(index - 1); 
        }

       
    }
}
