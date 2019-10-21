class Darts {

    private final int score;

    Darts(double x, double y) {
        double dist = Math.hypot(x, y);

        if (dist > 10)
            this.score = 0;
        else if (dist > 5)
            this.score = 1;
        else if (dist > 1)
            this.score = 5;
        else
            this.score = 10;
    }

    int score() {
        return this.score;
    }

}
