package baseball.controller;

import baseball.config.Config;
import baseball.domain.BaseballNumbers;
import baseball.service.GameService;
import baseball.domain.Result;
import baseball.util.Parser;
import baseball.util.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    GameService service = new GameService();
    BaseballNumbers computerNumbers;

    public static boolean playing = true;

    public void init() { computerNumbers = service.generateNumbers(); }

    public void play() {
        InputView.printStart();
        while (playing) {
            if (computerNumbers == null) computerNumbers = service.generateNumbers();
            InputView.printCheat(computerNumbers);
            InputView.printRequestingInput();
            BaseballNumbers userNumbers = InputView.getUserNumbers();
            Result result = service.compare(computerNumbers, userNumbers);
            OutputView.printResult(result);
            userNumbers.clear();
            if(result.isAllStrikes()){
                InputView.printGameOver();
                restartOrNot(InputView.getUserInput());;
            }
        }
    }

    private void restartOrNot(String input) {
        if(Validator.isInvalid(input)) throw new IllegalArgumentException(InputView.MSG_EXCEPTION_INVALID_INPUT);
        if(input.equals(InputView.EXIT)) playing = false;
        if(input.equals(InputView.RESTART)) init();
    }

}
