package benchmark;

public abstract class Benchmark {
    
    final static String DEFAULT = "Undefined method name";
    
    private static long t_start;
    private static long t_end;
    private static String name;
    
    /**
     * Start benchmark with the method location information to test
     * with the next pattern: Benchmark.start(getClass().getName(),"method name");
     * @param String   Name of class 
     * @param String   Name of method to test.
     */
    public static void start(String className, String methodName){ 
        name = className + "." + methodName;
        t_start = System.currentTimeMillis();
    }
    
    /**
     * Start benchmark without the method location information
     */    
    public static void start(){ 
        name = DEFAULT;
        t_start = System.currentTimeMillis();
    }    
    
    /**
     * Stop benchmark
     */    
    public static void stop(){ 
        t_end = System.currentTimeMillis();
        show();
    }
    
    /**
     * Show benchmark results in system console
     */    
    private static void show() {
        System.out.println("At '" + name + "'. Execution time: " + (t_end-t_start) + " ms");
        name = DEFAULT;
    }
}