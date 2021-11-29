import java.util.Random;


public class Puzzle {
    Random randMachine = new Random();

    public void getTenRolls(){
        int[] arr = new int[10];
        for(int i = 0; i<arr.length;i++){
            arr[i]=randMachine.nextInt(20);
            System.out.println(arr[i]);
        }
    }

    public void getRandomLetter(){
        String[] alpha = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        int index = randMachine.nextInt(25);
        System.out.println(alpha[index]);
        }

    public String generatePasswordSet(){
        String[] alpha = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String password = "Your Password is: ";
        for(int i = 0; i<8;i++){
            int index = randMachine.nextInt(25);
            password += alpha[index];
            
        }
        return password;
    }

    public String getNewPasswordSet(int pwLength){
        String[] alpha = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String password = "Your New Password is: ";
        for(int i = 0; i<pwLength;i++){
            int index = randMachine.nextInt(pwLength);
            password += alpha[index];
            
        }
        return password;
    }

}

