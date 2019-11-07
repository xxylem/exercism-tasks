import model.Hand;

import java.util.List;
import java.util.stream.Collectors;

class Poker {

    List<Hand> hands;

    Poker(List<String> hands) {
//        this.hands?ap(Hand::new).collect(Collectors.toList());
    }


    List<String> getBestHands() {
//        int bestScore = this.hands.stream().mapToInt(Hand::getScore).max().orElseThrow();
//        return this.hands.stream().filter(h -> h.getScore() == bestScore)
//                .map(Hand::toString).collect(Collectors.toList());

        return List.of("asd");
    }
}