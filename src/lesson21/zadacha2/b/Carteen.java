package lesson21.zadacha2.b;

/**
 * Created by Hello on 15.12.2018.
 */
public class Carteen {

    private boolean  order = false;
    private boolean statusWaiter = false;
    private boolean statusCooker = false;

    public synchronized void makeOrder(){

        while (order){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (statusCooker){
            System.out.println("Повар отдает блюдо клиенту");
            statusCooker = false;
        }else {
            System.out.println("Пришел клиент");
            order = true;
            System.out.println("Клиент сделал заказ");
            statusWaiter = true;
            System.out.println("Клиент ждет официанта");
        }
        notifyAll();
    }

    public synchronized void takeOrder(){
        while (!statusWaiter){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Пришел официант и взял заказ");
        statusCooker = true;
        System.out.println("Официант отнес заказ повару");
        System.out.println("Официант ушел ждать новую прихоть клиента");
        statusWaiter = false;

        notifyAll();
    }

    public synchronized void doOrder(){
        while (!statusCooker){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Повар приготовил блюдо");
        order = false;
        makeOrder();
        notifyAll();
    }
}

class Client implements Runnable{

    private Carteen carteen;

    public Client(Carteen carteen) {
        this.carteen = carteen;
    }

    @Override
    public void run() {
        carteen.makeOrder();
    }
}

class Waiter implements Runnable{

    private Carteen carteen;

    public Waiter(Carteen carteen) {
        this.carteen = carteen;
    }

    @Override
    public void run() {
        carteen.takeOrder();
    }
}

class Cooker implements Runnable{

    private Carteen carteen;

    public Cooker(Carteen carteen) {
        this.carteen = carteen;
    }

    @Override
    public void run() {
        carteen.doOrder();
    }
}
