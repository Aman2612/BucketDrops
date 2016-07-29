package techcoder.aman.bucketdrops.beans;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Aman on 30/07/16.
 */
public class Drop extends RealmObject{
    public Drop(String what, long when, long added, boolean completed) {
        this.what = what;
        this.when = when;
        this.added = added;
        this.completed = completed;
    }

    private String what;
    @PrimaryKey
    private long when;
    private long added;
    private boolean completed;

    public Drop() {
    }


    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public long getWhen() {
        return when;
    }

    public void setWhen(long when) {
        this.when = when;
    }

    public long getAdded() {
        return added;
    }

    public void setAdded(long added) {
        this.added = added;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
