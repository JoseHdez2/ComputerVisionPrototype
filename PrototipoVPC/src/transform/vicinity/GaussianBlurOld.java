package transform.vicinity;

import java.util.ArrayList;

import gui.utils.image.NamedImage;
import transform.vicinity.base.AbstractLinearFilter;
import transform.vicinity.base.Kernel;

public class GaussianBlurOld extends AbstractLinearFilter{
    
    public GaussianBlurOld(NamedImage img){
        
    }
    
    @Override
    protected Kernel createKernel() {
        
        ArrayList<ArrayList<Float>> someData = new ArrayList<ArrayList<Float>>();
        
        int x = 0;
        while(x){
            int y = 0;
            while(y){
                float value = (Math.pow(x, 2) + Math.pow(y, 2));
                y++;
            }
            x++;
        }
        
        // We build the gaussian kernel depending on the size given.
        for(int x= halfKernel; x < kerSize; x++){
            while()
            for(int y= 0; y < kerSize; y++){
                // Calculate kernel element value
                int value = (int)(Math.pow(x, 2) + Math.pow(y, 2));
                // Since gaussian is symmetrical, we repeat value for the four quadrants.
                data[halfKernel - x][halfKernel - y] = value;
                data[halfKernel - x][halfKernel + y] = value;
                data[halfKernel + x][halfKernel - y] = value;
                data[halfKernel + x][halfKernel + y] = value;
            }
        }
        
        
        
        float data[][] = new float[someData.size()][someData.size()];
        
        Kernel kernel = new Kernel(data);
        return kernel;
    }

}
