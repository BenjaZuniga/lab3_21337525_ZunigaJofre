package Codigo_fuente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Sistema que contiene todo y permite al usuario usar un chatbot
 */
public class System_21337525_ZunigaJofre implements System_Interface_21337525_ZunigaJofre{

    /**
     * Nombre del Sistema
     */
    private String name;

    /**
     * Id del chatbot inicial del sistema
     */
    private int inicialChatbotCodeLink;

    /**
     * Lista de los usuarios registrados en el sistema
     */
    private List<User_21337525_ZunigaJofre> registerUsers;

    /**
     * Lista con el nombre del usuario logeado en el sistema
     */
    private List<String> loginUser;

    /**
     * Opciones actuales del sistema, luego de haber interactuado con el
     */
    private List<Option_21337525_ZunigaJofre> actualOptions;

    /**
     * Lista de chatbots que contiene el sistema
     */
    private List<Chatbot_21337525_ZunigaJofre> chatbots;

    /**
     * Constructor de System
     * @param name Nombre del sistma
     * @param inicialChatbotCodeLink Id del chatbot inicial del sistema
     * @param chatbots Lista de chatbots que contiene el sistema
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
     * @return Nombre del sistema
     */
    public String getName() {
        return name;
    }

    /**
     * Método que retorna el inicialChatbotCodeLink de un System
     * @return Id del chatbot inicial del sistema
     */
    public int getInicialChatbotCodeLink(){
        return inicialChatbotCodeLink;
    }

    /**
     * Método que retorna el registerUsers de un System
     * @return Lista de usuarios registrados en el sistema
     */
    public List<User_21337525_ZunigaJofre> getRegisterUsers() {
        return registerUsers;
    }

    /**
     * Método que retorna los nombres de los usuarios registrados en un System
     * @return Lista de nombres de los usuarios registrados en el sistema
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
     * Método que retorna las actualOptions de un System
     * @return Lista de las opciones actuales del sistema
     */
    public List<Option_21337525_ZunigaJofre> getActualOptions() {
        return actualOptions;
    }

    /**
     * Método que retorna el loginUser de un System
     * @return Lista de chatbots que contiene el sistema
     */
    public List<Chatbot_21337525_ZunigaJofre> getChatbots() {
        return chatbots;
    }

    /**
     * Método que retorna los ids de los chatbots de un System
     * @return Lista de los ids de los chatbots que contiene el sistema
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
     * @param id Id del chatbot a buscar
     * @return Chatbot con el id a buscar, sino existe nulo
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
     * @param chatbot Chatbot que se desea añadir al sistema
     */
    public void systemAddChatbot(Chatbot_21337525_ZunigaJofre chatbot) {
        List<Integer> codes = getChatbotsIds();
        if(!codes.contains(chatbot.getId())){
            chatbots.add(chatbot);
        }

    }

    /**
     * Método que agrega un chatbot a un System si su id no está repetido
     * @param user User que se desea registrar en el sistema
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
     * @param user Nombre del usuario que se desea logear en el sistema
     */
    public void systemLogin(String user) {
        String name;
        loginUser.add(user);
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
     * @param message Mensaje o palabra para interactuar con las opciones del sistema
     */
    public void systemTalk(String message) {
        if(!loginUser.isEmpty()){
            Date date = new Date();
            String chat;
            chat = date + " - " + loginUser.get(0) + ": " + message + "\n";
            if(actualOptions.isEmpty()) {
                Chatbot_21337525_ZunigaJofre cb = getChatbotById(inicialChatbotCodeLink);
                chat += date + " - " + cb.getName() + "\n";
                Flow_21337525_ZunigaJofre flow = cb.getFlowById(cb.getStartFlowId());
                chat += flow.getName() + "\n" + flow.getAllOptionMessages();
                actualOptions = flow.getOptions();
                for(User_21337525_ZunigaJofre user: registerUsers){
                    String nameUser = user.getName();
                    if(nameUser.equals(loginUser.get(0))){
                        user.addChatHistory(chat);
                    }
                }
            }else {
                try {
                    for (Option_21337525_ZunigaJofre op : actualOptions) {
                        if (op.getKeyword().contains(message) || op.getMessage().contains(message)) {
                            Chatbot_21337525_ZunigaJofre cb = getChatbotById(op.getChatbotCodeLink());
                            chat = chat + date + " - " + cb.getName() + "\n";
                            Flow_21337525_ZunigaJofre flow = cb.getFlowById(op.getInicialFlowCodeLink());
                            chat = chat + flow.getName() + "\n" + flow.getAllOptionMessages();
                            actualOptions = flow.getOptions();
                            for (User_21337525_ZunigaJofre user : registerUsers) {
                                String nameUser = user.getName();
                                if (nameUser.equals(loginUser.get(0))) {
                                    user.addChatHistory(chat);
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Ninguna opcion tiene asociado el mensaje ingresado");
                }
            }
        }
    }

    /**
     * Método que retorna el historial de un usuario
     * @param username Nombre del usuario que se quiere el historial
     * @return Historial del usuario ingresado
     */
    public String systemSynthesis(String username) {
        String synthesis = "";
        for(User_21337525_ZunigaJofre user: registerUsers){
            if(username.equals(user.getName())){
                for(String chat: user.getChatHistory()){
                    synthesis += chat + "\n";
                }
            }
        }
        return synthesis;
    }

    /**
     * Método para simular una conversación con un System
     * @param maxInteractions Número máximo de interacciones de la simulación
     * @param seed Semilla para generar números pseudoaleatorios
     */
    public void systemSimulate(Integer maxInteractions, Integer seed, System_21337525_ZunigaJofre system) {
        Random randomSeed = new Random(seed);
        while(maxInteractions != 0){
            if(system.getActualOptions().isEmpty()){
                system.systemTalk("Hola");
            }else {
                int intMsg = randomSeed.nextInt();
                String message = String.valueOf( intMsg % system.getActualOptions().size() +1);
                system.systemTalk(message);
            }
            maxInteractions -= 1;
        }
    }

    /**
     * Método para imprimir un System en formato String
     * @return Sistema en formato String
     */
    public String toString(){
        return name + "," + inicialChatbotCodeLink + "," + registerUsers + "," + loginUser + "," + actualOptions + "," + chatbots;
    }
}
