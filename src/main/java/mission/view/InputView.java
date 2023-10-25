package mission.view;

import java.util.List;
import mission.dto.PlayerInfoDto;
import mission.dto.PlayerNamesDto;

public class InputView {

    private static final String INPUT_MESSAGE = "입력하세요";
    private static InputView instance;

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    public static PlayerNamesDto scanPlayerNames() {
        return null;
    }

    public List<PlayerInfoDto> scanBettingMoneys(List<String> playerNames) {
        return null;
    }
}
