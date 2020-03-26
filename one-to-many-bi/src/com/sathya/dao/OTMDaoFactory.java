package com.sathya.dao;

public class OTMDaoFactory 
{
	private   static  IOTMDao  dao;
	public  static  IOTMDao     getInstance()
	{
		if(dao==null) {
			dao = new  OTMDaoImpl();
		}
		return  dao;
	}

}
