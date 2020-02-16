import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Knapsack {

    public int maximumValue(int maxWeight, List<Item> items) {
        Set<Set<Item>> itemPermutations = Sets.powerSet(new HashSet<>(items));
        return itemPermutations
                .parallelStream()
                .filter( (s) -> withinWeightLimit(s, maxWeight))
                .map(Knapsack::valueOfItemSet)
                .max(Integer::compare)
                .orElse(0);
    }

    private static boolean withinWeightLimit(Set<Item> s, int maxWeight) {
        return maxWeight >=
                s.parallelStream()
                .mapToInt(Item::getWeight)
                .reduce(0, Integer::sum);
    }

    private static Integer valueOfItemSet(Set<Item> s) {
        return s.parallelStream()
                .mapToInt(Item::getValue)
                .reduce(0, Integer::sum);
    }

}