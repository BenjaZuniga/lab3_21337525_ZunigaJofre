package Codigo_fuente;


import java.util.List;


public class Option_21337525_ZunigaJofre implements Option_Interface_21337525_ZunigaJofre {
    private int code;
    private String message;
    private int chatbotCodeLink;
    private int inicialFlowCodeLink;
    private List<String> keyword;

    /**
     * Constructor de Option
     * @param code int
     * @param message String
     * @param chatbotCodeLink int
     * @param inicialFlowCodeLink int
     * @param keyword List<String>
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
     * @return code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * Método para retornar el message de un option
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Método para retornar el chatbotCodeLink de un option
     * @return chatbotCodeLink
     */
    public Integer getChatbotCodeLink() {
        return chatbotCodeLink;
    }

    /**
     * Método para retornar el inicialFlowCodeLink de un option
     * @return inicialFlowCodeLink
     */
    public Integer getInicialFlowCodeLink() {
        return inicialFlowCodeLink;
    }

    /**
     * * Método para retornar el keyword de un option
     * @return keyword
     */
    public List<String> getKeyword() {
        return keyword;
    }

    /**
     * * Método para retornar un option en formato String
     * @return String
     */
    @Override
    public String toString(){
        return  code + "," + message + "," + chatbotCodeLink + "," + inicialFlowCodeLink + "," + keyword;
    }
}
