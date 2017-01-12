package com.ittx.studentmanger.dao;

import java.util.ArrayList;

import com.ittx.studentmanger.model.Administractor;



public abstract interface AddAdministractorDao{
	void AddAdministractor(Administractor administractor);//添加用户	
	ArrayList<Administractor> getAllAdministractor();
	ArrayList<Administractor> getAllUser();
}
