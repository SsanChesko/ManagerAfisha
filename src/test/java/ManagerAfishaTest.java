import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerAfishaTest {
    private ManagerAfisha manager = new ManagerAfisha();

    private MovieItem first = new MovieItem(1, "Bloodshot", "ActionMovie");
    private MovieItem second = new MovieItem(2, "LetsGo", "Cartoon");
    private MovieItem third = new MovieItem(3, "HotelBelgrad", "Comedy");
    private MovieItem fourth = new MovieItem(4, "Gentelmens", "ActionMovie");
    private MovieItem fifth = new MovieItem(5, "InvisibleMan", "Horror");
    private MovieItem sixth = new MovieItem(6, "Trolls", "Cartoon");
    private MovieItem seventh = new MovieItem(7, "NumberOne", "Comedy");

    @Test
    void shouldAddFilms() {

        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);

        MovieItem[] expected = new MovieItem[]{first, second, third, fourth};
        MovieItem[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldCheckBaseLimitMovies() {

        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.save(sixth);
        manager.save(seventh);
        manager.getAll();

        MovieItem[] expected = new MovieItem[]{seventh, sixth, fifth, fourth, third, second, first};
        MovieItem[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldCheckWithLimitMovies() {

        ManagerAfisha manager1 = new ManagerAfisha(2);

        manager1.save(second);
        manager1.save(sixth);

        MovieItem[] expected = new MovieItem[]{sixth, second};
        MovieItem[] actual = manager1.getAll();

        assertArrayEquals(expected, actual);
    }
}