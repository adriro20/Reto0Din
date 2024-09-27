/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import Model.User;

/**
 * Interfaz que define el contrato para acceder a los datos de un usuario.
 * Cualquier clase que implemente esta interfaz debe proporcionar una implementación
 * del método {@code getUserData()} para recuperar los datos de un usuario desde
 * alguna fuente de datos (por ejemplo, una base de datos).
 * 
 * @author Adrian
 */
public interface DataAccessible {

    /**
     * Método para obtener los datos de un usuario.
     * Las clases que implementen esta interfaz deben definir cómo se recuperan
     * los datos de un usuario (como nombre, apellido, dirección, etc.).
     * 
     * @return Un objeto {@link User} que contiene los datos del usuario.
     * @throws Exception Si ocurre algún error durante la obtención de los datos,
     *         como problemas de conexión o de acceso a la fuente de datos.
     */
    public User getUserData() throws Exception;
}
