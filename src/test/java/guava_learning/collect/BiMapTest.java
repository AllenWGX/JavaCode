package guava_learning.collect;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class BiMapTest {
	@Test
	public void testBiMap() {
		BiMap<String,Integer> bimap = HashBiMap.create();
		bimap.put("samsung", 1);
		bimap.put("vivo", 2);
		//System.out.println(bimap);
		assertThat(bimap.toString(),is("{samsung=1, vivo=2}"));
		//
		BiMap<Integer,String> bimap_inverse = bimap.inverse();
		System.out.println(bimap_inverse);
	}
	
	@Test
	public void testForcePut() {
		BiMap<String,Integer> bimap = HashBiMap.create();
		Integer i = new Integer(1);
		bimap.put("samsung", i);
		try {
			bimap.put("vivo", i);
		}catch(IllegalArgumentException ex) {
			assertThat(bimap.toString(), is("{samsung=1}"));
		}
		bimap.forcePut("vivo", i);
		//System.out.println(bimap);
		assertThat(bimap.toString(), is("{vivo=1}"));
	}
}
