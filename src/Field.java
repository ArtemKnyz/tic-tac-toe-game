import java.util.Arrays;

public class Field {

    private final char[][] field = new char[][]{{' ', '|', ' ', '|', ' '}
            , {'-', '+', '-', '+', '-'}
            , {' ', '|', ' ', '|', ' '}
            , {'-', '+', '-', '+', '-'}
            , {' ', '|', ' ', '|', ' '}};


    public char[][] getField() {
        return field;
    }

    public void getFieldArray() {
        Arrays.stream(field).forEach(System.out::println);
    }

}
