package lesson6.animals;

import org.w3c.dom.ls.LSOutput;

public class Cat extends Animal {

    private String name;

    public Cat(String name) {
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
}
