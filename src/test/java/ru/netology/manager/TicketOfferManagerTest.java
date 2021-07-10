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
    private TicketOffer first = new TicketOffer(101, 100_000, "LED", "KUF", 60);
    private TicketOffer second = new TicketOffer(202, 800_000, "FRU", "EGO", 80);
    private TicketOffer third = new TicketOffer(303, 200_000, "GOJ", "KUF", 100);
    private TicketOffer fourth = new TicketOffer(404, 900_000, "GOJ", "KUF", 120);
    private TicketOffer fifth = new TicketOffer(505, 300_000, "KUF", "OGZ", 60);
    private TicketOffer sixth = new TicketOffer(606, 400_000, "FRU", "EGO", 80);
    private TicketOffer seventh = new TicketOffer(707, 700_000, "LED", "KUF", 140);
    private TicketOffer eighth = new TicketOffer(808, 500_000, "LED", "KUF", 120);
    private TicketOffer ninth = new TicketOffer(909, 600_000, "LED", "KUF", 160);
    private TicketOffer tenth = new TicketOffer(1001, 1000_000, "GOJ", "KUF", 120);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
    }

    // Сортировка предложений по цене;
    @Test
    public void shouldSortByCost() {
        TicketOffer[] expected = new TicketOffer[]{first, third, fifth, sixth, eighth, ninth, seventh,
                second, fourth, tenth};
        TicketOffer[] actual = new TicketOffer[]{first, second, third, fourth, fifth, sixth, seventh, eighth,
                ninth, tenth};

        Arrays.sort(actual);

        assertArrayEquals(actual, expected);
    }

    // Найти два предложения, для покупки билета, по аэропорту вылета и прилета;
    @Test
    public void shouldFindTwoTicketOffer() {

        TicketOffer[] expected = new TicketOffer[]{second, sixth};
        TicketOffer[] actual = manager.searchBy("FRU", "EGO", new TicketOfferComparator());

        assertArrayEquals(actual, expected);
    }

    // Найти три предложения, для покупки билета, по аэропорту вылета и прилета;
    @Test
    public void shouldFindThreeTicketsOffer() {

        TicketOffer[] expected = new TicketOffer[]{third, fourth, tenth};
        TicketOffer[] actual = manager.searchBy("GOJ", "KUF", new TicketOfferComparator());

        assertArrayEquals(actual, expected);
    }

    // Найти четыре предложения, для покупки билета, по аэропорту вылета и прилета;
    @Test
    public void shouldFindFourTicketsOffer() {

        TicketOffer[] expected = new TicketOffer[]{first, eighth, seventh, ninth};
        TicketOffer[] actual = manager.searchBy("LED", "KUF", new TicketOfferComparator());

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
