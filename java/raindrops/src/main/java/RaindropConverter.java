import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class RaindropConverter {

    private static final Map<Integer, String> DROPS = new HashMap<> ();
    static {
        DROPS.put(3, "Pling");
        DROPS.put(5, "Plang");
        DROPS.put(7, "Plong");
    }


    String convert(int number) {
        ArrayList<String> dropsFound = new ArrayList<>();

        DROPS.forEach(
                (factor, drop) -> {
                    if (number % factor == 0)
                        dropsFound.add(drop); });

        if (dropsFound.isEmpty())
            return String.valueOf(number);

        return String.join("", dropsFound);
    }



}
