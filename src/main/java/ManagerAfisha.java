import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ManagerAfisha {
    private int maxMovieLimit = 10;
    private MovieItem[] items = new MovieItem[0];

    public ManagerAfisha(int maxMovieLimit) {
        this.maxMovieLimit = maxMovieLimit;
    }

    public void save(MovieItem item) {

        int length = items.length + 1;
        MovieItem[] tmp = new MovieItem[length];

        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public MovieItem[] findAll() {
        return items;
    }

    public MovieItem[] getAll() {

        int resultLength;
        if (maxMovieLimit > items.length) {
            resultLength = items.length;
        } else {
            resultLength = maxMovieLimit;
        }
        MovieItem[] result = new MovieItem[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}


