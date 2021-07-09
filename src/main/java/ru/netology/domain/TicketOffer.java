package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketOffer implements Comparable<TicketOffer> {
    private int id;
    private int cost;
    private String from;
    private String to;
    private int travelTime;

    @Override
    public int compareTo(TicketOffer o) {
        return this.cost - o.cost;
    }
}




