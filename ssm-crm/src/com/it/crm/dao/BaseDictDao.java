package com.it.crm.dao;

import java.util.List;

import com.it.crm.pojo.BaseDict;

public interface BaseDictDao {
	List<BaseDict> getDictListByTypeCode(String typeCode);
}
