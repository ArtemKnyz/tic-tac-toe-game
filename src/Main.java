import java.util.*;

public class Main {

    static final List<Integer> listPlayer = new ArrayList<>();
    static final List<Integer> listCpu = new ArrayList<>();

    public static void main(String[] args) {
        Field field = new Field();
        field.getFieldArray();

        char[][] charField = field.getField();


        Scanner scan = new Scanner(System.in);
        System.out.println("Хочешь ходить первым? - 1");
        int step = scan.nextInt();

        if (step == 1) {
            while (true) {
                System.out.println("Your step, input number 1-9: ");
                int ch = scan.nextInt();

                while (listPlayer.contains(ch) || listCpu.contains(ch) || ch <= 0 || ch >= 10) {
                    System.out.println("Input correct number: ");
                    ch = scan.nextInt();
                }


                stepByStep(charField, ch, "gamer");
                String result = checkWinner();
                if (result.length() > 0) {
                    System.out.println(result);
                    break;
                }

                Random random = new Random();
                int cpu = random.nextInt(9) + 1;
                while (listPlayer.contains(cpu) || listCpu.contains(cpu)) {
                    System.out.println("Input correct number: ");
                    cpu = random.nextInt(9) + 1;
                }

                Arrays.stream(stepByStep(charField, cpu, "cpu")).forEach(System.out::println);
                result = checkWinner();
                if (result.length() > 0) {
                    System.out.println(result);
                    break;
                }


            }
        }

    }

    @SuppressWarnings("rawtypes")
    public static String checkWinner() {
        List<List> l = new ArrayList<>();

        List l1 = Arrays.asList(1, 2, 3);
        List l2 = Arrays.asList(4, 5, 6);
        List l3 = Arrays.asList(7, 8, 9);
        List l4 = Arrays.asList(1, 3, 7);
        List l5 = Arrays.asList(2, 5, 8);
        List l6 = Arrays.asList(3, 6, 9);
        List l7 = Arrays.asList(1, 5, 9);
        List l8 = Arrays.asList(3, 5, 7);


        l.add(l1);
        l.add(l2);
        l.add(l3);
        l.add(l4);
        l.add(l5);
        l.add(l6);
        l.add(l7);
        l.add(l8);

        for (List ls : l) {
            if (listPlayer.containsAll(ls)) {
                return "You won!";
            } else if (listCpu.containsAll(ls)) {
                return "CPU won!";
            } else if (listPlayer.size() + listCpu.size() == 9) {
                return "Game over!";
            }
        }
        return "";
    }


    public static char[][] stepByStep(char[][] ch, int step, String player) {
        char symbol;
        if (player.equals("gamer")) {
            symbol = '*';
            listPlayer.add(step);
        } else {
            listCpu.add(step);
            symbol = '0';
        }


        switch (step) {
            case 1:
                ch[0][0] = symbol;
                break;
            case 2:
                ch[0][2] = symbol;
                break;
            case 3:
                ch[0][4] = symbol;
                break;
            case 4:
                ch[2][0] = symbol;
                break;
            case 5:
                ch[2][2] = symbol;
                break;
            case 6:
                ch[2][4] = symbol;
                break;
            case 7:
                ch[4][0] = symbol;
                break;
            case 8:
                ch[4][2] = symbol;
                break;
            case 9:
                ch[4][4] = symbol;
                break;

        }
        return ch;

    }

}
