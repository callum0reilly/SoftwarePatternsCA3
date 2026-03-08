import javax.swing.*;

public class CurrentAccountInterestStrategy implements InterestStrategy {

    public void applyInterest(CustomerAccount acc, JFrame f)
    {
        String euro = "\u20ac";
        double interest = 0;
        boolean loop = true;

        while(loop)
        {
            String interestString = JOptionPane.showInputDialog(f, "Enter interest percentage you wish to apply: \n NOTE: Please enter a numerical value. (with no percentage sign) \n E.g: If you wish to apply 8% interest, enter '8'");

            if(Menu.isNumeric(interestString))
            {
                interest = Double.parseDouble(interestString);
                loop = false;

                acc.setBalance(acc.getBalance() + (acc.getBalance() * (interest/100)));

                JOptionPane.showMessageDialog(f, interest + "% interest applied. \n new balance = " + acc.getBalance() + euro ,"Success!",  JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(f, "You must enter a numerical value!" ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}