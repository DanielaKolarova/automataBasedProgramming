import java.util.function.Supplier;

// source: http://arhipov.blogspot.ru/2014/02/java-8-lambdas-unintentional-puzzle.html
public class Puzzler {
    public Runnable wrooom(){
        return () -> { System.out.println("Hello, lambda!"); };
    }

    public static void main(String[] args) {
        Runnable runnable = new Puzzler().wrooom();
        runnable.run(); // print "Hello, lambda!"

        Runnable runnable2 = new Puzzler()::wrooom;
        runnable2.run(); // print nothing
        
        Wroom w = new Puzzler()::wrooom;
        w.wrom().run();
        
        Supplier<Runnable> s = new Puzzler()::wrooom;
        s.get().run();
    }
    
    @FunctionalInterface
    private interface Wroom {
    	
    	Runnable wrom();
    }
}