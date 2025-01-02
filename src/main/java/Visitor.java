import Exceptions.InsufficientFundsException;
import lombok.Getter;

@Getter
public class Visitor {

    private final String name;

    private final Integer age;

    private Ticket ticket;

    private Card card;

    public Visitor(String name, Integer age) {

        this.name = name;
        this.age = age;
    }


    public void linkCard(Card card) {

        this.card = card;
    }

    public void buyTicket(Ticket ticket) throws InsufficientFundsException {

        if (card.getBalance() < ticket.getCost()) {

            throw new InsufficientFundsException("Problem with balance!");
        }

        else {

            card.setBalance(card.getBalance() - ticket.getCost());
            this.ticket = ticket;
        }


    }

}
