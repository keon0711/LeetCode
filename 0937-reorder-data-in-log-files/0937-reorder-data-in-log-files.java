import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();
        for (String log : logs) {
            if (Character.isLetter(log.split(" ")[1].charAt(0))) {
                letterLogs.add(log);
            } else {
                digitLogs.add(log);
            }
        }

        letterLogs.sort((s1, s2) -> {
            String[] s1x = s1.split(" ", 2);
            String[] s2x = s2.split(" ", 2);
            int compared = s1x[1].compareTo(s2x[1]);
            if (compared != 0) {
                return compared;
            } else {
                return s1x[0].compareTo(s2x[0]);
            }
        });

        letterLogs.addAll(digitLogs);
        return letterLogs.toArray(new String[0]);
    }

}