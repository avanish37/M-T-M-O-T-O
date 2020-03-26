package com.sathya.dao;

import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sathya.entity.Passport;
import com.sathya.entity.Person;
import com.sathya.util.HibernateUtil;

public class OTODaoImpl implements IOTODao 
{
	private   SessionFactory   factory;
	public OTODaoImpl() {
		factory=HibernateUtil.getSessionFactory();
	}

	@Override
	public void savePassportWithPerson() 
	{
		Person  p = new  Person();
		p.setPid(111); p.setName("A");
		Passport ps =new  Passport();
		
		try {
			SimpleDateFormat  sdf=new  SimpleDateFormat("dd-MMM-yyyy");
			java.util.Date  expDate=sdf.parse("31-DEC-2029");
			ps.setExpdate(expDate);
		}catch(Exception  e) { }
		ps.setPerson(p);
		Session   session=factory.openSession();
		Transaction  tx = session.beginTransaction();
		session.save(ps);
		tx.commit();
		session.close();
	}
}
