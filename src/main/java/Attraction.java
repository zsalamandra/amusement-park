import lombok.Getter;
import lombok.Setter;

@Getter
public class Attraction {

    private final String name;

    private final Integer rating;

    private final Integer ticketCost;

    @Setter
    private Boolean isWork = false;

    public Attraction(String name, Integer rating, Integer ticketCost) {

        this.name = name;
        this.rating = rating;
        this.ticketCost = ticketCost;
    }



}
