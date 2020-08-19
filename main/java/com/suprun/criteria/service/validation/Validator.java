package com.suprun.criteria.service.validation;

import com.suprun.criteria.entity.criteria.Criteria;
import com.suprun.criteria.entity.criteria.SearchCriteria;

public class Validator {
	
	public static boolean criteriaValidator(Criteria criteria) {
        String groupSearchName = criteria.getGroupSearchName();
        Class<?>[] classes = SearchCriteria.class.getDeclaredClasses();
        boolean isInGroup = false;
        for (Class<?> aClass : classes) {
            if (aClass.getSimpleName() == groupSearchName) {
                isInGroup = true;
            }
        }
        boolean isSearchParameterValid = true;
        boolean isSearchValueValid = true;
        for (String searchParameter : criteria.getSearchCriteria()){
            if (searchParameter == null || searchParameter.isEmpty()){
                isSearchParameterValid = false;
            }
            if (criteria.getCriteriaValue(searchParameter).toString() == null ||criteria.getCriteriaValue(searchParameter).toString().isEmpty()){
                isSearchValueValid = false;
            }
        }
        return isInGroup && isSearchParameterValid && isSearchValueValid;
    }
}