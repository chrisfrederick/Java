public class Main {
    public static void main(String[] args){
        Puzzle puzzle = new Puzzle();

        // puzzle.getTenRolls();
        // puzzle.getRandomLetter();
        String password = puzzle.generatePasswordSet();
        System.out.println(password);

        String passwordSet = puzzle.getNewPasswordSet(3);
        System.out.println(passwordSet);
    }
}
