package lesson22.zadacha2;

import java.util.concurrent.*;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Hello on 18.12.2018.
 */
public class Carteen {

    private BlockingQueue<String> orderQueue = new LinkedBlockingQueue<String>(3);
    private BlockingQueue<String> waitOrderQueue = new LinkedBlockingQueue<String>(3);
    private BlockingQueue<String> readyOrderQueue = new LinkedBlockingQueue<String>(3);

    public Carteen() {
        for (int i = 1; i <= 5; i++) {
            new Thread(new Client()).start();
        }
        new Thread(new Cooker()).start();
        new Thread(new Waiter()).start();

    }

    class Client implements Runnable{

        @Override
        public void run() {
            try {
                orderQueue.put("блюдо что закал клиент - " + Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getName() + " сделал заказ");
                while (readyOrderQueue.take().endsWith("ГОТОВО")){
                    System.out.println(Thread.currentThread().getName() + " получил свой заказ");
                    break;
                }
                System.out.println("/----------------/");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class Waiter implements Runnable{

        @Override
        public void run() {
            try {
                String order;
                if (orderQueue.isEmpty()){
                    Thread.sleep(1000);
                }
                while (!orderQueue.isEmpty()){
                    order = orderQueue.take();
                    System.out.println("Официант взял заказ на " + order);
                    System.out.println("Колличество заказов у официанта  - " + orderQueue.size() );
                    waitOrderQueue.put(order);
                    System.out.println("Официант передал заказ на кухню");
                    System.out.println("Колличество заказов на кухне  - " + waitOrderQueue.size() );
                    System.out.println("/----------------/");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class Cooker implements Runnable{

        @Override
        public void run() {
            try {
                String takeOrder;
                if (waitOrderQueue.isEmpty()){
                    Thread.sleep(1000);
                }
                while (waitOrderQueue.size() > 0 || !orderQueue.isEmpty()){
                    takeOrder = waitOrderQueue.take();
                    System.out.println("Повар начал готовить " + takeOrder);
                    readyOrderQueue.put(takeOrder + "ГОТОВО");
                    System.out.println("Повар приготовил " + takeOrder);
                    System.out.println("/----------------/");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
