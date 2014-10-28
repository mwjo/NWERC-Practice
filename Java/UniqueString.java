public class UniqueString {

	public static int getMinIndex(int[] array) {
		int minIndex = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[minIndex]) {
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	public static int getMaxIndex(int[]array) {
		int maxIndex = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[maxIndex]) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	
	public static void swap(int[] array, int m, int n) {
		int temp = array[m];
		System.out.println(temp);
		array[m] = array[n];
		array[n] = temp;
		System.out.println(array[m]);
		System.out.println(array[n]);
	}
	
	public static void swapMinMaxBetter(int[] array, int m, int n) {
		int minIndex = getMinIndex(array);
		int maxIndex = getMaxIndex(array);
		swap(array, minIndex, maxIndex);
	}
	
	public static void main(String[] args) {
		int[] anArray = {1,2,3,4,5,6,7,8,9,10};
		swapMinMaxBetter(anArray, 0, 10);
		for (int i = 0; i < 10; i++) {
			System.out.println(anArray[i]);
		}
		
	}
}
