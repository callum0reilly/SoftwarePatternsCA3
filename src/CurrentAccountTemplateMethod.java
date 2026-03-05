import javax.swing.JFrame;
import javax.swing.JOptionPane;

public abstract class CurrentAccountTemplateMethod {

    public final void execute(CustomerCurrentAccount acc, JFrame f, Customer e, Menu menu)
    {
        boolean ok = checkPin(acc, f, e, menu);

        if(ok)
        {
            doTransaction(acc, f, e, menu);
        }
    }

    private boolean checkPin(CustomerCurrentAccount acc, JFrame f, Customer e, Menu menu)
    {
        int count = 3;
        int checkPin = acc.getAtm().getPin();
        boolean loop = true;

        while(loop)
        {
            if(count == 0)
            {
                JOptionPane.showMessageDialog(f, "Pin entered incorrectly 3 times. ATM card locked."  ,"Pin",  JOptionPane.INFORMATION_MESSAGE);
                acc.getAtm().setValid(false);
                menu.customer(e);
                return false;
            }

            String Pin = JOptionPane.showInputDialog(f, "Enter 4 digit PIN;");
            int i = Integer.parseInt(Pin);

            if(checkPin == i)
            {
                loop = false;
                JOptionPane.showMessageDialog(f, "Pin entry successful" ,  "Pin", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
            else
            {
                count --;
                JOptionPane.showMessageDialog(f, "Incorrect pin. " + count + " attempts remaining."  ,"Pin",  JOptionPane.INFORMATION_MESSAGE);
            }
        }

        return false;
    }

    protected abstract void doTransaction(CustomerCurrentAccount acc, JFrame f, Customer e, Menu menu);

}