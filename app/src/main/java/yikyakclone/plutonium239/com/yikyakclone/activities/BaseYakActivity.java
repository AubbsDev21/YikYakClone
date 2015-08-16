package yikyakclone.plutonium239.com.yikyakclone.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import yikyakclone.plutonium239.com.yikyakclone.R;
import yikyakclone.plutonium239.com.yikyakclone.adapters.YakCommentsAdapter;
import yikyakclone.plutonium239.com.yikyakclone.events.YakEvents;
import yikyakclone.plutonium239.com.yikyakclone.models.ParseYak;
import yikyakclone.plutonium239.com.yikyakclone.models.ParseYakComment;
import yikyakclone.plutonium239.com.yikyakclone.utilities.Utilities;

/**
 * Created by alexander on 7/3/2015.
 */
public class BaseYakActivity extends AppCompatActivity {
    protected ListView yakCommentList;
    protected YakCommentsAdapter adapter;
    protected ParseYak yak;
    protected String yakId;
    protected Button sendYakComment;
    protected EditText editText;
    protected TextView parseYakText;
    protected ImageButton upVoteButton;
    protected ImageButton downVoteButton;
    protected TextView parseYakVote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yak);

        Intent intent = getIntent();
        Bundle yakBundle = intent.getBundleExtra("YakBundle");

        yakId = yakBundle.getString("YakId");

        ActionBar bar = getSupportActionBar();
        bar.setHomeButtonEnabled(true);

        setupViews();
        setupEvents();
        setupOther();

        ParseQuery<ParseYak> yakQuery = new ParseQuery<ParseYak>(ParseYak.class);
        yakQuery.getInBackground(yakId, new GetCallback<ParseYak>() {
            @Override
            public void done(ParseYak parseYak, ParseException e) {
                if(e == null) {
                    yak = parseYak;

                    parseYakText.setText(yak.getContent());
                    parseYakVote.setText(yak.getVotes() + "");

                    upVoteButton.setOnClickListener(YakEvents.getUpVoteListener(yak, parseYakVote));
                    downVoteButton.setOnClickListener(YakEvents.getDownVoteListener(yak, parseYakVote));
                }
            }
        });
    }

    protected void setupViews() {
        parseYakVote = (TextView)findViewById(R.id.yakSection).findViewById(R.id.voteCount);

        yakCommentList = (ListView)findViewById(R.id.yakCommentList);

        yakCommentList.setAdapter(adapter = new YakCommentsAdapter(this, yakId));

        editText = (EditText)findViewById(R.id.yakCommentEditText);

        sendYakComment = (Button)findViewById(R.id.saveYakComment);

        parseYakText = (TextView)findViewById(R.id.yakText);

        upVoteButton = (ImageButton)findViewById(R.id.yakSection).findViewById(R.id.voteUpButton);
        downVoteButton = (ImageButton)findViewById(R.id.yakSection).findViewById(R.id.voteDownButton);
    }

    protected void setupEvents() {

        sendYakComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = editText.getText().toString();

                if(content.isEmpty()) {
                    Toast.makeText(BaseYakActivity.this, "Cannot send an empty yak comment", Toast.LENGTH_SHORT).show();

                    return;
                }

                ParseYakComment comment = new ParseYakComment();
                comment.put("votes", 0);
                comment.put("content", content);
                comment.put("yak", ParseObject.createWithoutData(ParseYak.class, yakId));
                comment.put("author", ParseUser.createWithoutData(ParseUser.class, "07r0EnXrSe"));
                comment.put("location", new ParseGeoPoint(Utilities.getLocation().getLatitude(), Utilities.getLocation().getLongitude()));

                comment.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e == null) {
                            adapter.loadObjects();

                            editText.getText().clear();
                        }
                    }
                });
            }
        });
    }

    protected void setupOther() {

    }
}
