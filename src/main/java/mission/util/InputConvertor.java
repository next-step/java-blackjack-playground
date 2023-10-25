package mission.util;

import java.util.Arrays;
import java.util.List;

public class InputConvertor {

    public static List<String> convertInputs(String inputs) {
        return Arrays.asList(inputs.split(","));
    }
}
