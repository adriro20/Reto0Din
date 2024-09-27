/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import Model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Clase que permite acceder a los datos del usuario desde una base de datos.
 * Implementa la interfaz {@link DataAccessible} para obtener los datos del usuario.
 * Esta clase se encarga de establecer la conexión con la base de datos,
 * ejecutar la consulta para obtener los datos del usuario y cerrar la conexión.
 * 
 * La configuración de la base de datos, como la URL, el nombre de usuario (root)
 * y la contraseña, se cargan desde un archivo de propiedades.
 * 
 * @author Adrian
 */
public class DBUserDataAccessor implements DataAccessible {

    // Objeto para manejar el archivo de configuración de la base de datos.
    private ResourceBundle fichConf;
    
    // Objeto que representa al usuario cuyos datos se recuperarán de la base de datos.
    private User user;
    
    // Variables para almacenar los detalles de conexión a la base de datos.
    private String URL, DBROOT, DBROOTPASS;
    
    // Conexión y declaración SQL para interactuar con la base de datos.
    private Connection conexion;
    private PreparedStatement declaracion;
    
    // Consulta SQL para obtener los datos del usuario.
    private final String getDatos = "SELECT DNI, NOMBRE, APELLIDO, DIRECCION, EMAIL, SEXO FROM USER LIMIT 1";
    
    /**
     * Constructor de la clase. Inicializa los valores de conexión a la base de datos
     * obteniendo las configuraciones desde un archivo de propiedades.
     */
    public DBUserDataAccessor() {
        // Carga el archivo de configuración "databaseSettings.properties".
        fichConf = ResourceBundle.getBundle("dataAccess.databaseSettings");
        
        // Inicializa las variables de conexión con los valores del archivo de configuración.
        URL = fichConf.getString("URL");
        DBROOT = fichConf.getString("DBROOT");
        DBROOTPASS = fichConf.getString("DBROOTPASS");
    }
    
    /**
     * Abre la conexión con la base de datos utilizando los valores de URL, usuario root
     * y contraseña que fueron inicializados en el constructor.
     * 
     * @throws SQLException Si ocurre algún error al intentar establecer la conexión.
     */
    private void openConnection() throws SQLException {
        // Abre una conexión con la base de datos.
        conexion = DriverManager.getConnection(URL, DBROOT, DBROOTPASS);
    }
    
    /**
     * Cierra la conexión y la declaración SQL si están abiertas.
     * Maneja posibles excepciones de SQL de manera interna.
     */
    private void closeConnection() {
        try {
            if (declaracion != null) {
                // Cierra la declaración SQL.
                declaracion.close();
            }
            if (conexion != null) {
                // Cierra la conexión con la base de datos.
                conexion.close();
            }
        } catch (SQLException evento) {
            // Imprime el stack trace si ocurre una excepción al cerrar.
            evento.printStackTrace();
        }
    }

    /**
     * Obtiene los datos del usuario desde la base de datos.
     * Ejecuta una consulta SQL que recupera el DNI, nombre, apellido, dirección,
     * email y sexo del primer usuario en la tabla "USER".
     * 
     * @return Un objeto {@link User} con los datos recuperados.
     * @throws Exception Si ocurre algún error durante la consulta o la conexión a la base de datos.
     */
    @Override
    public User getUserData() throws Exception {
        ResultSet resultado;
        user = new User();  // Inicializa un nuevo objeto User para almacenar los datos.
        try {
            // Abre la conexión a la base de datos.
            openConnection();
            
            // Prepara la declaración SQL para ejecutar la consulta.
            declaracion = conexion.prepareStatement(getDatos);
            
            // Ejecuta la consulta y obtiene el resultado.
            resultado = declaracion.executeQuery();
            
            // Si existe un resultado, asigna los datos recuperados al objeto User.
            if (resultado.next()) {
                user.setDni(resultado.getString("DNI"));
                user.setNombre(resultado.getString("NOMBRE"));
                user.setApellido(resultado.getString("APELLIDO"));
                user.setDireccion(resultado.getString("DIRECCION"));
                user.setEmail(resultado.getString("EMAIL"));
                user.setSexo(resultado.getString("SEXO"));
            }
            
            // Cierra la conexión después de la consulta.
            closeConnection();
            
            // Retorna el objeto User con los datos recuperados.
            return user;
        } catch (Exception e) {
            // Lanza cualquier excepción que ocurra durante el proceso.
            throw e;
        }
    }
}

