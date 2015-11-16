package transform.point;

import transform.point.base.ThreeChannelAIPT;

public class Negative extends ThreeChannelAIPT{

    @Override
    protected int getVOut(int vIn) {
        // Return the opposite value of the channel.
        return 255 - vIn;
    }

}
