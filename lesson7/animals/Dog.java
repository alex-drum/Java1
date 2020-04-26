package lesson7.animals;

public class Dog extends Animal {

    private String name;

    public Dog(String name) {
        this.name = name;
        setType("Dog");
        setRunLimit(400, 1000);
        setJumpLimit(0.5);
        setSwimLimit(200);
    }

    @Override
    public void run(int runDist) {
        if (runDist <= runLimit) {
            System.out.println(name + " пробежал(а) " + runDist + " метров и не знает, что делать дальше.");
        } else {
            System.out.println(name + " пробежал(а) только " + runLimit + " метров и сдох от удушья.");
        }
    }

    @Override
    public void jump(double jumpDist) {
        if (jumpDist <= jumpLimit) {
            System.out.println(name + " прыгнул(а) на " + jumpDist + " метра.");
        } else {
            System.out.println(name + " прыгнул(а) только на " + jumpLimit + " метра и упал в волчью яму.");
        }
    }

    @Override
    public void swim(int swimDist) {
        if (swimDist <= swimLimit) {
            System.out.println(name + " проплыл(а) " + swimDist + " метров и выбрался на берег.");
        } else {
            System.out.println(name + " проплыл(а) только " + (int) swimLimit + " метров и утонул.");
        }
    }
}
