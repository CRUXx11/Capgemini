class BubbleSort {

	public int[] bubbleSort(int arr[]) {
		int arrSize = arr.length;
		for (int p = 0; p < arrSize; p++) {
			for (int j = 1;j < arrSize-p; j++) {
				if (arr[j-1] > arr[j]) {
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;

	}

}

public class Assignment1Q8 {
	public static void main(String args[]) {
		int arr[] = { 5, 12, 14, 6, 78, 19, 1, 23, 26, 35, 37, 7, 52, 86, 47 };
		
		BubbleSort sort = new BubbleSort();
		sort.bubbleSort(arr);
		for (int element: sort.bubbleSort(arr)) {
            System.out.println(element);
        }
	}
}