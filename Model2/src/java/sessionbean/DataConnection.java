/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Bt;
import model.Business;
import model.Coll;
import model.User;

/**
 *
 * @author lenovo
 */
@Stateless
public class DataConnection implements DataConnectionLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    private EntityManager em;
    public DataConnection(){
        
    }
    @Override
    public void perisit(Object obj) {
        em.persist(obj);
    }

    @Override
    public boolean checkByAccount(String name) {
        Query q = em.createQuery("select s from User s");
        List<User> items=q.getResultList();
        int k=items.size();
        if(k==0) return false;
        else{
            for(int i=0;i<=k-1;i++){
                if(name.equals(items.get(i).getUname())) return true;
            }
            return false;
        }
    }

    @Override
    public void insertUser(User current) {
          perisit(current);
    }

    @Override
    public boolean checkCollection(int uid, int bid) {
        Coll newC=new Coll();
        Query q=em.createQuery("select s from Coll s");
        List<Coll> items=q.getResultList();
        int k = items.size();
        if(k>0){
            for(int i=0;i<=k-1;i++){
                if(uid==items.get(i).getIdu().getId()&&bid==items.get(i).getIdb().getBid()){
                    return true;
                }
            }           
        }
        return false;   
    }

    @Override
    public void insertCollection(Coll coll) {
        perisit(coll);
    }

    @Override
    public boolean exsitSelectedUser(String name, String password) {
         Query q = em.createQuery("select s from User s");
        List<User> items=q.getResultList();
        int size=items.size();
        if(size==0) return false;
        else{
            for(int i=0;i<=size-1;i++){
                if(name.equals(items.get(i).getUname())&&password.equals(items.get(i).getUpassword()))
                    return true;
            }
            return false;
        }
    }

    @Override
    public int getSelectedUserID(String name, String password) {
         Query q = em.createQuery("select s from User s");
        List<User> items=q.getResultList();
        int size=items.size();
        if(size==0) return -1;
        else{
            for(int i=0;i<=size-1;i++){
                if(name.equals(items.get(i).getUname())&&password.equals(items.get(i).getUpassword())) {
                    int k = items.get(i).getId();
                    return k;//存在这样的user，返回他的id 
                }        
            }
             return -1;
        }
    }

    @Override
    public List<Business> limitedBusiness(int number) {
          Query q = em.createQuery("select s from Business s");
        List<Business> items=q.getResultList();
        if(items.size()<=number)
            return items;
        else{
            items=items.subList(0, number);
            return items;
            }
    }

    @Override
    public List<Business> limitedBusiness() {
         Query q = em.createQuery("select s from Business s");
        List<Business> items=q.getResultList();
        return items;
    }

    @Override
    public List<Business> taggedBusiness(String tag) {
        Query q = em.createQuery("select s from Bt s");
        List<Bt> items=q.getResultList();
        int size=items.size();
        List<Bt> item = new ArrayList<>();
        for(int i=0;i<=size-1;i++){
            if(items.get(i).getTname().getTname().equals(tag)){//是此tag下的东西
              // items.remove(i);
               // i--;
                item.add(items.get(i));
            }
        }
        size=item.size();
        Query q2 = em.createQuery("select s from Business s");
        List<Business> busItems=q2.getResultList();
        int size2=busItems.size();
        List<Business> its = new ArrayList<>();
        for(int i=0;i<=size-1;i++){
            its.add(item.get(i).getBid());
        }
      //for(int i =0;i<=size2-1;i++){
           // for(int j=0;j<=size-1;i++){/////////
           // if(busItems.get(i).getBid()==items.get(j).getBid().getBid())
            //        x=1;
           ///         break;
           // }
            
            
            
            
            //未通过过滤，淘汰!!!!!
            //Remove有毒！！！！！！ 
            //busItems.remove(i);
           // i--;
            
            
            
            
            
        //}
        return its;
    }

    @Override
    public List<Business> collectedItems(int uid) {
        Query q = em.createNamedQuery("Coll.findByIdu");
        q.setParameter("idu", uid);
        List<Coll> items=q.getResultList();//应选得所有business
        int size=items.size();
        if(size<=0) return null;
        List<Business> r = new ArrayList<>();
        for(int i=0;i<=size-1;i++){
            r.add(items.get(i).getIdb());
        }
        return r;
    }

    @Override
    public int saveAndId(String name, String password) {
        User stored = new User();
        stored.setUname(name);
        stored.setUpassword(password); 
        em.persist(stored);
        int id = getSelectedUserID(name,password);
        return id;
    }

    @Override
    public User findUserById(int uid) {
        Query q = em.createNamedQuery("User.findById");
        q.setParameter("id", uid);
        User returned = (User)q.getResultList().get(0);
        return returned;
    }

    @Override
    public Business findBusinessById(int bid) {
         Query q = em.createNamedQuery("Business.findById");
        q.setParameter("id", bid);
        Business returned = (Business)q.getResultList().get(0);
        return returned;
      
    }
    
    
    
    
    
    
    
    
}
