package Codigo_fuente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Menu para que interactue el usuario con uno o varios sitemas
 */
public class Menu_21337525_ZunigaJofre {

    /**
     * Constructor de menu
     */
    public Menu_21337525_ZunigaJofre(){}

    /**
     * Menu que permite elegir con que sistema trabajar
     * @param sistemas Lista de sistemas que maneja el menu
     */
    public void elegirSistema(ArrayList<System_21337525_ZunigaJofre> sistemas){
        int i = 0;
        System.out.println("..........Seleccion de sistema..........");
        if(sistemas.isEmpty()){
            System.out.println("No existen sistemas");
            ArrayList<Chatbot_21337525_ZunigaJofre> chatbots = new ArrayList<>();
            System_21337525_ZunigaJofre newS = makeSystem(chatbots);
            sistemas.add(newS);
        }
        for(System_21337525_ZunigaJofre sistema: sistemas){
            System.out.println(++i + ") " + sistema + "\n");
        }
        try{
            Scanner systemScanner = new Scanner(System.in);
            System.out.println("Ingrese el numero del sistema con el cual quiere trabajar: ");
            int systemIndex = systemScanner.nextInt() - 1;
            principal(sistemas.get(systemIndex), sistemas);

        }catch (Exception e) {
            System.out.println("¡¡ Ingresar una opción valida por favor !!");
            elegirSistema(sistemas);
        }
    }

    /**
     * Menu principal que se vincula con el menu de registro de usuarios y login
     * @param system Sistema con el cual se está trabajando
     * @param sistemas Lista de sistemas que maneja el menu
     */
    public void principal(System_21337525_ZunigaJofre system, ArrayList<System_21337525_ZunigaJofre> sistemas){
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        while (opcion != 0) {
            try {
                System.out.println("..........Sistema de chatbots: " + system.getName() + "..........");
                System.out.println("Bienvenido ¿Qué desea hacer?");
                System.out.println("1) Registrar un usuario");
                System.out.println("2) Login de un usuario");
                System.out.println("3) Mostrar sistema");
                System.out.println("4) Salir");
                System.out.println("Ingrese su opción: ");
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion){
                    case 1:
                        registroUsuario(system, sistemas);
                    case 2:
                        loginUsuario(system, sistemas);
                    case 3:
                        System.out.println("..........Sistema..........");
                        System.out.println(system);
                        System.out.println("..............................");
                        principal(system, sistemas);
                    case 4:
                        System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("¡¡ Ingresar una opción valida por favor !!");
                principal(system, sistemas);
            }
        }
    }

