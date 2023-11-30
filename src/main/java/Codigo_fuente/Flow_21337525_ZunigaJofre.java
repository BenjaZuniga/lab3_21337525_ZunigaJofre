package Codigo_fuente;

import java.util.ArrayList;
import java.util.List;


public class Flow_21337525_ZunigaJofre  implements Flow_Interface_21337525_ZunigaJofre {
    private Integer id;
    private String nameMsg;
    private List<Option_21337525_ZunigaJofre> options;

    /**
     * Constructor de Flow
     * @param id int
     * @param nameMsg String
     * @param options List<Option_21337525_ZunigaJofre>
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
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Método para retornar el nameMsg de un flow
     * @return nameMsg
     */
    public String getName() {
        return nameMsg;
    }

    /**
     * Método para retornar el options de un flow
     * @return options
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
     * Método para añadir un option a un flow si es que no está repetida
     * @param option Option
     */
    public void flowAddOption(Option_21337525_ZunigaJofre option){
        int opcode = option.getCode();
        ArrayList<Integer> codes = getOptionsCodes();
        if(!codes.contains(opcode)){
            options.add(option);
        }
    }

    /**
     * Método para retornar un String con todos los mensajes de las opciones de un flow
     * @return String
     */
    public String getAllOptionMessages(){
        String messages = null;
        for(Option_21337525_ZunigaJofre op: options) {
            messages = messages + op.getMessage() + "\n";
        }
        return messages;
    }

    /**
     * Método para imprimir un flow en formato String
     * @return String
     */
    @Override
    public String toString(){
        return id + "," + nameMsg + "," + options;
    }
}
