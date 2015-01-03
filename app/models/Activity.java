package models;

import static com.google.common.base.Objects.toStringHelper;
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
  public String kind;
  public String location;
  public double distance;
  public String date;

  
  public Activity()
  {
  }

  public Activity(String type, String location, double distance, String date)
  {
    this.kind = type;
    this.location = location;
    this.distance = distance;
    this.date = date;
  }
  
//  public void update (Activity activity)
//  {
//    this.type = activity.type;
//    this.location = activity.location;
//    this.distance = activity.distance;
//  }
  
  public String toString()
  {
    return toStringHelper(this).addValue(id)
                                       .addValue(kind)
                                       .addValue(location)
                                       .addValue(distance)
                                       .addValue(date)
                                       .toString();
  }
  
  @Override
  public boolean equals(final Object obj)
  {
    if (obj instanceof Activity)
    {
      final Activity other = (Activity) obj;
      return Objects.equal(kind, other.kind)
          && Objects.equal(location, other.location)
          && Objects.equal(distance, other.distance)
          && Objects.equal(date, other.date);
    }
    else
    {
      return false;
    }
  }
  
  @Override  
  public int hashCode()  
  {  
     return Objects.hashCode(this.id, this.kind, this.location, this.distance, this.date);  
  }
  
  public static Activity findById(Long id)
  {
    return find.where().eq("id", id).findUnique();
  }
  
  public static Model.Finder<String, Activity> find = new Model.Finder<String, Activity>(String.class, Activity.class);
}
