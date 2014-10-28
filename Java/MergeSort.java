public class MyMergeSort {
    
    private int[] array;
    private int[] tempMergeArray;
    private int length;
 
    public static void main(String a[]){
         
        MyMergeSort mergeSort = new MyMergeSort();
        int[] inputArray = mergeSort.setInputArray();
        mergeSort.sort(inputArray);
        mergeSort.printArray(inputArray);
    }
    
    public void printArray(int[] inputArray)
    {
    	for(int i:inputArray){ //prints each value in the array
            System.out.print(i + " ");
        }
    }
    public int[] setInputArray()
    {
    	int[] array = {24, 11, 9, 70, 48, 103, 3, 7, 2, 29}; //populate input array here, including taking user input if chosen
    	return array;
    }
     
    public void sort(int inputArray[]) {
        this.array = inputArray; //copies input array into object's array
        this.length = inputArray.length; //records the size of the array
        this.tempMergeArray = new int[length]; //creates a temporary array
        mergeSort(0, length - 1);
    }
 
    private void mergeSort(int lowerIndex, int higherIndex) {
         
    	//by default lowerIndex is 0 and higherIndex is arraylength-1, which performs a merge sort on the full array 
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            mergeSort(lowerIndex, middle); //call recursively
            // Below step sorts the right side of the array
            mergeSort(middle + 1, higherIndex); //call recursively
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
 
    private void mergeParts(int lowerIndex, int middle, int higherIndex) 
    {
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergeArray[i] = array[i]; //populate temporary array 
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergeArray[i] <= tempMergeArray[j]) {
                array[k] = tempMergeArray[i];
                i++;
            } else {
                array[k] = tempMergeArray[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergeArray[i];
            k++;
            i++;
        }
    }
}