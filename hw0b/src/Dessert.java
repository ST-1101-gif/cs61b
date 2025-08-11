public class Dessert {
    public int flavor;
    public int price;
    public static int numDesserts;

    public Dessert(int f, int p){
        flavor = f;
        price = p;
        Dessert.numDesserts++;
    }

    public void printDessert(){
        System.out.print(flavor + " " + price + " " + Dessert.numDesserts);
    }

    public static void main(String[] args){
        System.out.print("I love dessert!");
    }
}
