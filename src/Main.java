
public class Main {
	public static void main(String[] args) {
		Integer[] A = {3,2,1,4,5,6};
		QuickSort<Integer> qs = new QuickSort<Integer>(A, 0, A.length-1);
		qs.print();
		qs.sort();
		qs.print();
	}
}
