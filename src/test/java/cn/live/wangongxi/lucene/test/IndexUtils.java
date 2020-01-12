package cn.live.wangongxi.lucene.test;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class IndexUtils {
	private static String[] ids = {"1","2","3","4"};
	private static String[] emails = {"a@sina.com","b@souhu.com","c@baidu.com","d@taobao.com"};
	private static String[] contents = {"sina is a chinese internet company","sohou is similar with sina"
										,"baidu is a chinese search engine company","taobao is the biggest chinese e-commerence company"};
	private static int[] attaches = {4,6,9,2};
	private static String[] names = {"john welson","mike jackson","susan white","emma tompson"};
	
	private Directory indexDir = null;	//
	
	public IndexUtils() {
		try {
			indexDir = FSDirectory.open(new File("lucene/test/index"));
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	/***
	 *	创建索引 
	 */
	public void createIndex() {
		IndexWriter writer = null;
		try{
			IndexWriterConfig writerConfig = new IndexWriterConfig(Version.LUCENE_47, new WhitespaceAnalyzer(Version.LUCENE_47));
			writer = new IndexWriter (indexDir,writerConfig);
			Document doc = null;
			for( int i = 0; i < ids.length; ++i ) {
				doc = new Document();
				doc.add(new StringField("id",ids[i],Store.YES));
				doc.add(new StringField("email",emails[i],Store.YES));
				doc.add(new TextField("content", contents[i],Store.NO));
				doc.add(new IntField("attach",attaches[i],Store.YES));
				doc.add(new StringField("name",names[i],Store.YES));
				writer.addDocument(doc);
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			if( null != writer ) {
				try {
					writer.close();	//finally close will commit index
				}catch(IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	
	/***
	 *	查询索引 
	 * @throws IOException 
	 */
	public void queryIndex() throws IOException {
		IndexReader reader = null;
		try {
			reader = DirectoryReader.open(indexDir);
//			assert(reader.maxDoc() == ids.length);
//			assert(reader.numDocs() == ids.length);
			System.out.println("Max Doc: " + reader.maxDoc());
			System.out.println("Num Doc: " + reader.numDocs());
			System.out.println("Del Doc: " + reader.numDeletedDocs());
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			if( reader != null )reader.close();
		}
	}
	
	/***
	 * 删除索引
	 * @throws IOException 
	 */
	public void deleteIndex() throws IOException {
		IndexWriter writer = null;
		try {
			IndexWriterConfig writerConfig = new IndexWriterConfig(Version.LUCENE_47, new WhitespaceAnalyzer(Version.LUCENE_47));
			writer = new IndexWriter (indexDir,writerConfig);
			writer.deleteDocuments(new Term("id","1"));
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			if( writer != null )writer.close();
		}
	}
	
}
