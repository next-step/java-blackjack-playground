package mission.controller;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static mission.util.RetyrUtil.read;

import java.util.List;
import mission.domain.Players;
import mission.dto.PlayerInfoDto;
import mission.dto.PlayerNamesDto;
import mission.view.InputView;
import mission.view.OutputView;
import mission.domain.NumberGenerator;


public class GameController {

    private final NumberGenerator numberGenerator;
    InputView inputView = InputView.getInstance();

    public GameController(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void start() {
        Players players = read(this::generatePlayer);
        OutputView.printStart();
    }


    private Players generatePlayer() {
        PlayerNamesDto playerNamesDto = read(InputView::scanPlayerNames);
        List<PlayerInfoDto> playerInfoDtos = inputView.scanBettingMoneys(
            playerNamesDto.getPlayerNames());

        return playerInfoDtos.stream()
            .map(PlayerInfoDto::toPlayer)
            .collect(collectingAndThen(toList(), Players::from));
    }
}
