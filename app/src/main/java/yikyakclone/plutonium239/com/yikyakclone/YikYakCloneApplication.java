package yikyakclone.plutonium239.com.yikyakclone;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.pubnub.api.Callback;
import com.pubnub.api.Pubnub;
import com.pubnub.api.PubnubError;
import com.pubnub.api.PubnubException;

import yikyakclone.plutonium239.com.yikyakclone.models.ParseYak;
import yikyakclone.plutonium239.com.yikyakclone.models.ParseYakComment;
import yikyakclone.plutonium239.com.yikyakclone.models.ParseYakCommentVote;
import yikyakclone.plutonium239.com.yikyakclone.models.ParseYakVote;

/**
 * Created by alexander on 5/16/2015.
 */
public class YikYakCloneApplication extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Pubnub pubnub = new Pubnub(getString(R.string.pubnupPublish), getString(R.string.pubnupSubscribe));

        pubnub.time(new Callback() {
            @Override
            public void successCallback(String channel, Object message) {
                super.successCallback(channel, message);
            }

            @Override
            public void errorCallback(String channel, PubnubError error) {
                super.errorCallback(channel, error);
            }
        });

        try {
            pubnub.subscribe("shit", new Callback() {
                @Override
                public void successCallback(String channel, Object message) {
                    super.successCallback(channel, message);
                }

                @Override
                public void errorCallback(String channel, PubnubError error) {
                    super.errorCallback(channel, error);
                }

                @Override
                public void connectCallback(String channel, Object message) {
                    super.connectCallback(channel, message);
                }
            });
        } catch (PubnubException e) {
            e.printStackTrace();
        }

        ParseObject.registerSubclass(ParseYak.class);
        ParseObject.registerSubclass(ParseYakVote.class);
        ParseObject.registerSubclass(ParseYakComment.class);
        ParseObject.registerSubclass(ParseYakCommentVote.class);

        Parse.enableLocalDatastore(this);

        Parse.initialize(this, getString(R.string.applicationId), getString(R.string.clientId));

        ParseUser.enableAutomaticUser();

        ParseInstallation.getCurrentInstallation().saveInBackground();

        try {
            ParseUser.logIn("alex", "abc");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
