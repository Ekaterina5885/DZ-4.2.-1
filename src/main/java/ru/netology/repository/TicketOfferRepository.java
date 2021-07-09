package ru.netology.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.TicketOffer;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketOfferRepository {
    private TicketOffer[] items = new TicketOffer[0];

    public void save(TicketOffer item) {
        int length = items.length + 1;
        TicketOffer[] tmp = new TicketOffer[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public TicketOffer[] findAll() {
        return items;
    }

    public TicketOffer findById(int id) {
        for (TicketOffer item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        TicketOffer[] tmp = new TicketOffer[length];
        int index = 0;
        for (TicketOffer item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}
