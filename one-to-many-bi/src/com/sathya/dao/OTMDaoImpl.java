package com.sathya.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sathya.entity.Doctor;
import com.sathya.entity.Patient;
import com.sathya.util.HibernateUtil;

public class OTMDaoImpl  implements  IOTMDao 
{
	private   SessionFactory  factory;
	public OTMDaoImpl() {
		factory=HibernateUtil.getSessionFactory();
	}
	@Override
	public void saveDoctorWithPatients() 
	{
		Doctor  doctor=new  Doctor();
		doctor.setDoctorId(101);
		doctor.setName("Ravi");
		
		Patient patient1=new  Patient();
		patient1.setPatientId(9001);
		patient1.setName("A");
		
		Patient patient2=new  Patient();
		patient2.setPatientId(9002);
		patient2.setName("B");
		
		Patient patient3=new  Patient();
		patient3.setPatientId(9003);
		patient3.setName("C");
		
		patient1.setDoctor(doctor);
		patient2.setDoctor(doctor);
		patient3.setDoctor(doctor);
		Set<Patient>   patients=new   HashSet<Patient>();
		patients.add(patient1);
		patients.add(patient2);
		patients.add(patient3);
		doctor.setPatients(patients);
		
		Session  session=factory.openSession();
		Transaction  tx=session.beginTransaction();
		session.save(patient1);
		tx.commit();
		session.close();
	}
}
