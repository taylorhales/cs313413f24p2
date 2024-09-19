package cs271.lab.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestList {

  private List<Integer> list;

  @Before
  public void setUp() throws Exception {
    // Array list for testing
    list = new ArrayList<Integer>();
    // DONE -- TODO also try with a LinkedList - does it make any difference?

    // LinkedList for testing
   // list = new LinkedList<>();
  }

  @After
  public void tearDown() throws Exception {
    list = null;
  }

  @Test
  public void testSizeEmpty() {
    assertTrue(list.isEmpty());
    assertEquals(0, list.size());
    try {
      list.get(0);
      fail("there should not be any items in the list");
    } catch (Exception ex) {
    }
  }

  @Test
  public void testSizeNonEmpty() {
    // DONE -- TODO fix the expected values in the assertions below
    list.add(77);
    assertEquals(false, list.isEmpty()); // the list is not empty, so it should be 'false'
    assertEquals(1, list.size()); // after adding 77, size should be 1, not 0
    assertEquals(77, list.get(0).intValue()); // 1st element is 77, not 0
  }

  @Test
  public void testContains() {
    // DONE -- TODO write assertions using -- DONE
    // list.contains(77)
    // that hold before and after adding 77 to the list

    // list shouldn't contain 77 before adding
    assertFalse(list.contains(77)); // should be false bc 77 isn't in list

    list.add(77);  // add 77 to the list

    assertTrue(list.contains(77));  // should be true after adding 77 to list
  }

  @Test
  public void testAddMultiple() {
    list.add(77);
    list.add(77);
    list.add(77);
    // DONE -- TODO fix the expected values in the assertions below
    assertEquals(3, list.size()); // the size of the list is 3, not 0
    assertEquals(0, list.indexOf(77)); // this is correct, no changes
    assertEquals(77, list.get(1).intValue()); // 2nd element is 77, not 0
    assertEquals(2, list.lastIndexOf(77)); // should be index 2, not 0
  }

  @Test
  public void testAddMultiple2() {
    list.add(33);
    list.add(77);
    list.add(44);
    list.add(77);
    list.add(55);
    list.add(77);
    list.add(66);
    // DONE -- TODO fix the expected values in the assertions below
    assertEquals(7, list.size());  //size of list is 7, not 0
    assertEquals(1, list.indexOf(77)); //1st occurrence of 77 is at 1
    assertEquals(5, list.lastIndexOf(77));  // last occurrence is at 5
    assertEquals(44, list.get(2).intValue()); // element at index 2 is 44
    assertEquals(77, list.get(3).intValue()); // element at index 3 is 77
    assertEquals(List.of(33, 77, 44, 77, 55, 77, 66), list); // check whole list
  }

  @Test
  public void testRemoveObject() {
    list.add(3);
    list.add(77);
    list.add(4);
    list.add(77);
    list.add(5);
    list.add(77);
    list.add(6);
    list.remove(5); // what does this method do?
    // removes value at index 5
    // DONE -- TODO fix the expected values in the assertions below
    assertEquals(6, list.size()); // 6 elements in list after removal of index 5
    assertEquals(1, list.indexOf(77)); // 77 is at index 1
    assertEquals(3, list.lastIndexOf(77)); // last index of 77 is 3 after removal
    assertEquals(4, list.get(2).intValue()); // 4 at index 2 after removal
    assertEquals(77, list.get(3).intValue()); // 77 at index 3 after removal
    list.remove(Integer.valueOf(5)); // what does this one do?
    // removes 1st occurrence of value 5
    assertEquals(5, list.size()); // 5 elements in list after removal of element 5
    assertEquals(1, list.indexOf(77)); // 77 is at index 1
    assertEquals(3, list.lastIndexOf(77)); // last index of 77 is 3 after removal
    assertEquals(4, list.get(2).intValue()); // 4 at index 2 after removal
    assertEquals(77, list.get(3).intValue()); // 77 at index 3 after removal
  }

  @Test
  public void testContainsAll() {
    list.add(33);
    list.add(77);
    list.add(44);
    list.add(77);
    list.add(55);
    list.add(77);
    list.add(66);
    // DONE -- TODO using containsAll and List.of (see above),
    // 1) assert that list contains all five different numbers added
    assertTrue(list.containsAll(List.of(33, 44, 55, 66, 77)));
    // 2) assert that list does not contain all of 11, 22, and 33
    assertFalse(list.containsAll(List.of(11, 22, 33)));
  }

  @Test
  public void testAddAll() {
    // DONE -- TODO in a single statement using addAll and List.of,
    // add items to the list to make the following assertions pass
    // (without touching the assertions themselves)

    // addAll will add 7 values to the list at once
    list.addAll(List.of(33, 77, 44, 77, 55, 77, 66));

    assertEquals(7, list.size()); // checks that the list has 7 elements
    assertEquals(33, list.get(0).intValue());
    assertEquals(77, list.get(1).intValue());
    assertEquals(44, list.get(2).intValue());
    assertEquals(77, list.get(3).intValue());
    assertEquals(55, list.get(4).intValue());
    assertEquals(77, list.get(5).intValue());
    assertEquals(66, list.get(6).intValue());
  }

  @Test
  public void testRemoveAll() {
    list.add(33);
    list.add(77);
    list.add(44);
    list.add(77);
    list.add(55);
    list.add(77);
    list.add(66);
    // DONE -- TODO in a single statement using removeAll and List.of,
    // remove items from the list to make the following assertions pass
    // (without touching the assertions themselves)

    // removeAll is used to remove 33, 44, 55, & 66
    list.removeAll(List.of(33, 44, 55, 66));

    assertEquals(3, list.size());
    assertEquals(List.of(77, 77, 77), list);
  }

  @Test
  public void testRetainAll() {
    list.add(33);
    list.add(77);
    list.add(44);
    list.add(77);
    list.add(55);
    list.add(77);
    list.add(66);
    // DONE -- TODO in a single statement using retainAll and List.of,
    // remove items from the list to make the following assertions pass
    // (without touching the assertions themselves)

    // only keep value 77 in the list, remove the rest
    list.retainAll(List.of(77));

    assertEquals(3, list.size());
    assertEquals(List.of(77, 77, 77), list);
  }

  @Test
  public void testSet() {
    list.add(33);
    list.add(77);
    list.add(44);
    list.add(77);
    list.add(55);
    list.add(77);
    list.add(66);
    // DONE -- TODO use the set method to change specific elements in the list
    // such that the following assertions pass
    // (without touching the assertions themselves)

    // modify specific elements in the list
    list.set(1, 99); // at index 1, replaces 77 with 99
    list.set(3, 99); // at index 3, replaces 77 with 99
    list.set(5, 99); // at index 5, replaces 5 with 99

    assertEquals(7, list.size());
    assertEquals(33, list.get(0).intValue());
    assertEquals(99, list.get(1).intValue());
    assertEquals(44, list.get(2).intValue());
    assertEquals(99, list.get(3).intValue());
    assertEquals(55, list.get(4).intValue());
    assertEquals(99, list.get(5).intValue());
    assertEquals(66, list.get(6).intValue());
  }

  @Test
  public void testSubList() {
    list.add(33);
    list.add(77);
    list.add(44);
    list.add(77);
    list.add(55);
    list.add(77);
    list.add(66);
    // DONE -- TODO fix the arguments in the subList method so that the assertion
    // passes

    // update subList to 2 to 5
    // extract elements starting at index 2 up to index 5
    assertEquals(List.of(44, 77, 55), list.subList(2, 5));
  }
}
