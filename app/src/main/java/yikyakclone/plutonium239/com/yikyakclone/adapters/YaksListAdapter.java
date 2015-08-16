package yikyakclone.plutonium239.com.yikyakclone.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.parse.ParseQueryAdapter;
import com.parse.ParseUser;

import org.joda.time.DateTime;
import org.joda.time.Period;

import java.util.Date;

import yikyakclone.plutonium239.com.yikyakclone.R;
import yikyakclone.plutonium239.com.yikyakclone.events.YakEvents;
import yikyakclone.plutonium239.com.yikyakclone.models.ParseYak;
import yikyakclone.plutonium239.com.yikyakclone.models.ParseYakUser;
import yikyakclone.plutonium239.com.yikyakclone.models.ParseYakVote;
import yikyakclone.plutonium239.com.yikyakclone.queries.YakQueryFactory;
import yikyakclone.plutonium239.com.yikyakclone.utilities.Utilities;

/**
 * Created by alexander on 5/16/2015.
 */
public class YaksListAdapter extends ParseQueryAdapter<ParseYak> {
    private LayoutInflater inflater;

    public YaksListAdapter(Context context) {
        super(context, YakQueryFactory.getAllYaks());

        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getItemView(final ParseYak parseYak, View v, ViewGroup parent) {
        if(v == null) {
            v = inflater.inflate(R.layout.yak_list_item, parent, false);
        }

        final TextView voteCount = (TextView)v.findViewById(R.id.voteCount);
        voteCount.setText(parseYak.getVotes() + "");

        TextView yakTime = (TextView)v.findViewById(R.id.yakTime);

        DateTime createdAt = new DateTime(parseYak.getCreatedAt());
        Period period = new Period(createdAt, DateTime.now());
        String text = Utilities.getTextForPeriod(period);

        yakTime.setText(text);

        TextView contents = (TextView)v.findViewById(R.id.yakContent);
        contents.setText(parseYak.getContent());

        ImageButton voteUp = (ImageButton)v.findViewById(R.id.voteUpButton);
        ImageButton voteDown = (ImageButton)v.findViewById(R.id.voteDownButton);

        voteUp.setOnClickListener(YakEvents.getUpVoteListener(parseYak, voteCount));

        voteDown.setOnClickListener(YakEvents.getDownVoteListener(parseYak, voteCount));

        return super.getItemView(parseYak, v, parent);
    }
}
