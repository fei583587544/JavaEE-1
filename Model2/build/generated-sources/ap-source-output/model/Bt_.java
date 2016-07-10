package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Business;
import model.Tag;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-10T15:44:49")
@StaticMetamodel(Bt.class)
public class Bt_ { 

    public static volatile SingularAttribute<Bt, Integer> btid;
    public static volatile SingularAttribute<Bt, Tag> tname;
    public static volatile SingularAttribute<Bt, Business> bid;

}