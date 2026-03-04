import javax.swing.*;

public class DepositAccountChargeStrategy implements ChargeStrategy {

    public void applyCharge(CustomerAccount acc, JFrame f)
    {
        String euro = "\u20ac";

        JOptionPane.showMessageDialog(f, "25" + euro + " deposit account fee aplied."  ,"",  JOptionPane.INFORMATION_MESSAGE);
        acc.setBalance(acc.getBalance()-25);
        JOptionPane.showMessageDialog(f, "New balance = " + acc.getBalance() ,"Success!",  JOptionPane.INFORMATION_MESSAGE);
    }
}