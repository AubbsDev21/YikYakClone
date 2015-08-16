package yikyakclone.plutonium239.com.yikyakclone.activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import org.w3c.dom.Text;

import yikyakclone.plutonium239.com.yikyakclone.R;
import yikyakclone.plutonium239.com.yikyakclone.adapters.YakCommentsAdapter;
import yikyakclone.plutonium239.com.yikyakclone.adapters.YakListAdapter;
import yikyakclone.plutonium239.com.yikyakclone.events.YakEvents;
import yikyakclone.plutonium239.com.yikyakclone.models.IYak;
import yikyakclone.plutonium239.com.yikyakclone.models.ParseYak;
import yikyakclone.plutonium239.com.yikyakclone.models.ParseYakComment;

/**
 * Activity that holds text of yak and lists comments.
 */
public class YakActivity extends BaseYakActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_yak, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_flag) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
