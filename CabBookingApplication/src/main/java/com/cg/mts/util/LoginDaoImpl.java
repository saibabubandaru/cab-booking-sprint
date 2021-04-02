package com.cg.mts.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.mts.entities.Admin;
import com.cg.mts.entities.Customer;
import com.cg.mts.entities.Driver;
@Transactional
@Repository
public class LoginDaoImpl implements LoginDao {

	@PersistenceContext
	EntityManager em;
	@Override
	public String validateCredintials(Object obj) {
          if(obj instanceof Customer) {
        	  Customer c= (Customer) obj;
        	  TypedQuery<Customer> q=em.createQuery("select c from Customer c where c.username=:uname and c.password=:pass",Customer.class);
        	  q.setParameter("uname", c.getUsername());
        	  q.setParameter("pass", c.getPassword());
        	  List<Customer> custList=q.getResultList();
        	  System.out.println("======"+custList.size());
        	  if(custList.size()>0)
        		  return "login success";
        	  else 
        		  return "Invalid";
          }
          else if(obj instanceof Driver) {
        	  Driver d= (Driver) obj;
        	  TypedQuery<Driver> q=em.createQuery("select d from Driver c where d.username=:uname and d.password=:pass",Driver.class);
        	  q.setParameter("uname", d.getUsername());
        	  q.setParameter("pass", d.getPassword());
        	  
        	  List<Driver> driList=q.getResultList();
        	  if(driList.size()>0)
        		  return "login success";
        	  else 
        		  return "Invalid";
          }
          else if(obj instanceof Admin) {
        	  Admin d= (Admin) obj;
        	  TypedQuery<Admin> q=em.createQuery("select d from Admin d where d.username=:uname and d.password=:pass",Admin.class);
        	  q.setParameter("uname", d.getUsername());
        	  q.setParameter("pass", d.getPassword());
        	  List<Admin> admList=q.getResultList();
        	 
        	  if(admList.size()>0)
        		  return "login success";
        	  else 
        		  return "Invalid";
          }
          return null;
	}

}
