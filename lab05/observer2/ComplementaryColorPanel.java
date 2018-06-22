import java.awt.*;

/**
 * Created by lifesaver on 02/11/2017.
 */
public class ComplementaryColorPanel extends ColorPanel {
    public ComplementaryColorPanel(Color initialColor) {
        super(initialColor);
    }

    @Override
    public void update(float h, float s, float b) {
        float complementaryHue = h - (float) 0.5;
        if (complementaryHue < 0) {
            complementaryHue = complementaryHue + 1;
        }
        Color complementaryColor = Color.getHSBColor(complementaryHue, s, b);
        setColor(complementaryColor);
    }


}
