package yikyakclone.plutonium239.com.yikyakclone.models.parcelables;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by alexander on 7/1/2015.
 */
public class YakParcelable implements Parcelable {
    protected YakParcelable(Parcel in) {

    }

    public static final Creator<YakParcelable> CREATOR = new Creator<YakParcelable>() {
        @Override
        public YakParcelable createFromParcel(Parcel in) {
            return new YakParcelable(in);
        }

        @Override
        public YakParcelable[] newArray(int size) {
            return new YakParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
