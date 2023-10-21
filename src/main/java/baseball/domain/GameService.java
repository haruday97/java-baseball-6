package baseball.domain;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    static List<Integer> numbers = new ArrayList<>();
    static final int MAX_NUMBERS = 3;
    static final int START_INCLUSIVE = 1;
    static final int END_INCLUSIVE = 9;

    public List <Integer> generateNumbers(){
        while(numbers.size() < MAX_NUMBERS){
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            if(isNotDuplicated(randomNumber)) numbers.add(randomNumber);
        }
        return numbers;
    }

    private boolean isNotDuplicated(int randomNumber) {
        return !numbers.contains(randomNumber);
    }

    public int[] compare(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int[] result = new int[2]; // result[0] == strike, result[1] == ball
        for(int index = 0; index < MAX_NUMBERS; index++){
            if(isStrike(computerNumbers, userNumbers, index)) result[0]++;
            if(isBall(computerNumbers, userNumbers, index)) result[1]++;
        }
        return result;
    }

    private boolean isBall(List<Integer> computerNumbers, List<Integer> userNumbers, int index) {
        int number = userNumbers.get(index);
        return computerNumbers.contains(number) && !isStrike(computerNumbers, userNumbers, index);
    }

    private boolean isStrike(List<Integer> computerNumbers, List<Integer> userNumbers, int index) {
        return computerNumbers.get(index) ==  userNumbers.get(index);
    }



    public boolean isThreeStrikes(int[] result){
        return result[0] == 3;
    }

}
