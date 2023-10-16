package blackJack;

public class InputValidator {

    private static final String ENG_KOR_COMMA_FORMAT = "([A-Za-z가-힣]+,)*[A-Za-z가-힣]+";
    private static final String FORMAT_EXCEPTION_MESSAGE = "형식에 맞지 않습니다.";
    private static final String BLANK_EXCEPTION_MESSAGE = "공백은 입력할 수 없습니다.";
    private static final String INTEGER_EXCEPTIOIN_MESSAGE = "금액은 올바른 숫자로 입력해야합니다.";
    private static final String INTEGER_FORMAT = "\\d+";

    public static void validatePlayerNames(String rawPlayerNmaes) {
        if (isBlank(rawPlayerNmaes)) {
            throw new IllegalArgumentException(BLANK_EXCEPTION_MESSAGE);
        }
        if (!isRightForm(rawPlayerNmaes)) {
            throw new IllegalArgumentException(FORMAT_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isBlank(String rawPlayerNmaes) {
        return rawPlayerNmaes.isEmpty();
    }

    private static boolean isRightForm(String rawPlayerNmaes) {
        return rawPlayerNmaes.matches(ENG_KOR_COMMA_FORMAT);
    }

    public static void validateBettingMoney(String rawBetiingMoeny) {
        if (!isInteger(rawBetiingMoeny)) {
            throw new IllegalArgumentException(INTEGER_EXCEPTIOIN_MESSAGE);
        }
    }

    private static boolean isInteger(String rawBetiingMoeny) {
        return rawBetiingMoeny.matches(INTEGER_FORMAT);
    }
}
