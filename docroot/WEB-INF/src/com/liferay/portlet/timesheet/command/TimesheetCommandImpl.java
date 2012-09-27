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

package com.liferay.portlet.timesheet.command;

import java.util.Date;

/**
 * @author Daniel Kocsis
 */
public class TimesheetCommandImpl implements TimesheetCommand {

	public Date getEndDate() {
		return _endDate;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public String[] getTags() {
		return _tags;
	}

	public String getTitle() {
		return _title;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public void setTags(String[] tags) {
		_tags = tags;
	}

	public void setTitle(String title) {
		_title = title;
	}

	private Date _endDate;
	private Date _startDate;
	private String[] _tags;
	private String _title;

}