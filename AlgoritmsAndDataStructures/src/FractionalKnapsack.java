import java.util.Arrays;
import java.util.Comparator;

/// ЗАДАЧА О РЮКЗАКЕ (Fractional Knapsack) ///
// Хотим максимизировать кол-во каллорий(ценность какая-либо), которые возьмём с собой, при этом любой объект можно делить на части 



public class FractionalKnapsack {
	public static void main(String[] args) {
		
		final Item item1 = new Item(4, 20);
		final Item item2 = new Item(3, 18);
		final Item item3 = new Item(2, 14);
		
		final Item[] items = {item1, item2, item3};
		
		Arrays.sort(items, Comparator.comparingDouble(Item::valuePerUnitOfWeight).reversed()); 
		// компаратор - по какому принципу сравнивать
		// отсортировали по убыванию удельной ценности
		System.out.println(Arrays.toString(items)); // 
		
		final int W = 7;  // вместимость рюкзака
		
		int weightSoFar = 0;    // текущий вес
		double valueSoFar = 0;  // текущая ценность 
		int currentItem = 0;    // индекс текущего предмета
		
		while(currentItem < items.length && weightSoFar != W) {
			if(weightSoFar + items[currentItem].getWeight() < W) {
				// берем объект целиком
				
				valueSoFar += items[currentItem].getValue();
				weightSoFar += items[currentItem].getWeight();
				
			} else {
				// берём только часть веса и ценности 
				valueSoFar += ((W - weightSoFar) / (double) items[currentItem].getWeight()) * items[currentItem].getValue();
				weightSoFar = W; // т.к заполнили рюкзак
				
			}
			
			currentItem++;
		}
		
		System.out.println("Ценность наилучшего набора: " + valueSoFar);
		
		
		
	}
} 

class Item{
	private int weight;
	private int value;
	
	public Item(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}
	
	public double valuePerUnitOfWeight() {
		return (double)value / weight;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public int getValue() {
		return value;
	}
	
	 public String toString() {
		return "{w:" + weight + ",v:" + value + "}";
	}
	
}
