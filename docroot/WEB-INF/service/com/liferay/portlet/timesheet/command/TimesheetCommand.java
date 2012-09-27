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
public interface TimesheetCommand {

	public static final String TOKEN_END_TIME = "e";
	public static final String TOKEN_START_TIME = "s";
	public static final String TOKEN_TAGS = "x";
	public static final String TOKEN_TITLE = "t";

	public Date getEndDate();

	public Date getStartDate();

	public String[] getTags();

	public String getTitle();

	public void setEndDate(Date endDate);

	public void setStartDate(Date startDate);

	public void setTags(String tags[]);

	public void setTitle(String title);

}