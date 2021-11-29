public class CafeUtil {

    public void getStreakGoal(){
        int sum = 0;
        int[] streak = new int[10];
        for(int i=0; i<streak.length; i++){
            streak[i] = i;
            sum = i;
            return sum;
        }
    }

    public double getOrderTotal(double[] prices){
        double temp = 0.0;
        for(int i = 0; i<prices.length; i++){
            temp += i;
        }
        return temp;
    }

    public void displayMenu(){

    }
}
