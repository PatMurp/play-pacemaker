package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.google.common.base.Objects;

import play.db.ebean.Model;

@SuppressWarnings("serial")
@Entity
public class Activity extends Model
{
  @Id
  @GeneratedValue
  public Long id;
  public String type;
  public String location;
  public double distance;
  public String starttime;
  public String duration;
  
  public Activity()
  {
  }

  public Activity(String type, String location, double distance, String starttime, String duration)
  {
    this.type = type;
    this.location = location;
    this.distance = distance;
    this.starttime = starttime;
    this.duration = duration;
  }
  
  public void update (Activity activity)
  {
    this.type = activity.type;
    this.location = activity.location;
    this.distance = activity.distance;
    this.starttime = activity.starttime;
    this.duration = activity.duration;
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this)
        .add("Type", type)
        .add("Location", location)
        .add("Distance", distance)
        .add("Start Time", starttime)
        .add("Duration", duration).toString();
  }
  
  @Override
  public boolean equals(final Object obj)
  {
    if (obj instanceof Activity)
    {
      final Activity other = (Activity) obj;
      return Objects.equal(type, other.type)
          && Objects.equal(location, other.location)
          && Objects.equal(distance, other.distance)
          && Objects.equal(starttime, other.starttime)
          && Objects.equal(duration, duration);
    }
    else
    {
      return false;
    }
  }
  
  public static Activity findById(Long id)
  {
    return find.where().eq("id", id).findUnique();
  }
  
  public static List<Activity> findAll()
  {
    return find.all();
  }
  
  public static void deleteAll()
  {
    for (Activity activity : Activity.findAll())
    {
      activity.delete();
    }
  }
  
  public static Model.Finder<String, Activity> find = new Model.Finder<String, Activity>(String.class, Activity.class);
}
