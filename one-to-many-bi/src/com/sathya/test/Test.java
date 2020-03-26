package com.sathya.test;

import com.sathya.dao.IOTMDao;
import com.sathya.dao.OTMDaoFactory;
import com.sathya.entity.Patient;

public class Test 
{
	public static void main(String[] args) 
	{
		IOTMDao  dao = OTMDaoFactory.getInstance();
		dao.saveDoctorWithPatients();
	}
}
