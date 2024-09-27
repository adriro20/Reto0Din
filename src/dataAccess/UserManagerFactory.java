/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import Model.User;
import java.util.ResourceBundle;

/**
 * Clase fábrica que gestiona el acceso a los datos del usuario dependiendo de la fuente de datos.
 * La clase determina si los datos del usuario se obtendrán de un archivo de propiedades o de una base de datos,
 * basándose en una configuración especificada en el archivo de propiedades "dbOrFile.properties".
 * 
 * Dependiendo de esta configuración, crea una instancia de {@link FileUserDataAccessor} o {@link DBUserDataAccessor}.
 * 
 * @author Adrian
 */
public class UserManagerFactory {

    // Objeto para acceder a los datos del usuario, puede ser un FileUserDataAccessor o DBUserDataAccessor.
    public static DataAccessible data;
    
    // Objeto para manejar el archivo de configuración que define la fuente de los datos del usuario.
    public static ResourceBundle fichConf;
    
    // Variable que determina si los datos se obtienen de un archivo o de la base de datos.
    public static String dbOrFich;
    
    /**
     * Método estático que obtiene los datos del usuario, ya sea desde un archivo de propiedades
     * o desde una base de datos, dependiendo de la configuración.
     * 
     * La configuración se define en el archivo "dbOrFile.properties", que contiene una clave
     * "data" cuyo valor puede ser "File" para acceder desde un archivo o cualquier otro valor
     * para acceder desde la base de datos.
     * 
     * @return Un objeto {@link User} con los datos del usuario.
     * @throws Exception Si ocurre algún error durante la obtención de los datos.
     */
    public static User getUserData() throws Exception {
        try {
            // Carga el archivo de configuración "dbOrFile.properties".
            fichConf = ResourceBundle.getBundle("dataAccess.dbOrFile");
            
            // Obtiene el valor de la clave "data" para determinar la fuente de datos.
            dbOrFich = fichConf.getString("data");
            
            // Si el valor es "File", utiliza el acceso a datos desde un archivo.
            if (dbOrFich.equals("File")) {
                data = new FileUserDataAccessor();
                return data.getUserData();
            } else {
                // En caso contrario, utiliza el acceso a datos desde la base de datos.
                data = new DBUserDataAccessor();
                return data.getUserData();
            }
        } catch (Exception e) {
            // Lanza cualquier excepción que ocurra durante la obtención de datos.
            throw e;
        }
    }
}

