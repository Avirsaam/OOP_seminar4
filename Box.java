package seminar04.homework;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Box <F extends Fruit> implements Comparable {

    private List<F> fruits;

    Box(){
        fruits = new ArrayList<F>();
    }

    /**
     * @retun возвращает вес коробки
     */
    public float getWeight(){
        if (fruits.size() == 0)
            return 0;
        else {
            return fruits.get(0).getWeight() * fruits.size();
        }
    }

    /**
     * @return возвращает количество фруктов в коробке
     */
    public int getFruitsQuantity(){
        return fruits.size();
    }

    /**
     * @return возвращает объект вытащенный из этой коробки
     */
    public F takeOutFruit(){
        if (fruits.size() > 0) {
            F result = fruits.get(fruits.size() - 1);
            fruits.remove(fruits.size() - 1);
            return result;
        }
        return null;
    }

    /**
     * перемещает указанное количество фруктов из одной коробки в
     * другую коробку с фруктами данного типа.
     * @return возвращает true если транзакция совершилась успешно
     *          и false, если иначе
     */
    public boolean transferFruitsTo(Box <F> otherBox, int quantity){
        if (this.getFruitsQuantity() < quantity) return false;
        else {
            for (int i = 0; i < quantity; i++) {
                otherBox.addFruit(this.takeOutFruit());
            }
        }
        return true;
    }

    /**
     * добавляет один фрукт указанного типа в коробку
     */
    public void addFruit(F fruit){
        if (fruits.size() == 0 || fruit.getClass().equals(fruits.get(0).getClass())) {
            fruits.add(fruit);
        } else {
            //Если обявлять Box<Apple> box = new Box(); то проверка типа класс добавляемого фрукта вроде как и не нужна,
            //компилятор выдает ошибку при попытке добавить Orange в ящик в котором уже Apples.
            // но ящик можно объявить и вот так: Box box = new Box(); т.е. без указания типа вообще
            // и тогда в этот ящик можно добавить различные любые объекты наследумемые от Fruit,
            // и он их будет содержать одновременно. - **задать вопрос почему так.**
            throw new InputMismatchException();
        }
    }

    /**
     * добавляет несколько фруктов указанного типа в коробку
     */
    public void addFruit(F fruit, int quantity){
        for (int i = 0; i < quantity; i++) {
            addFruit(fruit);
        }
    }

    @Override
    public String toString() {
        if (fruits.size() == 0)
            return "Пустая коробка";
        else {
            return String.format("Коробка с %s, вес %.1f", fruits.get(0).getClass().getSimpleName(), getWeight());
        }
    }

    //как в требовании к заданию, достоинство, что нет
    //необходимости делать downcasting из Object в Box
    public boolean compare(Box other) {
        return this.getWeight() == other.getWeight() ? true : false;
    }

    //методы реализованы для имплементации интерфесa Comparable
    @Override
    public boolean equals(Object obj) {
        Box other = (Box)obj;
        return this.getWeight() == other.getWeight() ? true : false;
    }

    @Override
    public int compareTo(Object o) {
        Box other = (Box) o;
        return this.getWeight() == other.getWeight() ? 0 :
                this.getWeight() > other.getWeight() ? 1 : -1;
    }
}
