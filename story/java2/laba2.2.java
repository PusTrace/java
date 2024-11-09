public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++){
            for (int j = 4; j > i; j--){
                System.out.print(' ');
                }
            for (int k = (i - 4); k < 0; k++){
                System.out.print('*');
            }
            System.out.println();
        }
    }
}