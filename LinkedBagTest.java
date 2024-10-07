public class LinkedBagTest
{
    public static void main(String[] args)
    {
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
        LinkedBag1<String> unionBag = bag1.union(bag2);

        // Test the intersection of bag1 and bag2
        LinkedBag1<String> intersectionBag = bag1.intersection(bag2);

        // Test the difference of bag1 and bag2
        LinkedBag1<String> leftovers1 = bag1.differenceBag1(bag2);
        LinkedBag1<String> leftovers2 = bag1.differenceBag2(bag2);

        // Display the contents of bag1
        System.out.println("Bag 1 contents:");
        displayBag(bag1);

        // Display the contents of bag2
        System.out.println("\nBag 2 contents:");
        displayBag(bag2);

        // Display the contents of the union bag
        System.out.println("\nUnion of Bag 1 and Bag 2:");
        displayBag(unionBag);

        // Display the contents of the union bag
        System.out.println("\nIntersection of Bag 1 and Bag 2:");
        displayBag(intersectionBag);

        // Display the contents of leftovers from Bag 1
        System.out.println("\nLeftovers from Bag 1:");
        displayBag(leftovers1);

        // Display the contents of leftovers from Bag 2
        System.out.println("\nLeftovers from Bag 2:");
        displayBag(leftovers2);
    }

    // Helper method to display the contents of a bag
    private static <T> void displayBag(LinkedBag1<T> bag)
    {
        T[] bagArray = bag.toArray();
        for (T element : bagArray)
        {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}