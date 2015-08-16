package yikyakclone.plutonium239.com.yikyakclone.models;

import com.parse.ParseUser;

/**
 * This uses the Adapter pattern :)
 */
public class ParseYakUser implements IYakUser {
    private final ParseUser parseUser;

    public ParseYakUser(ParseUser parseUser) {
        this.parseUser = parseUser;
    }

    public ParseUser getUser() {
        return parseUser;
    }
}
