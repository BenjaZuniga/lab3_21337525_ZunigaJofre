package Codigo_fuente;

import java.util.ArrayList;

/**
 * Usuarios que se pueden registrar en un sitema
 */
public class User_21337525_ZunigaJofre {

    /**
     * Nombre del usuario
     */
    private String name;

    /**
     * Rol del usuario
     */
    private int rol;

    /**
     * Lista con las interacciones con el sistema por parte usuario
     */
    private ArrayList<String> chatHistory;

    /**
     * Constructor de User
     * @param name Nombre del usuario
     * @param rol Rol que se desea que tenga el usuario
     */
    public User_21337525_ZunigaJofre(String name,int rol) {
        this.name = name;
        this.rol = rol;
        this.chatHistory = new ArrayList<>();
    }

    /**
     * Método que retorna el name de un User
     * @return Nombre dek usuario
     */
    public String getName(){
        return name;
    }

    /**
     * Método que retorna el rol de un User
     * @return Rol del usuario
     */
    public int getRol(){
        return rol;
    }

    /**
     * Método que retorna el chatHistory de un User
     * @return Historial del usuario
     */
    public ArrayList<String> getChatHistory(){
        return chatHistory;
    }

    /**
     * Método que agrega un String al chatHistory de un User
     * @param newChat Interaccion que se desea agregar al historial del usuario
     */
    public void addChatHistory(String newChat){
        this.chatHistory.add(newChat);
    }

    /**
     * Método para imprimir un User en formato String
     * @return Un usuario en formato String
     */
    @Override
    public String toString(){
        return name + "," + rol + "," + chatHistory;
    }

}
