import java.util.HashMap;
import java.util.Map;

class ResistorColorDuo {

    private static Map<String, Integer> colorValues = new HashMap<>();
    static {
        colorValues.put("black", 0);
        colorValues.put("brown", 1);
        colorValues.put("red", 2);
        colorValues.put("orange", 3);
        colorValues.put("yellow", 4);
        colorValues.put("green", 5);
        colorValues.put("blue", 6);
        colorValues.put("violet", 7);
        colorValues.put("grey", 8);
        colorValues.put("white", 9);
    }

    int value(String[] colors) {
        return colorValues.get(colors[0]) * 10 + colorValues.get(colors[1]);
    }
}

