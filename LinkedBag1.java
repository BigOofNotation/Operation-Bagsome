/**
    A class of bags whose entries are stored in a chain of linked nodes.
    The bag is never full.
    INCOMPLETE DEFINITION; includes definitions for the methods add,
    toArray, isEmpty, and getCurrentSize.
    @author Frank M. Carrano, Timothy M. Henry
    @version 5.0
*/
public final class LinkedBag1<T> implements BagInterface<T>
{
	private Node firstNode;       // Reference to first node
	private int numberOfEntries;

	public LinkedBag1()
	{
		firstNode = null;
        numberOfEntries = 0;
	} // end default constructor

	/** Adds a new entry to this bag.
        @param newEntry  The object to be added as a new entry.
	    @return  True. */
	public boolean add(T newEntry) // OutOfMemoryError possible
	{
      // Add to beginning of chain:
		Node newNode = new Node(newEntry);
		newNode.next = firstNode;  // Make new node reference rest of chain
                                 // (firstNode is null if chain is empty)
        firstNode = newNode;       // New node is at beginning of chain
		numberOfEntries++;
		return true;
	} // end add

	/** Retrieves all entries that are in this bag.
       @return  A newly allocated array of all the entries in this bag. */
	public T[] toArray()
	{
      // The cast is safe because the new array contains null entries.
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast
        
        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null))
        {
            result[index] = currentNode.data;
            index++;
            currentNode = currentNode.next;
        } // end while
        
        return result;
        // Note: The body of this method could consist of one return statement,
        // if you call Arrays.copyOf
    } // end toArray
    
	/** Sees whether this bag is empty.
       @return  True if the bag is empty, or false if not. */
	public boolean isEmpty()
	{
		return numberOfEntries == 0;
	} // end isEmpty
	
    /** Gets the number of entries currently in this bag.
       @return  The integer number of entries currently in the bag. */
	public int getCurrentSize()
	{
		return numberOfEntries;
	} // end getCurrentSize
    
// STUBS:

	/** Removes one unspecified entry from this bag, if possible.
        @return  Either the removed entry, if the removal
                was successful, or null. */
	public T remove()
    {
        if (firstNode != null) {
            T result = firstNode.data;
            firstNode = firstNode.next;
            numberOfEntries--;
            return result;
        } else {
            return null;
        }
    } // end remove

	/** Removes one occurrence of a given entry from this bag.
        @param anEntry  The entry to be removed.
        @return  True if the removal was successful, or false otherwise. */
    public boolean remove(T anEntry)
    {
        Node currentNode = firstNode;
        Node previousNode = null;
        while (currentNode != null) {
            if (currentNode.data.equals(anEntry)) {
                if (previousNode == null) {
                    firstNode = currentNode.next;
                } else {
                    previousNode.next = currentNode.next;
                }
                numberOfEntries--;
                return true;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        return false;
    } // end remove
	
	/** Removes all entries from this bag. */
	public void clear()
    {
        firstNode = null;
        numberOfEntries = 0;
    } // end clear
	
	/** Counts the number of times a given entry appears in this bag.
		@param anEntry  The entry to be counted.
	    @return  The number of times anEntry appears in the bag. */
	public int getFrequencyOf(T anEntry)
    {
        int frequency = 0;
        Node currentNode = firstNode;
        while (currentNode != null) {
            if (currentNode.data.equals(anEntry)) {
                frequency++;
            }
            currentNode = currentNode.next;
        }
        return frequency;
    } // end getFrequencyOf
	
	/** Tests whether this bag contains a given entry.
		@param anEntry  The entry to locate.
		@return  True if the bag contains anEntry, or false otherwise. */
	public boolean contains(T anEntry)
    {
        Node currentNode = firstNode;
        while (currentNode != null) {
            if (currentNode.data.equals(anEntry)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    } // end contains

	private class Node
	{
	  private T data; // Entry in bag
	  private Node next; // Link to next node

		private Node(T dataPortion)
		{
			this(dataPortion, null);
		} // end constructor
		
		private Node(T dataPortion, Node nextNode)
		{
			data = dataPortion;
			next = nextNode;
		} // end constructor
	} // end Node

    // Union method
    public BagInterface<T> union(BagInterface<T> BagInterface) {
        if (BagInterface == null) throw new IllegalArgumentException("The other bag cannot be null.");

        LinkedBag1<T> resultBag = new LinkedBag1<>();
        Node currentNode = firstNode;
        while (currentNode != null) {
            resultBag.add(currentNode.data);
            currentNode = currentNode.next;
        }
        T[] tempArray = BagInterface.toArray();
        
        for (int i = 0; i < tempArray.length; i++){
            resultBag.add(tempArray[i]);
        }
        return resultBag;
    }

    // Intersection method
    public BagInterface<T> intersection(BagInterface<T> BagInterface) {
        if (BagInterface == null) {
            throw new IllegalArgumentException("The other bag cannot be null.");
        }

        BagInterface<T> resultBag = new LinkedBag1<>();
        Node currentNode = firstNode;
        
        while (currentNode != null) {
            if(BagInterface.contains(currentNode.data)){
                if(!resultBag.contains(currentNode.data)){
                    resultBag.add(currentNode.data);
                }
            }
            currentNode = currentNode.next;
        }
        return resultBag;
    }

    public BagInterface<T> difference(BagInterface<T> otherBag) {
        if (otherBag == null) {
            throw new IllegalArgumentException("The other bag cannot be null.");
        }

        BagInterface<T> leftovers = new LinkedBag1<>();

        Node currentNode = firstNode;
        
        while (currentNode != null) {
            leftovers.add(currentNode.data);
            currentNode = currentNode.next;
        }

        BagInterface<T> intersect = this.intersection(otherBag);
        T[] temp = intersect.toArray();

        for (int i = 0; i < temp.length; i++){
            leftovers.remove(temp[i]);
        }
        return leftovers;
    }
} // end LinkedBag1