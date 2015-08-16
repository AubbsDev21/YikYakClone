package yikyakclone.plutonium239.com.yikyakclone.activities;

import android.view.Menu;
import android.view.MenuItem;

import yikyakclone.plutonium239.com.yikyakclone.R;

/**
 * Created by alexander on 7/3/2015.
 */
public class MyYakActivity extends BaseYakActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_yak, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_delete) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
