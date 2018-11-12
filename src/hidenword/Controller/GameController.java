/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.Controller;

import static hidenword.Constants.Windows.GAME_SCENE_HEIGHT;
import static hidenword.Constants.Windows.GAME_SCENE_WIDTH;
import hidenword.View.GameScene;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Gaëtan
 */
public class GameController implements EventHandler{
    private final Stage primaryStage;
    private final GameScene gameScene = new GameScene(new GridPane(),GAME_SCENE_WIDTH,GAME_SCENE_HEIGHT,(this));

    public GameController(final Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public GameScene getView() {
        return gameScene;
    }
    
    @Override
    public void handle(final Event event) {
        final Object source = event.getSource();
        if (source.equals(gameScene.getTextFieldChar())) {
            if(event.getEventType().equals(KeyEvent.ANY)){
                if (KeyCode.ENTER.equals(((KeyEvent)event).getCode())) {
                
                }
            }
        }
        /*
        if (source.equals(view.getButton())) {
            System.out.println("ButtonA has been pressed, switching to ViewB.");

            final ControllerB controllerB = new ControllerB(primaryStage);
            final Scene scene = new Scene(controllerB.getView());
            primaryStage.setScene(scene);
        }
        */
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}