package yikyakclone.plutonium239.com.yikyakclone.models;

import com.parse.ParseObject;

/**
 * Created by alexander on 7/2/2015.
 */
public abstract class BaseVotable extends ParseObject {
    protected VoteType voteType;
    protected boolean hasDownvoted;
    protected boolean hasUpvoted;

    public void upVote() {
        if(hasAlreadyVoted() && VoteType.UP == voteType) {
            throw new IllegalStateException("Can't up vote twice");
        }

        if(voteType == VoteType.DOWN) {
            voteType = null;
            hasDownvoted = false;
        } else if(voteType == null) {
            voteType = VoteType.UP;
            hasUpvoted = true;
        } else {
            throw new IllegalStateException();
        }

        increment("votes");
    }

    public void downVote() {
        if(hasAlreadyVoted() && VoteType.DOWN == voteType) {
            throw new IllegalStateException("Can't down vote twice");
        }

        hasDownvoted = true;

        if(voteType == VoteType.UP) {
            voteType = null;
            hasUpvoted = false;
        } else if(voteType == null) {
            voteType = VoteType.DOWN;
            hasDownvoted = true;
        } else {
            throw new IllegalStateException();
        }

        increment("votes", -1);
    }

    public int getVotes() {
        return getInt("votes");
    }

    public boolean hasAlreadyVoted() {
        return hasUpvoted || hasDownvoted;
    }

    public boolean hasAlreadyUpVoted() {
        return hasUpvoted;
    }

    public boolean hasAlreadyDownVoted() {
        return hasDownvoted;
    }

    private enum VoteType {
        UP,
        DOWN
    }
}
