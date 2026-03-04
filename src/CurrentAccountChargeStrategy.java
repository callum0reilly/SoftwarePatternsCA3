import javax.swing.*;

public class CurrentAccountChargeStrategy implements ChargeStrategy {

    public void applyCharge(CustomerAccount acc, JFrame f)
    {
        String euro = "\u20ac";

        JOptionPane.showMessageDialog(f, "15" + euro + " current account fee aplied."  ,"",  JOptionPane.INFORMATION_MESSAGE);
        acc.setBalance(acc.getBalance()-25);
        JOptionPane.showMessageDialog(f, "New balance = " + acc.getBalance() ,"Success!",  JOptionPane.INFORMATION_MESSAGE);
    }
}