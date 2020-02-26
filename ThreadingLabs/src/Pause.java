import java.util.Random;

public class Pause implements Runnable{
    private int pause;

    public Pause(){
        Random rand = new Random();
        pause = rand.nextInt(5);
    }

    public void run(){
        System.out.println("Pausing for " + pause + " seconds");
        try {
            Thread.sleep(pause*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("Now we're ready to go boiiiii");
        }
    }
}
