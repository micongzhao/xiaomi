package com.ittx.studentmanger.sever;

import java.util.ArrayList;

import com.ittx.studentmanger.model.Administractor;
import com.ittx.studentmanger.model.User;

public class Userserver {
public interface UserServer{
	boolean checkUser(String userName,String passWord);
	boolean addUser(Administractor administractor);
	ArrayList<Administractor> getAllUser();
	
}

}

