package yikyakclone.plutonium239.com.yikyakclone.utilities;

import android.location.Location;

import org.joda.time.Period;

/**
 * Created by alexander on 6/20/2015.
 */
public class Utilities {
    private static Location _location;

    private Utilities(){}

    public static String getTextForPeriod(Period period) {
        if(period.getMonths() > 0) {
            return "A while ago...";
        }

        if(period.getWeeks() > 0) {
            return period.getWeeks() + "w";
        }

        if(period.getDays() > 0) {
            return period.getDays() + "d";
        }

        if(period.getHours() > 0) {
            return period.getHours() + "h";
        }

        if(period.getMinutes() > 0) {
            return period.getMinutes() + "m";
        }

        return period.getSeconds() == 0 ? "0s" : period.getSeconds() + "s";
    }

    public static Location getLocation() {
        return _location;
    }

    public static void setLocation(Location location) {
        _location = location;
    }
}
