package com.it.crm.service;

import java.util.List;

import com.it.crm.pojo.BaseDict;

public interface BaseDictService {
	List<BaseDict> getDictListByTypeCode(String typeCode);
}
