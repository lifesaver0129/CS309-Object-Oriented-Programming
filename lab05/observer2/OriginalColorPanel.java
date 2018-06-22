import java.awt.*;

/**
 * Created by lifesaver on 02/11/2017.
 */
public class OriginalColorPanel extends ColorPanel{

    public OriginalColorPanel(Color initialColor) {
        super(initialColor);
    }

    @Override
    public void update(float h, float s, float b) {
        Color newColor = Color.getHSBColor(h, s, b);
        setColor(newColor);
    }

}
