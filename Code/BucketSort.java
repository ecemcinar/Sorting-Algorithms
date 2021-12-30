

import java.util.List;
import java.util.ArrayList;
// //https://iq.opengenus.org/bucket-sort/ kodlarken burdaki c++ kodundan yararlandim.
public class BucketSort{
	
	private int findMaxValue(int[] arrayToSort) { // interval belirlerken maxValue'ya ihtiyacim var
		int maxValue = arrayToSort[0];
		for (int i = 0; i < arrayToSort.length; i++) {
			if (arrayToSort[i] > maxValue) { // to find max element in array
                maxValue = arrayToSort[i];
            }
		}
		return maxValue; // found
	}
	
	private final int def_bucket_count =20; // default olarak belirledim.
	

    public void bucketSort(int[] arrayToSort) {
    	int maxValue = findMaxValue(arrayToSort); // find max element
        
        int interval = (maxValue/def_bucket_count) +1; 
        // mesela max sayi 48 olarak belirlendi, bucket sayim da default olarak 5 belirlemis olayim. 48/5--> inte cast edildiginde 
		// sonuc 9 oluyor yani interval 9 olarak belirlemis oluyorum. e 5 sepetim var, 9x5=45 (max gelebilecek sayi oluyor) bu durumda,
		// maxValue olarak buldugum 48 bucket disi kaliyor. bu yuzden bolme islemi yaptigimda sonuca +1 ekliyorum.
        
        System.out.println("Interval:" + interval);
        sort(arrayToSort, interval);
    }

    private void sort(int arr[], int interval) {
        if (arr.length == 0) return; // if array is empty, no need to continue

        System.out.println("Bucket count:" + def_bucket_count);
        List<List<Integer>> myBuckets = new ArrayList<List<Integer>>(def_bucket_count); // to create bucketsss
        for (int i = 0; i < def_bucket_count; i++) { 
            myBuckets.add(new ArrayList<Integer>()); // bucketlerimi olusturuyorum
        }

        for (int i = 0; i < arr.length; i++) { // elemani intervala bolerek hangi bucketa gelmesi gerektigini buluyorum 
            myBuckets.get((arr[i] / interval)).add(arr[i]); // ve sayiyi o bucketa yerlestiriyorum
            
        }

        int index = 0;
        // simdi artik bucketlarimi kendi icinde insertion sort ile siralayip, en son siralanan bucketleri tek arraye atmak var
      for (int i = 0; i < myBuckets.size(); i++) {  
          Integer[] bucketArray = new Integer[myBuckets.get(i).size()];
          bucketArray = myBuckets.get(i).toArray(bucketArray); // list tipindeki bucketlarimi arraye cevirmek icin kullandigim method, cunku insertion sortu array uzerinden yapacagim.
         // printArray(bucketArray);
          insertionSort(bucketArray); // listten arraye cevirdigim bucketlari insertion sort ile kendi iclerinde siraliyorum
          for (int j = 0; j < bucketArray.length; j++) {
        	// artik siraladigim bucketArraydeki elemanlari, ana arrayime atmam gerekiyor,
        	  //bucketArrayde dolasarak bu islemi yapiyorum
              arr[index++] = bucketArray[j]; 
          }
      }
  }

   
    private void insertionSort(Integer[] array) { // int degil de Integer olarak yazmamin nedeni, listi arraye cevirirken kullandigim
    	// methodunun object tipinde attribute almasi
		int i;
	    int key;
	    for (int j = 1; j < array.length; j++) {
	         key = array[j];
	         i = j-1;
	         while(i>=0 && array[i] > key)  {
	              array[i+1]=array[i];
	               i--;
	          }
	          array[i+1]=key;
	     }
	}
    

}