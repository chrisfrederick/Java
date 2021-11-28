public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app.
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";

        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffee = 4.5;
        double latte = 2.5;
        double cappuccino = 6.5;

        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Chris";
        String customer3 = "Nysha";
        String customer4 = "Harrison";

        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;

        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
        // ** Your customer interaction print statements will go here ** //
        System.out.println(pendingMessage + customer1);

        if(isReadyOrder2){
            System.out.println(readyMessage + customer2);
        }else{
            System.out.println("Your order is not yet ready");
        }

        System.out.println(customer3 + "Order total for two lattes is: " + (latte*2));
        if(isReadyOrder4){
            System.out.println(customer3 + readyMessage + displayTotalMessage + (latte*2));
        }else{
            System.out.println("Your order is not yet ready");
        }

        System.out.println("New total for mixup " + displayTotalMessage + (dripCoffee-latte));
    }
}
