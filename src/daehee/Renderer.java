package daehee;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The class searches for smiley strings inside a raw message text
 * and stores the whole message ready to be rendered in the application.
 */
public class Renderer {

    private ArrayList<Object> arrRendered = new ArrayList<>();
    private String[] smiles = {":)", ":("};
    private Image smileImage;

    /**
     * The constructor creates an ArrayList of a message stub
     * using convertSmile and searchSmile methods
     * when the class is instantiated.
     * The first two elements are time and username, and the rest is the message text.
     * @param timeRendered the string of time recorded for the message text
     * @param username the string of username who wrote the message text
     * @param rawMsg the raw string of the message text
     * @throws Exception the image resource for some smiles does not exist.
     */
    public Renderer(String timeRendered, String username, String rawMsg) throws Exception {
        this.arrRendered.add(timeRendered);
        this.arrRendered.add(username);
        this.arrRendered.addAll(this.searchSmile(rawMsg));
    }

    /**
     * It converts a raw string into a matching Smiley image.
     * @param smileString a raw string that can be converted to an image
     * @return an image file that represents a raw string
     * @throws Exception the image resource for some smiles does not exist.
     */
    private Image convertSmile(String smileString) throws Exception {
        switch (smileString) {
            case ":)":
                smileImage = new Image("resources/happy.gif");
                break;
            case ":(":
                smileImage = new Image("resources/sad.gif");
                break;
            default:
                throw new Exception("No image to render such smile");
        }
        return smileImage;
    }

    /**
     * It iterates through a raw text and converts all existing Smiley strings into images.
     * @param rawMsg a string of text given to convert into rendered objects
     * @return an ArrayList of all strings and smiley images stripped of whitespaces
     * @throws Exception the image resource for some smiles does not exist.
     */
    private ArrayList<Object> searchSmile(String rawMsg) throws Exception {
        ArrayList<Object> arr = new ArrayList<>(Arrays.asList(rawMsg.split(" ")));
        for (String smile: smiles) {
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).equals(smile)) {
                   arr.set(i, convertSmile(smile));
                }
            }
        }
        return arr;
    }

}