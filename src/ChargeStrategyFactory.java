
public class ChargeStrategyFactory {

    public static ChargeStrategy getStrategy(CustomerAccount acc) {
        if(acc instanceof CustomerDepositAccount){
            return new DepositAccountChargeStrategy();
        }

        if(acc instanceof CustomerCurrentAccount){
            return new CurrentAccountChargeStrategy();
        }
        return null;
    }
}