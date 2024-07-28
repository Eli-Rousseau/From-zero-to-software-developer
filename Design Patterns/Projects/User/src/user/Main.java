package user;

public class Main {

    public static void main(String[] args) {
        User user = new User("Eli");
        System.out.println(user.name);
        user.sayHello();
    }
}
