import java.util.concurrent.locks.ReentrantLock;

public class MaxFinder {
    public static void main(String[] args){
        Double[][] randArray = createArray();
        Double maxValue = randArray[0][0];
        for(int i=0; i<100; i++){
            for(int j=0; j<50; j++){
                if(randArray[i][j] > maxValue){
                    maxValue = randArray[i][j];
                }
            }
        }
        System.out.println("The max value is: " + maxValue);

        Double[] maxValues = new Double[100];
        Thread[] maxValueThreads = new Thread[100];

        for(int i=0; i<100; i++) {
            maxValueThreads[i] = new Thread(new MaxValue1DArray(randArray[i], maxValues, i));
            maxValueThreads[i].start();
        }
        for(int i=0; i<100; i++){
            try {
                maxValueThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Double[] myMaxValue = new Double[1];
        Thread maxValueThread = new Thread(new MaxValue1DArray(maxValues, myMaxValue, 0));
        maxValueThread.start();
        try {
            maxValueThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("I got the max value as: " + myMaxValue[0]);

        SharedDouble myAltMaxValue = new SharedDouble();
        myAltMaxValue.setD(0.0);
        Thread[] maxAltValueThreads = new Thread[100];

        for(int i=0; i<100; i++) {
            maxAltValueThreads[i] = new Thread(new AltMaxValue1DArray(randArray[i], myAltMaxValue));
            maxAltValueThreads[i].start();
        }
        for(int i=0; i<100; i++){
            try {
                maxAltValueThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("But I got the max value as: " + myAltMaxValue.getD());

        AltSharedDouble myAltAltMaxValue = new AltSharedDouble();
        maxAltValueThreads = new Thread[100];

        for(int i=0; i<100; i++) {
            maxAltValueThreads[i] = new Thread(new NewAltMaxValue1DArray(randArray[i], myAltAltMaxValue));
            maxAltValueThreads[i].start();
        }
        for(int i=0; i<100; i++){
            try {
                maxAltValueThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("And I got the max value as: " + myAltAltMaxValue.getD());
    }

    private static Double[][] createArray(){
        int nRows = 100;
        int nCols = 50;
        Double[][] randArray = new Double[nRows][nCols];
        for(int r=0;r<nRows;r++) {
            for (int c = 0; c < nCols; c++) {
                randArray[r][c] = Math.random();
            }
        }
        return randArray;
    }
}
