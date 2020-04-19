import java.util.Random;

public class Employee {

    private String name, email, phone;
    private Position position;
    private int salary, age;
    private static final Random rnd = new Random();



    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", position=" + position +
                ", phone=" + phone +
                ", email=" + email +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    public Employee(String name) {
        this.name = name;
        position = Position.values()[rnd.nextInt(Position.values().length)];
        int x = rnd.nextInt(10);
        phone = "+"+x+"("+x+x+x+")"+x+x+x+x+x+x+x;
//    1111111";
//        phone = "+1-(111)-1111111";
//        email = Email.valueOf(Position.values(position));
        email = position.toString() + "@SOMEMAIL.RU";
        salary = 2000 + rnd.nextInt(10000);
        age = 20 + rnd.nextInt(45);
    }
}


