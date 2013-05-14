package controllers;

import models.Article;
import play.*;
import play.data.Form;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  
	
	static Form<Article> articleForm = Form.form(Article.class);
	static String title = Configuration.root().getString("title");
	
	public static Result index() {
		return ok (index.render(title,articleForm,Article.all()));
	}
	
	
    public static Result newArticle() {
    	Form<Article> filledform = articleForm.bindFromRequest();
    	if(filledform.hasErrors()) {
    		return badRequest(
    				index.render(title,filledform,Article.all())
    		);
    	}else {
    		Article.add(filledform.get());
    		return redirect(routes.Application.index());
    	}
    }
    
    
  
}
