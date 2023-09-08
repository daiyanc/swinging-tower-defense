import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Random;

public class GameBoard extends JPanel {
    private BufferedImage backgroundImage;
    private int boardWidth;
    private int boardHeight;

    public GameBoard(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            backgroundImage = ImageIO.read(url);
            boardWidth = backgroundImage.getWidth();
            boardHeight = backgroundImage.getHeight();
        } catch (IOException e) {
            e.printStackTrace();
            // Use default dimensions if image loading fails
            boardWidth = 800;
            boardHeight = 600;
        }

        setPreferredSize(new Dimension(boardWidth, boardHeight));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this);
        }

        // Draw other game elements here (e.g., towers, enemies, projectiles)
        // You can draw them on top of the background.
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create a list of image URLs
            List<String> imageUrls = ImageLoader.getImageUrls();

            // Pick a random URL from the list
            Random random = new Random();
            int randomIndex = random.nextInt(imageUrls.size());
            String githubImageUrl = imageUrls.get(randomIndex);

            // Create the game board with the selected image URL
            JFrame frame = new JFrame("Swinging Tower Defense");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new GameBoard(githubImageUrl));
            frame.pack();
            frame.setVisible(true);
        });
    }
}