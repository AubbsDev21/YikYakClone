package yikyakclone.plutonium239.com.yikyakclone.models;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by alexander on 5/17/2015.
 */
@ParseClassName("YakVote")
public class ParseYakVote extends BaseParseVote {
    private ParseYakUser user;

    public ParseYakVote(){}

    @Override
    public void setUser(ParseYakUser user) {
        this.user = user;

        put("user", user.getUser());
    }

    @Override
    public ParseYakUser getUser() {
        return user;
    }

    public void setYak(ParseYak parseYak) {
        put("yak", parseYak);
    }
}
