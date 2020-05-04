import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class HandshakeCalculator {

    private static final int REVERSE_BINARY_FLAG = 16;

    List<Signal> calculateHandshake(int number) {

        List<Signal> signals = Stream.of(Signal.values()).collect(Collectors.toList());

        if (shouldReverseOperations(number)) {
            Collections.reverse(signals);
        }

        signals.removeIf(signal -> !signal.isOperationUsed(number));

        return signals;
    }

    private static boolean shouldReverseOperations(int number) {
        return (number & REVERSE_BINARY_FLAG) > 0;
    }

}
