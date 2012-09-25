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

package com.liferay.portlet.timesheet.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.portlet.timesheet.model.TimesheetTask;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing TimesheetTask in entity cache.
 *
 * @author Mate Thurzo
 * @see TimesheetTask
 * @generated
 */
public class TimesheetTaskCacheModel implements CacheModel<TimesheetTask>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{taskId=");
		sb.append(taskId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", duration=");
		sb.append(duration);
		sb.append("}");

		return sb.toString();
	}

	public TimesheetTask toEntityModel() {
		TimesheetTaskImpl timesheetTaskImpl = new TimesheetTaskImpl();

		timesheetTaskImpl.setTaskId(taskId);
		timesheetTaskImpl.setUserId(userId);

		if (userName == null) {
			timesheetTaskImpl.setUserName(StringPool.BLANK);
		}
		else {
			timesheetTaskImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			timesheetTaskImpl.setCreateDate(null);
		}
		else {
			timesheetTaskImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			timesheetTaskImpl.setModifiedDate(null);
		}
		else {
			timesheetTaskImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			timesheetTaskImpl.setName(StringPool.BLANK);
		}
		else {
			timesheetTaskImpl.setName(name);
		}

		if (description == null) {
			timesheetTaskImpl.setDescription(StringPool.BLANK);
		}
		else {
			timesheetTaskImpl.setDescription(description);
		}

		timesheetTaskImpl.setDuration(duration);

		timesheetTaskImpl.resetOriginalValues();

		return timesheetTaskImpl;
	}

	public long taskId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String description;
	public long duration;
}