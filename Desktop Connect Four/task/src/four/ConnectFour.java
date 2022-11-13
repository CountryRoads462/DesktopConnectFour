package four;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class Coordinates {
    private final int x;
    private final int y;

    Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }
}

public class ConnectFour extends JFrame {
    static boolean gameIsOver = false;
    static List<Coordinates> fourWinCoordinates = new ArrayList<>();
    static JButton[][] buttons = new JButton[6][7];
    static int countOfClicks = 0;

    public ConnectFour() {
        super("Connect 4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 700);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        initComponents();

        setVisible(true);
    }

    private void initComponents() {
        JPanel board = new JPanel();
        board.setBounds(300, 300, 600, 600);
        board.setLayout(new GridLayout(6, 7));
        add(board);

        Font font = new Font("ABOBA", Font.BOLD, 12);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                char letter = (char) (j + 65);
                char number = Character.forDigit(6 - i, 10);
                JButton button = new JButton(" ");
                int finalJ = j;
                button.addActionListener(e -> {
                    if (!gameIsOver) {
                        changeFirstFreeCellInColumn(finalJ);
                        if (checkGameIsOver()) {
                            changeWinColors();
                            gameIsOver = true;
                        }
                    }
                });
                button.setName("Button" + letter + number);
                button.setBackground(Color.GRAY);
                button.setFont(font);
                button.setFont(button.getFont().deriveFont(30f));
                board.add(button);
                buttons[i][j] = button;
            }
        }

        JButton resetButton = new JButton("Reset");
        resetButton.setName("ButtonReset");
        resetButton.setFont(font);
        resetButton.setFont(resetButton.getFont().deriveFont(12f));
        resetButton.setBackground(Color.yellow);
        resetButton.addActionListener(e -> {
            fourWinCoordinates.clear();
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    buttons[i][j].setText(" ");
                    buttons[i][j].setBackground(Color.gray);
                    countOfClicks = 0;
                    gameIsOver = false;
                }
            }
        });
        add(resetButton);
    }

    static void changeFirstFreeCellInColumn(int numberOfColumn) {
        for (int i = 5; i >= 0; i--) {
            if (buttons[i][numberOfColumn].getText().equals(" ")) {
                if (countOfClicks % 2 == 0) {
                    buttons[i][numberOfColumn].setText("X");
                } else {
                    buttons[i][numberOfColumn].setText("O");
                }
                countOfClicks++;
                break;
            }
        }
    }

    static boolean checkGameIsOver() {
        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < 7; j++) {
                int count;
                int winCount = 0;
                if (!buttons[i][j].getText().equals(" ")) {
                    String currentSymbol = buttons[i][j].getText();

                    fourWinCoordinates.add(new Coordinates(i, j));
                    for (count = 1; count < 4; count++) {
                        int x = i - count;
                        int y = j - count;
                        if (x >= 0 && y >= 0) {
                            if (buttons[x][y].getText().equals(currentSymbol)) {
                                winCount++;
                                fourWinCoordinates.add(new Coordinates(x, y));
                            } else {
                                winCount = 0;
                                fourWinCoordinates.clear();
                                break;
                            }
                        }
                    }
                    if (winCount == 3) {
                        return true;
                    }

                    fourWinCoordinates.add(new Coordinates(i, j));
                    for (count = 1; count < 4; count++) {
                        int x = i - count;
                        if (x >= 0) {
                            if (buttons[x][j].getText().equals(currentSymbol)) {
                                winCount++;
                                fourWinCoordinates.add(new Coordinates(x, j));
                            } else {
                                winCount = 0;
                                fourWinCoordinates.clear();
                                break;
                            }
                        }
                    }
                    if (winCount == 3) {
                        return true;
                    }

                    fourWinCoordinates.add(new Coordinates(i, j));
                    for (count = 1; count < 4; count++) {
                        int x = i - count;
                        int y = j + count;
                        if (x >= 0 && y <= 6) {
                            if (buttons[x][y].getText().equals(currentSymbol)) {
                                winCount++;
                                fourWinCoordinates.add(new Coordinates(x, y));
                            } else {
                                winCount = 0;
                                fourWinCoordinates.clear();
                                break;
                            }
                        }
                    }
                    if (winCount == 3) {
                        return true;
                    }

                    fourWinCoordinates.add(new Coordinates(i, j));
                    for (count = 1; count < 4; count++) {
                        int y = j + count;
                        if (y <= 6) {
                            if (buttons[i][y].getText().equals(currentSymbol)) {
                                winCount++;
                                fourWinCoordinates.add(new Coordinates(i, y));
                            } else {
                                winCount = 0;
                                fourWinCoordinates.clear();
                                break;
                            }
                        }
                    }
                    if (winCount == 3) {
                        return true;
                    }

                    fourWinCoordinates.clear();
                }
            }
        }
        return false;
    }

    static void changeWinColors() {
        for (Coordinates coordinate :
                fourWinCoordinates) {
            buttons[coordinate.getX()][coordinate.getY()].setBackground(Color.GREEN);
        }
    }

    public static void main(String[] args) {
        new ConnectFour();
    }
}