package com.suprun.criteria.main;

import com.suprun.criteria.entity.Appliance;
import com.suprun.criteria.entity.criteria.Criteria;
import com.suprun.criteria.service.ApplianceService;
import com.suprun.criteria.service.ServiceException;
import com.suprun.criteria.service.ServiceFactory;

import static com.suprun.criteria.entity.criteria.SearchCriteria.Oven;
import static com.suprun.criteria.entity.criteria.SearchCriteria.TabletPC;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Appliance> appliances = new ArrayList<>();
		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		//////////////////////////////////////////////////////////////////

		Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());//"Oven"
		criteriaOven.add(Oven.CAPACITY.toString(), 3);
		try{
		    appliances = service.find(criteriaOven);
		} catch(ServiceException e){
		    System.out.plrinln(e.getMessage());
		}
		PrintApplianceInfo.print(appliances);

		//////////////////////////////////////////////////////////////////

		criteriaOven = new Criteria(Oven.class.getSimpleName());
		criteriaOven.add(Oven.HEIGHT.toString(), 200);
		criteriaOven.add(Oven.DEPTH.toString(), 300);
		try{
		    appliances = service.find(criteriaOven);
		} catch(ServiceException e){
		    System.out.plrinln(e.getMessage());
		}
		PrintApplianceInfo.print(appliances);

		//////////////////////////////////////////////////////////////////
		
		Criteria criteriaTabletPC = new Criteria(TabletPC.class.getSimpleName());
		criteriaTabletPC.add(TabletPC.COLOR.toString(), "BLUE");
		criteriaTabletPC.add(TabletPC.DISPLAY_INCHES.toString(), 14);
		criteriaTabletPC.add(TabletPC.MEMORY_ROM.toString(), 4);
		try{
		    appliances = service.find(criteriaOven);
		} catch(ServiceException e){
		    System.out.plrinln(e.getMessage());
		}
		PrintApplianceInfo.print(appliances);
	}
}