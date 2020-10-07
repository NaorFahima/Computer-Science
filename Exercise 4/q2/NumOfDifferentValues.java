package q2;    //name: Naor Fahima ; ID:315783563 ; Number of task = 2

import java.util.Arrays;

public class NumOfDifferentValues {

	public static int numOfDifferentValues(int[] arr, int size) {
		int cont = 0;
		if (size == 0) {
			return 1;
		}
		Arrays.sort(arr);
		if (arr[size] == arr[size-1]) {
			return numOfDifferentValues(arr, size-1);
		} else {
			cont++;
		}
		return numOfDifferentValues(arr, size-1) + cont;
	}
	

	public static void main(String[] args) {
		int[] arr = new int[5];

		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < arr.length; i++)
				arr[i] = (int) (Math.random() * 10);
		
			System.out.println(Arrays.toString(arr) + " --> " + numOfDifferentValues(arr, arr.length-1));
		}

	}

}
