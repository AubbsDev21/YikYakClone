package yikyakclone.plutonium239.com.yikyakclone.models;

import android.location.Location;

import com.parse.ParseGeoPoint;
import com.parse.ParseObject;

/**
 * Created by alexander on 7/2/2015.
 */
public abstract class BaseParseVote extends ParseObject {

    protected void setValue(int value) {
        put("value", value);
    }

    public void makeUpVote() {
        setValue(1);
    }

    public void makeDownVote() {
        setValue(-1);
    }

    public abstract void setUser(ParseYakUser user);

    public abstract ParseYakUser getUser();

    public void setLocation(Location location) {
        put("location", new ParseGeoPoint(location.getLatitude(), location.getLongitude()));
    }
}
