package yikyakclone.plutonium239.com.yikyakclone.events;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import yikyakclone.plutonium239.com.yikyakclone.activities.MainActivity;
import yikyakclone.plutonium239.com.yikyakclone.activities.NewYakActivity;
import yikyakclone.plutonium239.com.yikyakclone.activities.YakActivity;
import yikyakclone.plutonium239.com.yikyakclone.models.ParseYak;

/**
 * Created by alexander on 6/17/2015.
 */
public class MainActivityEvents {

    public View.OnClickListener getNewYakOnClickListener(final MainActivity activity, final Class<NewYakActivity> newYakActivityClass) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, newYakActivityClass);

                activity.startActivity(intent);
            }
        };
    }

    public AdapterView.OnItemLongClickListener getYaksListViewOnItemLongClickListener() {
        return new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                return false;
            }
        };
    }

    public AdapterView.OnItemClickListener getYaksListViewOnItemClickListener(final MainActivity activity, final Class<YakActivity> yakActivityClass) {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ParseYak yak = (ParseYak)adapterView.getItemAtPosition(position);

                Intent intent = new Intent(activity, yakActivityClass);

                Bundle bundle = new Bundle();
                bundle.putString("YakId", yak.getObjectId());

                intent.putExtra("YakBundle", bundle);

                activity.startActivity(intent);
            }
        };
    }
}
