public class Main {
    public static void main(String[] args) {
        Fridge fridge = new Fridge();
        fridge.addProduct("Банан", 200);
        fridge.addProduct("Масло", 500);
        fridge.addProduct("Банан", 400);
        fridge.addProduct("Йогурт", 150);
        fridge.addProduct("Колбаса", 1000);
        fridge.addProduct("Яблоко", 250);

        //g
        fridge.printAllProductsByNameFromZtoA();
        System.out.println();

        // b
        fridge.takeProduct("Банан", 300);
        fridge.takeProduct("Банан", 300);
        fridge.takeProduct("Йогурт", 250);
        System.out.println();

        //c
        fridge.printTotalWeight();
        System.out.println();

        //d
        fridge.printWight("Яблоко");
        System.out.println();

        //e + f
        System.out.println("Данной продукт скоро закончится - " + fridge.printProductWithMinWeight());
        System.out.println("Данной продукта больше всего - " + fridge.printProductWithMaxWeight());
        System.out.println();

        //h
        fridge.printAllProductsByWightFromMaxToMin();
    }
}