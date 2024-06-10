import java.util.*;

public class Main {
    static Map<Integer, Integer> luckys = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> input = new ArrayList<>();
        int num;
        while ((num = scanner.nextInt()) != 0) {
            input.add(num);
        }
        scanner.close();

        int mx = Collections.max(input);
        Map<Integer, Integer> lucky = new HashMap<>();
        for (int i = 0; i < 33808; i++) {
            lucky.put(i, i + 2);
        }
        luckys.put(1, 2);
        for (int i = 1; i < mx; i++) {
            List<Integer> keys = new ArrayList<>(lucky.keySet());
            int plusValue = lucky.get(keys.get(0));
            for (int j = 0; j < keys.size(); j += plusValue) {
                lucky.remove(keys.get(j));
            }
            luckys.put(i + 1, lucky.get(new ArrayList<>(lucky.keySet()).get(0)));
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            answer.add(luckys.get(input.get(i)));
        }

        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }
}