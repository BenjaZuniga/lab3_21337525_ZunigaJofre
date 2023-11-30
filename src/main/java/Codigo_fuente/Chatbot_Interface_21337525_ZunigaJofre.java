package Codigo_fuente;

import java.util.List;

public interface Chatbot_Interface_21337525_ZunigaJofre {

    int getId();
    String getName();
    String getWelcomeMessage();
    int getStartFlowId();
    List<Flow_21337525_ZunigaJofre> getFlows();
    void chatbotAddFlow(Flow_21337525_ZunigaJofre flow);
}
