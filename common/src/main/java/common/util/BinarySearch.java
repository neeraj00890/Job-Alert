package common.util;

public class BinarySearch {

	static boolean  binarSearch(int array[], int start,int end, int element) {
		int mid = start+end/2;
		int value = array[mid];
		System.out.println("calling for"+ start+"  "+end);
		System.out.println(element+ " "+ value);
		if(start <= end) {
			if(element == value) {
				return true;
			} else if(element < value) {
				return binarSearch(array,start,mid-1, element);
			} else {
				return binarSearch(array,mid+1, end, element);
			}
			
		} else {
			return false;
		}
		
	}
	public static void main(String[] args) {
		int element[] = {1,2,3,4,5,6,7,8};
		System.out.println(binarSearch(element,0, element.length-1, 8));

	}

}
