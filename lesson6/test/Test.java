package lesson6.test;
import lesson6.animals.*;


public class Test {

    public static void main(String[] args) {

        Dog dog1 = new Dog("Шарик");
        Dog dog2 = new Dog("Бобик");
        dog1.run(500);
        dog2.run(1200);
        dog1.jump(0.2);
        dog2.jump(0.6);
        dog1.swim(100);
        dog2.swim(300);

        System.out.println();

        Cat cat1 = new Cat("Барсик");
        Cat cat2 = new Cat("Мурзик");
        cat1.run(60);
        cat2.run(200);
        cat1.jump(3);
        cat2.jump(0.5);
        cat1.swim(10);
        cat1.swim(0);

    }
}
