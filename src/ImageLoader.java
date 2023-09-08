import java.util.ArrayList;
import java.util.List;

public class ImageLoader {
    public static List<String> getImageUrls() {
        List<String> imageUrls = new ArrayList<>();
        imageUrls.add("https://raw.githubusercontent.com/dchowdhury-mdsol/swinging-tower-defense/main/img/broken-park.png");
        imageUrls.add("https://raw.githubusercontent.com/dchowdhury-mdsol/swinging-tower-defense/main/img/graveyard.png");
        imageUrls.add("https://raw.githubusercontent.com/dchowdhury-mdsol/swinging-tower-defense/main/img/soccer.png");
        imageUrls.add("https://raw.githubusercontent.com/dchowdhury-mdsol/swinging-tower-defense/main/img/puzzle.png");

        return imageUrls;
    }
}