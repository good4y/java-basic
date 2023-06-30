package chap8;

import java.util.ArrayList;
import java.util.Arrays;

record GroceryItem(String name, String type, int count){
    public GroceryItem(String name) {
        this(name, "DIARY", 1);
    }

    @Override
    public String toString() {
        return String.format("%d %s in %s", count, name.toUpperCase(), type);
    }
}
public class ArrayLists {
    public static void main(String[] args) {

        GroceryItem[] groceryArray = new GroceryItem[3];
        groceryArray[0] = new GroceryItem("Milk");
        groceryArray[1] = new GroceryItem("Eggs", "PRODUCE", 6);
        groceryArray[2] = new GroceryItem("Oranges", "PRODUCE", 5);
        System.out.println(Arrays.toString(groceryArray));

        // 타입을 지정하지 않으면 Object 타입의 ArrayList가 된다.
        ArrayList objectList = new ArrayList();
        objectList.add(new GroceryItem("Milk"));
        objectList.add("Yogurt");

        // 타입 추론 (다이아몬드 연산자)
        ArrayList<GroceryItem> groceryItems = new ArrayList();
        groceryItems.add(new GroceryItem("Milk"));
        groceryItems.add(new GroceryItem("Eggs", "PRODUCE", 6));
        groceryItems.add(new GroceryItem("Butter"));
        groceryItems.add(0, new GroceryItem("Apples", "PRODUCE", 3));
        System.out.println(groceryItems);
    }
}
