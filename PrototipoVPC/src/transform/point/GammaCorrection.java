package transform.point;

import transform.point.base.ThreeChannelAIPT;

public class GammaCorrection extends ThreeChannelAIPT {

    public GammaCorrection(float gamma){
        
    }
    
    /*
     * 
     * a = Vin / 255 (saldra entre 0,1)
     * b = a ** gamma (gamma entre 0,1, b sera entre 0,1)
     * Vout = b * 255 (acordarse de redondear, no truncar)
     * 
     */
    
    @Override
    protected int getVOut(int vIn) {
        // TODO Auto-generated method stub
        return 0;
    }

}
