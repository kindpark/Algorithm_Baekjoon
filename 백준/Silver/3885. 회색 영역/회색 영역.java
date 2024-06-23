import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            int w = scanner.nextInt();
            if (n == 0 && w == 0) {
                break;
            }
            int[] values = new int[n];
            for (int i = 0; i < n; i++) {
                values[i] = scanner.nextInt();
            }
            double inkUsage = processHistogramData(n, w, values);
            System.out.printf("%.5f\n", inkUsage);
        }
        scanner.close();
    }

    private static double processHistogramData(int n, int w, int[] values) {
        int maxValue = Arrays.stream(values).max().orElse(0);
        int numIntervals = (maxValue / w) + 1;
        int[] histogram = new int[numIntervals];

        for (int value : values) {
            int intervalIndex = value / w;
            histogram[intervalIndex] += 1;
        }

        int maxHeight = Arrays.stream(histogram).max().orElse(0);
        double inkUsage = calculateInkUsage(histogram, maxHeight);

        // Adding ink for axes and labels
        inkUsage += 0.01;

        return inkUsage;
    }

    private static double calculateInkUsage(int[] histogram, int maxHeight) {
        double inkUsage = 0.0;
        int numBars = histogram.length;

        for (int i = 0; i < numBars; i++) {
            int height = histogram[i];
            double relativeHeight = (maxHeight > 0) ? (double) height / maxHeight : 0.0;
            double brightness = (numBars > 1) ? 1.0 - (double) i / (numBars - 1) : 1.0;
            double inkForBar = relativeHeight * brightness * 1.0;
            inkUsage += inkForBar;
        }

        return inkUsage;
    }
}
