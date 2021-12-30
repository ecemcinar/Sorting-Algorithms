import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Test {
	static Scanner sc = new Scanner(System.in);
	static Random rnd = new Random();
	
	private static void controlInput(int a) {
		if(a!=1 && a!=2 && a!=3 & a!=0) 
			throw new InvalidCharacterException("Invalid input!");
	}
	private static void controlSize(int size) {
		if(size!=1000 && size!=10000 && size!=100000 && size!=0)
			throw new InvalidSizeException("Invalid input");
	}
	
	
	private static void sortingType(int opt,int[] arr,int size) { // kod tekrarini engelllemek icin
		long startTimeMain=0;
		long endTimeMain=0;
		if(opt==1) {
			HeapSort hs = new HeapSort();
			//startTimeMain =  System.nanoTime();
			startTimeMain =  System.currentTimeMillis();
			hs.heapSort(arr);
			//endTimeMain = System.nanoTime();
			endTimeMain = System.currentTimeMillis();
			System.out.println("Time past:" + (endTimeMain - startTimeMain));
		}
		else if(opt==2) {
			QuickSort qs = new QuickSort();
			startTimeMain =  System.currentTimeMillis();
			//startTimeMain =  System.nanoTime();
			qs.dualPivotQuickSort(arr);
			//endTimeMain = System.nanoTime();
			endTimeMain = System.currentTimeMillis();
			System.out.println("Time past:" + (endTimeMain - startTimeMain));
		}
		else { // opt==3
			BucketSort bs = new BucketSort();
			//startTimeMain =  System.nanoTime();
			startTimeMain =  System.currentTimeMillis();
			bs.bucketSort(arr);
			//endTimeMain = System.nanoTime();
			endTimeMain = System.currentTimeMillis();
			System.out.println("Time past:" + (endTimeMain - startTimeMain));
		}
		if(size==1000) {
			System.out.println("Sorted Array");
			printArray(arr);
			System.out.println("--------------------------------------");
		}
	}
	
	private static void choosingOrder(int opt,String chc) { // kod tekrarini engellemek icin
		while(true) {
			System.out.println("To return first section,enter '0'..");
			System.out.print("Choose array size --->" + "1.000 , 10.000 or 100.000 (Enter integer form):");
			int sSize = sc.nextInt();
			sc.nextLine();
			
			try {
				controlSize(sSize);
				if(sSize==0) {
					System.out.println("Wait...");
					System.out.println("--------------------------------------");
					break;
				}
				int[] array = new int[sSize];
				if(chc.equalsIgnoreCase("a"))  //Equal Integers
					createArrayEqually(array);
				
				else if(chc.equalsIgnoreCase("b"))  // Random Integers
					createArrayRandomly(array);
				
				else if(chc.equalsIgnoreCase("c"))  // Increasing Integers
					createArrayIncreasingOrder(array);
				
				else  // Decreasing Integers
					createArrayDecreasingOrder(array);
				
				if(sSize==1000) {
					System.out.println("Unsorted Array");
					printArray(array);
					System.out.println("-------------------------------");
				}
				
				sortingType(opt,array,sSize);
			} catch (InvalidSizeException e) {
				e.printStackTrace();
			} catch(InputMismatchException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	public static void main(String[] args) {
        
        while(true) {
        	System.out.println("1.HEAPSORT" + "\n2.DUAL PIVOT QUICKSORT" +"\n3.BUCKET SORT");
        	System.out.print("Enter your choice(To exit, enter '0'):");
        	int firstOpt = sc.nextInt();
			sc.nextLine();
				try {
					controlInput(firstOpt);
					if(firstOpt==1 || firstOpt==2 || firstOpt==3) {
						while(true) {
							System.out.println("a)Array with EQUAL integers" + "\nb)Array with RANDOM integers"
								+"\nc)Array with INCREASING integers" + "\nd)Array with DECREASING integers");
							System.out.print("Enter your choice (To return first section ---> enter e):");
							String secondOpt=sc.nextLine();
							if(secondOpt.equalsIgnoreCase("a")|| secondOpt.equalsIgnoreCase("b")|| secondOpt.equalsIgnoreCase("c")|| secondOpt.equalsIgnoreCase("d")) {
								choosingOrder(firstOpt,secondOpt);
							}
							else if(secondOpt.equalsIgnoreCase("e")) {
								System.out.println("Wait...");
								System.out.println("-----------------------");
								break;
							}
							else {
								System.out.println("Invalid!! Enter only a, b, c, d or e!!!");
								System.out.println("-----------------------");
							}
						}
					}	
					else if(firstOpt==0) break;
				} catch (InvalidCharacterException e) {
					e.printStackTrace();
				} catch(InputMismatchException e) {
					e.printStackTrace();
				}
        }
	}
	
	private static void createArrayEqually(int[] arr) {
		int number = rnd.nextInt(arr.length);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = number;
		}
	}
	
	private static void createArrayRandomly(int[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			int number = rnd.nextInt(100);
			arr[i]=number;
		}
	}
	private static void createArrayIncreasingOrder(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		
		}
	}
	private static void createArrayDecreasingOrder(int[] arr) {
		int number= arr.length;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = number;
			number--;
		}
	}
	public static void printArray(int arr[]){
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
