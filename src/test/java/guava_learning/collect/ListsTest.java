package guava_learning.collect;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.Test;

import com.google.common.collect.Lists;

public class ListsTest {
	@Test
	public void newListTest() {
		List<Integer> intLst = Lists.newArrayList(1,2,3);
		System.out.println(intLst);
		CopyOnWriteArrayList<Integer> copuOnWriteLst = Lists.newCopyOnWriteArrayList(intLst);
		System.out.println(copuOnWriteLst);
	}
	
	@Test
	public void arrayToLstTest() {
		Integer[] intArray = new Integer[] {1,2,3};
		List<Integer> intLst = Lists.asList(0, intArray);
		System.out.println(intLst);
		try {
			intLst.add(4);
		}catch(UnsupportedOperationException ex) {
			System.out.println(intLst);
		}
	}
}
