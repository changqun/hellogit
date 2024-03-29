package blog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ChangQun
 * Blogを操作するビジネスロジック
 */
public class BlogController {

	/**
	 * シングルトンのインスタンス
	 */
	private static BlogController controller = new BlogController();
	
	private int idCounter;
	
	/**
	 * Blogのリスト
	 */
	private List<Topic> topics = new ArrayList<Topic>();
	
	/**
	 * このクラスのインスタンスを取得します。
	 * @return BlogControllerのインスタンス
	 */
	public static BlogController getInstance() {
		return controller;
	}
	
	private BlogController() {
	}
	
	/**
	 * トピックをポスト（登録）します。
	 * @param topic トピック
	 */
	public void postTopic(Topic topic) {
		synchronized(this) {
			topic.setId(idCounter++);
			topic.setPostDate(new Date());
			topics.add(topic);
		}
	}
	
	/**
	 * 最近の（というか全部の）トピックを取得します。
	 * @return トピックのリスト
	 */
	public List<Topic> getTopics() {
		return new ArrayList<Topic>(topics);
	}
}
