package yikyakclone.plutonium239.com.yikyakclone.models;

import com.parse.ParseClassName;

/**
 * Created by alexander on 7/2/2015.
 */
@ParseClassName("CommentVote")
public class ParseYakCommentVote extends BaseParseVote {
    private ParseYakUser user;

    public ParseYakCommentVote(){}

    @Override
    public void setUser(ParseYakUser user) {

        this.user = user;

        put("user", user.getUser());
    }

    @Override
    public ParseYakUser getUser() {
        return null;
    }

    public void setComment(ParseYakComment comment) {
        put("comment", comment);
    }
}
