package yikyakclone.plutonium239.com.yikyakclone.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.parse.ParseQueryAdapter;

import yikyakclone.plutonium239.com.yikyakclone.R;
import yikyakclone.plutonium239.com.yikyakclone.events.YakEvents;
import yikyakclone.plutonium239.com.yikyakclone.models.ParseYakComment;
import yikyakclone.plutonium239.com.yikyakclone.queries.YakQueryFactory;

/**
 * Created by alexander on 7/1/2015.
 */
public class YakCommentsAdapter extends ParseQueryAdapter<ParseYakComment> {
    private final LayoutInflater inflater;

    public YakCommentsAdapter(Context context, String yakId) {
        super(context, YakQueryFactory.getCommentsForYak(yakId));

        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getItemView(ParseYakComment comment, View v, ViewGroup parent) {

        if(v == null) {
            v = inflater.inflate(R.layout.yak_comment_list_item, parent, false);
        }

        TextView commentText = (TextView)v.findViewById(R.id.yakCommentText);

        commentText.setText(comment.getString("content"));

        TextView voteCount = (TextView)v.findViewById(R.id.voteCount);

        voteCount.setText(comment.getVotes() + "");

        ImageButton upVoteButton = (ImageButton)v.findViewById(R.id.voteUpButton);
        ImageButton downVoteButton = (ImageButton)v.findViewById(R.id.voteDownButton);

        upVoteButton.setOnClickListener(YakEvents.getCommentUpVoteListener(comment, voteCount));
        downVoteButton.setOnClickListener(YakEvents.getCommentDownVoteListener(comment, voteCount));

        return v;
    }
}
