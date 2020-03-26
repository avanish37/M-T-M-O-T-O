package com.sathya.dao;

public class MTMDaoFactory {
	private  static  IMTMDao  dao;
	public  static  IMTMDao   getInstance()
	{
		if(dao==null)
		{
			dao =new  MTMDaoImpl();
		}
		return  dao;
	}

}
