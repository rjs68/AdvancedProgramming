import java.util.concurrent.locks.ReentrantLock;

public class SharedDouble {
    private Double d;
    private ReentrantLock lock = new ReentrantLock();
    public void lock(){
        lock.lock();
    }
    public void unlock(){
        lock.unlock();
    }
    public Double getD() {
        return d;
    }
    public void setD(Double d) {
        this.d = d;
    }
}
