package com.cg.mts.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("ls")
public class LoginServiceImpl  implements LoginService{

	
	@Autowired
    LoginDao ld;


	@Override
	public String validateCredintials(Object obj) {
		
		return ld.validateCredintials(obj);
	}
       
}
