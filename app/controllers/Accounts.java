package controllers;

import models.User;
import play.*;
import play.data.Form;
import play.mvc.*;
import views.html.*;

public class Accounts extends Controller
{
  private static final Form<User> userForm = Form.form(User.class);
  

  public static Result index()
  {
    return ok(welcome_main.render());
  }
  
  public static Result signup()
  {
    return ok(accounts_signup.render());
  }
  
  public static Result login()
  {
    return ok(accounts_login.render(Form.form(Login.class)));
  }
  
  public static Result logout()
  {
    session().clear();
    flash("success", "You have sucessfully logged out");
    return redirect(routes.Accounts.index());
  }
  
  public static Result register()
  {
    Form<User> boundForm = userForm.bindFromRequest();
    if(userForm.hasErrors())
    {
      return badRequest();
    }
    else
    {
      User user = boundForm.get();
      Logger.info("User = " + user.toString());
      user.save();
      return ok(welcome_main.render());
    }
  }
  
  public static Result authenticate() 
  {
    Form<Login> loginForms = Form.form(Login.class).bindFromRequest();
    if (loginForms.hasErrors())
    {
      return badRequest(accounts_login.render(loginForms));
    }
    else
    {
      session().clear();
      session("email", loginForms.get().email);
      return redirect(routes.Dashboard.index());
    }

  }
  
  /**
   * inner static login class
   *
   */
  public static class Login
  {
    public String email;
    public String password;
    
    /**
     * @return error messager or null
     */
    public String validate()
    {
      if(User.authenticate(email, password) == null)
      {
        return "Invalid user or password";
      }
      return null;
    }
  }

  
}
