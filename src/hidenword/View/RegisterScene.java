/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hidenword.View;

import static hidenword.App.Paths.FILE_REGISTER_SCENE_LANGS_NAME;
import static hidenword.App.Paths.PATH_REGISTER_SCENE_LANGS;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author Gaëtan
 */
public class RegisterScene extends Scene{
    private HBox hbBtn;
    private Button registerButton;
    
    //Label text
    private String scenetitleLabel;
    private String userNameLabel;
    private String passwordLabel;
    private String registerButtonLabel;
    
    public RegisterScene(GridPane grid,double width, double height) {
        super(grid, width, height);
        prepareLabel();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));  
        
        Text scenetitle = new Text(scenetitleLabel);
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        //Pseudo
        Label userName = new Label(userNameLabel);
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        //Password
        Label pw = new Label(passwordLabel);
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);
        
        createSignInButton();
        grid.add(hbBtn, 1, 4);
        
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        registerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Create button pressed");
            }
        });
    }
    
    private void createSignInButton(){
        registerButton = new Button(registerButtonLabel);
        hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(registerButton);
    }
    
    //Internationnalisation
    private void prepareLabel(){
        Locale currentLocale = Locale.getDefault();
        ResourceBundle messages;
        File file = new File(PATH_REGISTER_SCENE_LANGS);
        URL[] urls = null;
        try {
            urls = new URL[]{file.toURI().toURL()};
        } catch (MalformedURLException ex) {
            Logger.getLogger(LoginScene.class.getName()).log(Level.SEVERE, null, ex);
        }
        ClassLoader loader = new URLClassLoader(urls);
        messages = ResourceBundle.getBundle(FILE_REGISTER_SCENE_LANGS_NAME, currentLocale,loader);
        
        scenetitleLabel = messages.getString("SCENE_TITLE_LABEL");
        userNameLabel = messages.getString("USER_NAME_LABEL");
        passwordLabel = messages.getString("PASSWORD_LABEL");
        registerButtonLabel = messages.getString("REGISTER_BUTTON_LABEL");
    }
}