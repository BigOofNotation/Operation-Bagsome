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

 /**
  * //Demonstrating test cases
  * 
  * public static void ResizableArrayBagDemo() {
      String[] aContent = {"A", "B", "C", "W", "O", "W"};
      String[] bContent = {"A", "A", "B", "B", "C", "C"};
      String[] emptyStrings = {};
      String[] nullStrings = {null};
      BagInterface<String> aBag = new ResizableArrayBag<>(6);
      BagInterface<String> bBag = new ResizableArrayBag<>(6);
      
      System.out.println("Testing the Union, Intersection, and Difference of two bags.\n\nFirst, we add to bag A.");
      testAdd(aBag, aContent);
      displayBag(aBag);
      System.out.println();
      System.out.println("Now, we add to bag B.");
      testAdd(bBag, bContent);
      displayBag(bBag);
      System.out.println();

      System.out.println("Union of two valid bags.");
      aBag = aBag.union(bBag);
      displayBag(aBag);
      aBag.clear();
      bBag.clear();
      System.out.println();

      System.out.println("Testing the case where if inputed bag is null.");
      testAdd(aBag, aContent);
      aBag = aBag.union(null);
      displayBag(aBag);
      aBag.clear();
      bBag.clear();
      System.out.println();

      System.out.println("Testing the case where both bags are empty.");
      testAdd(aBag, emptyStrings);
      testAdd(bBag, emptyStrings);
      aBag = aBag.union(bBag);
      displayBag(aBag);
      aBag.clear();
      bBag.clear();
      System.out.println();

      System.out.println("Testing if one bag full, one bag empty.");
      testAdd(aBag, aContent);
      testAdd(bBag, emptyStrings);
      aBag = aBag.union(bBag);
      displayBag(aBag);
      aBag.clear();
      bBag.clear();
      System.out.println();

      System.out.println("Intersection of 2 valid bags.");
      testAdd(aBag, aContent);
      displayBag(aBag);
      testAdd(bBag, bContent);
      displayBag(bBag);
      aBag = aBag.intersection(bBag);
      displayBag(aBag);
      aBag.clear();
      bBag.clear();
      System.out.println();

      System.out.println("Intersection of 2 valid bags but, comparing the other way.");
      testAdd(aBag, aContent);
      displayBag(aBag);
      testAdd(bBag, bContent);
      displayBag(bBag);
      bBag = bBag.intersection(aBag);
      displayBag(bBag);
      aBag.clear();
      bBag.clear();
      System.out.println();

      
      System.out.println("Testing to see the case of null bags.");
      testAdd(aBag, aContent);
      testAdd(bBag, null);
      aBag = aBag.intersection(bBag);
      aBag.clear();
      bBag.clear();
      System.out.println();
      

      System.out.println("Testing intersection of empty bags.");
      testAdd(aBag, emptyStrings);
      testAdd(bBag, emptyStrings);
      aBag = aBag.intersection(bBag);
      displayBag(aBag);
      aBag.clear();
      bBag.clear();
      System.out.println();

      System.out.println("Testing the intersection of one full bag and one bag empty.");
      testAdd(aBag, aContent);
      testAdd(bBag, emptyStrings);
      aBag = aBag.intersection(bBag);
      displayBag(aBag);
      aBag.clear();
      bBag.clear();
      System.out.println();

      System.out.println("Difference of 2 valid bags.");
      testAdd(aBag, aContent);
      displayBag(aBag);
      testAdd(bBag, bContent);
      displayBag(bBag);
      aBag = aBag.difference(bBag);
      displayBag(aBag);
      aBag.clear();
      bBag.clear();
      System.out.println();

      System.out.println("Difference of 2 valid bags but, comparing the other way.");
      testAdd(aBag, aContent);
      displayBag(aBag);
      testAdd(bBag, bContent);
      displayBag(bBag);
      bBag = bBag.difference(aBag);
      displayBag(aBag);
      aBag.clear();
      bBag.clear();
      System.out.println();

       
      System.out.println("Testing to see the case of null bags.");
      testAdd(aBag, aContent);
      testAdd(bBag, null);
      aBag = aBag.difference(bBag);
      aBag.clear();
      bBag.clear();
      System.out.println();

      System.out.println("Testing difference of empty bags.");
      testAdd(aBag, emptyStrings);
      displayBag(aBag);
      testAdd(bBag, emptyStrings);
      aBag = aBag.difference(bBag);
      displayBag(aBag);
      aBag.clear();
      bBag.clear();
      System.out.println();

      System.out.println("Testing the difference of one full bag and one bag empty.");
      testAdd(aBag, aContent);
      testAdd(bBag, emptyStrings);
      aBag = aBag.intersection(bBag);
      displayBag(aBag);
      aBag.clear();
      bBag.clear();
      System.out.println();

      System.out.println("Testing the difference of one full bag and one bag empty except, the other way.");
      testAdd(aBag, aContent);
      testAdd(bBag, emptyStrings);
      bBag = bBag.intersection(aBag);
      displayBag(aBag);
      aBag.clear();
      bBag.clear();
      System.out.println();

   
  */
