/** 
$Project: Insertion-Sort Algorithm Implementation  
It makes the order of sorting in descending order

Author: Chirag Mahadevanapura Onkarappa
       email: chiragmo2016@gmail.com

License: Read-only, No publication or usage in any form.
**/
package test;
import java.util.*;
public class sr1 {

	public static void main(String[] args) {
		
int[] array = {2,4,3,1,5}; //Descending order sorting
	
for(int i=1;i<array.length;i++)
{
	for(int j=i-1;j>=0;j--)
	{
		if(array[j]<array[j+1])
		{
			int temp=array[j+1];
			array[j+1]=array[j];
			array[j]=temp;
		}
	}
}
for(int i=0;i<array.length;i++) //Printing Values of Array
{
System.out.println(array[i]+"  ");	
}     	
}
}


