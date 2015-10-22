package transform;

public class Negative extends AbstractImageTransformation{

    @Override
    protected int getVOut(int vIn) {
        return 255 - vIn;
    }

}
