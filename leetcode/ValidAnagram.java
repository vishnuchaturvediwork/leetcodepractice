import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ValidAnagram {

    public boolean isValidAnagramBruteForce(String s, String t) {
        if (s.length() != t.length()) return false;
        return sorted(s).equals(sorted(t));
    }

    public boolean isValidAnagramEfficient(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> count = new HashMap<>();

        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c,0)+1);
        }

        for (char c : t.toCharArray()) {
            if (!count.containsKey(c)) return false;
            count.put(c, count.get(c)-1);
            if (count.get(c) < 0) return false;
        }

        return true;
    }

    public String sorted(String str) {
        return str.chars()
                .sorted()
                .mapToObj(s -> String.valueOf((char) s))
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        String s1 = "school master", s2 = "the classroom";

        ValidAnagram solution = new ValidAnagram();
        if (solution.isValidAnagramBruteForce(s1, s2)) System.out.println("Valid anagram");
        else System.out.println("Not a valid anagram");

        if (solution.isValidAnagramEfficient(s1, s2)) System.out.println("Valid anagram");
        else System.out.println("Not a valid anagram");
    }
}
