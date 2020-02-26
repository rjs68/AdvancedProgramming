public class AltSharedDouble {
    private Double d;
    public AltSharedDouble(){
        d = 0.0;
    }
    public Double getD() {
        return d;
    }
    public synchronized void compare(Double a) {
        if(a > d) {
            try {
                Thread.sleep(1);
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
            d = a;
        }
    }
}
