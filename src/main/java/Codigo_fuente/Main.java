package Codigo_fuente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Sistema de pruebas
        Option_21337525_ZunigaJofre op1 = new Option_21337525_ZunigaJofre(1, "1) Viajar", 1,1, Arrays.asList("viajar", "turistear", "conocer"));
        Option_21337525_ZunigaJofre op2 = new Option_21337525_ZunigaJofre(2, "2) Estudiar", 2, 1, Arrays.asList("estudiar", "aprender","perfeccionarme"));
        Option_21337525_ZunigaJofre op3 = new Option_21337525_ZunigaJofre(1, "1) New York, USA",1,2,Arrays.asList("Estados unidos", "New York"));
        Option_21337525_ZunigaJofre op4 = new Option_21337525_ZunigaJofre(2, "2) Paris, Francia ",1,1,Arrays.asList("Paris", "Eiffel"));
        Option_21337525_ZunigaJofre op5 = new Option_21337525_ZunigaJofre(3, "3) Torres del Paine, Chile",1,1,Arrays.asList("Chile", "Torres","Paine","Torres Paine", "Torres del Paine"));
        Option_21337525_ZunigaJofre op6 = new Option_21337525_ZunigaJofre(4, "4) Volver",0,1,Arrays.asList("Regresar", "Salir","Volver"));
        Option_21337525_ZunigaJofre op7 = new Option_21337525_ZunigaJofre(1, "1) Central Park",1,2,Arrays.asList("Central", "Park", "Central Park"));
        Option_21337525_ZunigaJofre op8 = new Option_21337525_ZunigaJofre(2, "2) Museos",1,2, List.of("Museo"));
        Option_21337525_ZunigaJofre op9 = new Option_21337525_ZunigaJofre(3, "3) Ningun otro atractivo",1,3, List.of("Ningun otro atractivo"));
        Option_21337525_ZunigaJofre op10 = new Option_21337525_ZunigaJofre(4, "4) Cambiar destino",1,1,Arrays.asList("Cambiar","Volver", "Salir"));
        Option_21337525_ZunigaJofre op11 = new Option_21337525_ZunigaJofre(1, "1) Solo",1,3, List.of("Solo"));
        Option_21337525_ZunigaJofre op12 = new Option_21337525_ZunigaJofre(2, "2) En pareja",1,3, List.of("Pareja"));
        Option_21337525_ZunigaJofre op13 = new Option_21337525_ZunigaJofre(3, "3) En familia",1,3, List.of("Familia"));
        Option_21337525_ZunigaJofre op14 = new Option_21337525_ZunigaJofre(4, "4) Agregar más atractivos",1,2,Arrays.asList("Volver", "Atractivos"));
        Option_21337525_ZunigaJofre op15 = new Option_21337525_ZunigaJofre(5, "5) En realidad quiero otro destino",1,1, List.of("Cambiar destino"));
        Option_21337525_ZunigaJofre op16 = new Option_21337525_ZunigaJofre(1, "1) Carrera Técnica",2,1, List.of("Tecnica"));
        Option_21337525_ZunigaJofre op17 = new Option_21337525_ZunigaJofre(2, "2) Postgrado",2,1,Arrays.asList("Doctorado", "Magister", "Postgrado"));
        Option_21337525_ZunigaJofre op18 = new Option_21337525_ZunigaJofre(3, "3) Volver",0,1,Arrays.asList("Regresar", "Salir","Volver"));

        Flow_21337525_ZunigaJofre f11 = new Flow_21337525_ZunigaJofre(1, "Flujo Principal Chatbot 1\nBienvenido\n¿Que te gustaria hacer?", Arrays.asList(op1,op2,op2,op2,op2,op1));
        f11.flowAddOption(op1);
        Flow_21337525_ZunigaJofre f20 = new  Flow_21337525_ZunigaJofre(1, "Flujo 1 Chatbot1\n¿Donde te gustaria ir", Arrays.asList(op3,op4,op5,op6));
        Flow_21337525_ZunigaJofre f21 = new  Flow_21337525_ZunigaJofre(2, "Flujo 2 Chatbot1\n¿Que atractivos te gustaria visitar?", Arrays.asList(op7,op8,op9,op10));
        Flow_21337525_ZunigaJofre f22 = new  Flow_21337525_ZunigaJofre(3, "Flujo 3 Chatbot1\n¿Vas solo o acompañado?", Arrays.asList(op11,op12,op13,op14,op15));
        Flow_21337525_ZunigaJofre f30 = new  Flow_21337525_ZunigaJofre(1, "Flujo 1 Chatbot2\n¿Que te gustaria estudiar?", Arrays.asList(op16, op17, op18));
        Chatbot_21337525_ZunigaJofre cb0 = new Chatbot_21337525_ZunigaJofre(0, "Inicial", "Bienvenido\n¿Que te gustaria hacer?", 1, Arrays.asList(f11,f11,f11,f11));
        Chatbot_21337525_ZunigaJofre cb1 = new Chatbot_21337525_ZunigaJofre(1, "Agenda Viajes", "Bienvenido\n¿Donde quieres viajar?", 1, Arrays.asList(f20,f21,f22));
        Chatbot_21337525_ZunigaJofre cb2 = new Chatbot_21337525_ZunigaJofre(2, "Orientador Academico", "Bienvenido\n¿Que te gustaria estudiar?", 1, List.of(f30));

        System_21337525_ZunigaJofre s1 = new System_21337525_ZunigaJofre("Chatbots Paradigmas", 0, Arrays.asList(cb0,cb0,cb1,cb1,cb2));

        Menu_21337525_ZunigaJofre menu = new Menu_21337525_ZunigaJofre();
        ArrayList<System_21337525_ZunigaJofre> sistemas = new ArrayList<>();
        sistemas.add(s1);

        menu.elegirSistema(sistemas);
    }
}