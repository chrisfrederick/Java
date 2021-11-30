

public class Main {
    public static void main(String[] args){
        BankAccount bankAccount = new BankAccount();

        String deposit = bankAccount.depositChecking(150.30);
        String withdaw = bankAccount.withdrawChecking(30);
        String netWorth = bankAccount.netWorth();

        System.out.println(deposit);
        System.out.println(withdaw);
        System.out.println(netWorth);






    }
}
