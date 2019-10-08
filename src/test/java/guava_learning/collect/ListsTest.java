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
			ex.printStackTrace();
			System.out.println(intLst);
		}
	}
	
	@Test
	public void cartesianProductTest() {
		List<String> userLst = Lists.newArrayList("user1","user2");
		List<String> itemLst = Lists.newArrayList("item1","item2");
		List<List<String>> result = Lists.cartesianProduct(userLst, itemLst);
		System.out.println(result);
	}
	
	@Test
	public void stringToCharLstTest() {
		List<Character> charLst = Lists.charactersOf("Hello World");
		System.out.println(charLst);
	}
	
	@Test
	public void partitionTest() {
		List<List<Integer>> result = Lists.partition(Lists.newArrayList(1,2,3,4), 2);
		System.out.println("After Partiton: " + result);
	}
}
