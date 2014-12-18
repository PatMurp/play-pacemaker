package controllers;

import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.*;
import views.html.*;

public class Accounts extends Controller
{
  private static final Form<User> userForm = Form.form(User.class);
  private static final Form<User> loginForm = Form.form(User.class);

  public static Result index()
  {
    return ok(welcome_main.render());
  }
  
}
