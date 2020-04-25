package lesson6.animals;
import java.util.Random;

public abstract class Animal {

    private Random rand = new Random();
    private int getRand(int limit) {
        return rand.nextInt(limit);
    }

    private String type;
    protected int runLimit;
    protected double jumpLimit;
    protected int swimLimit;

    protected void setType(String type) {
        this.type = type;
    }

    protected void setRunLimit(int min, int runLimit) {
        this.runLimit = min + getRand(runLimit-min);
    }
    protected void setJumpLimit(double jumpLimit) {
        this.jumpLimit = jumpLimit;
    }
    protected void setSwimLimit(int swimLimit) {
        this.swimLimit = swimLimit;
    }

    public abstract void run(int runDist);
    public abstract void jump(double jumpDist);
    public abstract void swim(int swimDist);

}
