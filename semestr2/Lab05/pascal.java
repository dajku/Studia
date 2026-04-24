import java.awt.*;

import javax.swing.*;

public class pascal {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Nie podano argumentów");
            return;
        }
        try {
            int n = Integer.parseInt(args[0]);
            if (n <= 0) {
                System.out.println("Błędny argument");
                return;
            }

            JFrame fr = new JFrame("Pascal");
            
            fr.setSize(1000, 1000);

            fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel mainPanel = new JPanel();
            mainPanel.setBackground(Color.BLACK);

            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

            fr.setContentPane(mainPanel); // ustawienie mainPanel jako główny canvas

            mainPanel.add(Box.createVerticalGlue()); // dodanie górnego marginesu
            Font mainFont = new Font("Arial", Font.BOLD, 24);

            // IMPLEMENTACJA NIEOPTYMALNA (czasowo) czyli z użyciem klasy PascalTriangleRow
            // Oblicza każdy wiersz po kolei aż do n, więc powtarzają sie obliczenia ale
            // wykorzystuje już napisany kod
            for (int i = 0; i <= n; i++) {

                JPanel triangleRow = new JPanel(new FlowLayout(FlowLayout.CENTER));

                triangleRow.setBackground(Color.BLACK);

                PascalTriangleRow calcPascal = new PascalTriangleRow(i);
                for (int j = 0; j < i + 1; j++) {
                    int value = calcPascal.pascalValue(j);
                    if (value != 0) {
                        JLabel number = new JLabel(String.valueOf(value)); 

                        number.setFont(mainFont);
                        number.setForeground(Color.WHITE);
                        number.setPreferredSize(new Dimension(75, 75));
                        number.setHorizontalAlignment(SwingConstants.CENTER);

                        triangleRow.add(number);
                    }

                }
                triangleRow.setMaximumSize(new Dimension(Integer.MAX_VALUE, triangleRow.getPreferredSize().height)); // ustawienie aby wiersze mogły brać całą szerokość ekranu ale żeby wysokość zostawała taka sama
                mainPanel.add(triangleRow);
            }
            mainPanel.add(Box.createVerticalGlue()); // dodanie dolnego marginesu

            fr.setVisible(true);
            mainPanel.setVisible(true);

        } catch (InvalidArraySize ex) {
            System.out.println(ex + ": " + args[0] + " - Nieprawidłowy wiersz trójkąta Pascala");
            return;

        } catch (NumberFormatException ex) {
            System.out.println(args[0] + " - nieprawidłowa dana");
            return;
        }

    }

}
