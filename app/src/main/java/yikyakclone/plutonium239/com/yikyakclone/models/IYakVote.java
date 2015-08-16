package yikyakclone.plutonium239.com.yikyakclone.models;

import com.parse.*;

/**
 * Created by alexander on 6/19/2015.
 */
public interface IYakVote<T extends IYak, U extends IYakUser> {
    void makeUpVote();

    void makeDownVote();

    void setUser(U user);

    U getUser();

    void setYak(T parseYak);
}
