//* Виды алгоритмов * - Жадные(Greedy algoritms), Разделяй и властвуй(Devide and Conquer)
// Динамическое программирование(Dynamic Programming)
//--Жадные Алгоритмы-- в мелких задачах принимаем оптимальные решения, что
//приводит к глобальному оптимальному решению
//Но это не всегда безопасно, например: Нужно разменять 40 копеек за наименьшее количество шагов,
//в наличии есть: 1, 5, 10, 20, 25, 50;
//Лучшое решение: 25 + 10 + 5 (3 монеты)
//Плохое жадное решение: 20 + 20 (2 монеты)

//--Когда применим жадный алгоритм--
//бака топлива хватает на 400км, нужно за min кол-во заправок доехать от A до B, заправки расположены
//с некоторым интервалом: Если до заправки <= 400км то заправимся там, так получим MIN Кол-во заправок



import java.util.Arrays;

public class GreedyAlgoritms {

	public static void main(String[] args) {
		
		
		
		
		
		
		
		/////////////////////////////////////////////
		int[] stations = {0, 200, 375, 550, 750, 950};
		System.out.println(minStops(stations, 400));
		
		
		
		//////////////////////////////////////////////
		int[] digits = {1, 3, 7, 9, 9, 5};
		System.out.println(maxNumberFromDigits(digits));

		
		
		
		
		
		
		
		
		
		
	

	}
	
	
	public static int minStops(int[] stations, int capacity) { // остановки, сколько на полном баке проедет
		
		int result = 0; // оптимальное кол-во остановок
		int currentStop = 0; // на какой остановке сейчас находиться машина
		
		while(currentStop < stations.length - 1) {
			int nextStop = currentStop;
			
			while(nextStop < stations.length - 1  && stations[nextStop + 1] - stations[currentStop] <= capacity)
				nextStop++; // в nextStop самая дальняя и достижимая заправка
			
			if (currentStop == nextStop)   // если не можем доехать до след заправки
				return -1;				   // изначально если массив stations имеет большой разрыв между числами 
										   // и нашего capacity бака не хватает
			if(nextStop < stations.length - 1)
				 result++;
			
			currentStop = nextStop;
			
		}
		return result;
	}
	
	public static String maxNumberFromDigits(int[] digits) {

		Arrays.sort(digits); // quick-sort
		// 1, 3, 5, 7, 9, 9
		String result = "";
		for (int i = digits.length - 1 ; i >= 0; i--) { // 
			result += digits[i];
		}
		return result;
		
		
		
		
		
		
		
		
		
	}


	
	
	
	
	
	
}







