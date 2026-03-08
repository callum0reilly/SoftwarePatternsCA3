
public class InterestStrategyFactory {

    public static InterestStrategy getStrategy(CustomerAccount acc)
    {
        if(acc instanceof CustomerDepositAccount) {
            return new DepositAccountInterestStrategy();
        }
        if(acc instanceof CustomerCurrentAccount)
        {
            return new CurrentAccountInterestStrategy();
        }
        return null;
    }
}