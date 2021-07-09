package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.comparator.TicketOfferComparator;
import ru.netology.domain.TicketOffer;
import ru.netology.repository.TicketOfferRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketOfferManagerTest {
    TicketOfferRepository repository = new TicketOfferRepository();
    TicketOfferManager manager = new TicketOfferManager();
    private TicketOffer first = new TicketOffer(1, 100_000, "KUF", "OGZ", 60);
    private TicketOffer second = new TicketOffer(2, 800_000, "FRU", "EGO", 80);
    private TicketOffer third = new TicketOffer(3, 200_000, "GOJ", "KUF", 100);
    private TicketOffer fourth = new TicketOffer(4, 900_000, "GOJ", "KUF", 120);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
    }

    // Сортировка предложений по цене;
    @Test
    public void shouldSortByCost() {
        TicketOffer[] expected = new TicketOffer[]{first, third, second, fourth};
        TicketOffer[] actual = new TicketOffer[]{first, second, third, fourth};

        Arrays.sort(actual);

        assertArrayEquals(actual, expected);
    }

    // Найти одно предложение, для покупки билета;
    @Test
    public void shouldFindOneTicketOffer() {

        TicketOffer[] expected = new TicketOffer[]{second};
        TicketOffer[] actual = manager.searchBy("FRU", "EGO", new TicketOfferComparator());

        assertArrayEquals(actual, expected);
    }

    // Найти два предложения, для покупки билета;
    @Test
    public void shouldFindTwoTicketsOffer() {

        TicketOffer[] expected = new TicketOffer[]{third, fourth};
        TicketOffer[] actual = manager.searchBy("GOJ", "KUF", new TicketOfferComparator());

        assertArrayEquals(actual, expected);
    }

    // Билеты по критериям поиска не найдены;
    @Test
    public void shouldNotFindTicketOffer() {

        TicketOffer[] expected = new TicketOffer[]{};
        TicketOffer[] actual = manager.searchBy("GOJ", "OGZ", new TicketOfferComparator());

        assertArrayEquals(actual, expected);
    }
}
