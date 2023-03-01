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
                howManyLetters.merge(ch, 1, Integer::sum);
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

        int highFreqElem = highFreqElem(howManyLetters);
        System.out.print("В тексте самая высокочастотная буква ");
        System.out.print((char) highFreqElem);
        System.out.print(". Частота повторов: ");
        System.out.println(howManyLetters.get((char) highFreqElem));

        int lowFreqElem = lowFreqElem(howManyLetters);
        System.out.print("В тексте самая низкочастотная буква ");
        System.out.print((char) lowFreqElem);
        System.out.print(". Частота повторов: ");
        System.out.print(howManyLetters.get((char) lowFreqElem));
        System.out.println();

    }

    private static final char IF_EMPTY_LETTER = ' ';

    public static int highFreqElem(Map<Character, Integer> map) {
        return map.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse(IF_EMPTY_LETTER);
    }
    
    public static int lowFreqElem(Map<Character, Integer> map) {
        return map.entrySet().stream()
            .min(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse(IF_EMPTY_LETTER);
    }

}
