package transform.point;

import transform.point.base.ThreeChannelAIPT;

public class GammaCorrection extends ThreeChannelAIPT {

    float gamma;
    
    public GammaCorrection(float gamma){
        this.gamma = gamma;
    }
    
    @Override
    protected int getVOut(int vIn) {
        float a = vIn / 255;
        // saldra entre 0 y 1
        
        double b = Math.pow(a, gamma);
        // como gamma entre 0,1; b sera entre 0,1 tambien
        
        return (int) Math.round(b * 255);
    }

}
