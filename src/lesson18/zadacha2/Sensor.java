package lesson18.zadacha2;



import java.util.*;

/**
 * Created by Hello on 06.12.2018.
 */
public class Sensor {

    private List<Alarm> alarmList = new ArrayList<>();

    public void addListenerAlarm(Alarm listenerAlarm){
        alarmList.add(listenerAlarm);
    }

    public  void notifyListenerAlarm(int temp){
        for (Alarm listener: alarmList) {
            listener.tempChanged(temp);
        }
    }

    public static void start(){
        Sensor sensor = new Sensor();

        sensor.addListenerAlarm(new Alarm() {
            @Override
            public void tempChanged(int temp) {
                if (temp == 100 ) System.out.println( temp + " градусов - Green");
            }
        });

        sensor.addListenerAlarm(new Alarm() {
            @Override
            public void tempChanged(int temp) {
                if (temp == 300) System.out.println(temp + " градусов - Green, Yellow");
            }
        });

        sensor.addListenerAlarm(new Alarm() {
            @Override
            public void tempChanged(int temp) {
                if (temp == 600) System.out.println(temp + " градусов - Green, Yellow, Red");
            }
        });

        for (int i = 0; i < 700; i++) {
            if (i%10 == 0) System.out.println("Teмпература - " + i);
            sensor.notifyListenerAlarm(i);

            // на случайной значении температура пойдет вниз на 50 градусов
            // шанс что температура упадет выпадает каждые 10 градусов
            int fortuna =(int) (Math.random()*10);
            if (i%10== 0 && fortuna == 5){
                int tempStop = i;
                for (int j = i; j > i - 50 ; j--) {
                    if (j%10 == 0) System.out.println("Teмпература - " + j);
                    sensor.notifyListenerAlarm(j);
                }
                i = tempStop - 50;
            }
        }
    }

    public static void main(String[] args) {
        start();
    }


}
