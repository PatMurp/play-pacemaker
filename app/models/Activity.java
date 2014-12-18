package models;

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

  
  public Activity()
  {
  }

  public Activity(String type, String location, double distance)
  {
    this.type = type;
    this.location = location;
    this.distance = distance;
  }
  
//  public void update (Activity activity)
//  {
//    this.type = activity.type;
//    this.location = activity.location;
//    this.distance = activity.distance;
//  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).addValue(id)
                                       .addValue(type)
                                       .addValue(location)
                                       .addValue(distance)
                                       .toString();
  }
  
  @Override
  public boolean equals(final Object obj)
  {
    if (obj instanceof Activity)
    {
      final Activity other = (Activity) obj;
      return Objects.equal(type, other.type)
          && Objects.equal(location, other.location)
          && Objects.equal(distance, other.distance);
    }
    else
    {
      return false;
    }
  }
  
  @Override  
  public int hashCode()  
  {  
     return Objects.hashCode(this.id, this.type, this.location, this.distance);  
  }
  
  public static Activity findById(Long id)
  {
    return find.where().eq("id", id).findUnique();
  }
  
  public static Model.Finder<String, Activity> find = new Model.Finder<String, Activity>(String.class, Activity.class);
}
