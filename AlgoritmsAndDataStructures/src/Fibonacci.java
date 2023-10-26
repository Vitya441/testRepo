// * Числа Фиббоначи * - математическая модель, описывающая размножение кроликов 
// 0 1 1 2 3 5 8 13 21 34 55 89 144

// * Мемоизация * - ускорение плохого алгоритма за счёт памяти

// * Большое О * -  оценка эффективности алгоритма(ОС, ПК, compilier - константы - можно отбросить)
// Для нас важно --Ассимптотическое время-- выполнения алгоритма - поведение функ при стремл арг к бесконечности 
//	2^n очень редко применяются, big O - легко сравнивать


import java.util.Arrays;

public class Fibonacci {

	public static void main(String[] args) {
		
//		int[] digits = {1, 3, 7, 9, 9, 5};
//		AlgoritmTypes alg = new AlgoritmTypes(); // объекта моего класса, вынес по приколу
//		System.out.println(alg.maxNumberFromDigits(digits));
		
		
		
		
		/////////////////////////////////////////////////////////////////////////////
		int n = 100;
		long[] mem = new long[n + 1];
		Arrays.fill(mem, -1);
		
		System.out.println(fibMemoiz(n, mem)); // тоже < 1сек
		
		System.out.println(fibEffective(8)); // 
		
		//System.out.println(fibBad(100)); // программа будет выполняться 50 000 лет!
		
		System.out.println(fibEffective(100)); // выполниться меньше чем за секунду!
		
		
		

	}
	
// Неэффективный, наивный, медленный алгоритм (рекурсия, очень много вызовов, много повторяющихся операций
// Мого раз вычисляются одни и те же числа Фиббоначи	 	
	public static long fibBad(int n) {
		if (n <= 1)
			return n;
		
		return fibBad(n - 1) + fibBad(n - 2); 
	}
	// Используя Мемоизацию - улучшение алгоритма за счет памяти 
	public static long fibMemoiz(int n, long[] mem) {
		if (mem[n] != -1)
			return mem[n];
		if (n <= 1)
			return n;
		
		long result = fibMemoiz(n - 1, mem) + fibMemoiz(n - 2, mem); 
		mem[n] = result;
		
		return result;
	}
	
	
	// Быстрый алгоритм без понтовых рекурсий)
	public static long fibEffective(int n) {
		long[] arr = new long[n + 1]; // O(n)
		
		arr[0] = 0; // O(1)
		arr[1] = 1; 
		
		for (int i = 2; i <= n; i++) { // O(n)
			arr[i] = arr[i - 1] + arr[i - 2];
		} 
		// O(n + n) = O(2n)  = O(n)
		return arr[n];
	}
	

}
