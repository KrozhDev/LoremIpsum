import java.util.*;

public class Main {

    public static void main(String[] args) {

        String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt" +
                " ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris" +
                " nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse" +
                " cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa " +
                "qui officia deserunt mollit anim id est laborum.";

        String loremLow = lorem.toLowerCase(Locale.ROOT);



        Map<Character,Integer> howManyLetters = new HashMap<>();

        for (int i = 0; i < loremLow.length(); i++) {
            Character ch = loremLow.charAt(i);
            if (ch.isLetter(ch)) {
                if (howManyLetters.get(ch) == null) {
                    howManyLetters.put(ch,1);
                } else {
                    Integer quantity = howManyLetters.get(ch);
                    howManyLetters.put(ch, quantity + 1);
                }
            }
        }

        System.out.println();
        System.out.println("Исходный текст:");
        System.out.println(lorem.substring(0,130) + "...");
        System.out.println();
        System.out.println("Словарь частотности букв:");
        System.out.println(howManyLetters);
        System.out.println();
        System.out.println("Анализ:");


        System.out.print("В тексте самая высокочастотная буква ");
        System.out.print((char) highFreqElem(howManyLetters));
        System.out.print(". Частота повторов: ");
        System.out.println(howManyLetters.get((char)highFreqElem(howManyLetters)));

        System.out.print("В тексте самая низкочастотная буква ");
        System.out.print((char) lowFreqElem(howManyLetters));
        System.out.print(". Частота повторов: ");
        System.out.print(howManyLetters.get((char)lowFreqElem(howManyLetters)));
        System.out.println();

    }


    public static int highFreqElem(Map<Character, Integer> map) {
        char highFreqLetter = ' ';
        int max = -1;
        for (char key: map.keySet()) {
            if (map.get(key) > max) {
                highFreqLetter = key;
                max = map.get(key);
            }
        }

        return highFreqLetter;
    }

    public static int lowFreqElem(Map<Character, Integer> map) {
        char lowFreqLetter = ' ';
        int min = Integer.MAX_VALUE;
        for (char key: map.keySet()) {
            if (map.get(key) < min) {
                min = map.get(key);
                lowFreqLetter = key;
            }
        }
        return lowFreqLetter;
    }


}
