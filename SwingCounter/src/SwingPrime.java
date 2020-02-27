import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SwingPrime extends JFrame implements ActionListener {
    private final JTextArea primeNumbers;
    private final JButton startButton, stopButton, resetButton;
    private PrimeWorker worker;

    public SwingPrime(){
        super("Swing Prime");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridBagLayout());

        startButton = makeButton("Start");
        stopButton = makeButton("Stop");
        resetButton = makeButton("Reset");
        primeNumbers = makeTextArea();

        pack();
        setVisible(true);
    }

    private JTextArea makeTextArea(){
        JTextArea text = new JTextArea(20, 10);
        getContentPane().add(text);
        return text;
    }

    public void addText(String nextLine){
        String newText = primeNumbers.getText() + nextLine + "\n";
        primeNumbers.setText(newText);
    }

    private JButton makeButton(String command){
        JButton button = new JButton(command);
        button.setActionCommand(command);
        button.addActionListener(this);
        getContentPane().add(button);
        return button;
    }

    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand()=="Start"){
            worker = new PrimeWorker();
            worker.execute();
        }else if(e.getActionCommand()=="Stop"){
            worker.cancel(true);
        }else if(e.getActionCommand()=="Reset"){
            primeNumbers.setText("");
        }
    }

    public class PrimeWorker extends SwingWorker<Void, Integer>{
        public Void doInBackground(){
            try{
                int number = 0;
                while(!isCancelled()){
                    while(!isPrime(number)){
                        number++;
                    }
                    publish(number);
                    number++;
                    Thread.sleep(1000);
                }
            }catch(Exception e){

            }
            return null;
        }

        private int counter = 1;
        protected void process(List<Integer> primeNumbers){
            String newLine = String.format("%d: %d", counter, primeNumbers.get(primeNumbers.size()-1));
            addText(newLine);
            counter++;
        }
    }

    private boolean isPrime(int number){
        if(number == 0 || number == 1){
            return false;
        }
        for(int i=2; i<=(number/2); i++){
            if(number%i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        new SwingPrime();
                    }
                }
        );
    }
}
