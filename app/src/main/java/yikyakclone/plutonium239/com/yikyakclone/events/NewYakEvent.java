package yikyakclone.plutonium239.com.yikyakclone.events;

import android.app.Activity;
import android.location.Location;

import com.parse.ParseException;
import com.parse.ParseGeoPoint;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import yikyakclone.plutonium239.com.yikyakclone.activities.MainActivity;
import yikyakclone.plutonium239.com.yikyakclone.activities.NewYakActivity;
import yikyakclone.plutonium239.com.yikyakclone.models.ParseYak;

/**
 * Created by alexander on 6/20/2015.
 */
public class NewYakEvent implements IEventExecutor {
    private final NewYakActivity activity;
    private final Location location;

    public NewYakEvent(NewYakActivity activity, Location location) {
        this.activity = activity;
        this.location = location;
    }

    @Override
    public void executeEvent() {
        String contents = activity.getNewYakEditText().getText().toString();

        if(contents.isEmpty()) {
            // no
            return;
        }

        ParseYak parseYak = new ParseYak();
        parseYak.setContent(contents);
        parseYak.put("votes", 0);
        parseYak.put("author", ParseUser.getCurrentUser());

        ParseGeoPoint parseGeoPoint = new ParseGeoPoint(location.getLatitude(), location.getLongitude());

        parseYak.put("location", parseGeoPoint);

        parseYak.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
            }
        });

        activity.finish();
    }
}
