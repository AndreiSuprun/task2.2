package com.suprun.criteria.dao.impl;

import com.suprun.criteria.dao.ApplianceDAO;
import com.suprun.criteria.dao.DAOException;
import com.suprun.criteria.dao.creator.ApplianceCreator;
import com.suprun.criteria.dao.source.ApplianceSource;
import com.suprun.criteria.entity.Appliance;
import com.suprun.criteria.entity.criteria.Criteria;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApplianceDAOImpl implements ApplianceDAO{

	@Override
	public List<Appliance> find(Criteria criteria) throws DAOException {
		Stream<String> applianceStream = new ApplianceSource().receiveApplianceStream();
  		BiPredicate<String, Criteria> predicate = new BiPredicate<String, Criteria>() {
  			@Override
  			public boolean test(String line, Criteria criteria) {
  				boolean isTypeMatch = line.contains(criteria.getGroupSearchName());
  				boolean isParameterPresent = false;
  				for (String criteriaSearch : criteria.getSearchCriteriaSet()){
  					if (line.contains(criteriaSearch) && line.matches(criteria.getSearchCriteriaValue(criteriaSearch).toString()){
  					    return true;
  					}
  				}
  				return isTypeMatch && isParameterPresent;
  			}
  		};
		ApplianceCreator applianceCreator = new ApplianceCreator();
		List<Appliance> appliances = applianceStream.filter(line -> predicate.test(line, criteria))
				.map(applianceCreator::createAppliance).collect(Collectors.toList());
		return appliances;
		}
	}
}