package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.TicketOffer;
import ru.netology.repository.TicketOfferRepository;

import java.util.Arrays;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TicketOfferManager {
    private TicketOfferRepository repository = new TicketOfferRepository();

    public void add(TicketOffer item) {
        repository.save(item);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public TicketOffer[] searchBy(String from, String to) {
        TicketOffer[] result = new TicketOffer[0];
        for (TicketOffer ticketOffer : repository.findAll()) {
            if (ticketOffer.getFrom().equalsIgnoreCase(from) && ticketOffer.getTo().equalsIgnoreCase(to)) {
                TicketOffer[] tmp = new TicketOffer[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticketOffer;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}

