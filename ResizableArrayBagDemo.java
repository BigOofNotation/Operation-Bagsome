/** A demonstration of the class ResizableArrayBag
    @author Frank M. Carrano
    @author Timothy M. Henry
    @version 5.0
*/
import java.util.Arrays;
public class ResizableArrayBagDemo 
{
	public static void main(String[] args) {
      //New contents to test union, intersection, and difference
      String[] aContent = {"A", "B", "C", "W", "O", "W"};
      String[] bContent = {"A","B", "B", "C"};
      BagInterface<String> aBag = new ResizableArrayBag<>(6);
      BagInterface<String> bBag = new ResizableArrayBag<>(4);
      
      System.out.println("Testing the Union, Intersection, and Difference of two bags.\nFirst, we add to bag A.");
      testAdd(aBag, aContent);
      System.out.println();
      System.out.println("Now, we add to bag B.");
      testAdd(bBag, bContent);
      System.out.println();

      testUnion(aBag, bBag);
      System.out.println();
      testIntersection(aBag, bBag);
      System.out.println();
      testDifference(aBag, bBag);
      System.out.println();
	} // end main
	
   // Tests the method add.
	private static void testAdd(BagInterface<String> aBag, String[] content)
	{
		System.out.print("Adding to the bag: ");
		for (int index = 0; index < content.length; index++)
		{
			aBag.add(content[index]);
         System.out.print(content[index] + " ");
		} // end for
      System.out.println();
      
		displayBag(aBag);
	} // end testAdd

   // Tests the method toArray while displaying the bag.
	private static void displayBag(BagInterface<String> aBag)
	{
		System.out.println("The bag contains " + aBag.getCurrentSize() +
		                   " string(s), as follows:");		
		Object[] bagArray = aBag.toArray();
		for (int index = 0; index < bagArray.length; index++)
		{
			System.out.print(bagArray[index] + " ");
		} // end for
		
		System.out.println();
	} // end displayBag


   //Tests the method union by using and displaying a temporary bag. 
   private static void testUnion(BagInterface<String> aBag, BagInterface<String> bBag){
      BagInterface<String> tempUnion = aBag.union(bBag);
      System.out.println("If we wanted the union of bag A with bag B, it would look like this.");
      displayBag(tempUnion);
   }
   
   //Tests the method intersection by using and displaying a temporary bag.
   private static void testIntersection(BagInterface<String> aBag, BagInterface<String> bBag){
      BagInterface<String> tempIntersection = aBag.intersection(bBag);
      System.out.println("If we looked for the characters of bag A that intersected with bag B, it would look like this.");
      displayBag(tempIntersection);
   }
   
   //Tests the method difference by using and displaying a temporary bag.
   private static void testDifference(BagInterface<String> aBag, BagInterface<String> bBag){
      BagInterface<String> tempDifference = aBag.difference(bBag);
      System.out.println("Finally, if we wanted the content of bag A that were different from bag B, it would look like this.");
      displayBag(tempDifference);
   }

} // end ResizableArrayBagDemo
/*

 Testing the Union, Intersection, and Difference of two bags.
 First, we add to bag A.
 Adding to the bag: A B C W O W
 The bag contains 6 string(s), as follows:
 A B C W O W

 Now, we add to bag B.
 Adding to the bag: A B B C
 The bag contains 4 string(s), as follows:
 A B B C

 If we wanted the union of bag A with bag B, it would look like this.
 The bag contains 10 string(s), as follows:
 A B C W O W A B B C

 If we looked for the characters of bag A that intersected with bag B, it would look like this.
 The bag contains 3 string(s), as follows:
 A B C

 Finally, if we wanted the content of bag A that were different from bag B, it would look like this.
 The bag contains 3 string(s), as follows:
 W O W

 */
