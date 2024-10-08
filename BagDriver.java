public class BagDriver {

    public static void main(String[] args) {

        ResizableArrayBagDemo();
        LinkedBag1Demo();

    }
        
    public static void ResizableArrayBagDemo() {
      String[] aContent = {"A", "B", "C", "W", "O", "W"};
      String[] bContent = {"A", "A", "B", "B", "C", "C"};
      BagInterface<String> aBag = new ResizableArrayBag<>(6);
      BagInterface<String> bBag = new ResizableArrayBag<>(6);

      System.out.println("Testing the Union, Intersection, and Difference of two bags.\nFirst, we add to bag A.");
      testAdd(aBag, aContent);
      System.out.println();
      System.out.println("Now, we add to bag B.");
      testAdd(bBag, bContent);
      System.out.println();

      System.out.println("If we wanted the union of bag A with bag B, it would look like this.");
      BagInterface<String> tempUnion = aBag.union(bBag);
      displayBag(tempUnion);

      System.out.println("If we looked for the characters of bag A that intersected with bag B, it would look like this.");
      BagInterface<String> tempIntersection = aBag.intersection(bBag);
      displayBag(tempIntersection);

      System.out.println("If we looked for the intersection of Bag B with Bag A, it would look like this.");
      BagInterface<String> tempIntersection2 = bBag.intersection(aBag);
      displayBag(tempIntersection2);

      System.out.println("If we wanted the content of bag A that were different from bag B, it would look like this.");
      BagInterface<String> tempDifference = aBag.difference(bBag);
      displayBag(tempDifference);

      System.out.println("Finally, if we wanted the difference of Bag B to Bag A, it would look like this.");
      BagInterface<String> tempDifference2 = bBag.difference(aBag);
      displayBag(tempDifference2);

      System.out.println();
      System.out.println("The original bags remain unchanged.");
      System.out.println("For Bag A,");
      displayBag(aBag);
      System.out.println("For Bag B,");
      displayBag(bBag);



        //Initializing Bag 1 and Bag 2

        // Printing contents of Bag 1 and Bag 2

        // Demonstrating Union

        // Demonstrating Intersection

        // Demonstrating Difference (Bag 1 to Bag 2)

        // Demonstrating Difference (Bag 2 to Bag 1)

        /* Printing contents of Bags 1 and 2 again, 
        showing content of both bags did not change */

    }

    public static void LinkedBag1Demo() {

        //Initializing Bag 1 and Bag 2

        // Printing contents of Bag 1 and Bag 2

        // Demonstrating Union

        // Demonstrating Intersection

        // Demonstrating Difference (Bag 1 to Bag 2)

        // Demonstrating Difference (Bag 2 to Bag 1)

        /* Printing contents of Bags 1 and 2 again, 
        showing contents of both bags did not change */

    }



    private static void testAdd(BagInterface<String> aBag, String[] content)
	{
		System.out.print("Adding to the bag: ");
		for (int index = 0; index < content.length; index++)
		{
			aBag.add(content[index]);
         System.out.print(content[index] + " ");
		} // end for
      System.out.println();
	} // end testAdd


    private static void displayBag(BagInterface<String> aBag) {
		System.out.println("The bag contains " + aBag.getCurrentSize() + " string(s), as follows:");		
		Object[] bagArray = aBag.toArray();
		for (int index = 0; index < bagArray.length; index++) {
			System.out.print(bagArray[index] + " ");
		} // end for
		System.out.println();
	} // end displayBag

    



}