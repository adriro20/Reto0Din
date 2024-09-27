/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import Model.User;
import dataAccess.UserManagerFactory;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

/**
 * Controlador de la interfaz de usuario que gestiona la visualización
 * de los datos del usuario en la aplicación. Esta clase implementa
 * la interfaz {@link Initializable} para realizar inicializaciones
 * necesarias al cargar la interfaz gráfica.
 * 
 * La clase permite mostrar información sobre un usuario, como DNI,
 * nombre, apellido, dirección, email y sexo, utilizando etiquetas
 * (labels) en la interfaz de usuario.
 * 
 * @author Guillermo
 */
public class UserDataViewController implements Initializable {

    // Etiquetas para mostrar los datos del usuario en la interfaz.
    @FXML
    private Label lblDNI = new Label();
    
    @FXML
    private Label lblNombre = new Label();
    
    @FXML
    private Label lblApellido = new Label();
    
    @FXML
    private Label lblDireccion = new Label();
    
    @FXML
    private Label lblEmail = new Label();
    
    @FXML
    private Label lblSexo = new Label();

    /**
     * Maneja la acción del botón que solicita la obtención de datos del usuario.
     * Al hacer clic en el botón, se llama a este método, que intenta obtener
     * los datos del usuario utilizando la clase {@link UserManagerFactory}.
     * Los datos obtenidos se muestran en las etiquetas correspondientes.
     * 
     * @param event El evento de acción que provoca la ejecución de este método.
     */
    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            // Obtiene los datos del usuario.
            User user = UserManagerFactory.getUserData();
            
            // Muestra los datos del usuario en las etiquetas.
            lblDNI.setText(user.getDni());
            lblNombre.setText(user.getNombre());
            lblApellido.setText(user.getApellido());
            lblDireccion.setText(user.getDireccion());
            lblEmail.setText(user.getEmail());
            lblSexo.setText(user.getSexo());
        } catch (Exception ex) {
            // Registra el error y muestra una alerta con el mensaje de error.
            Logger.getLogger(UserDataViewController.class.getName())
                  .severe(ex.getLocalizedMessage());
            
            new Alert(Alert.AlertType.ERROR, ex.getLocalizedMessage(),
                    ButtonType.OK).showAndWait();
        }
    }

    /**
     * Método que se llama al inicializar el controlador.
     * Este método puede ser utilizado para realizar cualquier configuración
     * necesaria al cargar la interfaz, aunque en esta implementación
     * no se realiza ninguna acción.
     * 
     * @param url La URL utilizada para localizar recursos.
     * @param rb El recurso del bundle que se utilizará para localizar
     *           cualquier texto para la interfaz.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO: Aquí se pueden realizar inicializaciones adicionales.
    }
}

