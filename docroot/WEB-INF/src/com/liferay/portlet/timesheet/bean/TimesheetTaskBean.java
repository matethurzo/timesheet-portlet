package com.liferay.portlet.timesheet.bean;

import com.liferay.portlet.timesheet.model.impl.TimesheetTaskImpl;
import com.liferay.portlet.timesheet.service.TimesheetTaskLocalServiceUtil;

/**
 * 
 * @author Mate Thurzo
 *
 */
public class TimesheetTaskBean extends TimesheetTaskImpl {

	public String saveTask() {
		try {
			TimesheetTaskLocalServiceUtil.addTask(this);

			return "success";
		}
		catch (Exception e) {
			return "error";
		}
	}

}
