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
}
