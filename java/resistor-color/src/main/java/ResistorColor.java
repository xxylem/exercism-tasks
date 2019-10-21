class ResistorColor {

    private static String[] _colors =
            { "black", "brown", "red", "orange", "yellow", "green", "blue",
                    "violet", "grey", "white"};

    int colorCode(String color) {
        // Would prefer to use a switch or a map but the tests seem to lean
        // towards using a String array.
        return java.util.Arrays.asList(_colors).indexOf(color);
    }

    String[] colors() {
        return _colors;
    }
}
