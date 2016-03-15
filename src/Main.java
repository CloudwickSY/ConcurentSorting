import java.util.Random;

public class Main {
	public static void main(String[] args) {
		//random 10.000 and 100.000
		//300 sec -> 100000000;
		int size = 100000000;
		Integer[] A = new Integer[size];
		Random rnd = new Random();
		
		for (int i =0 ; i<size; i++){
			A[i] = rnd.nextInt(size);
		}
		QuickSort<Integer> qs = new QuickSort<Integer>(A, 0, A.length-1);
		//qs.print();
		
		double start = System.currentTimeMillis();
		qs.sort();
		double stop = System.currentTimeMillis();
		System.out.println(stop-start+"ms");
		//qs.print();
	}
}
//json xml networking debuging 