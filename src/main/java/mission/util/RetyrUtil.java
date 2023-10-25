package mission.util;

import java.util.function.Function;
import java.util.function.Supplier;
import mission.view.OutputView;

public class RetyrUtil {

    public static <T, R> R read(Function<T, R> function, T input) {
        try {
            return function.apply(input);
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return read(function, input);
        }
    }
    public static <T> T read(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return read(supplier);
        }
    }
}
