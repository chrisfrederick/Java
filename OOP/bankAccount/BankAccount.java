

public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    static int numberOfAccounts;
    static double totalAccountAmount;

    public BankAccount(){
        numberOfAccounts++;
    }

    public double totalAmount(){
        double total = checkingBalance+savingsBalance;
        return total;
    }

    public double getCheckingBalance(){
        return checkingBalance;
    }

    public double getSavingsBalance(){
        return savingsBalance;
    }

    public void setCheckingBalance(double checkingBalance){
        this.checkingBalance = checkingBalance;
    }

    public void setSavingsBalance(double savingsBalance){
        this.savingsBalance = savingsBalance;
    }

    public String depositChecking(double depositAmount){
       this.setCheckingBalance(depositAmount+getCheckingBalance());
       totalAccountAmount+=depositAmount;
        return "you deposited: $" + depositAmount + " Your chekcking balance is: $"+ this.getCheckingBalance();

    }

    public String withdrawChecking(double withdrawAmount){
        
        if(checkingBalance < withdrawAmount){
            return"Insufficient Funds";
        }else{
            this.setCheckingBalance(getCheckingBalance()-withdrawAmount);
            return"You have made a withdaral of: $"+withdrawAmount+"Your Balance is now: $"+getCheckingBalance();
        }
    }

    public String netWorth(){
        double total = this.getCheckingBalance()+this.getSavingsBalance();
        return "Your net worth is: $"+total;
    }
}