    /**
     * Menu que permite registrar a un sistema un usuario administrador o comun
     * @param system Sistema con el cual se está trabajando
     * @param sistemas Lista de sistemas que maneja el menu
     */
    public void registroUsuario(System_21337525_ZunigaJofre system, ArrayList<System_21337525_ZunigaJofre> sistemas){
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
                        if(!system.getRegisterUsersNames().contains(username1)){
                            System.out.println("..........Usuario creado..........");
                            System.out.println(newUser1);
                            System.out.println("..............................");
                        }
                        system.systemAddUser(newUser1);
                        registroUsuario(system, sistemas);
                    case 2:
                        System.out.println("Ingresar nombre del usuario: ");
                        String username2 = scanner.nextLine();
                        Admin_User_21337525_ZunigaJofre newUser2 = new Admin_User_21337525_ZunigaJofre(username2);
                        if(!system.getRegisterUsersNames().contains(username2)){
                            System.out.println("..........Usuario creado..........");
                            System.out.println(newUser2);
                            System.out.println("..............................");
                        }
                        system.systemAddUser(newUser2);
                        registroUsuario(system, sistemas);
                    case 3:
                        principal(system, sistemas);
                    case 4:
                        System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("¡¡ Ingresar una opción valida por favor !!");
                registroUsuario(system, sistemas);
            }
        }

    }

    /**
     * Menu que permite logear un usuario al sistema con el cual se esta trabajando y deriva al menu de usuario
     * comun o administrador segun corresponda
     * @param system Sistema con el cual se está trabajando
     * @param sistemas Lista de sistemas que maneja el menu
     */
    public void loginUsuario(System_21337525_ZunigaJofre system, ArrayList<System_21337525_ZunigaJofre> sistemas){
        Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("..........Login de usuarios..........");
                System.out.println("Ingrese el nombre del usuario que quiere logear: ");
                String username = scanner.nextLine();
                if(!system.getRegisterUsersNames().contains(username)){
                    System.out.println("No se ha registrado un usuario con ese nombre");
                    principal(system, sistemas);
                }
                for (User_21337525_ZunigaJofre user : system.getRegisterUsers()) {
                    if (1 == user.getRol() && username.equals(user.getName())) {
                        system.systemLogin(username);
                        System.out.println("..........Usuario logeado..........");
                        System.out.println(username);
                        System.out.println("..............................");
                        ArrayList<Option_21337525_ZunigaJofre> opciones = new ArrayList<>();
                        ArrayList<Flow_21337525_ZunigaJofre> flujos = new ArrayList<>();
                        ArrayList<Chatbot_21337525_ZunigaJofre> chatbots = new ArrayList<>();
                        admin(system, username, opciones, flujos, chatbots, sistemas);
                    } else if (0 == user.getRol() && username.equals(user.getName())) {
                        system.systemLogin(username);
                        System.out.println("..........Usuario logeado..........");
                        System.out.println(username);
                        System.out.println("..............................");
                        common(system, username, sistemas);
                    }
                }
            } catch (Exception e) {
                System.out.println("¡¡ Ingresar una opción valida por favor !!");
                loginUsuario(system, sistemas);
            }
    }

    /**
     * Menu para usuarios administradores
     * @param system Sistema con el cual se está trabajando
     * @param username Nombre del usuario logeado
     * @param opciones Lista de opciones que ha creado el usuario admistrador
     * @param flujos Lista de flujos que ha creado el usuario admistrador
     * @param chatbots Lista de chatbots que ha creado el usuario admistrador
     * @param sistemas Lista de sistemas que maneja el menu
     */
    public void admin(System_21337525_ZunigaJofre system, String username, ArrayList<Option_21337525_ZunigaJofre> opciones,
                      ArrayList<Flow_21337525_ZunigaJofre> flujos, ArrayList<Chatbot_21337525_ZunigaJofre> chatbots,
                      ArrayList<System_21337525_ZunigaJofre> sistemas) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("..........Sistema de chatbots" + system.getName() + " - Usuario Administrador..........");
            System.out.println("Bienvenido " + username + " usted es un usuario administrador\n¿Qué desea hacer?");
            System.out.println("1) Crear una opción");
            System.out.println("2) Crear un flujo");
            System.out.println("3) Crear un chatbot");
            System.out.println("4) Crear un sistema");
            System.out.println("5) Añadir una opción a un flujo");
            System.out.println("6) Añadir un flujo a un chatbot");
            System.out.println("7) Añadir un chatbot al sistema actual");
            System.out.println("8) Mostrar el sistema");
            System.out.println("9) Cambiar de sistema");
            System.out.println("10) Hablar con el sistema");
            System.out.println("11) Mostrar historial");
            System.out.println("12) Simular conversación");
            System.out.println("13) Logout");
            System.out.println("14) Salir");
            System.out.println("Ingrese su opción: ");
            try{
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion){
                    case 1:
                        Option_21337525_ZunigaJofre op = makeOption();
                        System.out.println("..........Opción creada..........");
                        System.out.println(op);
                        System.out.println("....................");
                        opciones.add(op);
                        admin(system, username,opciones,flujos,chatbots, sistemas);
                        break;
                    case 2:
                        Flow_21337525_ZunigaJofre flujo = crearFlujo(opciones);
                        System.out.println("..........Flujo creado..........");
                        System.out.println(flujo);
                        System.out.println("....................");
                        flujos.add(flujo);
                        admin(system, username,opciones,flujos,chatbots,sistemas);
                        break;
                    case 3:
                        Chatbot_21337525_ZunigaJofre chatbot = createChatbot(flujos);
                        System.out.println("..........Chatbot creado..........");
                        System.out.println(chatbot);
                        System.out.println("....................");
                        chatbots.add(chatbot);
                        admin(system, username,opciones,flujos,chatbots,sistemas);
                        break;
                    case 4:
                        System_21337525_ZunigaJofre newSystem = makeSystem(chatbots);
                        System.out.println("..........Sistema creado..........");
                        System.out.println(newSystem);
                        System.out.println("....................");
                        sistemas.add(newSystem);
                        admin(system, username,opciones,flujos,chatbots,sistemas);
                        break;
                    case 5:
                        addOption(system, username,opciones,flujos,chatbots,sistemas);
                        admin(system, username,opciones,flujos,chatbots,sistemas);
                        break;
                    case 6:
                        addFlow(system, username,opciones,flujos,chatbots,sistemas);
                        admin(system, username,opciones,flujos,chatbots,sistemas);
                        break;
                    case 7:
                        addChatbot(system, username,opciones,flujos,chatbots,sistemas);
                        admin(system, username,opciones,flujos,chatbots,sistemas);
                        break;
                    case 8:
                        System.out.println("..........Sistema..........");
                        System.out.println(system);
                        System.out.println("....................");
                        admin(system, username,opciones,flujos,chatbots,sistemas);
                        break;
                    case 9:
                        system.systemLogout();
                        elegirSistema(sistemas);
                        break;
                    case 10:
                        System.out.println("Ingrese un mensaje: ");
                        String message = scanner.nextLine();
                        system.systemTalk(message.toLowerCase());
                        System.out.println("..........Interaccion realizada...........");
                        for(User_21337525_ZunigaJofre user: system.getRegisterUsers()){
                            if(user.getName().equals(username)){
                                System.out.println(user.getChatHistory().get(user.getChatHistory().size() - 1));
                            }
                        }
                        System.out.println("....................");
                        admin(system, username,opciones,flujos,chatbots,sistemas);
                        break;
                    case 11:
                        System.out.println(system.systemSynthesis(username));
                        admin(system, username,opciones,flujos,chatbots,sistemas);
                        break;
                    case 12:
                        Scanner seedScanner = new Scanner(System.in);
                        System.out.println("Ingrese un número máximo de interacciones: ");
                        int maxInteractions = scanner.nextInt();
                        if(maxInteractions == 0){
                            System.out.println("No se pueden realizar 0 interacciones");
                            break;
                        }
                        System.out.println("Ingrese una semilla para generar la simulación: ");
                        int seed = seedScanner.nextInt();
                        if(seed == 0){
                            System.out.println("No se pueden tener 0 como semilla");
                            break;
                        }
                        String newUsername = "User" + seed;
                        Common_User_21337525_ZunigaJofre newUser= new Common_User_21337525_ZunigaJofre(newUsername);
                        System_21337525_ZunigaJofre simulate = new System_21337525_ZunigaJofre(system.getName(),system.getInicialChatbotCodeLink(),system.getChatbots());
                        simulate.systemLogout();
                        simulate.systemAddUser(newUser);
                        simulate.systemLogin(newUsername);
                        simulate.systemSimulate(maxInteractions, seed, simulate);
                        System.out.println("..........Interaccion realizada...........");
                        System.out.println(simulate.systemSynthesis(newUsername));
                        System.out.println("....................");
                        admin(system, username,opciones,flujos,chatbots,sistemas);
                        break;
                    case 13:
                        system.systemLogout();
                        principal(system,sistemas);
                        break;
                    case 14:
                        System.exit(0);
                        break;
                }
            } catch (Exception e) {
                System.out.println("¡¡ Ingresar una opción valida por favor !!");
                admin(system, username,opciones,flujos,chatbots, sistemas);
            }
        }
    }

    /**
     * Menu para usuarios comunes
     * @param system Sistema con el cual se está trabajando
     * @param username Nombre del usuario logeado
     * @param sistemas Lista de sistemas que maneja el menu
     */
    public void common(System_21337525_ZunigaJofre system, String username, ArrayList<System_21337525_ZunigaJofre> sistemas){
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        while (opcion != 0) {
            try {
                System.out.println("..........Sistema de chatbots:" + system.getName() + " - Usuario Común..........");
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
                        system.systemTalk(message.toLowerCase());
                        System.out.println("..........Interaccion realizada...........");
                        for(User_21337525_ZunigaJofre user: system.getRegisterUsers()){
                            if(user.getName().equals(username)){
                                System.out.println(user.getChatHistory().get(user.getChatHistory().size() - 1));
                            }
                        }
                        System.out.println("....................");
                        common(system, username,sistemas);
                        break;
                    case 2:
                        System.out.println(system.systemSynthesis(username));
                        common(system, username, sistemas);
                        break;
                    case 3:
                        Scanner seedScanner = new Scanner(System.in);
                        System.out.println("Ingrese un número máximo de interacciones: ");
                        int maxInteractions = scanner.nextInt();
                        if(maxInteractions == 0){
                            System.out.println("No se pueden realizar 0 interacciones");
                            break;
                        }
                        System.out.println("Ingrese una semilla para generar la simulación: ");
                        int seed = seedScanner.nextInt();
                        if(seed == 0){
                            System.out.println("No se pueden tener 0 como semilla");
                            break;
                        }
                        String newUsername = "User" + seed;
                        Common_User_21337525_ZunigaJofre newUser= new Common_User_21337525_ZunigaJofre(newUsername);
                        System_21337525_ZunigaJofre simulate = new System_21337525_ZunigaJofre(system.getName(),system.getInicialChatbotCodeLink(),system.getChatbots());
                        simulate.systemLogout();
                        simulate.systemAddUser(newUser);
                        simulate.systemLogin(newUsername);
                        simulate.systemSimulate(maxInteractions, seed, simulate);
                        System.out.println("..........Interaccion realizada...........");
                        System.out.println(simulate.systemSynthesis(newUsername));
                        System.out.println("....................");
                        common(system, username,sistemas);
                        break;
                    case 4:
                        system.systemLogout();
                        principal(system,sistemas);
                        break;
                    case 5:
                        System.exit(0);
                        break;
                }
            } catch (Exception e) {
                System.out.println("¡¡ Ingresar una opción valida por favor !!");
                common(system, username, sistemas);
            }
        }
    }

    /**
     * Menu para crear un sistema
     * @param chatbots Lista de chatbots creados por el usuario administrador
     * @return system
     */
    public System_21337525_ZunigaJofre makeSystem(ArrayList<Chatbot_21337525_ZunigaJofre> chatbots){
        Scanner eleccionScanner = new Scanner(System.in);
        System.out.println("..........Creador de sistema..........");
        Scanner nameScanner = new Scanner(System.in);
        Scanner inicialChatbotScanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre de su sistema ");
        String name = nameScanner.nextLine();
        System.out.println("Ingrese el id de su chatbot inicial:");
        int inicialChatbot = inicialChatbotScanner.nextInt();
        ArrayList<Chatbot_21337525_ZunigaJofre> newChatbots = new ArrayList<>();
        int terminar = -1;
        while(terminar != 0){
            try{
                Scanner chatbotScanner = new Scanner(System.in);
                System.out.println("..........Creador de chatbots..........");
                System.out.println("1) Deseo añadir un chatbot");
                System.out.println("2) Terminar");
                System.out.println("Ingrese su opción: ");
                terminar = eleccionScanner.nextInt();
                switch (terminar){
                    case 1:
                        if(chatbots == null || chatbots.isEmpty()){
                            System.out.println("No se han creado chatbots");
                            terminar = 0;
                        }else {
                            int cont = 0;
                            System.out.println("Chatbots creadas:");
                            for (Chatbot_21337525_ZunigaJofre chatbot : chatbots) {
                                cont += 1;
                                System.out.println(cont + ") " + chatbot + "\n");
                            }
                            System.out.println("Seleccione el chatbot que quiere añadir al sistema:");
                            int optionIndex = chatbotScanner.nextInt();
                            newChatbots.add(chatbots.get(optionIndex - 1));
                        }
                        break;
                    case 2:
                        terminar = 0;
                        break;
                }
            }catch (Exception e) {
                System.out.println("¡¡ Ingresar una opción valida por favor !!");
            }
        }
        return new System_21337525_ZunigaJofre(name, inicialChatbot, newChatbots);
    }

    /**
     * Menu para crear una opcion
     * @return Opcion creado por el usuario
     */

    public Option_21337525_ZunigaJofre makeOption(){
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
                System.out.println("¡¡ Ingresar una opción valida por favor 1!!");
            }
        }
        return new Option_21337525_ZunigaJofre(idOp,msgOp,idCbOp,idFlOp,keywords);
    }

    /**
     * Menu para crear un flujo
     * @param opciones Lista de opciones creadas por el usuario administrador
     * @return Flujo creado por el usuario
     */
    public Flow_21337525_ZunigaJofre crearFlujo(ArrayList<Option_21337525_ZunigaJofre> opciones){
        Scanner idScanner = new Scanner(System.in);
        Scanner nameMsgScanner = new Scanner(System.in);
        Scanner eleccionScanner = new Scanner(System.in);
        System.out.println("..........Creador de flujo..........");
        System.out.println("Ingrese el id de su flujo: ");
        int idFlow = idScanner.nextInt();
        System.out.println("Ingrese el mensaje de su flujo: ");
        String nameMsg = nameMsgScanner.nextLine();
        ArrayList<Option_21337525_ZunigaJofre> options = new ArrayList<>();
        int terminar = -1;
        while(terminar != 0){
            try{
                Scanner optionScanner = new Scanner(System.in);
                System.out.println("..........Creador de options..........");
                System.out.println("1) Deseo añadir una opcion");
                System.out.println("2) Terminar");
                System.out.println("Ingrese su opción: ");
                terminar = eleccionScanner.nextInt();
                switch (terminar){
                    case 1:
                        if(opciones == null || opciones.isEmpty()){
                            System.out.println("No se han creado opciones");
                            terminar = 0;
                        }else {
                            int cont = 0;
                            System.out.println("Opciones creadas:");
                            for (Option_21337525_ZunigaJofre option : opciones) {
                                cont += 1;
                                System.out.println(cont + ") " + option + "\n");
                            }
                            System.out.println("Seleccione la opcion que quiere añadir al flujo:");
                            int optionIndex = optionScanner.nextInt();
                            options.add(opciones.get(optionIndex - 1));
                        }
                        break;
                    case 2:
                        terminar = 0;
                        break;
                }
            }catch (Exception e) {
                System.out.println("¡¡ Ingresar una opción valida por favor !!");
            }
        }
        return new Flow_21337525_ZunigaJofre(idFlow,nameMsg,options);
    }

    /**
     * Menu para agregar una opcion a un flujo
     * @param system Sistema con el cual se está trabajando
     * @param username Nombre del usuario logeado
     * @param opciones Lista de opciones que ha creado el usuario admistrador
     * @param flujos Lista de flujos que ha creado el usuario admistrador
     * @param chatbots Lista de chatbots que ha creado el usuario admistrador
     * @param sistemas Lista de sistemas que maneja el menu
     */
    public void addOption(System_21337525_ZunigaJofre system, String username, ArrayList<Option_21337525_ZunigaJofre> opciones,
                          ArrayList<Flow_21337525_ZunigaJofre> flujos, ArrayList<Chatbot_21337525_ZunigaJofre> chatbots,
                          ArrayList<System_21337525_ZunigaJofre> sistemas){
        Scanner opcionScanner = new Scanner(System.in);
        if(opciones == null || opciones.isEmpty()) {
            System.out.println("No se han creado opciones");
            admin(system,username,opciones,flujos,chatbots,sistemas);
        }
        System.out.println("..........Añadir opcion a flujo..........");
        System.out.println("¿A qué tipo de flujo desea añadir una opcion?");
        System.out.println("1) Existente en el sistema");
        System.out.println("2) Creado por mi");
        int opcion = opcionScanner.nextInt();
        try{
            switch(opcion){
                case 1:
                    addOptionToOldFlow(system, username,opciones,flujos,chatbots, sistemas);
                case 2:
                    addOptionToNewFlow(system, username,opciones,flujos,chatbots, sistemas);
            }
        }catch (Exception e) {
            System.out.println("¡¡ Ingresar una opción valida por favor !!");
        }
    }

    /**
     * Menu para agregar una opcion a un flujo del sistema actual
     * @param system Sistema con el cual se está trabajando
     * @param username Nombre del usuario logeado
     * @param opciones Lista de opciones que ha creado el usuario admistrador
     * @param flujos Lista de flujos que ha creado el usuario admistrador
     * @param chatbots Lista de chatbots que ha creado el usuario admistrador
     * @param sistemas Lista de sistemas que maneja el menu
     */
    public void addOptionToOldFlow(System_21337525_ZunigaJofre system, String username, ArrayList<Option_21337525_ZunigaJofre> opciones,
                                   ArrayList<Flow_21337525_ZunigaJofre> flujos, ArrayList<Chatbot_21337525_ZunigaJofre> chatbots,
                                   ArrayList<System_21337525_ZunigaJofre> sistemas){
        Scanner chatbotScanner = new Scanner(System.in);
        Scanner flowScanner = new Scanner(System.in);
        Scanner optionScanner = new Scanner(System.in);
        System.out.println("Flujos del sistema:");
        int cont1 = 0;
        for(Chatbot_21337525_ZunigaJofre chatbot: system.getChatbots()){
            cont1 +=1;
            System.out.println("Flujos del chatbot " + cont1 + ":");
            int cont2 = 0;
            for(Flow_21337525_ZunigaJofre flow: chatbot.getFlows()){
                cont2 += 1;
                System.out.println(cont2 +") " + flow + "\n");
            }
        }
        System.out.println("Ingrese el número de chatbot al cual pertenece el flujo que quiere modificar:");
        int chatbotIndex = chatbotScanner.nextInt() - 1;
        System.out.println("Ingrese el número del flujo que quiere modificar:");
        int flowIndex = flowScanner.nextInt() - 1;
        int cont3 = 0;
        System.out.println("Opciones creadas:");
        for(Option_21337525_ZunigaJofre option: opciones){
            cont3 += 1;
            System.out.println(cont3 + ") " + option + "\n");
        }
        System.out.println("Seleccione la opcion que quiere añadir al flujo:");
        int optionIndex = optionScanner.nextInt() - 1;
        int index1 = -1;
        for(Chatbot_21337525_ZunigaJofre chatbot : system.getChatbots()){
            int index2 = -1;
            index1 += 1;
            if(index1 == chatbotIndex){
                for(Flow_21337525_ZunigaJofre flow: chatbot.getFlows()){
                    index2 += 1;
                    if(index2 == flowIndex){
                        flow.flowAddOption(opciones.get(optionIndex));
                    }
                }
            }
        }
        admin(system,username,opciones,flujos,chatbots, sistemas);
    }

    /**
     * Menu para agregar una opcion a un flujo creado por el usuario
     * @param system Sistema con el cual se está trabajando
     * @param username Nombre del usuario logeado
     * @param opciones Lista de opciones que ha creado el usuario admistrador
     * @param flujos Lista de flujos que ha creado el usuario admistrador
     * @param chatbots Lista de chatbots que ha creado el usuario admistrador
     * @param sistemas Lista de sistemas que maneja el menu
     */
    public void addOptionToNewFlow(System_21337525_ZunigaJofre system, String username, ArrayList<Option_21337525_ZunigaJofre> opciones,
                                   ArrayList<Flow_21337525_ZunigaJofre> flujos, ArrayList<Chatbot_21337525_ZunigaJofre> chatbots,
                                   ArrayList<System_21337525_ZunigaJofre> sistemas){
        Scanner flowScanner = new Scanner(System.in);
        Scanner optionScanner = new Scanner(System.in);

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
        admin(system,username,opciones,flujos,chatbots, sistemas);
    }

    /**
     * Menu para crear un chatbot
     * @param flujos Lista de flujos creados por el usuario
     * @return Chatbot creado por el usuario
     */
    public Chatbot_21337525_ZunigaJofre createChatbot(ArrayList<Flow_21337525_ZunigaJofre> flujos) {
        Scanner idScanner = new Scanner(System.in);
        Scanner nameScanner = new Scanner(System.in);
        Scanner wMsgScanner = new Scanner(System.in);
        Scanner sFIScanner = new Scanner(System.in);
        Scanner eleccionScanner = new Scanner(System.in);
        System.out.println("..........Creador de chatbots..........");
        System.out.println("Ingrese el id del chatbot:");
        int id = idScanner.nextInt();
        System.out.println("Ingrese el nombre del chatbot:");
        String name = nameScanner.nextLine();
        System.out.println("Ingrese un mensaje de bienvenida para el chatbot:");
        String welcomeMessage = wMsgScanner.nextLine();
        System.out.println("Ingrese el id del flujo inicial del chatbot:");
        int startFlowId = sFIScanner.nextInt();
        ArrayList<Flow_21337525_ZunigaJofre> newFlows = new ArrayList<>();
        int terminar = -1;
        while (terminar != 0) {
            try {
                Scanner optionScanner = new Scanner(System.in);
                System.out.println("..........Creador de flows..........");
                System.out.println("1) Deseo añadir un flujo");
                System.out.println("2) Terminar");
                System.out.println("Ingrese su opción: ");
                terminar = eleccionScanner.nextInt();
                switch (terminar) {
                    case 1:
                        if (flujos == null || flujos.isEmpty()) {
                            System.out.println("No se han creado flujos");
                            terminar = 0;
                        } else {
                            int cont = 0;
                            System.out.println("Flujos creados:");
                            for (Flow_21337525_ZunigaJofre flow : flujos) {
                                cont += 1;
                                System.out.println(cont + ") " + flow + "\n");
                            }
                            System.out.println("Seleccione el flujo que quiere añadir al chatbot:");
                            int optionIndex = optionScanner.nextInt();
                            newFlows.add(flujos.get(optionIndex - 1));
                        }
                        break;
                    case 2:
                        terminar = 0;
                        break;
                }
            } catch (Exception e) {
                System.out.println("¡¡ Ingresar una opción valida por favor !!");
            }
        }
        return new Chatbot_21337525_ZunigaJofre(id, name, welcomeMessage, startFlowId, newFlows);
    }

    /**
     * Menu para agregar un flujo a un chatbot
     * @param system Sistema con el cual se está trabajando
     * @param username Nombre del usuario logeado
     * @param opciones Lista de opciones que ha creado el usuario admistrador
     * @param flujos Lista de flujos que ha creado el usuario admistrador
     * @param chatbots Lista de chatbots que ha creado el usuario admistrador
     * @param sistemas Lista de sistemas que maneja el menu
     */
    public void addFlow(System_21337525_ZunigaJofre system, String username, ArrayList<Option_21337525_ZunigaJofre> opciones,
                        ArrayList<Flow_21337525_ZunigaJofre> flujos, ArrayList<Chatbot_21337525_ZunigaJofre> chatbots,
                        ArrayList<System_21337525_ZunigaJofre> sistemas){
        Scanner opcionScanner = new Scanner(System.in);
        if(flujos == null || flujos.isEmpty()) {
            System.out.println("No se han creado flujos");
            admin(system,username,opciones,flujos,chatbots, sistemas);
        }
        System.out.println("..........Añadir opcion a flujo..........");
        System.out.println("¿A qué tipo de chatbot desea añadir un flujo?");
        System.out.println("1) Existente en el sistema");
        System.out.println("2) Creado por mi");
        int opcion = opcionScanner.nextInt();
        try{
            switch(opcion){
                case 1:
                    addFlowToOldChatbot(system, username,opciones,flujos,chatbots, sistemas);
                case 2:
                    addFlowToNewChatbot(system, username,opciones,flujos,chatbots, sistemas);
            }
        }catch (Exception e) {
            System.out.println("¡¡ Ingresar una opción valida por favor !!");
        }
    }

    /**
     * Menu para agregar un flujo a un chatbot ya existente en el sistema
     * @param system Sistema con el cual se está trabajando
     * @param username Nombre del usuario logeado
     * @param opciones Lista de opciones que ha creado el usuario admistrador
     * @param flujos Lista de flujos que ha creado el usuario admistrador
     * @param chatbots Lista de chatbots que ha creado el usuario admistrador
     * @param sistemas Lista de sistemas que maneja el menu
     */
    public void addFlowToOldChatbot(System_21337525_ZunigaJofre system, String username, ArrayList<Option_21337525_ZunigaJofre> opciones,
                                    ArrayList<Flow_21337525_ZunigaJofre> flujos, ArrayList<Chatbot_21337525_ZunigaJofre> chatbots,
                                    ArrayList<System_21337525_ZunigaJofre> sistemas){
        Scanner chatbotScanner = new Scanner(System.in);
        Scanner flowScanner = new Scanner(System.in);
        System.out.println("Chatbots del sistema:");
        int cont = 0;
        for(Chatbot_21337525_ZunigaJofre chatbot: system.getChatbots()){
            cont +=1;
            System.out.println(cont + ") " + chatbot + "\n");
        }
        System.out.println("Ingrese el número de chatbot al cual le quiere añadir un flujo:");
        int chatbotIndex = chatbotScanner.nextInt() - 1;
        cont = 0;
        System.out.println("Flujos creados:");
        for(Flow_21337525_ZunigaJofre flow: flujos){
            cont += 1;
            System.out.println(cont +") " + flow + "\n");
        }
        System.out.println("Seleccione el flujo que quiere añadir al chatbot:");
        int flowIndex = flowScanner.nextInt() - 1;
        int index1 = -1;
        for(Chatbot_21337525_ZunigaJofre chatbot : system.getChatbots()){
            index1 += 1;
            if(index1 == chatbotIndex){
                chatbot.chatbotAddFlow(flujos.get(flowIndex));
            }
        }
        admin(system,username,opciones,flujos,chatbots, sistemas);
    }

    /**
     * Menu para agregar un flujo a un chatbot creado por el usuario
     * @param system Sistema con el cual se está trabajando
     * @param username Nombre del usuario logeado
     * @param opciones Lista de opciones que ha creado el usuario admistrador
     * @param flujos Lista de flujos que ha creado el usuario admistrador
     * @param chatbots Lista de chatbots que ha creado el usuario admistrador
     * @param sistemas Lista de sistemas que maneja el menu
     */
    public void addFlowToNewChatbot(System_21337525_ZunigaJofre system, String username, ArrayList<Option_21337525_ZunigaJofre> opciones,
                                    ArrayList<Flow_21337525_ZunigaJofre> flujos, ArrayList<Chatbot_21337525_ZunigaJofre> chatbots,
                                    ArrayList<System_21337525_ZunigaJofre> sistemas){
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
        admin(system,username,opciones,flujos,chatbots,sistemas);
    }

    /**
     * Menu para agregar un chatbot al sistema actual
     * @param system Sistema con el cual se está trabajando
     * @param username Nombre del usuario logeado
     * @param opciones Lista de opciones que ha creado el usuario admistrador
     * @param flujos Lista de flujos que ha creado el usuario admistrador
     * @param chatbots Lista de chatbots que ha creado el usuario admistrador
     * @param sistemas Lista de sistemas que maneja el menu
     */
    public void addChatbot(System_21337525_ZunigaJofre system, String username, ArrayList<Option_21337525_ZunigaJofre> opciones,
                           ArrayList<Flow_21337525_ZunigaJofre> flujos, ArrayList<Chatbot_21337525_ZunigaJofre> chatbots,
                           ArrayList<System_21337525_ZunigaJofre> sistemas){
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
        try {
            system.systemAddChatbot(chatbots.get(chatbotIndex));
            System.out.println("..........Sistema modificado..........");
            System.out.println(system);
            System.out.println("....................");
        }catch (Exception e) {
            System.out.println("El indice del chatbot no corresponde");
        }
        admin(system,username,opciones,flujos,chatbots,sistemas);
    }

}

