package controllers;

import models.Activity;
import models.User;
import play.data.Form;
import play.mvc.*;
import views.html.*;

@Security.Authenticated(Secured.class)
public class Dashboard extends Controller
{
  private static final Form<Activity> activityForm = Form.form(Activity.class);
  
  public static Result index()
  {
    String email = session().get("email");
    User user = User.findByEmail(email);
    return ok(dashboard_main.render(user.activities));
  }
  
  public static Result report()
  {
    String email = session().get("email");
    User user = User.findByEmail(email);
    return ok(dashboard_report.render(user.activities));
  }
  
  public static Result uploadActivityForm()
  {
    return ok(dashboard_uploadactivity.render());
  } 
  
  public static Result bmiCalculate()
  {
    return ok(dashboard_bmi.render());
  }

  public static Result submitActivity()
  {
    Form<Activity> boundForm = activityForm.bindFromRequest();
    Activity activity = boundForm.get();
    
    if(activityForm.hasErrors()) 
    {
      return badRequest();
    }

    String email = session().get("email");
    User user = User.findByEmail(email);
    

    user.activities.add(activity);
    user.save();
    flash("success", "You added an activity: " + activity.kind + " in " + activity.location);
    return redirect (routes.Dashboard.index());
  }
}