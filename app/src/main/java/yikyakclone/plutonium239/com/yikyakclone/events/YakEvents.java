package yikyakclone.plutonium239.com.yikyakclone.events;

import android.view.View;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import yikyakclone.plutonium239.com.yikyakclone.models.ParseYak;
import yikyakclone.plutonium239.com.yikyakclone.models.ParseYakComment;
import yikyakclone.plutonium239.com.yikyakclone.models.ParseYakCommentVote;
import yikyakclone.plutonium239.com.yikyakclone.models.ParseYakUser;
import yikyakclone.plutonium239.com.yikyakclone.models.ParseYakVote;
import yikyakclone.plutonium239.com.yikyakclone.utilities.Utilities;

/**
 * Created by alexander on 7/2/2015.
 */
public class YakEvents {
    public static View.OnClickListener getUpVoteListener(final ParseYak parseYak, final TextView voteCount) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(parseYak.hasAlreadyUpVoted()) {
                    return;
                }

                parseYak.upVote();
                voteCount.setText(parseYak.getVotes() + "");

                parseYak.saveInBackground();

                ParseYakVote parseYakVote = new ParseYakVote();
                parseYakVote.makeUpVote();
                parseYakVote.setYak(parseYak);
                parseYakVote.setUser(new ParseYakUser(ParseUser.getCurrentUser()));
                parseYakVote.setLocation(Utilities.getLocation());

                parseYakVote.saveInBackground();

            }
        };
    }

    public static View.OnClickListener getDownVoteListener(final ParseYak parseYak, final TextView voteCount) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(parseYak.hasAlreadyDownVoted()) {
                    return;
                }

                parseYak.downVote();

                voteCount.setText(parseYak.getVotes() + "");

                parseYak.saveInBackground();

                ParseYakVote parseYakVote = new ParseYakVote();
                parseYakVote.makeDownVote();
                parseYakVote.setYak(parseYak);
                parseYakVote.setUser(new ParseYakUser(ParseUser.getCurrentUser()));
                parseYakVote.setLocation(Utilities.getLocation());

                parseYakVote.saveInBackground();
            }
        };
    };

    public static View.OnClickListener getCommentUpVoteListener(final ParseYakComment comment, final TextView voteCount) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(comment.hasAlreadyUpVoted()) {
                    return;
                }

                comment.upVote();

                voteCount.setText(comment.getVotes() + "");

                comment.saveInBackground();

                ParseYakCommentVote parseYakCommentVote = new ParseYakCommentVote();
                parseYakCommentVote.makeUpVote();
                parseYakCommentVote.setComment(comment);
                parseYakCommentVote.setUser(new ParseYakUser(ParseUser.getCurrentUser()));
                parseYakCommentVote.setLocation(Utilities.getLocation());

                parseYakCommentVote.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {

                    }
                });
            }
        };
    }

    public static View.OnClickListener getCommentDownVoteListener(final ParseYakComment comment, final TextView voteCount) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(comment.hasAlreadyDownVoted()) {
                    return;
                }

                comment.downVote();

                voteCount.setText(comment.getVotes() + "");

                comment.saveInBackground();

                ParseYakCommentVote parseYakCommentVote = new ParseYakCommentVote();
                parseYakCommentVote.makeDownVote();
                parseYakCommentVote.setComment(comment);
                parseYakCommentVote.setUser(new ParseYakUser(ParseUser.getCurrentUser()));
                parseYakCommentVote.setLocation(Utilities.getLocation());

                parseYakCommentVote.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {

                    }
                });
            }
        };
    }
}
