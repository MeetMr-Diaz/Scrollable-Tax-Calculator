import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
public class CalculatorPanel extends JPanel {
    private JPanel panel1,panel2;
    private JLabel label1,label2,label3,label4;
    private JTextField text1,text2,text3;
    private JSlider slider;
    private double tax;;
    public CalculatorPanel(){
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel1.setLayout(new GridLayout(5,2));

        label1 = new JLabel("Enter price amount  $");
        text1 = new JTextField(5);
        text1.addActionListener(new priceListener());

        panel1.add(label1);
        panel1.add(text1);

        label2 = new JLabel("Sale tax %");
        text2 = new JTextField("",5);
        text2.setEditable(false);
        panel1.add(label2);
        panel1.add(text2);

        label3 = new JLabel("Total Sale $");
        text3 = new JTextField("",5);
        text3.setEditable(false);
        panel1.add(label3);
        panel1.add(text3);

        slider = new JSlider(JSlider.HORIZONTAL,0,10,0);
        slider.setMajorTickSpacing(1);
        slider.setPaintLabels(true);
        slider.addChangeListener(new SliderListener());
        panel2.add(slider);

        add(panel1);
        add(panel2);
    }
    private class SliderListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {

            DecimalFormat format = new DecimalFormat("0.00");
            tax = slider.getValue();
            text2.setText( Double.toString(tax));

            //lookup for a way to update as slider is move,
            text1.getActionListeners()[0].actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
        }
    }
    private class priceListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            double price, finalPrice;
            DecimalFormat format = new DecimalFormat("0.00");
            price = Double.parseDouble(text1.getText());
            finalPrice = price+(price*(tax/100));
            text3.setText(Double.toString(finalPrice));
        }
    }
}
