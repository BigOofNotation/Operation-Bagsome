import java.util.Arrays;
/**
   A class that implements a bag of objects by using an array.
	The bag is never full.
   @author Frank M. Carrano, Timothy M. Henry
   @version 5.0
*/
public final class ResizableArrayBag<T> implements BagInterface<T>
{
	private T[] bag; // Cannot be final due to doubling
	private int numberOfEntries;
   private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 25; // Initial capacity of bag
	private static final int MAX_CAPACITY = 10000;

	/** Creates an empty bag whose initial capacity is 25. */
	public ResizableArrayBag() 
	{
		this(DEFAULT_CAPACITY);
	} // end default constructor

	/** Creates an empty bag having a given initial capacity.
	    @param initialCapacity  The integer capacity desired. */
	public ResizableArrayBag(int initialCapacity)
	{
      checkCapacity(initialCapacity);
      
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempBag = (T[])new Object[initialCapacity]; // Unchecked cast
      bag = tempBag;
      numberOfEntries = 0;
      integrityOK = true;
	} // end constructor

	/** Creates a bag containing given entries.
	    @param contents  An array of objects. */
   public ResizableArrayBag(T[] contents) 
   {
      checkCapacity(contents.length);
      bag = Arrays.copyOf(contents, contents.length);
      numberOfEntries = contents.length;
      integrityOK = true;
   } // end constructor
       
	/** Adds a new entry to this bag.
       @param newEntry  The object to be added as a new entry.
       @return  True. */
	public boolean add(T newEntry)
	{
		checkintegrity();
      if (isArrayFull())
      {
         doubleCapacity();
      } // end if
      
      bag[numberOfEntries] = newEntry;
      numberOfEntries++;
      
      return true;
	} // end add

	/** Retrieves all entries that are in this bag.
       @return  A newly allocated array of all the entries in this bag. */
	public T[] toArray() 
	{
		checkintegrity();
      
      // The cast is safe because the new array contains null entries.
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast
      for (int index = 0; index < numberOfEntries; index++)
      {
         result[index] = bag[index];
      } // end for
      
      return result;
	} // end toArray
   
	/** Sees whether this bag is empty.
       @return  True if this bag is empty, or false if not. */
	public boolean isEmpty()
	{
      return numberOfEntries == 0;
	} // end isEmpty
   
	/** Gets the current number of entries in this bag.
       @return  The integer number of entries currently in this bag. */
	public int getCurrentSize()
	{
      return numberOfEntries;
	} // end getCurrentSize
   
	/** Counts the number of times a given entry appears in this bag.
       @param anEntry  The entry to be counted.
       @return  The number of times anEntry appears in this ba. */
	public int getFrequencyOf(T anEntry)
	{
		checkintegrity();
      int counter = 0;
      
      for (int index = 0; index < numberOfEntries; index++)
      {
         if (anEntry.equals(bag[index]))
         {
            counter++;
         } // end if
      } // end for
      
      return counter;
	} // end getFrequencyOf
   
	/** Tests whether this bag contains a given entry.
       @param anEntry  The entry to locate.
       @return  True if this bag contains anEntry, or false otherwise. */
   public boolean contains(T anEntry)
	{
		checkintegrity();
      return getIndexOf(anEntry) > -1; // or >= 0
	} // end contains
   
	/** Removes all entries from this bag. */
	public void clear()
	{
      while (!isEmpty())
         remove();
	} // end clear
	
	/** Removes one unspecified entry from this bag, if possible.
       @return  Either the removed entry, if the removal
       was successful, or null. */
	public T remove()
	{
		checkintegrity();
      T result = removeEntry(numberOfEntries - 1);
      return result;
	} // end remove
	
	/** Removes one occurrence of a given entry from this bag.
       @param anEntry  The entry to be removed.
       @return  True if the removal was successful, or false if not. */
	public boolean remove(T anEntry)
	{
		checkintegrity();
      int index = getIndexOf(anEntry);
      T result = removeEntry(index);
      return anEntry.equals(result);
	} // end remove
   
 	// Locates a given entry within the array bag.
	// Returns the index of the entry, if located,
	// or -1 otherwise.
   // Precondition: checkintegrity has been called.
	private int getIndexOf(T anEntry)
	{
		int where = -1;
		boolean found = false;
		int index = 0;
      
      while (!found && (index < numberOfEntries))
		{
			if (anEntry.equals(bag[index]))
			{
				found = true;
				where = index;
			} // end if
         index++;
		} // end while
      
      // Assertion: If where > -1, anEntry is in the array bag, and it
      // equals bag[where]; otherwise, anEntry is not in the array.
      
		return where;
	} // end getIndexOf
   
