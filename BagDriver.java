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


    }

    public static void LinkedBag1Demo() {

      // Create two LinkedBag1 instances
      LinkedBag1<String> bag1 = new LinkedBag1<>();
      LinkedBag1<String> bag2 = new LinkedBag1<>();

      // Add elements to bag1
      bag1.add("Apple");
      bag1.add("Banana");
      bag1.add("Orange");

      // Add elements to bag2
      bag2.add("Banana");
      bag2.add("Grape");
      bag2.add("Pineapple");

      // Test the union of bag1 and bag2
      BagInterface<String> unionBag = bag1.union(bag2);

      // Test the intersection of bag1 and bag2
      BagInterface<String> intersectionBag = bag1.intersection(bag2);

      // Test the difference of bag1 and bag2
      BagInterface<String> leftovers1 = bag1.difference(bag2);
      BagInterface<String> leftovers2 = bag2.difference(bag1);

      // Display the contents of bag1
      System.out.println("Bag 1 contents:");
      displayLinkedBag(bag1);

      // Display the contents of bag2
      System.out.println("\nBag 2 contents:");
      displayLinkedBag(bag2);

      // Display the contents of the union bag
      System.out.println("\nUnion of Bag 1 and Bag 2:");
      displayLinkedBag(unionBag);

      // Display the contents of the union bag
      System.out.println("\nIntersection of Bag 1 and Bag 2:");
      displayLinkedBag(intersectionBag);

      // Display the contents of leftovers from Bag 1
      System.out.println("\nLeftovers from Bag 1:");
      displayLinkedBag(leftovers1);

      // Display the contents of leftovers from Bag 2
      System.out.println("\nLeftovers from Bag 2:");
      displayLinkedBag(leftovers2);
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

    // Helper method to display the contents of a bag
    private static <T> void displayLinkedBag(BagInterface<T> bag)
    {
        T[] bagArray = bag.toArray();
        for (T element : bagArray)
        {
            System.out.print(element + " ");
        }
        System.out.println();
    }



}