package guava_learning.collect;

import org.junit.Test;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class MultiMapTest {
	@Test
	public void testMultiValue() {
		Multimap<String,String> multimap = HashMultimap.create();
		multimap.put("apple", "brand");
		multimap.put("apple", "fruit");
		System.out.println(multimap);
	}
}
