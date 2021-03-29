package com.cg.mts.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("lServiceImpl")
public class LoginServiceImpl implements LoginService {
	@Autowired
	LoginDao ld;

	@Override
	public String validateCredentials(Object obj) {

		return ld.validateCredintials(obj);
	}
	
}
