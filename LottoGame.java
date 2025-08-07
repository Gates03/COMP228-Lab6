import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoGame {
    private int runNumber;
    private int min;
    private int max;
    private int ballCount;
    private Set<Integer> numbers;
    private SecureRandom random;

    public LottoGame(int runNumber, int min, int max, int ballCount) {
        this.runNumber = runNumber;
        this.min = min;
        this.max = max;
        this.ballCount = ballCount;
        this.numbers = new HashSet<>();
        this.random = new SecureRandom();
    }

    public void generate() {
        while (numbers.size() < ballCount) {
            int number = random.nextInt((max - min + 1)) + min;
            numbers.add(number);
        }
    }

    public String getResult() {
        return numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}