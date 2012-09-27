/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.timesheet.bean;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portlet.timesheet.model.TimesheetTask;
import com.liferay.portlet.timesheet.model.TimesheetTaskConstants;

import java.util.Calendar;
import java.util.List;

import javax.faces.context.FacesContext;

/**
 * @author Mate Thurzo
 */
public class TimesheetEntryBean {

	public List<TimesheetTask> getTasksByDay(int day)
		throws PortalException, SystemException {

		FacesContext facesContext = FacesContext.getCurrentInstance();

		String userId = facesContext.getExternalContext().getRemoteUser();

		User user = UserServiceUtil.getUserById(Long.parseLong(userId));

		Calendar cal = Calendar.getInstance(user.getLocale());

		cal.set(Calendar.DAY_OF_WEEK, day);

		System.out.println(cal.getTime() + " WW " + cal.getFirstDayOfWeek());

		return null;
	}

	public String getTimesheetCommand() {
		return _timesheetCommand;
	}

	public String saveTask() {
		// parse object here

		try {
			//TimesheetTaskLocalServiceUtil.addTask();

			return TimesheetTaskConstants.SUCCESS;
		}
		catch (Exception e) {
			return TimesheetTaskConstants.ERROR;
		}
	}

	public void setTimesheetCommand(String command) {
		_timesheetCommand = command;
	}

	private String _timesheetCommand;

}