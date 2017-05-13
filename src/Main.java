//For your reading enjoyment, I have commented and segmented my code


// pull imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// declare main class
public class Main {

	//declare globals
	
		// File Variables
		private Scanner sc;
		private File file; 
	
		// Array Variables
		String raw; 
		int[] fileData;
		
	/**
	 * Constructor for Main Class
	 * Does nothing of importance
	 *
	 * @param  n/a
	 */
	public Main(){

	}
	
	public static void main(String[] args) {
		Main m = new Main();
		m.init();
		m.solve();
		System.exit(0);
	}
	
	/**
	 * Init Method
	 * <p>
	 * This method initializes variables vital to the Main Class
	 *
	 * @param  n/a
	 * @return void
	 */
	private void init(){
		
		file = new File("Project_3_Data_Analysis_Input.txt"); // Initialize the file
		
		// Attempt to initialize Scanner object with file
		try {
			sc = new Scanner(file); // initialize scanner
			
			while(sc.hasNextLine()){
				raw = sc.nextLine();
			}
			
			sc.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace(); // Print errors in case the file does not exist
		}
		String[] temp = raw.split(", ");
		fileData = new int[temp.length];
		for(int i = 0; i < temp.length; i ++){
			fileData[i] = Integer.parseInt(temp[i]);
		}
		
	}
	
	/**
	 * Solve Method
	 * <p>
	 * Perhaps the most important method of the Main Class, this method calls several computational methods
	 * to act upon the data retrieved in the init method. After computing several values this method then
	 * displays them to the console.
	 *
	 * @param  n/a
	 * @return void
	 */
	private void solve(){
		System.out.println("Average: " + average(fileData));
		System.out.println("Median: " + median(fileData));
		System.out.println("Mode: " + mode(fileData));
		System.out.println("Range: " + range(fileData));
	}
	
	/**
	 * Average Method
	 * <p>
	 * This method takes any given array of integers and iterates through the values, summing them and then dividing
	 * them by their size in order to return their average.
	 *
	 * @param  Integer[]	An array of integers to find their average
	 * @return Integer		The Average of the Array
	 */
	public int average(int[] data){
		int sum = 0;
		for(int i = 0; i < data.length; i++){
			sum += data[i];
		}
		return sum/data.length;
	}
	
	/**
	 * Range Method
	 * <p>
	 * This method takes an array, sorts them by value in ascending order and subtracts the
	 * smallest from the largest.
	 *
	 * @param  Integer[]	An array of integers to find their range
	 * @return Integer		The Range of the Array
	 */
	public int range(int[] data){
		Arrays.sort(data);
		return data[data.length-1] - data[0];
	}
	
	/**
	 * Mode Method
	 * <p>
	 * This method takes any given array of integers and iterates through the values, finding the value that
	 * is repeated the most
	 *
	 * @param  Integer[]	An array of integers to find their mode
	 * @return Integer		The Mode of the Array
	 */
	public int mode(int[] data){
		int mode = data[0];
	    int maxCount = 0;
	    for (int i = 0; i < data.length; i++) {
	        int value = data[i];
	        int count = 1;
	        for (int j = 0; j < data.length; j++) {
	            if (data[j] == value) count++;
	            if (count > maxCount) {
	                mode = value;
	                maxCount = count;
	            }
	        }
	    }
	    return mode;
	}
	
	/**
	 * Median Method
	 * <p>
	 * This method takes any given array of integers and iterates through the values, finding the "middle" 
	 * value of the array.
	 *
	 * @param  Integer[]	An array of integers to find their Median
	 * @return Integer		The Median of the Array
	 */
	public int median(int[] data){
		if (data.length % 2 == 0)
		    return (data[data.length/2] + data[data.length/2 - 1])/2;
		else
			return data[data.length/2];
	}

}
