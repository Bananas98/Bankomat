import java.util.ArrayList;
import java.util.Scanner;

public class Bankomat {
    public static void main(String[] args) {
        int money,input;
        Soft bank = new Soft();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("нажмите 1 если хотите пополнить счет");
            System.out.println("нажмите 2 если хотите снять наличные");
            System.out.println("нажмите 3 для возврата карты");

            input = scanner.nextInt();

            if (input == 1) {
                System.out.println("введите сумму  на которую хотите пополнить счет");
                money = scanner.nextInt();
                bank.setCash(money);
            } else if (input == 2) {
                System.out.println("введите сумму которую хотите снять");
                int put = scanner.nextInt();
                bank.getCash(put);
            } else if (input == 3) {
                System.out.println("заберите карту");
                System.exit(0);
            } else {
                System.out.println("некоректная опция");
            }
        }
    }
}

class Soft{
     private int cash;
     private int total;
     ArrayList<Integer> mycash = new ArrayList<Integer>();

    public void setCash(int cash){
        if (cash <= 0){
            System.out.println("недоступна операция");
        }
        else{
            this.cash = cash;
            mycash.add(cash);
            total = 0;
            for (int i = 0; i < mycash.size();i++){
                total = total + mycash.get(i);
            }
            System.out.println("на счете  " + total +" грн");
        }
    }
    public void getCash(int cash){
        total=0;
        for (int i = 0; i < mycash.size();i++){
            total = total +mycash.get(i);
        }
        if (cash>total){
            System.out.println("недостатоно средств на счете");
        }
        else{
            mycash.clear();
            mycash.add(total-cash);
            total = 0;
            for (int i = 0; i < mycash.size();i++) {
                total = total + mycash.get(i);
            }
            System.out.println("остаток на счете " + total+ "грн");
        }
    }
}

