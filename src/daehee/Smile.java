package daehee;

import javafx.scene.image.Image;

/**
 * The class contains all Smiley information and the resource to display with Renderer class.
 * This can be further developed into a class where more Smileys can be added.
 * Each instance of Smile represents one particular Smiley.
 */

public class Smile {

    int index;
    String expression;
    Image resource;

    /**
     * The constructor of Smile class primarily serves as storage of indices of smiles
     * @param index the integer indicates where the smile is in a text
     * @param expression the string that represents a smile
     */
    public Smile(int index, String expression) {
        this.index = index;
        this.expression = expression;
        switch (expression) {
            case ":)":
                this.resource = new Image(getClass().getResource("resources/happy.gif").toExternalForm());
                break;
            case ":(":
                this.resource = new Image(getClass().getResource("resources/sad.gif").toExternalForm());
                break;
        }
    }
}
