package lesson21.zadacha1;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Hello on 13.12.2018.
 */
public class Storage {

    private  List<String> listWord;
    private Map<String,Integer> mapCommon = new TreeMap<>();


    public  synchronized void findTopWord(int begin, int finish) {
        //----------------------
        if ( mapCommon.isEmpty()){
            for (int i = 0; i < listWord.size(); i++) {
                mapCommon.put(listWord.get(i), 0);
            }
        }
        Map<String,Integer> mapThread = new HashMap<>();
        //----------------------
        for (int i = begin; i < finish; i++) {
            mapThread.put(listWord.get(i),0);
        }
        //----------------------
        for (int i = begin; i < finish; i++) {
            for (Map.Entry<String,Integer> map: mapThread.entrySet()) {
                if (map.getKey().toLowerCase().equals(listWord.get(i))){
                    map.setValue(map.getValue() + 1);
                }
            }
        }
        //----------------------
        for (Map.Entry<String,Integer> mapTh: mapThread.entrySet()) {
            for (Map.Entry<String,Integer> mapCom: mapCommon.entrySet()) {
                if (mapCom.getKey().toLowerCase().equals(mapTh.getKey())){
                    mapCom.setValue(mapCom.getValue() + mapTh.getValue());
                }
            }
        }
    }

    public void printTop100 (){
        if (mapCommon.isEmpty()){
            System.out.println("Общий список пуст");
        } else {
            mapCommon.entrySet().stream().
                    sorted(Map.Entry.<String,Integer>comparingByValue().reversed()).
                    limit(100).forEach(System.out::println);
        }
    }

    public void setListWord( List<String> listWord) {
        this.listWord = listWord;
    }

    public List<String> getListWord() {
        return listWord;
    }


}
