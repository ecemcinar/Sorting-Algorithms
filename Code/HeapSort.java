

public class HeapSort {

	// https://www.geeksforgeeks.org/heap-sort/
	// https://www.youtube.com/watch?v=Q_eia3jC9Ts
	public void heapSort (int[] arrayToSort) { // maximum heap 
		
		int n = arrayToSort.length;
		for (int i = n/2-1; i>=0; i--) {
			maxHeapify(arrayToSort,n,i);
		}
		for (int i = n-1; i>0; i--) {
			exchange(arrayToSort,0,i);
			maxHeapify(arrayToSort,i,0);
		}
		
	}
	private void maxHeapify(int[] arrayToSort,int n,int i) { //          8
															//		  10    4
														   //        5  3  2  1
		
		// ornegin ilk cagirmada max=i=0(array[0]=8) 
		int max = i; // root						
		int left = i*2+1; // left child index
		int right = i*2 +2; // right child index
		
		
		if(left<n && arrayToSort[left]> arrayToSort[max]) { // burada left<n(size of array) kontrolu yapmamin nedeni leaf nodelara geldiginde leaflerin childi yoktur
		//ama en basta tanimalama yaparken i*2+1 ve i*2+2 sekilde atama yapilmistir ve bu sayilar array.length'ten buyuktur. bu kontrolu yapmasam hatali olurdu.	
		// mesela i=3 oldugunda yani array[i]=5'e geldinide, 5 leaf ve childi exist degil. fakat en basta tanimlama yaparken left=11 seklinde tanimlamistik. iste bu left<n kontrolu bunun icindir.
			max = left; // left child parentinden buyuk ise, max'e left childin indeksi atanir
		}
		if(right<n && arrayToSort[right]> arrayToSort[max]) { 
			max= right; 
		}
		if(max!=i) { // eger dongude ustteki iflerden herhangi birine girilmisse, bu demek ki bu ife de girilmesi gerekiyor cunku max elemanin indexi degismis.
			exchange(arrayToSort,i,max); // bu indexlerdeki sayilar swaplenir
			
			maxHeapify(arrayToSort,n,max); // rescursive bir sekilde devam eder..
		}

	}
	private void exchange(int[] arrayToSort, int rIndex,int oIndex) { 
		int temp = arrayToSort[rIndex]; 
		arrayToSort[rIndex] = arrayToSort[oIndex]; // swap
		arrayToSort[oIndex] = temp; 
	}
}
