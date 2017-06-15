package ref;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import org.junit.Test;

/***
 *  Test Weak Reference and WeakHashMap
 *  Execute Command : java -Xmx2m ... 
 */
public class TestWeakReference{
    private static final int NUM = (int)1e8;
    
    @Test
    public void ref(){
        Map<Integer,Integer> map = new HashMap<>();
        for( int i = 0; i < NUM ; ++i )map.put(new Integer(i), new Integer(i)); //OOM
    }
    
    @Test
    public void weakref(){
        Map<Integer,Integer> map = new WeakHashMap<>();
        for( int i = 0; i < NUM ; ++i )map.put(new Integer(i), new Integer(i)); //Succceed
    }
}
