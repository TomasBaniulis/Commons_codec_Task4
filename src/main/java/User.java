public class User {

    private final String name;
    private final String surname;
    private final String userName;
    private final String pasword;


    public User(String name, String surname, String userName, String pasword) {
        this.name = name;
        this.surname = surname;
        this.userName = userName;
        this.pasword = pasword;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUserName() {
        return userName;
    }

    public String getPasword() {
        return pasword;
    }
}
