package com.luchao.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luchao.dao.AffairMapper;

import com.luchao.entity.Affair;


import com.luchao.service.IAffairService;

@Service
public class AffairServiceImpl implements IAffairService{
		@Autowired
		AffairMapper am;

		@Override
		public int add(Affair a) {
			// TODO Auto-generated method stub
			return am.add(a);
		}
	
	
	
	
	

}
