package cn.live.wangongxi.lucene.test;

import java.io.IOException;

import org.junit.Test;

public class IndexUtilsTest {
	@Test
	public void testCreateIndex() {
		IndexUtils util = new IndexUtils();
		util.createIndex();
	}
	
	@Test
	public void testQueryIndex() throws IOException {
		IndexUtils util = new IndexUtils();
		util.queryIndex();
	}
	
	@Test
	public void testDeleteIndex() throws IOException {
		IndexUtils util = new IndexUtils();
		util.deleteIndex();
	}
	
}
