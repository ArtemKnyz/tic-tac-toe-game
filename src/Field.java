import java.util.Arrays;

public class Field {

    private char[][] field = new char[][]{{'_', '|', '_', '|', '_'}
            , {'_', '|', '_', '|', '_'}
            , {' ', '|', ' ', '|', ' '}};


    public void getField() {
        Arrays.stream(field).forEach(System.out::println);
    }

}
