package Codigo_fuente;

import java.util.ArrayList;
import java.util.List;

/**
 * Es una especie de contenedor de Opciones, que permite organizar de mejor manera el sistema
 */
public class Flow_21337525_ZunigaJofre  implements Flow_Interface_21337525_ZunigaJofre {
    /**
     * Id del flujo para identificarlo
     */
    private Integer id;

    /**
     * Nombre del flujo
     */
    private String nameMsg;

    /**
     * Lista de opciones que contiene el flujo
     */
    private List<Option_21337525_ZunigaJofre> options;

    /**
     * Constructor de Flow
     * @param id Id del flujo
     * @param nameMsg Nombre del flujo
     * @param options Lista de opciones que contiene el flujo
     */
    public Flow_21337525_ZunigaJofre(Integer id, String nameMsg, List<Option_21337525_ZunigaJofre> options) {
        this.id = id;
        this.nameMsg = nameMsg;
        ArrayList<Integer> Codes = new ArrayList<>() ;
        ArrayList<Option_21337525_ZunigaJofre> newOps = new ArrayList<>();
        for (Option_21337525_ZunigaJofre op : options){
            Integer opcode = op.getCode();
            if (!Codes.contains(opcode)){
                Codes.add(opcode);
                newOps.add(op);
            }
        }
        this.options = newOps;
    }

    /**
     * Método para retornar el id de un flow
     * @return Id del flujo
     */
    public Integer getId() {
        return id;
    }

    /**
     * Método para retornar el nameMsg de un flow
     * @return Nombre del flujo
     */
    public String getName() {
        return nameMsg;
    }

    /**
     * Método para retornar el options de un flow
     * @return Lista de opciones que contiene el flujo
     */
    public List<Option_21337525_ZunigaJofre> getOptions() {
        return options;
    }
    public ArrayList<Integer> getOptionsCodes(){
        ArrayList<Integer> Codes = new ArrayList<>();
        int e;
        for (Option_21337525_ZunigaJofre op : options){
            e = op.getCode();
            Codes.add(e);
        }
        return Codes;
    }

    /**
     * Método para retornar un String con todos los mensajes de las opciones de un flow
     * @return Un String que contiene todos los mensajes de las opciones que contiene el flujo
     */
    public String getAllOptionMessages(){
        String messages = "";
        for(Option_21337525_ZunigaJofre op: options) {
            messages = messages + op.getMessage() + "\n";
        }
        return messages;
    }

    /**
     * Método para añadir un option a un flow si es que no está repetida
     * @param option Opcion que se quiere añadir
     */
    public void flowAddOption(Option_21337525_ZunigaJofre option){
        int opcode = option.getCode();
        ArrayList<Integer> codes = getOptionsCodes();
        if(!codes.contains(opcode)){
            options.add(option);
        }
    }

    /**
     * Método para imprimir un flow en formato String
     * @return Un flujo em formato String
     */
    @Override
    public String toString(){
        return id + "," + nameMsg + "," + options;
    }
}
