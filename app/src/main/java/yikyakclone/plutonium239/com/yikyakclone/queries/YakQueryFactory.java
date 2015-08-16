package yikyakclone.plutonium239.com.yikyakclone.queries;

import com.parse.GetCallback;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

import yikyakclone.plutonium239.com.yikyakclone.models.ParseYak;
import yikyakclone.plutonium239.com.yikyakclone.models.ParseYakComment;
import yikyakclone.plutonium239.com.yikyakclone.utilities.Utilities;

/**
 * Created by alexander on 5/16/2015.
 */
public class YakQueryFactory {
    private YakQueryFactory() {}

    public static ParseQueryAdapter.QueryFactory<ParseYak> getAllYaks() {
        return new ParseQueryAdapter.QueryFactory<ParseYak>() {
            @Override
            public ParseQuery<ParseYak> create() {
                ParseQuery query = ParseQuery.getQuery(ParseYak.class);

                query.orderByDescending("createdAt");
                query.whereWithinKilometers("location", new ParseGeoPoint(Utilities.getLocation().getLatitude(), Utilities.getLocation().getLongitude()), 10);

                return query;
            }
        };
    }

    public static ParseQueryAdapter.QueryFactory<ParseYakComment> getCommentsForYak(final String yakId) {
        return new ParseQueryAdapter.QueryFactory<ParseYakComment>() {
            @Override
            public ParseQuery<ParseYakComment> create() {
                ParseQuery query = ParseQuery.getQuery(ParseYakComment.class);

                query.whereEqualTo("yak", ParseObject.createWithoutData(ParseYak.class, yakId));
                query.orderByAscending("createdAt");


                return query;
            }
        };
    }
}
