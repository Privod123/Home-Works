package lessons11.zadachiSyntax.zadacha2;

/**
 * Created by Hello on 19.11.2018.
 */
public class Cat {

    private String name;
    private int age;
    private int weight;
    private int strength;

    public Cat(String name, int age, int weight, int strength) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.strength = strength;
    }

    public boolean fight(Cat anotherCat){
        int victoriThisCat = 0;
        int victoriAnotherCat = 0;
        // ----------------------------------
        if (this.age > anotherCat.age){
            victoriThisCat ++;
        }else {
            victoriAnotherCat ++;
        }
        if ((this.age > 3 && this.age < 7) && (anotherCat.age < 3 || anotherCat.age > 7)){
            victoriThisCat++;
        }else if ((this.age < 3 || this.age > 7) && (anotherCat.age > 3 && anotherCat.age < 7)){
            victoriAnotherCat++;
        }
        // ----------------------------------
        if (this.strength > anotherCat.strength){
            victoriThisCat++;
        }
        // ----------------------------------
        if (this.weight > anotherCat.weight*1.2){
            victoriThisCat++;
        }else if (this.weight > anotherCat.weight*2){
            victoriAnotherCat++;
        }
        return victoriThisCat > victoriAnotherCat ? true : false;
    }
}
