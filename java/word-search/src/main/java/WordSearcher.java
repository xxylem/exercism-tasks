import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

class WordSearcher {

    public Map<String, Optional<WordLocation>> search(Set<String> searchWords, char[][] letterGrid) {

        int nRows = letterGrid.length;
        int nCols = letterGrid[0].length; // Assumed to exist.

        Map<String, Optional<WordLocation>> wordLocations = new HashMap<>();

        for (String word : searchWords) {
            Optional<WordLocation> location = findWord(word, letterGrid, nRows, nCols);
            location = location.map(WordLocation::toOneIndexing);
            wordLocations.put(word, location);
        }

        return wordLocations;
    }

    private Optional<WordLocation> findWord(String word, char[][] letterGrid, int nRows, int nCols) {
        for (int row = 0; row < nRows; row++) {
            for (int col = 0; col < nCols; col++) {
                char letter = letterGrid[row][col];
                if (letter == word.charAt(0)) {
                    Pair startCoord = new Pair(col, row);
                    Optional<WordLocation> location = findWordGivenStart(startCoord, word, letterGrid, nRows, nCols);
                    if (location.isPresent()) {
                        return location;
                    }
                }
            }
        }
        return Optional.empty();
    }

    private Optional<WordLocation> findWordGivenStart(Pair startCoord, String word, char[][] letterGrid, int nRows, int nCols) {

        Optional<WordLocation> location;
        return findWordGivenStartAndDirection(startCoord, word, letterGrid, nRows, nCols, Pair::moveNorth)
                .or(() -> findWordGivenStartAndDirection(startCoord, word, letterGrid, nRows, nCols, Pair::moveNorthEast))
                .or(() -> findWordGivenStartAndDirection(startCoord, word, letterGrid, nRows, nCols, Pair::moveEast))
                .or(() -> findWordGivenStartAndDirection(startCoord, word, letterGrid, nRows, nCols, Pair::moveSouthEast))
                .or(() -> findWordGivenStartAndDirection(startCoord, word, letterGrid, nRows, nCols, Pair::moveSouth))
                .or(() -> findWordGivenStartAndDirection(startCoord, word, letterGrid, nRows, nCols, Pair::moveSouthWest))
                .or(() -> findWordGivenStartAndDirection(startCoord, word, letterGrid, nRows, nCols, Pair::moveWest))
                .or(() -> findWordGivenStartAndDirection(startCoord, word, letterGrid, nRows, nCols, Pair::moveNorthWest));
    }

    private Optional<WordLocation> findWordGivenStartAndDirection(Pair startCoord, String word, char[][] letterGrid, int nRows, int nCols, Function<Pair, Pair> directionFunction) {
        Pair currentLocation = new Pair(startCoord.getX(), startCoord.getY());
        for (char letter : word.substring(1).toCharArray()) {
            currentLocation = directionFunction.apply(currentLocation);
            int x = currentLocation.getX();
            int y = currentLocation.getY();
            if (x < 0 || x > nCols - 1 || y < 0 || y > nRows - 1 || letter != letterGrid[y][x]) {
                return Optional.empty();
            }
        }
        return Optional.of(new WordLocation(startCoord, currentLocation));
    }
}