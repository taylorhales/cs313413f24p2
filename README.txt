TestList Class Answers:
For both the TestIterator and TestList classes, there is not much of a difference behaviorally between arrays and linked
lists. Both arrays and linked lists have the same interface and iterator operations such as add, remove,and next and work
as expected. The real difference between the two is the performance, linked lists are more efficient when removing
elements while array lists are much faster with simple operations like accessing elements.


In the class TestList, the method list.remove(5) removes the element that is currently located at an index of 5 from the
list. So, based on the elements added to the list in testRemoveObject(), that would be 77.

In the class TestList, the method list.remove(Integer.valueOf(5)) removes the first occurrence of the value 5 from the
list. The removal is based on where the value 5 first appears in the list, not the 5th index of the list like
with list.remove(5).

TestIterator Class Answers:

In the testRemove() method, when you use i.remove() that makes sure that the element returned by “i.next()” is removed
from the list in the correct sequence. If you try to remove an element without using the iterator’s remove() method, it
would throw the exception “ConcurrentModificationException.” If you use “list.remove(Integer.valueOf(77))” instead, that
removes only the first occurrence of 77, but it will throw the exception. So, the remove() method is preferred while
looping over elements with an Iterator.

TestPerformance Answer:

Based on the test results, the ArrayList performs at a slower pace as the size increases when adding or removing elements.
It’s noticeable at larger sizes, for example 18 seconds for size 100,000. ArrayList has a Big O complexity of O(n) when
adding or removing elements from the beginning. ArrayList is very fast for access operations, there is almost no change
in time as the size grows. That is because ArrayList has O(1) random access, so it is very efficient for accessing an
element by index regardless of list size

LinkedList performs quickly across all of the sizes for adding/removing, in comparison it only takes 2 ms for size 100,000.
LinkedList has a Big O complexity of O(1) for adding or removing elements from the beginning of the list since it is a
node-based structure. LinkedList becomes slower as the size increases when accessing elements, for example 40 seconds
for size 100,000. It has an O(n) complexity for accessing elements since they have to traverse nodes to reach a
particular index.

So, LinkedList is better than ArrayList for adding and removing elements while ArrayList is better for accessing elements.
