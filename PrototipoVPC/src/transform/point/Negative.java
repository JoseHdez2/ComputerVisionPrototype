package transform.point;

import transform.point.base.AbstractImagePointTransformation;

public class Negative extends AbstractImagePointTransformation{

    @Override
    protected int getVOut(int vIn) {
        return 255 - vIn;
    }

}
