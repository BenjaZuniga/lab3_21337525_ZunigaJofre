package Codigo_fuente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu_21337525_ZunigaJofre {
    public Menu_21337525_ZunigaJofre(){}
    public void principal(System_21337525_ZunigaJofre system){
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            try {
                System.out.println("..........Sistema de chatbots..........");
                System.out.println("Bienvenido ¿Qué desea hacer?");
                System.out.println("1) Registrar un usuario");
                System.out.println("2) Login de un usuario");
                System.out.println("3) Mostrar sistema");
                System.out.println("4) Salir");
                System.out.println("Ingrese su opción: ");
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion){
                    case 1:
                        registroUsuario(system);
                    case 2:
                        loginUsuario(system);
                    case 3:
                        System.out.println("..........Sistema..........");
                        System.out.println(system);
                        System.out.println("..............................");
                        principal(system);
                    case 4:
                        System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("¡¡ Ingresar una opción valida por favor !!");
                principal(system);
            }
        }
    }
    public void registroUsuario(System_21337525_ZunigaJofre system){
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        while (opcion != 0) {
            try {
                System.out.println("..........Registro de usuarios..........");
                System.out.println("1) Registrar un usuario común");
                System.out.println("2) Registrar un usuario administrador");
                System.out.println("3) Volver");
                System.out.println("4) Salir");
                System.out.println("Ingrese su opción: ");
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1:
                        System.out.println("Ingresar nombre del usuario: ");
                        String username1 = scanner.nextLine();
                        Common_User_21337525_ZunigaJofre newUser1 = new Common_User_21337525_ZunigaJofre(username1);
                        system.systemAddUser(newUser1);
                        System.out.println("..........Usuario creado..........");
                        System.out.println(newUser1);
                        System.out.println("..............................");
                        registroUsuario(system);
                    case 2:
                        System.out.println("Ingresar nombre del usuario: ");
                        String username2 = scanner.nextLine();
                        Admin_User_21337525_ZunigaJofre newUser2 = new Admin_User_21337525_ZunigaJofre(username2);
                        system.systemAddUser(newUser2);
                        System.out.println("..........Usuario creado..........");
                        System.out.println(newUser2);
                        System.out.println("..............................");
                        registroUsuario(system);
                    case 3:
                        principal(system);
                    case 4:
                        System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("¡¡ Ingresar una opción valida por favor !!");
                registroUsuario(system);
            }
        }

    }
    public void loginUsuario(System_21337525_ZunigaJofre system){
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("..........Login de usuarios..........");
            System.out.println("Ingrese el nombre del usuario que quiere logear: ");
            String username = scanner.nextLine();
            for(User_21337525_ZunigaJofre user: system.getRegisterUsers()){
                if(1 == user.getRol() && username.equals(user.getName())){
                    system.systemLogin(username);
                    System.out.println("..........Usuario logeado..........");
                    System.out.println(username);
                    System.out.println("..............................");
                    admin(system, username, null, null, null);
                } else if(0 == user.getRol() && username.equals(user.getName())){
                    system.systemLogin(username);
                    System.out.println("..........Usuario logeado..........");
                    System.out.println(username);
                    System.out.println("..............................");
                    common(system, username);
                }
            }
        }catch (Exception e) {
                System.out.println("¡¡ Ingresar una opción valida por favor !!");
                loginUsuario(system);
            }
    }
    public void admin(System_21337525_ZunigaJofre system, String username, ArrayList<Option_21337525_ZunigaJofre> opciones,
                      ArrayList<Flow_21337525_ZunigaJofre> flujos, ArrayList<Chatbot_21337525_ZunigaJofre> chatbots) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        while (opcion != 0) {
            try {
                System.out.println("..........Sistema de chatbots - Usuario Administrador..........");
                System.out.println("Bienvenido " + username + " usted es un usuario administrador\n¿Qué desea hacer?");
                System.out.println("1) Crear una opción");
                System.out.println("2) Crear un flujo");
                System.out.println("3) Añadir una opción a un flujo");
                System.out.println("4) Crear un chatbot");
                System.out.println("5) Añadir un flujo a un chatbot");
                System.out.println("6) Añadir un chatbot al sistema");
                System.out.println("7) Hablar con el sistema");
                System.out.println("8) Mostrar historial");
                System.out.println("9) Simular conversación");
                System.out.println("10) Logout");
                System.out.println("11) Salir");
                System.out.println("Ingrese su opción: ");
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion){
                    case 1:
                        Option_21337525_ZunigaJofre op = crearOpcion();
                        System.out.println("..........Opción creada..........");
                        System.out.println(op);
                        System.out.println("....................");
                        opciones.add(op);
                        admin(system, username,opciones,flujos,chatbots);
                    case 2:
                        Flow_21337525_ZunigaJofre flujo = crearFlujo(opciones);
                        System.out.println("..........Flujo creado..........");
                        System.out.println(flujo);
                        System.out.println("....................");
                        flujos.add(flujo);
                        admin(system, username,opciones,flujos,chatbots);
                    case 3:
                        addOption(opciones, flujos);
                        admin(system, username,opciones,flujos,chatbots);
                    case 4:
                        Chatbot_21337525_ZunigaJofre chatbot = createChatbot(flujos);
                        System.out.println("..........Chatbot creado..........");
                        System.out.println(chatbot);
                        System.out.println("....................");
                        chatbots.add(chatbot);
                        admin(system, username,opciones,flujos,chatbots);
                    case 5:
                        addFlow(chatbots,flujos);
                        admin(system, username,opciones,flujos,chatbots);
                    case 6:
                        addChatbot(system,chatbots);
                        admin(system, username,opciones,flujos,chatbots);
                    case 7:
                        System.out.println("Ingrese un mensaje: ");
                        String message = scanner.nextLine();
                        system.systemTalk(message);
                        admin(system, username,opciones,flujos,chatbots);
                    case 8:
                        System.out.println(system.systemSynthesis(username));
                        admin(system, username,opciones,flujos,chatbots);
                    case 9:
                        System.out.println("Ingrese un número máximo de interacciones: ");
                        int maxInteractions = scanner.nextInt();
                        System.out.println("Ingrese una semilla para generar la simulación: ");
                        int seed = scanner.nextInt();
                        system.systemSimulate(maxInteractions, seed);
                        admin(system, username,opciones,flujos,chatbots);
                    case 10:
                        system.systemLogout();
                        principal(system);
                    case 11:
                        System.exit(0);
                }

            } catch (Exception e) {
                System.out.println("¡¡ Ingresar una opción valida por favor !!");
                admin(system, username,opciones,flujos,chatbots);
            }
        }
    }
    public void common(System_21337525_ZunigaJofre system, String username){
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        while (opcion != 0) {
            try {
                System.out.println("..........Sistema de chatbots - Usuario Común..........");
                System.out.println("Bienvenido " + username + " usted es un usuario común\n¿Qué desea hacer?");
                System.out.println("1) Hablar con el sistema");
                System.out.println("2) Mostrar historial");
                System.out.println("3) Simular conversación");
                System.out.println("4) Logout");
                System.out.println("5) Salir");
                System.out.println("Ingrese su opción: ");
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion){
                    case 1:
                        System.out.println("Ingrese un mensaje: ");
                        String message = scanner.nextLine();
                        system.systemTalk(message);
                        common(system, username);
                    case 2:
                        System.out.println(system.systemSynthesis(username));
                        common(system, username);
                    case 3:
                        System.out.println("Ingrese un número máximo de interacciones: ");
                        int maxInteractions = scanner.nextInt();
                        System.out.println("Ingrese una semilla para generar la simulación: ");
                        int seed = scanner.nextInt();
                        system.systemSimulate(maxInteractions, seed);
                        common(system, username);
                    case 4:
                        system.systemLogout();
                        principal(system);
                    case 5:
                        System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("¡¡ Ingresar una opción valida por favor !!");
                common(system, username);
            }
        }
    }
    public Option_21337525_ZunigaJofre crearOpcion(){
        Scanner scanner0 = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        Scanner scanner4 = new Scanner(System.in);
        System.out.println("..........Creador de opción..........");
        System.out.println("Ingrese el id de su opción: ");
        int idOp = scanner1.nextInt();
        System.out.println("Ingrese el mensaje de su opción: ");
        String msgOp = scanner2.nextLine();
        System.out.println("Ingrese el id del chatbot vinculado a su opción: ");
        int idCbOp = scanner3.nextInt();
        System.out.println("Ingrese el id del flujo vinculado a su opción: ");
        int idFlOp = scanner4.nextInt();
        List<String> keywords = new ArrayList<>();
        int terminar = -1;
        while(terminar != 0){
            try{
                Scanner scanner5 = new Scanner(System.in);
                System.out.println("..........Creador de keyword..........");
                System.out.println("1) Ingresar keyword");
                System.out.println("2) Terminar");
                System.out.println("Ingrese su opción: ");
                String keyword;
                terminar = scanner0.nextInt();
                switch(terminar){
                    case 1:
                        System.out.println("Ingrese la keyword: ");
                        keyword = scanner5.nextLine();
                        keywords.add(keyword);
                        break;
                    case 2:
                        terminar = 0;
                        break;
                }
            }catch (Exception e) {
                System.out.println("¡¡ Ingresar una opción valida por favor !!");
            }
        }
        return new Option_21337525_ZunigaJofre(idOp,msgOp,idCbOp,idFlOp,keywords);
    }
    public Flow_21337525_ZunigaJofre crearFlujo(ArrayList<Option_21337525_ZunigaJofre> opciones){
        Scanner idScanner = new Scanner(System.in);
        Scanner nameMsgScanner = new Scanner(System.in);
        System.out.println("..........Creador de flujo..........");
        System.out.println("Ingrese el id de su flujo: ");
        int idOp = idScanner.nextInt();
        System.out.println("Ingrese el mensaje de su flujo: ");
        String nameMsg = nameMsgScanner.nextLine();
        Flow_21337525_ZunigaJofre newFlow = new Flow_21337525_ZunigaJofre(idOp,nameMsg,null);
        int terminar = -1;
        while(terminar != 0){
            try{
                Scanner optionScanner = new Scanner(System.in);
                Scanner eleccion = new Scanner(System.in);
                System.out.println("..........Creador de options..........");
                int cont = 0;
                System.out.println("Opciones creadas:");
                for(Option_21337525_ZunigaJofre option: opciones){
                    cont += 1;
                    System.out.println(cont + ") " + option + "\n");
                }
                System.out.println("Seleccione la opcion que quiere añadir al flujo:");
                int optionIndex = optionScanner.nextInt();
                newFlow.flowAddOption(opciones.get(optionIndex-1));
                System.out.println("1) Deseo añadir otra option");
                System.out.println("2) Terminar");
                System.out.println("Ingrese su opción: ");
                terminar = eleccion.nextInt();
                switch(terminar){
                    case 1:
                        break;
                    case 2:
                        terminar = 0;
                        break;
                }
            }catch (Exception e) {
                System.out.println("¡¡ Ingresar una opción valida por favor !!");
            }
        }
        return newFlow;
    }

    public void addOption(ArrayList<Option_21337525_ZunigaJofre> opciones, ArrayList<Flow_21337525_ZunigaJofre> flujos){
        Scanner flowScanner = new Scanner(System.in);
        Scanner optionScanner = new Scanner(System.in);
        System.out.println("..........Añadir opcion a flujo..........");
        int cont = 0;
        System.out.println("Flujos creados:");
        for(Flow_21337525_ZunigaJofre flow: flujos){
            cont += 1;
            System.out.println(cont +") " + flow + "\n");
        }
        System.out.println("Seleccione el flujo al cual le quiere añadir una opcion:");
        int flowIndex = flowScanner.nextInt();
        cont = 0;
        System.out.println("Opciones creadas:");
        for(Option_21337525_ZunigaJofre option: opciones){
            cont += 1;
            System.out.println(cont + ") " + option + "\n");
        }
        System.out.println("Seleccione la opcion que quiere añadir al flujo:");
        int optionIndex = optionScanner.nextInt();
        int index = -1;
        try {
            for(Flow_21337525_ZunigaJofre flow: flujos){
                index += 1;
                if(index == (flowIndex - 1)){
                    flow.flowAddOption(opciones.get(optionIndex - 1));
                    System.out.println("..........Flujo creado..........");
                    System.out.println(flujos.get(flowIndex - 1));
                    System.out.println("....................");
                }
            }
        }catch (Exception e) {
            System.out.println("Alguno de los indices seleccionados no corresponde");
        }
    }
    public Chatbot_21337525_ZunigaJofre createChatbot(ArrayList<Flow_21337525_ZunigaJofre> flujos){
        Scanner idScanner = new Scanner(System.in);
        Scanner nameScanner = new Scanner(System.in);
        Scanner wMsgScanner = new Scanner(System.in);
        Scanner sFIScanner = new Scanner(System.in);
        System.out.println("..........Creador de chatbots..........");
        System.out.println("Ingrese el id del chatbot:");
        int id = idScanner.nextInt();
        System.out.println("Ingrese el nombre del chatbot:");
        String name = nameScanner.nextLine();
        System.out.println("Ingrese un mensaje de bienvenida para el chatbot:");
        String welcomeMessage = wMsgScanner.nextLine();
        System.out.println("Ingrese el id del flujo inicial del chatbot:");
        int startFlowId = sFIScanner.nextInt();
        return new Chatbot_21337525_ZunigaJofre(id,name,welcomeMessage,startFlowId,flujos);
    }
    public void addFlow(ArrayList<Chatbot_21337525_ZunigaJofre> chatbots, ArrayList<Flow_21337525_ZunigaJofre> flujos){
        Scanner flowScanner = new Scanner(System.in);
        Scanner chatbotScanner = new Scanner(System.in);
        System.out.println("..........Añadir flujo a chatbot..........");
        System.out.println("Chatbots creados:");
        int cont = 0;
        for(Chatbot_21337525_ZunigaJofre chatbot: chatbots){
            cont += 1;
            System.out.println(cont + ") " + chatbot + "\n");
        }
        System.out.println("Seleccione el chatbot al cual le que quiere añadir un flujo:");
        int chatbotIndex = chatbotScanner.nextInt();
        cont = 0;
        System.out.println("Flujos creados:");
        for(Flow_21337525_ZunigaJofre flow: flujos){
            cont += 1;
            System.out.println(cont +") " + flow + "\n");
        }
        System.out.println("Seleccione el flujo que quiere añadir al chatbot:");
        int flowIndex = flowScanner.nextInt();
        int index = -1;
        try {
            for(Chatbot_21337525_ZunigaJofre chatbot: chatbots){
                index += 1;
                if(index == (chatbotIndex - 1)){
                    chatbot.chatbotAddFlow(flujos.get(flowIndex - 1));
                    System.out.println("..........Chatbot creado..........");
                    System.out.println(flujos.get(flowIndex - 1));
                    System.out.println("....................");
                }
            }
        }catch (Exception e) {
            System.out.println("Alguno de los indices seleccionados no corresponde");
        }
    }
    public void addChatbot(System_21337525_ZunigaJofre system, ArrayList<Chatbot_21337525_ZunigaJofre> chatbots){
        Scanner chatbotScanner = new Scanner(System.in);
        System.out.println("..........Añadir flujo a chatbot..........");
        System.out.println("Chatbots creados:");
        int cont = 0;
        for(Chatbot_21337525_ZunigaJofre chatbot: chatbots){
            cont += 1;
            System.out.println(cont + ") " + chatbot + "\n");
        }
        System.out.println("Seleccione el chatbot que quiere añadir al sistema:");
        int chatbotIndex = chatbotScanner.nextInt() - 1;
        int index = -1;
        try {
            for(Chatbot_21337525_ZunigaJofre chatbot: chatbots){
                index += 1;
                if(index == chatbotIndex){
                    system.systemAddChatbot(chatbot);
                    System.out.println("..........Sistema modificado..........");
                    System.out.println(system);
                    System.out.println("....................");
                }
            }
        }catch (Exception e) {
            System.out.println("El indice del chatbot no corresponde");
        }
    }
}
