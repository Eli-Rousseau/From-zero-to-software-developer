package user;

public class User {

    public String name;

    public User(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Hello to " + name + " !");
    }

}
