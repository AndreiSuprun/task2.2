package com.suprun.criteria.entity.criteria;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Criteria {

	private String groupSearchName;
	private Map<String, Object> criteria = new HashMap<String, Object>();

	public Criteria(String groupSearchName) {
		this.groupSearchName = groupSearchName;
	}
	
	public String getGroupSearchName() {
		return groupSearchName;
	}

	public void add(String searchCriteria, Object value) {
		criteria.put(searchCriteria, value);
	}

	public Set<String> getSearchCriteriaSet() {
		Set<String> searchCriteria = criteria.keySet();
		return searchCriteria;
	}

	public Object getSearchCriteriaValue(String searchCriteria) {
		return criteria.get(searchCriteria);
	}

}
