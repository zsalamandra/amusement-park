import lombok.Getter;
import lombok.Setter;


@Getter
public class Card {

    @Setter
    private Integer balance = 0;

    private final String validityPeriod;

    private final Integer minCostForExit;

    public Card(String validityPeriod, Integer minCostForExit) {

        this.validityPeriod = validityPeriod;
        this.minCostForExit = minCostForExit;
    }


    public void topUpBalance(Integer moneyAmount) {

        if (moneyAmount < minCostForExit) {

            throw new RuntimeException("Too Few");

        } else {

            balance += moneyAmount;
        }
    }
}
