package junitDemo;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Calculation {

	 public static int findMax(int arr[]){  
	        int max=0;  
	        for(int i=1;i<arr.length;i++){  
	            if(max<arr[i])  
	                max=arr[i];  
	        }  
	        return max;  
	    }  
	 
	 public static int findMin(int arr[]){  
	        int min =  Integer.MAX_VALUE; 
	        for(int i=1;i<arr.length;i++){  
	            if(min>arr[i])  
	                min=arr[i];  
	        }  
	        return min;  
	    }  
	 
	 public static int[] sortData(int arr[]){  
	        Arrays.sort(arr);
	        return arr;  
	    }  
}
