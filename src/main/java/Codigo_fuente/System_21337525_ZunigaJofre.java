package Codigo_fuente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class System_21337525_ZunigaJofre implements System_Interface_21337525_ZunigaJofre{
    private String Name;
    private int InicialChatbotCodeLink;
    private List<User_21337525_ZunigaJofre> RegisterUsers;
    private List<String> LoginUser;
    private List<Option_21337525_ZunigaJofre> ActualOptions;
    private List<Chatbot_21337525_ZunigaJofre> Chatbots;

    public System_21337525_ZunigaJofre(String name, int inicialChatbotCodeLink, List<Chatbot_21337525_ZunigaJofre> chatbots){
        Name = name;
        InicialChatbotCodeLink = inicialChatbotCodeLink;
        RegisterUsers = new ArrayList<>();
        LoginUser = new ArrayList<>();
        ActualOptions = new ArrayList<>();
        ArrayList<Integer> cbscodes = new ArrayList<>();
        ArrayList<Chatbot_21337525_ZunigaJofre> newChatbots = new ArrayList<>();
        for(Chatbot_21337525_ZunigaJofre chatbot: chatbots){
            int code = chatbot.getId();
            if(!cbscodes.contains(code)){
                cbscodes.add(code);
                newChatbots.add(chatbot);
            }
        }
        Chatbots = newChatbots;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public int getInicialChatbotCodeLink() {
        return InicialChatbotCodeLink;
    }

    @Override
    public List<User_21337525_ZunigaJofre> getRegisterUsers() {
        return RegisterUsers;
    }

    @Override
    public List<String> getLoginUser() {
        return LoginUser;
    }

    @Override
    public List<Option_21337525_ZunigaJofre> getActualOptions() {
        return ActualOptions;
    }

    @Override
    public List<Chatbot_21337525_ZunigaJofre> getChatbots() {
        return Chatbots;
    }
    public List<Integer> getChatbotsIds(){
        List<Integer> codes = new ArrayList<>();
        for(Chatbot_21337525_ZunigaJofre chatbot : Chatbots){
            int code = chatbot.getId();
            if(!codes.contains(code)){
                codes.add(code);
            }
        }
        return codes;
    }

    @Override
    public void systemAddChatbot(Chatbot_21337525_ZunigaJofre chatbot) {
        List<Integer> codes = getChatbotsIds();
        if(!codes.contains(chatbot.getId())){
            Chatbots.add(chatbot);
        }

    }

    @Override
    public void systemAddUser(User_21337525_ZunigaJofre user) {
        if(!RegisterUsers.contains(user)){
            RegisterUsers.add(user);
        }

    }

    @Override
    public void systemLogin(String user) {
        String name;
        if(LoginUser.isEmpty()) {
            for (User_21337525_ZunigaJofre systemUser : RegisterUsers) {
                name = systemUser.getName();
                if (user.equals(name)) {
                    LoginUser.add(user);
                }
            }
        }
    }

    @Override
    public void systemLogout() {
        LoginUser = new ArrayList<>();
        ActualOptions = new ArrayList<>();
    }

    @Override
    public void systemTalk(String message) {
        Date date = new Date();
        String chat;
        chat = date + " - " + LoginUser.get(0) + ": " + message + "\n";
        if(ActualOptions.isEmpty()){
            Chatbot_21337525_ZunigaJofre cb = getChatbotById(InicialChatbotCodeLink);
            chat = chat + date +  " - " + cb.getName() + "\n";
            Flow_21337525_ZunigaJofre flow = cb.getFlowById(cb.getStartFlowId());
            chat = chat + flow.getName() +"\n" + flow.getAllOptionMessages();
            ActualOptions = flow.getOptions();
            }else{
            for(Option_21337525_ZunigaJofre op: ActualOptions){
                if(op.getKeyword().contains(message) ||op.getMessage().contains(message)){
                    Chatbot_21337525_ZunigaJofre cb = getChatbotById(op.getChatbotCodeLink());
                    chat =  chat + date + " - " + cb.getName() + "\n";
                    Flow_21337525_ZunigaJofre flow = cb.getFlowById(op.getInicialFlowCodeLink());
                    chat = chat + flow.getName() +"\n" + flow.getAllOptionMessages();
                    ActualOptions = flow.getOptions();
                }
            }
        }
        for(User_21337525_ZunigaJofre user: RegisterUsers){
            String nameUser = user.getName();
            if(nameUser.equals(LoginUser.get(0))){
                user.addChatHistory(chat);
            }
        }
        }




    @Override
    public String systemSynthesis(String username) {
        for(User_21337525_ZunigaJofre user: RegisterUsers){
            if(username.equals(user.getName())){
                return user.getChatHistory();
            }
        }
        return null;
    }

    @Override
    public void systemSimulate(Integer maxInteractions, Integer seed) {
        while(maxInteractions != 0){
            seed = myRandom(seed);
            String message = String.valueOf((seed % (ActualOptions.size()- 1))+ 1);
            systemTalk(message);
            maxInteractions -= 1;
        }
    }
    public Integer myRandom(Integer x){
        x = 1103515245 * x;
        x = x + 12345;
        x = x % 214748364;
        return x;
    }
    public String toString(){
        return Name + "," +InicialChatbotCodeLink + "," + RegisterUsers + "," + LoginUser + "," + ActualOptions + "," + Chatbots;
    }

    public Chatbot_21337525_ZunigaJofre getChatbotById(Integer id){
        for(Chatbot_21337525_ZunigaJofre cb: Chatbots){
            Integer cbId = cb.getId();
            if(cbId.equals(id)){
                return cb;
            }
        }
        return null;
    }
}
