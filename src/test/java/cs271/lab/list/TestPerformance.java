package cs271.lab.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPerformance {

  // TODO run test and record running times for SIZE = 10, 100, 1000, 10000, ...
  // (choose in conjunction with REPS below up to an upper limit where the clock
  // running time is in the tens of seconds)
  // TODO (optional) refactor to DRY
  // which of the two lists performs better as the size increases?
  private final int[] SIZE = {10, 100, 1000, 10000, 100000};

  // TODO choose this value in such a way that you can observe an actual effect
  // for increasing problem sizes
  private final int REPS = 1000000;

  private List<Integer> arrayList;

  private List<Integer> linkedList;

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {
    arrayList = null;
    linkedList = null;
  }

  // method to add & remove for ArrayList & LinkedList
  private void testAddRemove(List<Integer> list, int size, String listType) {
    // initialize list with 'size' elements
    for (var i = 0; i < size; i++) {
      list.add(i);
    }

    long start = System.currentTimeMillis(); // starts timer

    // add(0, 77) & remove(0) for REPS times
    for (var r = 0; r < REPS; r++) {
      list.add(0, 77);
      list.remove(0);
    }

    long end = System.currentTimeMillis(); // ends timer
    System.out.println(listType + " add & remove for size " + size + " took " + (end - start) + " ms");
  }

  // method to test access for ArrayList & LinkedList
  private void testAccess(List<Integer> list, int size, String listType) {
    long sum = 0;
    long start = System.currentTimeMillis(); // Start timer

    // REPS times accessing list elements using modulo to simulate random access
    for (var r = 0; r < REPS; r++) {
      sum += list.get(r % size);
    }

    long end = System.currentTimeMillis(); // ends timer
    System.out.println(listType + " access for size " + size + " took " + (end - start) + " ms, sum = " + sum);
  }

  // test method for measuring performance

  @Test
  public void testPerformance() {
    // Loop through each size
    for (int size : SIZE) {
      System.out.println("Testing size: " + size);

      // Test ArrayList
      arrayList = new ArrayList<>(size);
      testAddRemove(arrayList, size, "ArrayList");
      testAccess(arrayList, size, "ArrayList");

      // Test LinkedList
      linkedList = new LinkedList<>();
      testAddRemove(linkedList, size, "LinkedList");
      testAccess(linkedList, size, "LinkedList");
    }
  }
}
