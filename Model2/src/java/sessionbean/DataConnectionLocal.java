/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import java.util.List;
import javax.ejb.Local;
import model.Business;
import model.Coll;
import model.User;

/**
 *
 * @author lenovo
 */
@Local
public interface DataConnectionLocal {

    void perisit(Object obj);

    boolean checkByAccount(String name);

    void insertUser(User current);

    boolean checkCollection(int uid, int bid);

    void insertCollection(Coll coll);

    boolean exsitSelectedUser(String name, String password);

    int getSelectedUserID(String name, String password);

    List<Business> limitedBusiness(int number);

    List<Business> limitedBusiness();

    List<Business> taggedBusiness(String tag);

    List<Business> collectedItems(int uid);

    int saveAndId(String name, String password);

    User findUserById(int uid);

    Business findBusinessById(int bid);
    
    
}
