package Codigo_fuente;

import java.util.ArrayList;
import java.util.List;

/**
 * Chatbot que contiene flujos y puede ser agregado a un sistema
 */
public class Chatbot_21337525_ZunigaJofre implements Chatbot_Interface_21337525_ZunigaJofre {

    /**
     * Id del Chatbot que permite identificarlo
     */
    private int id;

    /**
     * Nombre del Chatbot
     */
    private String name;

    /**
     * Mensaje de bienvenida del Chatbot
     */
    private String welcomeMessage;

    /**
     * Id del flujo inicial del Chatbot
     */
    private int startFlowId;

    /**
     * Lista de Flujos que contiene el Chatbot
     */
    private List<Flow_21337525_ZunigaJofre> flows;

    /**
     * Constructor de chatbot
     * @param id Id del Chatbot
     * @param name Nombre del Chatbot
     * @param welcomeMessage Mensaje de bienvenida del Chatbot
     * @param startFlowId Id del flujo inicial del Chatbot
     * @param flows Lista de Flujos que contiene el Chatbot
     */
    public Chatbot_21337525_ZunigaJofre(int id, String name, String welcomeMessage, int startFlowId, List<Flow_21337525_ZunigaJofre> flows) {
        this.id = id;
        this.name = name;
        this.welcomeMessage = welcomeMessage;
        this.startFlowId = startFlowId;
        ArrayList<Integer> codes = new ArrayList<>();
        ArrayList<Flow_21337525_ZunigaJofre> newFlows = new ArrayList<>();
        for(Flow_21337525_ZunigaJofre flow: flows){
            Integer code = flow.getId();
            if(!codes.contains(code)){
                codes.add(code);
                newFlows.add(flow);
            }
        }
        this.flows = newFlows;
    }

    /**
     * Método que retorna el id de un chatbot
     * @return Id del Chatbot
     */
    public int getId() {
        return id;
    }

    /**
     * Método que retorna el name de un chatbot
     * @return Nombre del Chatbot
     */
    public String getName() {
        return name;
    }

    /**
     * Método que retorna el startFlowId de un chatbot
     * @return Id del flujo inicial del Chatbot
     */
    public int getStartFlowId() {
        return startFlowId;
    }

    /**
     * Método que retorna el flows de un chatbot
     * @return Lista de Flujos que contiene el Chatbot
     */
    public List<Flow_21337525_ZunigaJofre> getFlows() {
        return flows;
    }

    /**
     * Método que retorna una lista con los ids de todos los flows de un chatbot
     * @return Lista de Ids de los Flujos que contiene el Chatbot
     */
    public ArrayList<Integer> getFlowsIds(){
        ArrayList<Integer> codes = new ArrayList<>();
        int code;
        for(Flow_21337525_ZunigaJofre flow: flows){
            code = flow.getId();
            if(!codes.contains(code)){
                codes.add(code);
            }
        }
        return codes;
    }

    /**
     * Método que agrega un flow aun chatbot si su id no esta repetido
     * @param flow Flujo que se quiere añadir
     */
    public void chatbotAddFlow(Flow_21337525_ZunigaJofre flow){
        ArrayList<Integer> codes = getFlowsIds();
        int flowCode = flow.getId();
        if(!codes.contains(flowCode)){
            flows.add(flow);
        }
    }

    /**
     * Método que busca un flow dentro de un chatbot por su id y lo retorna si es que existe
     * @param id Id del Flujo a buscar
     * @return Flujo con el Id que se estaba buscando, sino existe FLujo con el id a buscar nulo
     */
    public Flow_21337525_ZunigaJofre getFlowById(Integer id){
        for(Flow_21337525_ZunigaJofre flow: flows){
            Integer flowId = flow.getId();
            if(flowId.equals(id)){
                return flow;
            }
        }
        return null;
    }

    /**
     * Método para imprimir un chatbot en formato String
     * @return Un chatbot en formato String
     */
    @Override
    public String toString(){
        return id + "," + name + "," + welcomeMessage + "," + startFlowId + "," + flows;
    }
}
