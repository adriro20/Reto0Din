/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase principal de la aplicación que extiende {@link javafx.application.Application}.
 * Esta clase es responsable de iniciar la aplicación JavaFX y cargar la interfaz de usuario
 * desde el archivo FXML correspondiente.
 * 
 * En el método {@link #start(Stage)} se configura la escena inicial y se muestra la ventana
 * principal de la aplicación.
 * 
 * @author Guillermo y Adrian
 */
public class Application extends javafx.application.Application {

    /**
     * Método que se llama al iniciar la aplicación. Carga el archivo FXML que define la interfaz
     * de usuario y establece la escena en la ventana principal.
     * 
     * @param stage La ventana principal de la aplicación.
     * @throws Exception Si ocurre un error al cargar el archivo FXML.
     */
    @Override
    public void start(Stage stage) throws Exception {
        // Carga el archivo FXML que contiene la definición de la interfaz de usuario.
        Parent root = FXMLLoader.load(getClass().getResource("UserDataView.fxml"));
        
        // Crea una nueva escena con el contenido cargado.
        Scene scene = new Scene(root);
        
        // Establece la escena en la ventana principal y la muestra.
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Método principal que inicia la aplicación.
     * 
     * @param args Los argumentos de línea de comandos que se pueden pasar al iniciar la aplicación.
     */
    public static void main(String[] args) {
        // Llama al método launch para iniciar la aplicación JavaFX.
        launch(args);
    }
}

