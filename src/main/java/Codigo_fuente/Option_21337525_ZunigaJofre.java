package Codigo_fuente;


import java.util.List;

/**
 * Representa las opciones de un chatbot a la hora de interactuar
 */
public class Option_21337525_ZunigaJofre implements Option_Interface_21337525_ZunigaJofre {
    /**
     * Codigo o id de la opcion para identificarla
     */
    private int code;

    /**
     * Mensaje que se muestra al usuario
     */
    private String message;

    /**
     * Id del chatbot vinculado a la opcion
     */
    private int chatbotCodeLink;

    /**
     * Id del flujo vinculado a la opcion
     */
    private int inicialFlowCodeLink;

    /**
     * Palabras que puede ingresar el usuario para seleccionar la opcion
     */
    private List<String> keyword;

    /**
     * Constructor de Option
     * @param code Codigo de la opcion
     * @param message Mensaje de la opcion
     * @param chatbotCodeLink Id del chatbot vinculado a la opcion
     * @param inicialFlowCodeLink Id del flujo vinculado a la opcion
     * @param keyword Lista de palabras que puede ingresar el usuario para seleccionar la opcion
     */
    public Option_21337525_ZunigaJofre(int code, String message, int chatbotCodeLink, int inicialFlowCodeLink, List<String> keyword) {
        this.code = code;
        this.message = message;
        this.chatbotCodeLink = chatbotCodeLink;
        this.inicialFlowCodeLink = inicialFlowCodeLink;
        this.keyword = keyword ;
    }


    /**
     * Método para retornar el code de un option
     * @return Codigo de la opcion
     */
    public Integer getCode() {
        return code;
    }

    /**
     * Método para retornar el message de un option
     * @return Mensaje de la opcion
     */
    public String getMessage() {
        return message;
    }

    /**
     * Método para retornar el chatbotCodeLink de un option
     * @return Id del chatbot vinculado a la opcion
     */
    public Integer getChatbotCodeLink() {
        return chatbotCodeLink;
    }

    /**
     * Método para retornar el inicialFlowCodeLink de un option
     * @return Id del flujo vinculado a la opcion
     */
    public Integer getInicialFlowCodeLink() {
        return inicialFlowCodeLink;
    }

    /**
     * * Método para retornar el keyword de un option
     * @return Lista de palabras que puede ingresar el usuario para seleccionar la opcion
     */
    public List<String> getKeyword() {
        return keyword;
    }

    /**
     * * Método para retornar un option en formato String
     * @return Opcion en formato String
     */
    @Override
    public String toString(){
        return  code + "," + message + "," + chatbotCodeLink + "," + inicialFlowCodeLink + "," + keyword;
    }
}
