import javax.swing.*;
public class Main {
    public static class saleTaxCalculator extends JFrame {
        private final   int WIDTH = 300;
        private final   int LENGTH = 300;
        private CalculatorPanel calculator;
        public saleTaxCalculator(){
            setTitle("Sale Tax Calculator");
            setSize(WIDTH,LENGTH);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             calculator = new CalculatorPanel();

            add(calculator);
            setVisible(true);
        }
    }
    public static void main(String[] args) {
        new saleTaxCalculator();
    }
}