import java.util.Random;

public class PauseExtendTest {
    private static class PauseExtend extends Thread{
        private int pause;
        private String name;

        public PauseExtend(int i){
            this.name = "Thread " + i;
            Random rand = new Random();
            pause = rand.nextInt(5);
        }

        public void run(){
            System.out.println(name + " is pausing for " + pause + " seconds");
            try {
                Thread.sleep(pause*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println(name + " is ready to go!");
            }
        }
    }

    public static void main(String args[]) {
        PauseExtend[] pauses = new PauseExtend[10];
        for(int i=0; i<pauses.length; i++){
            pauses[i] = new PauseExtend(i+1);
            pauses[i].start();
        }
        for(int i=0; i<pauses.length; i++){
            try {
                pauses[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("All the threads have finished!");
    }
}
