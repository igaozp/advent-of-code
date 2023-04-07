package day2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * A for Rock, B for Paper, and C for Scissors
 * X for Rock, Y for Paper, and Z for Scissors
 * 1 for Rock, 2 for Paper, and 3 for Scissors
 * 0 if you lost, 3 if the round was a draw, and 6 if you won
 */
public class Main {
    private static final Map<String, List<String>> CHOOSE_MAP_TABLE = new HashMap<>();
    private static final Map<String, Integer> SCORE_MAP = new HashMap<>();

    static {
        // key opponent choose, value: 1 you won 2 draw 3 lost
        CHOOSE_MAP_TABLE.put("A", List.of("Y", "X", "Z"));
        CHOOSE_MAP_TABLE.put("B", List.of("Z", "Y", "X"));
        CHOOSE_MAP_TABLE.put("C", List.of("X", "Z", "Y"));

        SCORE_MAP.put("X", 1);
        SCORE_MAP.put("Y", 2);
        SCORE_MAP.put("Z", 3);
    }

    public static void main(String[] args) throws IOException {
        var path = Objects.requireNonNull(day1.Main.class.getClassLoader().getResource("")).getPath();
        var file = new File(path + "/day2/input.txt");

        var input = "";
        try (InputStream inputStream = new FileInputStream(file)) {
            byte[] bytes = inputStream.readAllBytes();
            input = new String(bytes);
        }

        String[] split = input.split("\r\n");

        var sum = 0;
        for (String line : split) {
            String[] content = line.split(" ");
            sum += judge(content[0], content[1]);
        }

        System.out.println(sum);
    }

    public static int judge(String opponent, String my) {
        var index = CHOOSE_MAP_TABLE.get(opponent).indexOf(my);
        var score = 0;
        switch (index) {
            case 0 -> score = 6;
            case 1 -> score = 3;
            case 2 -> {
            }
            default -> new RuntimeException();
        }
        return score + SCORE_MAP.get(my);
    }
}
