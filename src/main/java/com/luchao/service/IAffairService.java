package com.luchao.service;


import java.util.List;

import com.luchao.entity.Affair;


public interface IAffairService {
	int add(Affair a);
	List<Affair> getAllByUserId(Integer id);
	Affair getByAffairId(Integer id);
}
