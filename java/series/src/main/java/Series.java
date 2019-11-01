import java.util.LinkedList;
import java.util.List;

class Series {

    private final String number;

    Series(String number) {
        this.number = number;
    }

    List<String> slices(int sliceSize) {

        int len = number.length();

        if (sliceSize > len)
            throw new IllegalArgumentException("Slice size is too big.");
        if (sliceSize < 1)
            throw new IllegalArgumentException("Slice size is too small.");

        List<String> slicesList = new LinkedList<>();
        for (int i = 0; i < len - sliceSize + 1; i++) {
            slicesList.add(this.number.substring(i, i + sliceSize));
        }
        return slicesList;
    }
}