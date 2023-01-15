import org.apache.commons.codec.digest.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        Map<String, User> users = new HashMap<>();
        String action;

        do {
            main.mainMenu();
            action = scanner.nextLine();
            main.action(action, scanner,users);

        } while (!action.equals("0"));
    }
    private void mainMenu () {
        System.out.printf("""
                    [1] -> register new user
                    [2] -> login
                    [0] -> Exit
                                    
                    """);
    }

    private void action (String action, Scanner scanner, Map <String, User> users){
        switch (action) {
            case "1" -> getNewUser(scanner, users) ;
            case "2" -> login(scanner, users);
            case "0" -> System.out.println("EXIT");
            default -> System.out.println("no such action!");
            }
    }
    private String getNewUserName (Scanner scanner, Map <String, User> users) {

        System.out.println("Enter user name");
        String userName = scanner.nextLine();
        if (users.size()<1){
            return  userName;
        }
        while (true) {
            System.out.println("Enter user name");
            userName = scanner.nextLine();
            for (Map.Entry<String, User> user : users.entrySet()) {
                if (!userName.equals(user.getValue().getUserName())) {
                    return userName;
                } else {
                    System.out.println("The userName already exist");
                }
            }
        }
    }
   private void getNewUser (Scanner scanner, Map <String, User> users) {
        String userName = getNewUserName(scanner, users);
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter surname");
        String surname = scanner.nextLine();
        System.out.println(("Enter password"));
        String password = scanner.nextLine();
        String sha256hex= DigestUtils.sha256Hex(password);
        User user = new User (name, surname, userName, sha256hex);
        users.put(userName, user);
    }
    private void login (Scanner scanner, Map <String, User> users){
        System.out.println("Enter user name");
        String userName = scanner.nextLine();
        for (Map.Entry<String , User> user : users.entrySet()){
            if (!userName.equals(user.getKey())){
                System.out.println("Enter password");
                String password = scanner.nextLine();
                String sha256hex = DigestUtils.sha256Hex(password);
                if (sha256hex.equals(user.getValue().getPasword())){
                    System.out.println("Welcome!");
                } else {
                    System.out.println("Wrong password");
                }
            }else {
                System.out.println("user name does not exist!");
            }
        }
    }
}
