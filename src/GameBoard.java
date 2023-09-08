import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {

    // Define the dimensions of the game board
    private static final int BOARD_WIDTH = 800;
    private static final int BOARD_HEIGHT = 600;

    public GameBoard() {
        // Set the preferred size of the game board
        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
    }

    public GameBoard(int WIDTH, int HEIGHT) {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Clear the game board
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, BOARD_WIDTH, BOARD_HEIGHT);

        // Draw game elements here (e.g., towers, enemies, projectiles)
        // You'll implement this based on your game logic and data structures.
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Tower Defense Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new GameBoard());
            frame.pack();
            frame.setVisible(true);
        });
    }
}