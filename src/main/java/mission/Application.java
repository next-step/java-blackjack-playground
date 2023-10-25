package mission;


import mission.controller.GameController;
import mission.domain.NumberGenerator;
import mission.domain.RandomNumberGenerator;

public class Application {

    public static void main(String[] args) {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        GameController gameController = new GameController(numberGenerator);
        gameController.start();
    }
}
