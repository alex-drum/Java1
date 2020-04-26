package lesson7.plate;

public class Plate {

    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public void info() {
        System.out.printf("В тарелке %d единиц еды.\n", food);
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int howMuch) {
        if (food >= howMuch) {
            food -= howMuch;
        } else {
            System.out.println("В тарелке недостаточно еды.");
        }
    }

    public void addFood(int howMuch) {
        food += howMuch;
        System.out.printf("Папа положил в тарелку %d еды.\n", howMuch);
    }

}
