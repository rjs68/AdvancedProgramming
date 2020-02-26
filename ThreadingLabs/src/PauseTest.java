public class PauseTest {
    public static void main(String[] args){
        Pause pause = new Pause();
        Thread thread = new Thread(pause);
        thread.start();
    }
}
