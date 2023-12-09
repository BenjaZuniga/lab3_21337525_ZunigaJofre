package Codigo_fuente;

import java.util.ArrayList;

public class User_21337525_ZunigaJofre {
    private String name;
    private int rol;
    private ArrayList<String> chatHistory;

    /**
     * Constructor de User
     * @param name String
     * @param rol int
     */
    public User_21337525_ZunigaJofre(String name,int rol) {
        this.name = name;
        this.rol = rol;
        this.chatHistory = new ArrayList<>();
    }

    /**
     * Método que retorna el name de un User
     * @return name
     */
    public String getName(){
        return name;
    }

    /**
     * Método que retorna el rol de un User
     * @return rol
     */
    public int getRol(){
        return rol;
    }

    /**
     * Método que retorna el chatHistory de un User
     * @return chatHistory
     */
    public ArrayList<String> getChatHistory(){
        return chatHistory;
    }

    /**
     * Método que agrega un String al chatHistory de un User
     * @param newChat String
     */
    public void addChatHistory(String newChat){
        this.chatHistory.add(newChat);
    }

    /**
     * Método para imprimir un User en formato String
     * @return String
     */
    @Override
    public String toString(){
        return name + "," + rol + "," + chatHistory;
    }

}
