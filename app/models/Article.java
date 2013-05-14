package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.Required;


public class Article {
	@Required(message="名前欄は必須です")
	public String name;
	
	@Required(message="メール欄は必須です")
	@Email(message="メールの形式で入力してください")
	public String mail;
	public Boolean isMailPrivate;
	public Calendar postTime ;
	
	@Required(message="内容は必須です")
	public String content;
	static List<Article> articles = new LinkedList<>();
	static DateFormat format = SimpleDateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.MEDIUM);
	
	
	
	public static void add(Article article) {
		//ここで書き込みを追加する処理を書く
		if (article.isMailPrivate == null) {
	        article.isMailPrivate = false;
	    }
		article.postTime = Calendar.getInstance();
		articles.add(article);
		
	}
	
	public static List<Article> all(){
		return articles;
	}
	
	public String getTimeString() {
		Date date = new Date(this.postTime.getTimeInMillis());
		return format.format(date);
	}
	
	public String showMail() {
	    return this.isMailPrivate ? "秘密" : this.mail;
	}
	
	
			
}

