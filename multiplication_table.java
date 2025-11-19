public class multiplication_table {
    public static void main(String[]args){
        int num = 5;

        for (int i = 1; i<=10; i++){
            System.out.println(num+"X"+i+"="+(num*i));
        }

        switch(num){
            case 2:
            case 5:
            case 10:
                System.out.println("Status: Special Table");
                break;
            default:
                System.out.println("Status: Normal Table");

        }
    }
    
}