   // Removes and returns the entry at a given index within the array.
   // If no such entry exists, returns null.
   // Precondition: 0 <= givenIndex < numberOfEntries.
   // Precondition: checkintegrity has been called.
	private T removeEntry(int givenIndex)
	{
		T result = null;
      
		if (!isEmpty() && (givenIndex >= 0))
		{
         result = bag[givenIndex];          // Entry to remove
         int lastIndex = numberOfEntries - 1;
         bag[givenIndex] = bag[lastIndex];  // Replace entry to remove with last entry
         bag[lastIndex] = null;             // Remove reference to last entry
         numberOfEntries--;
		} // end if
      
      return result;
	} // end removeEntry
   
   // Returns true if the array bag is full, or false if not.
	private boolean isArrayFull()
	{
		return numberOfEntries >= bag.length;
	} // end isArrayFull
   
   // Doubles the size of the array bag.
   // Precondition: checkInitialization has been called.
	private void doubleCapacity()
	{
      int newLength = 2 * bag.length;
      checkCapacity(newLength);
      bag = Arrays.copyOf(bag, newLength);
	} // end doubleCapacity
   
   // Throws an exception if the client requests a capacity that is too large.
   private void checkCapacity(int capacity)
   {
      if (capacity > MAX_CAPACITY)
         throw new IllegalStateException("Attempt to create a bag whose capacity exceeds " +
                                         "allowed maximum of " + MAX_CAPACITY);
   } // end checkCapacity
   
   // Throws an exception if receiving object is not initialized.
   private void checkintegrity()
   {
      if (!integrityOK)
         throw new SecurityException ("ArrayBag object is corrupt.");
   } // end checkintegrity


   /** Combines content of this bag with another bag
    * @param otherBag The other bag that is being combined
    * @return BagInterface<T> with the combined entries
    */
   public BagInterface<T> union(BagInterface<T> otherBag){
      checkintegrity();
      if (otherBag == null) {
         throw new IllegalArgumentException("The other bag cannot be null.");
      }

      BagInterface<T> temp = new ResizableArrayBag<>();

      for(int i = 0; i < numberOfEntries; i++){
         temp.add(bag[i]);
      }

      T[] others = otherBag.toArray();
      for(int k = 0; k < others.length; k++){
         temp.add(others[k]);
      }
      return temp;
   }

   /** Finds the common entries, duplicates included, of this bag and another bag
    * @param otherBag The other bag that is being compared
    * @return BagInterface<T> with the common entries
    */
   public BagInterface<T> intersection(BagInterface<T> otherBag){
      checkintegrity();
      if (otherBag == null) {
         throw new IllegalArgumentException("The other bag cannot be null.");
      }

      BagInterface<T> result = new ResizableArrayBag<>();
      T[] other = otherBag.toArray();

      int maxLength;
      if(numberOfEntries >= other.length){
         maxLength = other.length;
         
         for(int i = 0; i < maxLength; i++){
            if(otherBag.contains(bag[i])){
               if(!result.contains(bag[i])){
                  result.add(bag[i]);
               }
            }
         }
      } else {
         maxLength = numberOfEntries;
         
         for(int j = 0; j < maxLength; j++){
            if(otherBag.contains(bag[j])){
               if(!result.contains(bag[j])){
                  result.add(bag[j]);
               }
            }
         }
      }    

      return result;
   }

   /** Finds the entries that are different, duplicates included, between this bag and another bag
    * @param otherBag The other bag that is being compared
    * @return BagInterface<T> with the entries that are different
    */
   public BagInterface<T> difference(BagInterface<T> otherBag){
      checkintegrity();
      if (otherBag == null) {
         throw new IllegalArgumentException("The other bag cannot be null.");
      }
      BagInterface<T> result = new ResizableArrayBag<>();
      for(int x = 0; x < numberOfEntries; x++){
         result.add(bag[x]);
      }

      BagInterface<T> intersect = this.intersection(otherBag);
      T[] iArray = intersect.toArray();
      for(int i = 0; i < iArray.length; i++){
         result.remove(iArray[i]);
      }
      return result;
   }
} // end ResizableArrayBag

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

