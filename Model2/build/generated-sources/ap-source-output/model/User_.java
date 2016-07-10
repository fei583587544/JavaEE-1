package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Coll;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-10T15:44:49")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> upassword;
    public static volatile CollectionAttribute<User, Coll> collCollection;
    public static volatile SingularAttribute<User, String> uname;
    public static volatile SingularAttribute<User, Integer> id;

}