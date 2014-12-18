package controllers;

import java.util.List;

import models.User;
import play.data.Form;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
  
    private static final Form<User> userForm = Form.form(User.class);

    public static Result index() {
        List<User> users = User.findAll();
        return ok(index.render(users));
    } 
    
    public static Result addUser()
    {
      return ok(adduser.render());
    }
    
    public static Result submitUser()
    {
      Form<User> boundForm = userForm.bindFromRequest();
      User user = boundForm.get();
      user.save();
      return redirect ("/");
    }
    
    public static Result showUser(Long id)
    {
      User user = User.findById(id);
      return ok(showuser.render(user));
    }

}
