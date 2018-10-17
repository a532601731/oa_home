package com.luchao.dao;

import java.util.List;

import com.luchao.entity.Affair;

public interface AffairMapper {
	
	int add(Affair a);
	List<Affair> getAllByUserId(Integer id);
	Affair getByAffairId(Integer id);
}
