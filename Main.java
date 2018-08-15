import java.util.Random;
import java.util.Scanner;

public class Main

{

    private static final int SIZE = 3;

    private static final char X = 'X';

    private static final char O = 'O';

    private static final char blank = '•';

    private static char[][] field;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        field = initField(field, SIZE, blank);
        showField(field);
        while(isThereEmptyCell(field, blank))
        {
            playerTurn(field, X);
            if(checkWin(field) == true)
            {
                System.out.println("Player won!");
                showField(field);
                break;
            }
            AITurn(field, O);
            if(checkWin(field) == true)
            {
                System.out.println("Artificial intelligence won!");
                showField(field);
                break;
            }
            showField(field);
        }
    }

    private static char[][] initField(char[][] field, int SIZE, char blank)
    {
        field = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
            {
                field[i][j] = blank;
            }
        }
        return field;
    }

    private static void showField(char[][] field)
    {
        System.out.println("  1 2 3");
        for (int i = 0; i < SIZE; i++)
        {
            System.out.print((i+1 + " "));
            for (int j = 0; j < SIZE; j++)
            {
                System.out.print(field[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    private static boolean isCellEmpty(char[][] field, int x, int y, char blank)
    {
        if(field[x][y] == blank){return true;}else{return false;}
    }

    private static boolean isThereEmptyCell(char[][] field, char blank)
    {
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
            {
                if(isCellEmpty(field, i, j, blank) == true){return true;}
            }
        }
        return false;
    }

    private static char[][] playerTurn(char[][] field, char X)
    {
        int x;
        int y;
        System.out.println("Hello, write X for move: ");
        x = (scanner.nextInt()-1);
        System.out.println("Hello, write Y for move: ");
        y = (scanner.nextInt()-1);
        if(isCellEmpty(field, x, y, blank) == true)
        {field[y][x] = X;}else {
            System.out.println("Sorry, cell is already full. Try again");
            playerTurn(field, X);
        }

        return field;
    }

    private static char[][] AITurn(char[][] field, char O)
    {
        Random random = new Random();
        int x = random.nextInt(SIZE);
        int y = random.nextInt(SIZE);
        if(isCellEmpty(field, y, x, blank) == true)
        {field[y][x] = O;}else
            {
            AITurn(field, O);
            }
        return field;
    }

    private static boolean checkWin(char[][] field)
    {
        if(field[0][0] == field[0][1] && field[0][1] == field[0][2] && (field[0][2] == X || field[0][2] == O)){return true;}
        if(field[1][0] == field[1][1] && field[1][1] == field[1][2] && (field[1][2] == X || field[1][2] == O)){return true;}
        if(field[2][0] == field[2][1] && field[2][1] == field[2][2] && (field[2][2] == X || field[2][2] == O)){return true;}
        if(field[0][0] == field[1][1] && field[1][1] == field[2][2] && (field[2][2] == X || field[2][2] == O)){return true;}
        if(field[0][2] == field[1][1] && field[1][1] == field[2][0] && (field[2][0] == X || field[2][0] == O)){return true;}
        if(field[0][0] == field[1][0] && field[1][0] == field[2][0] && (field[2][0] == X || field[2][0] == O)){return true;}
        if(field[0][1] == field[1][1] && field[1][1] == field[2][1] && (field[2][1] == X || field[2][1] == O)){return true;}
        if(field[0][2] == field[1][2] && field[1][2] == field[2][2] && (field[2][2] == X || field[2][2] == O)){return true;}
        else{return false;}
    }

}
