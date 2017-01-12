package com.ittx.studentmanager;
import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class strutslist extends ActionSupport  {
 Logger log=Logger.getLogger(strutslist.class);

	public String execute() throws Exception{
		log.debug("hellow>>>>>>>>");
		return SUCCESS;
	}

}
