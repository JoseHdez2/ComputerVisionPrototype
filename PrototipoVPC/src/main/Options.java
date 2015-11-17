package main;

/**
 *  Models user options. The user's preferences as to how the program should behave.
 */
public class Options {

    // Whether image transformations will write over the source image.
    boolean overwrite = false;

    /*
     * Getters and setters.
     */
    
    public boolean isOverwrite() {
        return overwrite;
    }

    public void setOverwrite(boolean overwrite) {
        this.overwrite = overwrite;
    }
    
}
