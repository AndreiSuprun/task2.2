package com.suprun.criteria.service.impl;

import com.suprun.criteria.dao.ApplianceDAO;
import com.suprun.criteria.dao.DAOException;
import com.suprun.criteria.dao.DAOFactory;
import com.suprun.criteria.entity.Appliance;
import com.suprun.criteria.entity.criteria.Criteria;
import com.suprun.criteria.service.ApplianceService;
import com.suprun.criteria.service.ServiceException;
import com.suprun.criteria.service.validation.Validator;

import java.util.List;

public class ApplianceServiceImpl implements ApplianceService{

	@Override
	public List<Appliance> find(Criteria criteria) throws ServiceException {
		if (!Validator.criteriaValidator(criteria)) {
			throw new ServiceException("Invalid input parameters");
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();

		try{
		List<Appliance> appliances = applianceDAO.find(criteria);
		if (appliances.isEmpty()) {
		    throw new ServiceException("No applianсes was found");
		    }
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return appliances;
	}
}
