package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Bt;
import model.Coll;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-10T15:44:49")
@StaticMetamodel(Business.class)
public class Business_ { 

    public static volatile CollectionAttribute<Business, Coll> collCollection;
    public static volatile SingularAttribute<Business, String> bname;
    public static volatile SingularAttribute<Business, String> bpic;
    public static volatile SingularAttribute<Business, String> binfo;
    public static volatile SingularAttribute<Business, String> btel;
    public static volatile SingularAttribute<Business, String> baddress;
    public static volatile CollectionAttribute<Business, Bt> btCollection;
    public static volatile SingularAttribute<Business, Integer> bid;

}