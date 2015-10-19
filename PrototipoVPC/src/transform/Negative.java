package transform;

import gui.utils.NamedImage;

public class Negative extends AbstractImageTransformation{

    // TODO: Deberia de ser un override, pero el IDE no lo pilla.
    protected static int getVOut(int vIn, NamedImage img) {
        return 255 - vIn;
    }

}
