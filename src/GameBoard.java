import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class GameBoard extends JPanel {

    private ImageIcon backgroundImage;
    private int boardWidth;
    private int boardHeight;

public GameBoard(String imagePath) {
        // Load the background image using Toolkit
        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource(imagePath));

        // Wait for the image to fully load
        MediaTracker mediaTracker = new MediaTracker(this);
        mediaTracker.addImage(img, 0);
        try {
            mediaTracker.waitForAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (mediaTracker.isErrorAny()) {
            // Handle image loading error
            System.err.println("Error loading image: " + imagePath);
            // Use default dimensions if image loading fails
            boardWidth = 800;
            boardHeight = 600;
        } else {
            backgroundImage = new ImageIcon(img); // Create an ImageIcon from the loaded Image
            boardWidth = backgroundImage.getIconWidth();
            boardHeight = backgroundImage.getIconHeight();
        }

        setPreferredSize(new Dimension(boardWidth, boardHeight));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image
        if (backgroundImage != null) {
            backgroundImage.paintIcon(this, g, 0, 0);
        }

        // Draw other game elements here (e.g., towers, enemies, projectiles)
        // You can draw them on top of the background.
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Randomly select an image path
            Random random = new Random();
            int randomIndex = random.nextInt(ImageLoader.imagePaths.size());
            String selectedImagePath = ImageLoader.imagePaths.get(randomIndex);
            
            // Create the game board with the selected image
            JFrame frame = new JFrame("Swinging Tower Defense");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new GameBoard(selectedImagePath));
            frame.pack();
            frame.setVisible(true);
        });
    }
}
