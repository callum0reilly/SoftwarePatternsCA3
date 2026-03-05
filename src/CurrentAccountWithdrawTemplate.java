import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CurrentAccountWithdrawTemplate extends CurrentAccountTemplateMethod {

    protected void doTransaction(CustomerCurrentAccount acc, JFrame f, Customer e, Menu menu)
    {
        boolean loop = true;
        double withdraw = 0;

        while(loop)
        {
            String balanceTest = JOptionPane.showInputDialog(f, "Enter amount you wish to withdraw (max 500):");
            if(Menu.isNumeric(balanceTest))
            {
                withdraw = Double.parseDouble(balanceTest);
                loop = false;
            }
            else
            {
                JOptionPane.showMessageDialog(f, "You must enter a numerical value!" ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
            }
        }

        if(withdraw > 500)
        {
            JOptionPane.showMessageDialog(f, "500 is the maximum you can withdraw at a time." ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
            withdraw = 0;
        }
        if(withdraw > acc.getBalance())
        {
            JOptionPane.showMessageDialog(f, "Insufficient funds." ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
            withdraw = 0;
        }

        String euro = "\u20ac";
        acc.setBalance(acc.getBalance()-withdraw);

        Date date = new Date();
        String date2 = date.toString();

        String type = "Withdraw";
        double amount = withdraw;

        AccountTransaction transaction = new AccountTransaction(date2, type, amount);
        acc.getTransactionList().add(transaction);

        JOptionPane.showMessageDialog(f, withdraw + euro + " withdrawn." ,"Withdraw",  JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(f, "New balance = " + acc.getBalance() + euro ,"Withdraw",  JOptionPane.INFORMATION_MESSAGE);
    }
}