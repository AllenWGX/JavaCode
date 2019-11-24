package guava_learning.base;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.base.Joiner.MapJoiner;
import com.google.common.collect.Lists;


public class JoinerTest {
    @Test
    public void joinLst(){
        Joiner joiner = Joiner.on(",").skipNulls();
        List<String> lst = Lists.newArrayList("samsung","vivo","nokia",null);
        //System.out.println(joiner.join(lst));
        assertThat(joiner.join(lst), is("samsung,vivo,nokia"));
    }
    
    @Test
    public void joinArray(){
        Joiner joiner = Joiner.on(",").skipNulls();
        Integer[] intArray = new Integer[]{1,2,3,null};
        //System.out.println(joiner.join(intArray));
        assertThat(joiner.join(intArray), is("1,2,3"));
    }
    
    @Test
    public void appendStringBuilder(){
        Joiner joiner = Joiner.on(",").skipNulls();
        List<String> lst = Lists.newArrayList("samsung","vivo","nokia",null);
        StringBuilder sb = new StringBuilder();
        joiner.appendTo(sb, lst);
        //System.out.println(sb);
        assertThat(sb.toString(), is("samsung,vivo,nokia"));
    }
    
    
    @Test
    public void joinMap(){
        MapJoiner mapJoin = Joiner.on(",").withKeyValueSeparator("=");
        Map<String,Integer> wordcount = new HashMap<String,Integer>(){{put("samsung",1);put("vivo",2);}};
        //System.out.println(mapJoin.join(wordcount));
        assertThat(mapJoin.join(wordcount), is("samsung=1,vivo=2"));
    }
}
