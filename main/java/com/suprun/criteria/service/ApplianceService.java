package com.suprun.criteria.service;

import com.suprun.criteria.dao.DAOException;
import com.suprun.criteria.entity.Appliance;
import com.suprun.criteria.entity.criteria.Criteria;

import java.util.List;

public interface ApplianceService {	
	
	List<Appliance> find(Criteria criteria) throws ServiceException;
	
}
