package Codigo_fuente;

import java.util.List;

public interface System_Interface_21337525_ZunigaJofre {

    String getName();

    int getInicialChatbotCodeLink();

    List<User_21337525_ZunigaJofre> getRegisterUsers();
    List<String> getLoginUser();

    List<Option_21337525_ZunigaJofre> getActualOptions();

    List<Chatbot_21337525_ZunigaJofre> getChatbots();

    void systemAddChatbot(Chatbot_21337525_ZunigaJofre chatbot);
    void systemAddUser(User_21337525_ZunigaJofre user);
    void systemLogin(String user);
    void systemLogout();

    void systemTalk(String message);

    String systemSynthesis(String username);

    void systemSimulate(Integer maxInteractions, Integer seed);
    String toString();



}
