public class AltMaxValue1DArray implements Runnable {
    private Double[] inputArray;
    private Double maxValue;
    private SharedDouble sharedMaxValue;

    public AltMaxValue1DArray(Double[] inputArray, SharedDouble maxValue){
        this.inputArray = inputArray;
        this.maxValue = maxValue.getD();
        this.sharedMaxValue = maxValue;
    }

    public void run(){
        for(int i=1; i<inputArray.length; i++){
            if(inputArray[i]>maxValue){
                sharedMaxValue.setD(inputArray[i]);
            }
        }
    }
}
