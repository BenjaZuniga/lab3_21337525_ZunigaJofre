package Codigo_fuente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class System_21337525_ZunigaJofre implements System_Interface_21337525_ZunigaJofre{
    private String name;
    private int inicialChatbotCodeLink;
    private List<User_21337525_ZunigaJofre> registerUsers;
    private List<String> loginUser;
    private List<Option_21337525_ZunigaJofre> actualOptions;
    private List<Chatbot_21337525_ZunigaJofre> chatbots;

    /**
     * Constructor de System
     * @param name int
     * @param inicialChatbotCodeLink String
     * @param chatbots List<Chatbot_21337525_ZunigaJofre>
     */
    public System_21337525_ZunigaJofre(String name, int inicialChatbotCodeLink, List<Chatbot_21337525_ZunigaJofre> chatbots){
        this.name = name;
        this.inicialChatbotCodeLink = inicialChatbotCodeLink;
        this.registerUsers = new ArrayList<>();
        this.loginUser = new ArrayList<>();
        this.actualOptions = new ArrayList<>();
        ArrayList<Integer> chatbotsCodes = new ArrayList<>();
        ArrayList<Chatbot_21337525_ZunigaJofre> newChatbots = new ArrayList<>();
        for(Chatbot_21337525_ZunigaJofre chatbot: chatbots){
            int chatbotCode = chatbot.getId();
            if(!chatbotsCodes.contains(chatbotCode)){
                chatbotsCodes.add(chatbotCode);
                newChatbots.add(chatbot);
            }
        }
        this.chatbots = newChatbots;
    }

    /**
     * Método que retorna el name de un System
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Método que retorna el inicialChatbotCodeLink de un System
     * @return inicialChatbotCodeLink
     */
    public int getInicialChatbotCodeLink() {
        return inicialChatbotCodeLink;
    }

    /**
     * Método que retorna el registerUsers de un System
     * @return registerUsers
     */
    public List<User_21337525_ZunigaJofre> getRegisterUsers() {
        return registerUsers;
    }

    /**
     * Método que retorna los nombres de los usuarios registrados en un System
     * @return registerUsersNames
     */
    public List<String>getRegisterUsersNames(){
        List <String> registerUsersNames = new ArrayList<>();
        for(User_21337525_ZunigaJofre user: registerUsers){
            if(!registerUsersNames.contains(user.getName())){
                registerUsersNames.add(user.getName());
            }
        }
        return registerUsersNames;
    }

    /**
     * Método que retorna el loginUser de un System
     * @return loginUser
     */
    public List<String> getLoginUser() {
        return loginUser;
    }

    /**
     * Método que retorna el actualOptions de un System
     * @return actualOptions
     */
    public List<Option_21337525_ZunigaJofre> getActualOptions() {
        return actualOptions;
    }

    /**
     * Método que retorna el loginUser de un System
     * @return chatbots
     */
    public List<Chatbot_21337525_ZunigaJofre> getChatbots() {
        return chatbots;
    }

    /**
     * Método que retorna los ids de los chatbots de un System
     * @return
     */
    public List<Integer> getChatbotsIds(){
        List<Integer> chatbotsCodes = new ArrayList<>();
        for(Chatbot_21337525_ZunigaJofre chatbot : chatbots){
            int chatbotCode = chatbot.getId();
            if(!chatbotsCodes.contains(chatbotCode)){
                chatbotsCodes.add(chatbotCode);
            }
        }
        return chatbotsCodes;
    }

    /**
     * Método que busca un chatbot dentro de un System por id
     * @param id int
     * @return Chatbot
     */
    public Chatbot_21337525_ZunigaJofre getChatbotById(Integer id){
        for(Chatbot_21337525_ZunigaJofre cb: chatbots){
            Integer cbId = cb.getId();
            if(cbId.equals(id)){
                return cb;
            }
        }
        return null;
    }

    /**
     * Método que agrega un chatbot a un System si su id no está repetido
     * @param chatbot Chatbot
     */
    public void systemAddChatbot(Chatbot_21337525_ZunigaJofre chatbot) {
        List<Integer> codes = getChatbotsIds();
        if(!codes.contains(chatbot.getId())){
            chatbots.add(chatbot);
        }

    }

    /**
     * Método que agrega un chatbot a un System si su id no está repetido
     * @param user User
     */
    public void systemAddUser(User_21337525_ZunigaJofre user) {
        List<String> userNames = getRegisterUsersNames();
        if(!userNames.contains(user.getName())){
            registerUsers.add(user);
        }else{
            System.out.println("Ya existe un usuario con ese nombre");
        }

    }

    /**
     * Método que logea un usuario a un System si es que esta registrado y no hay otro logeado
     * @param user String
     */
    public void systemLogin(String user) {
        String name;
        if(loginUser.isEmpty()) {
            List<String> userNames = getRegisterUsersNames();
            if(!userNames.contains(user)){
                loginUser.add(user);
            }
        }
    }

    /**
     * Método que deslogea un usuario de un System
     */
    public void systemLogout() {
        loginUser = new ArrayList<>();
        actualOptions = new ArrayList<>();
    }

    /**
     * Método que permite hablar con un System
     * @param message String
     */
    public void systemTalk(String message) {
        if(!loginUser.isEmpty()){
            Date date = new Date();
            String chat;
            chat = date + " - " + loginUser.get(0) + ": " + message + "\n";
            if(actualOptions.isEmpty()){
                Chatbot_21337525_ZunigaJofre cb = getChatbotById(inicialChatbotCodeLink);
                chat = chat + date +  " - " + cb.getName() + "\n";
                Flow_21337525_ZunigaJofre flow = cb.getFlowById(cb.getStartFlowId());
                chat = chat + flow.getName() +"\n" + flow.getAllOptionMessages();
                actualOptions = flow.getOptions();
            }else{
                for(Option_21337525_ZunigaJofre op: actualOptions){
                    try {
                        if(op.getKeyword().contains(message) ||op.getMessage().contains(message)){
                            Chatbot_21337525_ZunigaJofre cb = getChatbotById(op.getChatbotCodeLink());
                            chat =  chat + date + " - " + cb.getName() + "\n";
                            Flow_21337525_ZunigaJofre flow = cb.getFlowById(op.getInicialFlowCodeLink());
                            chat = chat + flow.getName() +"\n" + flow.getAllOptionMessages();
                            actualOptions = flow.getOptions();
                        }
                    }catch (Exception e) {
                        System.out.println("Ninguna opción tiene asociado el mensaje ingresado");
                    }
                }
            }
            for(User_21337525_ZunigaJofre user: registerUsers){
                String nameUser = user.getName();
                if(nameUser.equals(loginUser.get(0))){
                    user.addChatHistory(chat);
                }
            }
        }
    }

    /**
     * Método que retorna el historial de un usuario
     * @param username String
     * @return chatHistory
     */
    public String systemSynthesis(String username) {
        for(User_21337525_ZunigaJofre user: registerUsers){
            if(username.equals(user.getName())){
                return user.getChatHistory();
            }
        }
        return null;
    }

    /**
     * Método para simular una conversación con un System
     * @param maxInteractions int
     * @param seed int
     */
    public void systemSimulate(Integer maxInteractions, Integer seed) {
        while(maxInteractions != 0){
            String message = String.valueOf((seed % (actualOptions.size()- 1))+ 1);
            systemTalk(message);
            maxInteractions -= 1;
        }
    }

    /**
     * Método para imprimir un System en formato String
     * @return String
     */
    public String toString(){
        return name + "," + inicialChatbotCodeLink + "," + registerUsers + "," + loginUser + "," + actualOptions + "," + chatbots;
    }
}
