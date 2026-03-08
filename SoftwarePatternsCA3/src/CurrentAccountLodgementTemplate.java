import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CurrentAccountLodgementTemplate extends CurrentAccountTemplateMethod {

    protected void doTransaction(CustomerCurrentAccount acc, JFrame f, Customer e, Menu menu)
    {
        boolean loop = true;
        double balance = 0;

        while(loop)
        {
            String balanceTest = JOptionPane.showInputDialog(f, "Enter amount you wish to lodge:");
            if(Menu.isNumeric(balanceTest))
            {
                balance = Double.parseDouble(balanceTest);
                loop = false;
            }
            else
            {
                JOptionPane.showMessageDialog(f, "You must enter a numerical value!" ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
            }
        }

        String euro = "\u20ac";
        acc.setBalance(acc.getBalance() + balance);
        Date date = new Date();
        String date2 = date.toString();
        String type = "Lodgement";
        double amount = balance;

        AccountTransaction transaction = new AccountTransaction(date2, type, amount);
        acc.getTransactionList().add(transaction);

        JOptionPane.showMessageDialog(f, balance + euro + " added do you account!" ,"Lodgement",  JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(f, "New balance = " + acc.getBalance() + euro ,"Lodgement",  JOptionPane.INFORMATION_MESSAGE);
    }
}