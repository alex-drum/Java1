import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        System.out.println("Угадайте слово, загаданное компьютером.");
        System.out.println("Список возможных слов:" + Arrays.toString(words));
        System.out.println("Введите Ваш вариант:");
        String wordToGuess = words[(int) (Math.random() * words.length)];
//        System.out.println(wordToGuess);
        String guessedChars = "";
        String userInput = in.next();
        int counter = 1;

        while (!userInput.equals(wordToGuess)) {
            if (wordToGuess.charAt(0) != userInput.charAt(0)) {
                System.out.println("Слово начинается на другую букву. Попробуйте еще раз.");
                counter++;
                userInput = in.next();
            } else if (!userInput.equals(wordToGuess)) {
                for (int i = 0; i < ((wordToGuess.length() > userInput.length()) ? userInput.length() : wordToGuess.length());
                     i++) {
                    if (userInput.charAt(i) == wordToGuess.charAt(i)) {
                        guessedChars += userInput.charAt(i);
                    } else break;
                }
                guessedChars += "##################";
                System.out.println("Вы угадали следующие буквы с начала слова: " + guessedChars);
                guessedChars = "";
                counter++;
                userInput = in.next();
            }
        }
        System.out.println("Вы угадали c " + counter + "-го раза! Загаданное слово - " + wordToGuess + ".");
        in.close();
    }
}
