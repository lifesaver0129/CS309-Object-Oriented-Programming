import java.awt.*;
import java.util.ArrayList;

/**
 * Created by lifesaver on 02/11/2017.
 */
public class OriginalColorPanel extends ColorPanel {

    ArrayList<ColorPanel> colorpanal = new ArrayList<>();

    public OriginalColorPanel(Color initialColor) {
        super(initialColor);
    }

    @Override
    public void update(float h, float s, float b) {
        Color newColor = Color.getHSBColor(h, s, b);
        setColor(newColor);
        notifyColorPanel(h, s, b);
    }

    public void registerColorPanel(ColorPanel cp) {
        colorpanal.add(cp);
    }


    public void notifyColorPanel(float h, float s, float b) {
        for (ColorPanel c : colorpanal)
            c.update(h, s, b);
    }

}
