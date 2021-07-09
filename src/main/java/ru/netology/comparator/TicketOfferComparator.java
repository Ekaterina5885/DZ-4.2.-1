package ru.netology.comparator;

import ru.netology.domain.TicketOffer;

import java.util.Comparator;

public class TicketOfferComparator implements Comparator<TicketOffer> {

    @Override
    public int compare(TicketOffer o1, TicketOffer o2) {
        return o1.getTravelTime() - o2.getTravelTime();
    }
}
