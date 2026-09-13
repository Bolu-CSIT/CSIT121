import java.util.Scanner;

public class AirlineDriver 
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        char [][] layout = { {'A', 'B','C','D'},
                             {'A', 'B','C','D'}, 
                             {'A', 'B','C','D'},
                             {'A', 'B','C','D'},
                             {'A', 'B','C','D'} };

        String seat;
        int r, c;

        displaySeats(layout);

        while (true)
        {
            System.out.print("Enter row and seat (e.g. 1A) or -1 to quit: ");
            seat = scan.nextLine();

            if (seat.equals("-1"))
                break;

            seat = seat.toUpperCase(); // make case insensitive

            r = Character.getNumericValue(seat.charAt(0)) - 1;
            c = seat.charAt(1) - 'A';

            // check bounds
            if (r < 0 || r >= 5 || c < 0 || c >= 4)
            {
                System.out.println("Invalid seat!");
                continue;
            }

            if (layout[r][c] == 'X')
            {
                System.out.println("Seat already taken!");
            }
            else
            {
                layout[r][c] = 'X';
            }

            displaySeats(layout);

            // check if full
            if (isFull(layout))
            {
                System.out.println("All seats are filled!");
                break;
            }
        }

        scan.close();
    }

    public static void displaySeats(char [][] plane)
    {
        for (int row = 0; row < plane.length; row++)
        {
            System.out.print((row + 1) + "  ");
            for (int col = 0; col < plane[row].length; col++)
            {
                System.out.print(plane[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isFull(char [][] plane)
    {
        for (int i = 0; i < plane.length; i++)
        {
            for (int j = 0; j < plane[i].length; j++)
            {
                if (plane[i][j] != 'X')
                    return false;
            }
        }
        return true;
    }
}