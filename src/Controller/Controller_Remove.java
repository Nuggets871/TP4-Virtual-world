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
public class Controller_Remove {
    private ShapeManager data;

    public Controller_Remove(ShapeManager data) {
        this.data = data;
    }

    public void control(int[] selectedIndices) {
        if (selectedIndices == null || selectedIndices.length == 0) {
            return;
        }

        // Parcourez chaque indice sélectionné pour le supprimer
        for (int index : selectedIndices) {
            // Supprimer chaque élément sélectionné
            // L'ajustement de l'indice peut être nécessaire en fonction de la façon dont votre JTree est structuré
            boolean isRemoved = data.remove(index - 1); 

            if (!isRemoved) {
                // Gérer les cas où la suppression échoue, si nécessaire
            }
        }

        // Mise à jour de l'affichage, si nécessaire
    }
}
