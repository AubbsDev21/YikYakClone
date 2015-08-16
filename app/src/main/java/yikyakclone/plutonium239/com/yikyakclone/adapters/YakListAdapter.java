package yikyakclone.plutonium239.com.yikyakclone.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.parse.ParseQueryAdapter;

import yikyakclone.plutonium239.com.yikyakclone.models.ParseYakComment;

/**
 * Created by alexander on 6/21/2015.
 */
public class YakListAdapter extends ParseQueryAdapter<ParseYakComment> {
    public YakListAdapter(Context context, QueryFactory<ParseYakComment> queryFactory) {
        super(context, queryFactory);
    }

    @Override
    public View getItemView(ParseYakComment object, View v, ViewGroup parent) {
        return super.getItemView(object, v, parent);
    }
}
