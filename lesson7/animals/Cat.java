package lesson7.animals;
import lesson7.plate.*;

public class Cat extends Animal {

    private String name;
    private int appetite;
    private Boolean bellyful = false;

    public Cat(String name, int appetite) {
        this.appetite = appetite;
        this.name = name;
        setType("Cat");
        setRunLimit(50, 200);
        setJumpLimit(2);

    }

    @Override
    public void run(int runDist) {
        if (runDist <= runLimit) {
            System.out.println(name + " пробежал(а) " + runDist + " метров и сожрал мышь.");
        } else {
            System.out.println(name + " пробежал(а) только " + runLimit + " метров и сдох от удушья.");
        }
    }

    @Override
    public void jump(double jumpDist) {
        if (jumpDist >= jumpLimit) {
            System.out.println(name + " прыгнул(а) на " + jumpDist + " метра и выпал из окна.");
        } else {
            System.out.println(name + " прыгнул(а) только на " + jumpDist + " метра и не допрыгнул до окна.");
        }
    }

    @Override
    public void swim(int swimDist) {
        System.out.println(name +": Ага, щас, сам плыви!");
    }

    public void eat(Plate plate) {
        if (plate.getFood() >= appetite) {
            plate.decreaseFood(appetite);
            bellyful = true;
            System.out.println(name + " покушал.");
        } else {
            System.out.printf("%sу недостаточно еды.\n", name);
        }
    }

    public void getBellyful() {
        if (bellyful == false) {
            System.out.printf("%s голоден.\n", name);
        } else {
            System.out.printf("%s сыт.\n", name);
        }
    }
    public String getName() {
        return name;
    }

}
