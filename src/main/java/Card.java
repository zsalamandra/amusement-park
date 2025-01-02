import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
public class Card {

    @Setter
    private BigDecimal balance = BigDecimal.ZERO;

    private final String validityPeriod;

    private final BigDecimal minCostForExit;

    public Card(String validityPeriod, BigDecimal minCostForExit) {

        this.validityPeriod = validityPeriod;
        this.minCostForExit = minCostForExit;
    }


    public void topUpBalance(BigDecimal moneyAmount) {

        if (moneyAmount.compareTo(minCostForExit) > 0) {
            throw new RuntimeException("Too Few");
        } else {
            balance.add(moneyAmount);
        }
    }
}
