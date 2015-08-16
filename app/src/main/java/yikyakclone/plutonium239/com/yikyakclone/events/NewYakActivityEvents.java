package yikyakclone.plutonium239.com.yikyakclone.events;

import android.location.Location;
import android.view.View;

import com.parse.ParseException;
import com.parse.SaveCallback;

import yikyakclone.plutonium239.com.yikyakclone.activities.NewYakActivity;
import yikyakclone.plutonium239.com.yikyakclone.models.ParseYak;

/**
 * Created by alexander on 6/17/2015.
 */
public class NewYakActivityEvents {
    public View.OnClickListener saveYakOnClickListener(final NewYakActivity activity, final Location location) {
        final NewYakEvent event = new NewYakEvent(activity, location);

        return saveYakOnClickListener(event);
    }

    public View.OnClickListener saveYakOnClickListener(final IEventExecutor executor) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                executor.executeEvent();
            }
        };
    }

    public IEventExecutor getSaveYakEventExecutor(final NewYakActivity activity, final Location location) {
        return new NewYakEvent(activity, location);
    }
}
