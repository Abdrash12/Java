public class Bankingdemo {
    public static void main(String[]args){
        double balance = 1000;
        System.out.println("Initial Balance: "+balance);
        balance = deposit(balance,500);
        System.out.println("Balance after deposit: "+balance);
        balance  = withdraw(balance, 2000);
        System.out.println("Balance(Final): "+balance);
    }




        public static double deposit(double balance, double amount){
            System.out.println("Depositing: "+amount);
            balance+=amount;
            return balance;
        }
        public static double withdraw(double balance, double amount){
            System.out.println("Withdrawing: "+ amount);
            if (amount > balance){
                System.out.println("Insufficient Funds");
                return balance;
            }
            else{
                balance-=amount;
                return balance;
            }
        }
        
    }
    

