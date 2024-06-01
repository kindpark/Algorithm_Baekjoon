import java.util.*;

public class Main {
    public static List<String> findMostFrequentGratitudes(int N, int K, String[] gratitudes) {
        Map<String, Integer> gratitudeCount = new HashMap<>();
        Map<String, Integer> lastOccurrence = new HashMap<>();
        for(int index = 0; index < gratitudes.length; index++) {
            String gratitude = gratitudes[index];
            gratitudeCount.put(gratitude, gratitudeCount.getOrDefault(gratitude, 0) + 1);
            lastOccurrence.put(gratitude, index);
        }

        List<Map.Entry<String, Integer>> sortedGratitudes = new ArrayList<>(gratitudeCount.entrySet());
        Collections.sort(sortedGratitudes, (a, b) -> {
            if(!Objects.equals(a.getValue(), b.getValue())) {
                return Integer.compare(b.getValue(), a.getValue());
            } else{
                return Integer.compare(lastOccurrence.get(b.getKey()), lastOccurrence.get(a.getKey()));
            }
        });

        List<String> result = new ArrayList<>();
        for(int i = 0; i < K && i < sortedGratitudes.size(); i++) {
            result.add(sortedGratitudes.get(i).getKey());
        }
        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine(); // Consume newline

        String[] gratitudes = new String[3 * N];
        for(int i = 0; i < 3 * N; i++) {
            gratitudes[i] = sc.nextLine();
        }

        List<String> result = findMostFrequentGratitudes(N, K, gratitudes);

        for(String gratitude : result) {
            System.out.println(gratitude);
        }
    }
}
