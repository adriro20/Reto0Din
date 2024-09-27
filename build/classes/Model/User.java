/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Clase que representa un usuario con atributos como DNI, nombre, apellido,
 * dirección, email y sexo. Esta clase proporciona métodos para obtener y 
 * establecer los valores de estos atributos.
 * 
 * La clase incluye dos constructores: uno que permite inicializar todos los 
 * atributos del usuario y otro que no recibe parámetros.
 * 
 * @author Guillermo
 */
public class User {
    
    // Atributo que almacena el DNI del usuario.
    private String dni;
    
    // Atributo que almacena el nombre del usuario.
    private String nombre;
    
    // Atributo que almacena el apellido del usuario.
    private String apellido;
    
    // Atributo que almacena la dirección del usuario.
    private String direccion;
    
    // Atributo que almacena el email del usuario.
    private String email;
    
    // Atributo que almacena el sexo del usuario.
    private String sexo;

    /**
     * Constructor que inicializa todos los atributos del usuario.
     * 
     * @param dni El DNI del usuario.
     * @param nombre El nombre del usuario.
     * @param apellido El apellido del usuario.
     * @param direccion La dirección del usuario.
     * @param email El email del usuario.
     * @param sexo El sexo del usuario.
     */
    public User(String dni, String nombre, String apellido, String direccion, String email, String sexo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.email = email;
        this.sexo = sexo;
    }

    /**
     * Constructor vacío que permite crear un objeto User sin inicializar
     * sus atributos.
     */
    public User() {
    }

    /**
     * Establece el DNI del usuario.
     * 
     * @param dni El DNI a asignar al usuario.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Establece el nombre del usuario.
     * 
     * @param nombre El nombre a asignar al usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el apellido del usuario.
     * 
     * @param apellido El apellido a asignar al usuario.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Establece la dirección del usuario.
     * 
     * @param direccion La dirección a asignar al usuario.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Establece el email del usuario.
     * 
     * @param email El email a asignar al usuario.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Establece el sexo del usuario.
     * 
     * @param sexo El sexo a asignar al usuario.
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * Obtiene el DNI del usuario.
     * 
     * @return El DNI del usuario.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Obtiene el nombre del usuario.
     * 
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el apellido del usuario.
     * 
     * @return El apellido del usuario.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Obtiene la dirección del usuario.
     * 
     * @return La dirección del usuario.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Obtiene el email del usuario.
     * 
     * @return El email del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Obtiene el sexo del usuario.
     * 
     * @return El sexo del usuario.
     */
    public String getSexo() {
        return sexo;
    }
}

