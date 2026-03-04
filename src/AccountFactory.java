import java.util.ArrayList;

public class AccountFactory {

    public static CustomerAccount createAccount(String type, Customer customer, ArrayList<Customer> customerList)
    {
        double balance = 0;
        ArrayList<AccountTransaction> transactionList = new ArrayList<AccountTransaction>();

        if(type.equals("Current Account"))
        {
            boolean valid = true;

            String number = String.valueOf("C" + (customerList.indexOf(customer) + 1) * 10 + (customer.getAccounts().size() + 1));

            int randomPIN = (int)(Math.random() * 9000) + 1000;

            ATMCard atm = new ATMCard(randomPIN, valid);

            CustomerCurrentAccount current = new CustomerCurrentAccount(atm, number, balance, transactionList);

            return current;
        }

        if(type.equals("Deposit Account"))
        {
            double interest = 0;

            String number = String.valueOf("D" + (customerList.indexOf(customer) + 1) * 10 + (customer.getAccounts().size() + 1));

            CustomerDepositAccount deposit = new CustomerDepositAccount(interest, number, balance, transactionList);

            return deposit;
        }

        return null;
    }

    public static int getPin(CustomerAccount acc)
    {
        if(acc instanceof CustomerCurrentAccount)
        {
            return ((CustomerCurrentAccount) acc).getAtm().getPin();
        }

        return -1;
    }
}