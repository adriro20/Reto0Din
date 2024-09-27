/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import Model.User;
import java.util.ResourceBundle;

/**
 * Clase que permite acceder a los datos del usuario desde un archivo de propiedades.
 * Implementa la interfaz {@link DataAccessible} para obtener los datos del usuario.
 * Esta clase se encarga de leer un archivo de propiedades (en formato {@code .properties}),
 * desde el cual extrae información sobre el usuario, como DNI, nombre, apellido, etc.
 * 
 * @author Adrian
 */
public class FileUserDataAccessor implements DataAccessible {
    
    // Objeto para manejar el archivo de propiedades que contiene los datos del usuario.
    private ResourceBundle fichConf;
    
    /**
     * Obtiene los datos del usuario desde un archivo de propiedades.
     * El archivo de propiedades debe contener claves como "DNI", "NOMBRE", "APELLIDO",
     * "DIRECCION", "EMAIL", y "SEXO", con sus respectivos valores asociados.
     * 
     * @return Un objeto {@link User} con los datos recuperados del archivo de propiedades.
     * @throws Exception Si ocurre algún error durante la lectura del archivo de propiedades.
     */
    @Override
    public User getUserData() throws Exception {
        try {
            // Inicializa un nuevo objeto User para almacenar los datos del archivo.
            User user = new User();

            // Carga el archivo de propiedades "UserData.properties".
            fichConf = ResourceBundle.getBundle("dataAccess.UserData");
            
            // Asigna los valores del archivo de propiedades al objeto User.
            user.setDni(fichConf.getString("DNI"));
            user.setNombre(fichConf.getString("NOMBRE"));
            user.setApellido(fichConf.getString("APELLIDO"));
            user.setDireccion(fichConf.getString("DIRECCION"));
            user.setEmail(fichConf.getString("EMAIL"));
            user.setSexo(fichConf.getString("SEXO"));

            // Retorna el objeto User con los datos cargados.
            return user;
        } catch (Exception e) {
            // Lanza cualquier excepción que ocurra durante la obtención de datos.
            throw e;
        }
    }
}

