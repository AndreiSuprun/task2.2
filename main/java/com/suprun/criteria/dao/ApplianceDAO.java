package com.suprun.criteria.dao;

import com.suprun.criteria.entity.Appliance;
import com.suprun.criteria.entity.criteria.Criteria;

import java.util.List;

public interface ApplianceDAO {
	List<Appliance> find(Criteria criteria) throws DAOException;
}
