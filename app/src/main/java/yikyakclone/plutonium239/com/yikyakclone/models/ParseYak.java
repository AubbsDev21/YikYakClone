package yikyakclone.plutonium239.com.yikyakclone.models;

import android.os.Bundle;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.io.Serializable;

/**
 * Created by alexander on 5/16/2015.
 */
@ParseClassName("Yak")
public class ParseYak extends BaseVotable implements IYak, Serializable {
    public ParseYak(){}

    @Override
    public void setContent(String content) {
        if(content == null || content.isEmpty()) {
            throw new IllegalArgumentException("Cannot set empty content.");
        }

        put("content", content);
    }

    @Override
    public String getContent() {
        return getString("content");
    }

    @Override
    public String getId() {
        return getObjectId();
    }
}
