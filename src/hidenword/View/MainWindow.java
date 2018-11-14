package hidenword.View;

import static hidenword.View.Windows.APP_NAME;
import static hidenword.View.Windows.LOGIN_SCENE_HEIGHT;
import static hidenword.View.Windows.LOGIN_SCENE_WIDTH;
import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainWindow extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(APP_NAME);
        
        GridPane grid = new GridPane();
        LoginScene loginScene = new LoginScene(grid,LOGIN_SCENE_WIDTH,LOGIN_SCENE_HEIGHT);
        primaryStage.setScene(loginScene);
        /*
        RegisterScene registerScene = new RegisterScene(grid,LOGIN_SCENE_WIDTH,LOGIN_SCENE_HEIGHT);
        primaryStage.setScene(registerScene);
        */
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
