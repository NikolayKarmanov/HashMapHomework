import java.util.HashMap;
import java.util.Map;

public class Main {
    public static String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
    public static int min = Integer.MAX_VALUE;
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Map<Character, Integer> characters = new HashMap<>();

        // Here we are filling our Map
        for (int i = 0; i < text.length(); i++) {
            char key = text.charAt(i);
            if (Character.isLetter(key)) {
                if (characters.containsKey(key)) {
                    int temp = characters.get(key);
                    characters.put(key, temp + 1);
                } else {
                    characters.put(key, 1);
                }
            }
        } // Our Map is filled

        System.out.println("Буква " + minCh(characters) + " встречалась в тексте реже всего");
        System.out.println("Буква " + maxCh(characters) + " встречалась в тексте чаще всего");
    }

    public static char minCh(Map<Character, Integer> characters) {
        char temp = 0;
        for (Map.Entry<Character, Integer> ch : characters.entrySet()) {
            if (min > ch.getValue()) {
                min = ch.getValue();
                temp = ch.getKey();
            }
        }
        return temp;
    }

    public static char maxCh(Map<Character, Integer> characters) {
        char temp = 0;
        for (Map.Entry<Character, Integer> ch : characters.entrySet()) {
            if (max < ch.getValue()) {
                max = ch.getValue();
                temp = ch.getKey();
            }
        }
        return temp;
    }
}