import lombok.Data;

import java.util.Date;


@Data
public class Ticket {

    private Attraction attraction;

    private Integer cost;

    private Date date;

    public Ticket(Attraction attraction) {

        this.attraction = attraction;
        this.cost = attraction.getTicketCost();

    }
}
