package com.suprun.criteria.main;

import com.suprun.criteria.entity.Appliance;

import java.util.List;

public class PrintApplianceInfo {
    
    public static void print(List<Appliance> appliances) {
	    for (Appliance appliance : appliances){
		appliance.toString();
	    }
	}
}