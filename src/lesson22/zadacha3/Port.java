package lesson22.zadacha3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by Hello on 29.12.2018.
 */
public class Port {

    private ConcurrentMap<Prichal,Ship> portLoad = new ConcurrentHashMap();
    private List<Prichal> listPrisalov = new ArrayList<>();

    public void addNewPrichal(Prichal prichal){
        listPrisalov.add(prichal);
    }

    public void shipPutPrichal(Prichal prichal,Ship ship){
        System.out.println("Корабль " + ship.getNameShip() + " покинул порт") ;
        portLoad.remove(prichal, ship);
    }

    public void shipTakePrichal(Prichal prichal,Ship ship){
        if (portLoad.isEmpty()){
            prichal.setStatus(true);
            portLoad.putIfAbsent(prichal, ship);
            return;
        }
        int countLockrdPrichal = 0;
        for (Map.Entry<Prichal,Ship> p : portLoad.entrySet()) {
            if (p.getKey().isStatus()){
                countLockrdPrichal++;
                continue;
            }
        }

        if (countLockrdPrichal == portLoad.size()){
            System.out.println("В порту нет свободных причалов, корабль " + ship.getNameShip() + " отправляется стоять на рейде");
            return;
        }
        prichal.setStatus(true);
        portLoad.putIfAbsent(prichal, ship);
    }


    public void showStatusPort(){
        if (portLoad.isEmpty()){
            System.out.println("В порту все причалы свободны");
        } else {
            for (Map.Entry<Prichal,Ship> p : portLoad.entrySet()) {
                System.out.println("Причал № " + p.getKey().getId() + " статус : " +
                        ((p.getKey().isStatus())? "Причал занят": "Причал свободен") +
                        ((p.getValue().equals(null))? "" : " кораблем " + p.getValue().getNameShip()));
            }
        }

    }
}
