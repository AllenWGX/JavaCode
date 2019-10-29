package guava_learning.collect;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.Test;

import com.google.common.collect.Lists;

public class ListsTest {
	@Test
	public void newListTest() {
		List<Integer> intLst = Lists.newArrayList(1,2,3);
		assertEquals(intLst.toString(),"[1, 2, 3]");
		CopyOnWriteArrayList<Integer> copuOnWriteLst = Lists.newCopyOnWriteArrayList(intLst);
		assertEquals(copuOnWriteLst.toString(),"[1, 2, 3]");
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void arrayToLstTest() {
		Integer[] intArray = new Integer[] {1,2,3};
		List<Integer> intLst = Lists.asList(0, intArray);
		assertEquals(intLst.toString(),"[0, 1, 2, 3]");
		intLst.add(4);
	}
	
	@Test
	public void cartesianProductTest() {
		List<String> userLst = Lists.newArrayList("user1","user2");
		List<String> itemLst = Lists.newArrayList("item1","item2");
		List<List<String>> result = Lists.cartesianProduct(userLst, itemLst);
		assertEquals(
		result.toString(),
		"[[user1, item1], [user1, item2], [user2, item1], [user2, item2]]"
		);
	}
	
	@Test
	public void stringToCharLstTest() {
		List<Character> charLst = Lists.charactersOf("Hello World");
		assertEquals(charLst.toString(), "[H, e, l, l, o,  , W, o, r, l, d]");
	}
	
	@Test
	public void partitionTest() {
		List<List<Integer>> result = Lists.partition(Lists.newArrayList(1,2,3,4), 2);
		assertEquals(result.toString(),"[[1, 2], [3, 4]]");
	}
}
