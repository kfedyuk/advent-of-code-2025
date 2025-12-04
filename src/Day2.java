import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day2 {

    public long totalSum;

    public Day2() {
        this.totalSum = 0;
    }

    public void computeInvalidIDTotal1(String fileName) throws IOException {
        String[] inputRanges = readInput(fileName);

        for (String inputRange : inputRanges) {
            String[] ranges = inputRange.split("-");
            long start = Long.parseLong(ranges[0]);
            long end = Long.parseLong(ranges[1]);
            for (long j = start; j <= end; j++) {
                String sj = String.valueOf(j);
                if (sj.startsWith("0"))
                    continue;
                if (sj.length() % 2 == 0) {
                    String firstHalf = sj.substring(0, sj.length() / 2);
                    String secondHalf = sj.substring(sj.length() / 2);
                    if (firstHalf.equals(secondHalf))
                        totalSum += j;
                }
            }
        }
    }

    public void computeInvalidIDTotal2(String fileName) throws IOException {
        String[] inputRanges = readInput(fileName);

        for (String inputRange : inputRanges) {
            String[] ranges = inputRange.split("-");
            long start = Long.parseLong(ranges[0]);
            long end = Long.parseLong(ranges[1]);
            for (long j = start; j <= end; j++) {
                String sj = String.valueOf(j);
                if (sj.startsWith("0"))
                    continue;

                for(int len = 1; len <= sj.length()/2; len ++) {
                    if (sj.length() % len == 0) {
                        String pattern = sj.substring(0, len);
                        StringBuilder match = new StringBuilder();
                        int repeats = sj.length() / len;

                        for (int i = 0; i < repeats; i++) {
                            match.append(pattern);
                        }

                        if (match.toString().equals(sj)) {
                            totalSum += j;
                            break;
                        }
                    }
                }
            }
        }
    }



    public String[] readInput(String fileName) throws IOException {
        return  Files.readAllLines(Paths.get(fileName)).getFirst().split(",");
    }

    public long getTotalSum() { return totalSum; }
}
