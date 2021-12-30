
public class QuickSort {
	// https://codeblab.com/wp-content/uploads/2009/09/DualPivotQuicksort.pdf
	// https://arxiv.org/pdf/1304.0988.pdf 
	//geeksforgeeksten aldigim kod stackoverflow hatasi verdiginden onu kullanmak istemistim. aslinda o kod daha kisa ve daha anlasilir gozukuyordu
	public  void dualPivotQuickSort(int[] a) {
        sort(a, 0, a.length);
    }
    private  void sort(int[] a, int fromIndex, int toIndex) {
    	quicksort(a, fromIndex, toIndex - 1, 3); // uc parcaya ayriliyor
    }

    private void exchange(int[] arrayToSort, int rIndex,int oIndex) { 
		int temp = arrayToSort[rIndex]; // kaybetmemek icin tempe atariz
		arrayToSort[rIndex] = arrayToSort[oIndex]; // swapp
		arrayToSort[oIndex] = temp; 
	}
    
    private void quicksort(int[] a, int left,int right, int div) {
        int length = right - left;
        if (length < 27) { // insertion sort for tiny array --> bu algoritmayi gelistiren kisi tarafindan belirlenmistir.
            for (int i = left + 1; i <= right; i++) {
                for (int j = i; j > left && a[j] < a[j - 1]; j--) 
                    exchange(a, j, j - 1);
            }
            return;
        }
        int third = length / div; // arrayin uc bolume ayrildigindan raporda bahsetmistim
        // "medians"
        int m1 = left + third;
        int m2 = right - third;
        if (m1 <= left)  m1 = left + 1;
        if (m2 >= right) m2 = right - 1;  
        if (a[m1] < a[m2]) {
            exchange(a, m1, left);
            exchange(a, m2, right);
        }
        else {
            exchange(a, m1, right);
            exchange(a, m2, left);
        }
        // yeni pivotlar belirleniyor
        int pivot1 = a[left];
        int pivot2 = a[right];
        // pointers
        int less = left + 1;
        int great = right - 1;
        // sorting
        for (int k = less; k <= great; k++) {
            if (a[k] < pivot1)  
            	exchange(a, k, less++);
            else if (a[k] > pivot2) {
                while (k < great && a[great] > pivot2) 
                    great--;
                exchange(a, k, great--);
                if (a[k] < pivot1) 
                    exchange(a, k, less++);
            }
        }
        // swaps
        int distance = great - less;
        if (distance < 13) {
            div++;
        }
        // recursive calistigi bolum
        exchange(a, less - 1, left);
        exchange(a, great + 1, right);
        // subarrays
        quicksort(a, left, less - 2, div);
        quicksort(a, great + 2, right, div);
        
        if (distance > length - 13 && pivot1 != pivot2) {
            for (int k = less; k <= great; k++) {
                if (a[k] == pivot1) 
                    exchange(a, k, less++);
                
                else if (a[k] == pivot2) {
                    exchange(a, k, great--);
                    if (a[k] == pivot1) 
                        exchange(a, k, less++);
                    
                }
            }
        }
        if (pivot1 < pivot2) // raporda da belirtigim gibi sol tarafta secilen pivot sag tarafta secilenden buyuk ise, pivotlar degistirilerek sorting yapilir
            quicksort(a, less, great, div);
        
    }
	}
