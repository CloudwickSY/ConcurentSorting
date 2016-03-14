
public class QuickSort<T extends Comparable<T>> implements Runnable {
	T[] A;
	int low, high;

	public QuickSort(T[] A, int low, int high) {
		this.A = A;
		this.low = low;
		this.high = high;
	}

	public void quicksort(T[] A, int low, int high) {
		if (low < high) {
			int p = partition(A, low, high);
			//Thread qst = new Thread(new QuickSort<T>(A, low, p-1));
			//qst.run();
			this.quicksort(A, low, p-1);
			this.quicksort(A, p + 1, high);
			//qst.join();
		}
	}

	public int partition(T[] A, int low, int high) {
		T pivot = A[high];
		int i = low; // place for swapping
		for (int j = low; j < high - 1; j++) {
			System.out.printf("(%d-%d)(%d:%d)\n",i,j,A[i],A[j]);
			
			if (A[j].compareTo(pivot) < 0) {
				System.out.printf("[%d-%d--",i,j);
				this.swap(i, j);
				System.out.printf("%d-%d]\n",i,j);
				i++;
			}
		}
		swap(i, high);
		return i;
	}

	private void swap(int i, int j) {
		System.out.printf("[%d-%d--",A[i],A[j]);
		T tmp = this.A[j];
		this.A[j] = this.A[i];
		this.A[i] = tmp;
		System.out.printf("%d-%d]\n",A[i],A[j]);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.sort();
	}

	public void sort() {
		//this.print();
		this.quicksort(this.A, this.low, this.high);
		//this.print();
	}
	
	public void print() {
		for(int i=0; i<A.length; i++){
			System.out.printf("%d, ",A[i]);
		}
		System.out.println("");
	}
}

/*
 * algorithm quicksort(A, lo, hi) is if lo < hi then p := partition(A, lo, hi)
 * quicksort(A, lo, p – 1) quicksort(A, p + 1, hi)
 * 
 * algorithm partition(A, lo, hi) is pivot := A[hi] i := lo // place for
 * swapping for j := lo to hi – 1 do if A[j] ≤ pivot then swap A[i] with A[j] i
 * := i + 1 swap A[i] with A[hi] return i
 */