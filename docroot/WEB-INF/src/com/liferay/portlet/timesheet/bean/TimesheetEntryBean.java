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

import java.util.Calendar;
import java.util.List;

import javax.faces.context.FacesContext;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portlet.timesheet.model.TimesheetTask;
import com.liferay.portlet.timesheet.model.TimesheetTaskConstants;

/**
 * @author Mate Thurzo
 */
public class TimesheetEntryBean {

	private static int monday = Calendar.MONDAY;
	private static int tuesday = Calendar.TUESDAY;
	private static int wednesday = Calendar.WEDNESDAY;
	private static int thursday = Calendar.THURSDAY;
	private static int friday = Calendar.FRIDAY;
	private static int saturday = Calendar.SATURDAY;
	private static int sunday = Calendar.SUNDAY;

	public int getMonday() {
		return monday;
	}

	public int getTuesday() {
		return tuesday;
	}

	public int getWednesday() {
		return wednesday;
	}

	public int getThursday() {
		return thursday;
	}

	public int getFriday() {
		return friday;
	}

	public int getSaturday() {
		return saturday;
	}

	public int getSunday() {
		return sunday;
	}

	public List<TimesheetTask> getTasksByDay(int day)
		throws PortalException, SystemException {

		String userId = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
		User user = UserServiceUtil.getUserById(Long.parseLong(userId));

		System.out.println("UserId: " + userId + " UserName: " + user.getScreenName());
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