import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SwingCounter extends JFrame implements ActionListener {
    private final JButton startButton, stopButton, resetButton;
    private final JTextField countdown;
    private Counter counter;

    public SwingCounter(){
        super("Swing Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridBagLayout());

        countdown = makeText();
        startButton = makeButton("Start");
        stopButton = makeButton("Stop");
        resetButton = makeButton("Reset");

        stopButton.setEnabled(false);
        resetButton.setEnabled(false);

        pack();
        setVisible(true);
    }

    private JButton makeButton(String buttonLabel){
        JButton button = new JButton(buttonLabel);
        button.setActionCommand(buttonLabel);
        button.addActionListener(this);
        getContentPane().add(button);
        return button;
    }

    private JTextField makeText(){
        JTextField text = new JTextField(10);
        text.setText("10");
        getContentPane().add(text);
        return text;
    }

    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand()=="Start"){
            startButton.setEnabled(false);
            stopButton.setEnabled(true);
            resetButton.setEnabled(false);
            counter = new Counter();
            counter.execute();
        }else if(e.getActionCommand()=="Stop"){
            startButton.setEnabled(true);
            stopButton.setEnabled(false);
            resetButton.setEnabled(true);
            counter.cancel(true);
            counter = null;
        }else if(e.getActionCommand()=="Reset"){
            startButton.setEnabled(true);
            stopButton.setEnabled(false);
            resetButton.setEnabled(false);
            countdown.setText("10");
        }
    }

    public class Counter extends SwingWorker<Void, Integer> {

        protected Void doInBackground() {
            try{
                Integer countValue = Integer.parseInt(countdown.getText());
                while(!isCancelled() && countValue>0){
                    countValue--;
                    publish(countValue);
                    Thread.sleep(1000);
                }
                startButton.setEnabled(false);
                stopButton.setEnabled(false);
                resetButton.setEnabled(true);
            }catch(Exception e){
            }
            return null;
        }

        protected void process(List<Integer> countValues) {
            int lastValue = countValues.get(countValues.size()-1);
            countdown.setText(String.valueOf(lastValue));
        }
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SwingCounter();
            }
        });
    }
}
