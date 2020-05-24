package daehee;

import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;

/**
 * The class searches for smiley strings inside a raw message text
 * and stores the whole message ready to be rendered in the application.
 */
public class Renderer {

    private Message message;
    private TextFlow textFlow;

    /**It passes all the message items into a text flow object using tokens stored in Message class
     * @param message an instance of Message that contains processed tokens
     * @param textFlow an instance of textFlow to display tokens
     */
    public void render(Message message, TextFlow textFlow) {
        this.message = message;
        this.textFlow = textFlow;

        for (int i = 0; i < message.getMsgTokens().size(); i++) {
            switch (i % 4) {
                case 0:
                    textFlow.getChildren().add(new Text("[" + message.getMsgTokens().get(i) + "] "));
                    break;
                case 1:
                    textFlow.getChildren().add(new Text(message.getMsgTokens().get(i) + ": "));
                    break;
                case 2:
                    for (Object contentToken: (ArrayList<Object>) message.getMsgTokens().get(i)) {
                        if (contentToken instanceof String) {
                            textFlow.getChildren().add(new Text((String)contentToken));
                        } else {
                            textFlow.getChildren().add(new ImageView(((Smile)contentToken).resource));
                        }
                    }
                    break;
                case 3:
                    textFlow.getChildren().add(new Text(System.getProperty("line.separator")));
                    break;
            }
        }
    }
}