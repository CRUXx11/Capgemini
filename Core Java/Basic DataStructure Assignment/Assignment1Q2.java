import java.util.ArrayList;
class ArmstrongNumBetweenRange{
    public int[] armstrongNumbersInRange(int min , int max){
    	boolean n;
        ArrayList<Integer> myValues = new ArrayList<Integer>();
        
        for(int i = min;i<=max; i++){
        	n = armstrongCheck(i);
            if(n == true){
                myValues.add(i);
            }
        }
        
        int[] arr = myValues.stream().mapToInt(i -> i).toArray(); 
		return arr;
	}
	public boolean armstrongCheck(int num) {

		String s = String.valueOf(num);
		int size = s.length();
		int total = 0;
		int myNum = num;

		for (int i = 0; i < size; i++) {
			if (myNum > 0) {
				int temp = myNum % 10;
				total += Math.pow(temp, size);
				myNum = myNum / 10;
			}
		}
		if (num == total) {
			return true;
		} else {
			return false;
		}
   
    }
}

public class Assignment1Q2 {

	public static void main(String[] args) {
		int min = 100;int max = 999;
		 ArmstrongNumBetweenRange R = new ArmstrongNumBetweenRange();
		 for (int element: R.armstrongNumbersInRange(min,max)) {
	           System.out.println(element);
	       }

	}

}
