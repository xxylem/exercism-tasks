//
//Black: 0
//        Brown: 1
//        Red: 2
//        Orange: 3
//        Yellow: 4
//        Green: 5
//        Blue: 6
//        Violet: 7
//        Grey: 8
//        White: 9
//


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

