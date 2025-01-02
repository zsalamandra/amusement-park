import Exceptions.AgeRestrictionException;
import Exceptions.AttractionUnavailableException;
import Exceptions.InsufficientFundsException;

import java.util.logging.Level;

public class Main {

    public static void main(String[] args) throws InsufficientFundsException {

        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Main.class.getName());

        Park parkOfAttraction = new Park("Funny Park", "10:00 - 15:00");

        Worker worker = new Worker("Joel");

        Attraction firstAttraction = new Attraction("Amazing", 12, 500);

        Attraction secondAttraction = new Attraction("Awesome", 18, 1000);

        Attraction thirdAttraction = new Attraction("Bomb", 21, 1200);

        Attraction forthAttraction = new Attraction("Bobble", 6, 300);

        Attraction fifthAttraction = new Attraction("Cinema", 0, 200);


        worker.fixAttraction(firstAttraction);
        worker.fixAttraction(secondAttraction);
        worker.fixAttraction(thirdAttraction);
        worker.fixAttraction(forthAttraction);
        worker.fixAttraction(fifthAttraction);


        Card firstCard = new Card("1 Year", 500);
        firstCard.topUpBalance(1000);

        Card secondCard = new Card("2 Year", 500);
        secondCard.topUpBalance(600);

        Card thirdCard = new Card("1 month", 500);
        thirdCard.topUpBalance(660);

        Card forthCard = new Card("3 Year", 500);
        forthCard.topUpBalance(730);

        Card fifthCard = new Card("10 Year", 500);

        try {

            fifthCard.topUpBalance(400);

        } catch (Exception e) {

            logger.log(Level.INFO, "Too Few Money");
        }


        parkOfAttraction.addAttraction(firstAttraction);

        parkOfAttraction.addAttraction(secondAttraction);

        parkOfAttraction.addAttraction(thirdAttraction);

        parkOfAttraction.addAttraction(forthAttraction);

        parkOfAttraction.addAttraction(fifthAttraction);


        Ticket firstTicket = new Ticket(firstAttraction);
        Ticket secondTicket = new Ticket(secondAttraction);
        Ticket thirdTicket = new Ticket(thirdAttraction);
        Ticket forthTicket = new Ticket(forthAttraction);
        Ticket fifthTicket = new Ticket(fifthAttraction);


        Visitor firstVisitor = new Visitor("Artem", 11);

        firstVisitor.linkCard(firstCard);

        try {
            firstVisitor.buyTicket(firstTicket);

        } catch (InsufficientFundsException e) {

            logger.log(Level.INFO, "Too Few Money");
        }


        Visitor secondVisitor = new Visitor("Nikita", 10);

        secondVisitor.linkCard(secondCard);

        try {
            secondVisitor.buyTicket(secondTicket);

        } catch (InsufficientFundsException e) {

            logger.log(Level.INFO, "Too Few Money");
        }


        Visitor thirdVisitor = new Visitor("Misha", 30);

        thirdVisitor.linkCard(thirdCard);

        try {
            thirdVisitor.buyTicket(thirdTicket);

        } catch (InsufficientFundsException e) {

            logger.log(Level.INFO, "Too Few Money");
        }


        Visitor forthVisitor = new Visitor("Sanya", 22);

        forthVisitor.linkCard(forthCard);

        try {

            forthVisitor.buyTicket(forthTicket);

        } catch (InsufficientFundsException e) {

            logger.log(Level.INFO, "Too Few Money");
        }


        Visitor fifthVisitor = new Visitor("Oleg", 0);

        fifthVisitor.linkCard(fifthCard);

        try {
            fifthVisitor.buyTicket(fifthTicket);

        } catch (InsufficientFundsException e) {

            logger.log(Level.INFO, "Too Few Money");
        }



        try {

            useAttraction(fifthVisitor);
            useAttraction(secondVisitor);
            useAttraction(thirdVisitor);
            useAttraction(forthVisitor);
            useAttraction(fifthVisitor);

        } catch (AgeRestrictionException e) {
            System.out.println("Too Young");

        } catch (AttractionUnavailableException e) {
            System.out.println("Attraction does not work");

        }

    }

    public static void useAttraction(Visitor visitor) throws AgeRestrictionException,
            AttractionUnavailableException {

        if (visitor.getTicket() == null) {

            return;
        }

        else {

            if (visitor.getAge() < visitor.getTicket().getAttraction().getRating()) {

                throw new AgeRestrictionException("You're too young");
            }
        }


        if (visitor.getTicket().getAttraction().getIsWork().equals(false)) {

            throw new AttractionUnavailableException("Not Working");
        }
    }
}
