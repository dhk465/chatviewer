package daehee;

import javafx.scene.image.Image;

public class Renderer {

    private String timeRendered;
    private String username;
    private String msgRendered;
    private Image smileHappy= new Image("resources/happy.gif");
    private Image smileSad= new Image("resources/sad.gif");

    public Renderer(String timeRendered, String username, String msgRendered) {
        this.timeRendered = timeRendered;
        this.username = username;
        this.msgRendered = msgRendered;
    }
}
