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

/**
 * @author Mate Thurzo
 */
public class TimesheetEntryBean {

	public String getTimesheetCommand() {
		return _timesheetCommand;
	}

	public String saveTask() {
		// parse object here

		try {
			//TimesheetTaskLocalServiceUtil.addTask();

			return "success";
		}
		catch (Exception e) {
			return "error";
		}
	}

	public void setTimesheetCommand(String command) {
		_timesheetCommand = command;
	}

	private String _timesheetCommand;

}