import java.awt.*;


public class Solution {

    enum Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST
    }

    public static Direction rotateLeft(Direction d) {
        switch (d) {
            case NORTH:
                return Direction.WEST;
            case EAST:
                return Direction.NORTH;
            case SOUTH:
                return Direction.EAST;
            case WEST:
                return Direction.SOUTH;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static Direction rotateRight(Direction d) {
        switch (d) {
            case NORTH:
                return Direction.EAST;
            case EAST:
                return Direction.SOUTH;
            case SOUTH:
                return Direction.WEST;
            case WEST:
                return Direction.NORTH;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static Point move(Point coords, Direction d) {

        switch (d) {

            case NORTH:
                return new Point(coords.x, coords.y + 1);
            case EAST:
                return new Point(coords.x + 1, coords.y);
            case SOUTH:
                return new Point(coords.x, coords.y - 1);
            case WEST:
                return new Point(coords.x - 1, coords.y);
            default:
                throw new IllegalArgumentException();
        }
    }

    public static int fLR(String input) {
        Direction dir = Direction.NORTH;
        Point coords = new Point(0, 0);

        for (char c : input.toCharArray()) {
            switch (c) {
                case 'L':
                    dir = rotateLeft(dir);
                    continue;
                case 'R':
                    dir = rotateRight(dir);
                    continue;
                case 'F':
                    coords = move(coords, dir);
                    continue;
                default:
            }
        }


        int movesNeeded = 0;

        switch (dir) {

            case NORTH:

                if (coords.x != 0)
                    movesNeeded += 1 + Math.abs(coords.x); // Turn from side.

                movesNeeded += Math.abs(coords.y);
                if (coords.y > 0 && coords.x != 0)
                    movesNeeded++; // Turn around from above.
                if (coords.y > 0 && coords.x == 0)
                    movesNeeded += 2; // Full turn.

                return movesNeeded;


            case EAST:

                if (coords.y != 0)
                    movesNeeded += 1 + Math.abs(coords.y); // Turn from side.

                movesNeeded += Math.abs(coords.x);
                if (coords.x > 0 && coords.y != 0)
                    movesNeeded++; // Turn around from above.
                if (coords.x > 0 && coords.y == 0)
                    movesNeeded += 2; // Full turn.

                return movesNeeded;


            case SOUTH:

                if (coords.x != 0)
                    movesNeeded += 1 + Math.abs(coords.x); // Turn from side.

                movesNeeded += Math.abs(coords.y);
                if (coords.y < 0 && coords.x != 0)
                    movesNeeded++; // Turn around from above.
                if (coords.y < 0 && coords.x == 0)
                    movesNeeded += 2; // Full turn.

                return movesNeeded;

            case WEST:

                if (coords.y != 0)
                    movesNeeded += 1 + Math.abs(coords.y); // Turn from side.

                movesNeeded += Math.abs(coords.x);
                if (coords.x < 0 && coords.y != 0)
                    movesNeeded++; // Turn around from above.
                if (coords.x < 0 && coords.y == 0)
                    movesNeeded += 2; // Full turn.

                return movesNeeded;

            default:
                throw new IllegalArgumentException();
        }
    }
}