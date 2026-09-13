import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {

    // Bruteforce solution
    public List<List<String>> bruteForce(String[] strs) {

        List<List<String>> result = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {
            if (visited[i] == true) {
                continue;
            }
            List<String> subResult = new ArrayList<>();
            subResult.add(strs[i]);
            visited[i] = true;
            for (int j = i+1; j< strs.length; j++) {
                String element1 = sorted(strs[i]), element2 = sorted(strs[j]);
                if (!visited[j] &&element1.equals(element2)) {
                    subResult.add(strs[j]);
                    visited[j] = true;
                }
            }
            result.add(subResult);
        }

        return result;
    }

    public List<List<String>> efficientSolution(String[] strs) {
        HashMap<String, List<String>> result = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String key = sorted(strs[i]);

            if (result.containsKey(key)) {
                result.get(key).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                result.put(key, list);
            }
        }
        return new ArrayList<>(result.values());
    }

    public List<List<String>> optimizedSolution(String[] strs) {
        HashMap<String, List<String>> result = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String key = stringCharMap(strs[i]);
            if (result.containsKey(key)) {
                result.get(key).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                result.put(key, list);
            }
        }
        return new ArrayList<>(result.values());
    }

    public String stringCharMap(String str) {
        Map<Character, Integer> result = new TreeMap<>();
        for (int i = 0; i < str.length(); i++) {
            result.put(str.charAt(i), result.getOrDefault(str.charAt(i), 0) + 1);
        }

        return result.entrySet()
                .stream()
                .map(entry -> entry.getKey() + String.valueOf(entry.getValue()))
                .collect(Collectors.joining());
    }

    public String sorted(String str) {
        return str.chars()
                .sorted()
                .mapToObj(s -> String.valueOf((char) s))
                .collect(Collectors.joining());
    }


    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        GroupAnagrams groupAnagrams = new GroupAnagrams();

        System.out.println("==================BRUTEFORCE SOLUTION=====================");
        System.out.println(groupAnagrams.bruteForce(strs));
        System.out.println("\n");

        System.out.println("==================EFFICIENT SOLUTION=====================");
        System.out.println(groupAnagrams.efficientSolution(strs));
        System.out.println("\n");


        System.out.println("==================OPTIMIZED SOLUTION=====================");
        System.out.println(groupAnagrams.optimizedSolution(strs));
    }
}
