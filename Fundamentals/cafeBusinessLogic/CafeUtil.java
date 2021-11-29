import java.util.ArrayList;

public class CafeUtil{

    public int getStreakGoal(){
        int sum = 0;
        for(int i = 0; i<11;i++){
            sum+=i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices){
        double sum = 0;
        for(int i = 0; i<prices.length;i++){
            sum+=prices[i];
        }
        return sum;
    }

    public void displayMenu(ArrayList<String> menuItems){
        for(int i = 0;i<menuItems.size();i++){
            int index = i;
            System.out.println(index +" "+ menuItems.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers){
        System.out.println("Enter your name: ");
        String userName = System.console().readLine();
        System.out.println("Greetings: " + userName);
        System.out.printf("There are %s people before you", customers.size());
        customers.add(userName);
    }





}