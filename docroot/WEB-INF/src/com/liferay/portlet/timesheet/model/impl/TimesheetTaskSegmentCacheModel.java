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
import com.liferay.portal.model.CacheModel;

import com.liferay.portlet.timesheet.model.TimesheetTaskSegment;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing TimesheetTaskSegment in entity cache.
 *
 * @author Mate Thurzo
 * @see TimesheetTaskSegment
 * @generated
 */
public class TimesheetTaskSegmentCacheModel implements CacheModel<TimesheetTaskSegment>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{segmentId=");
		sb.append(segmentId);
		sb.append(", taskId=");
		sb.append(taskId);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", duration=");
		sb.append(duration);
		sb.append("}");

		return sb.toString();
	}

	public TimesheetTaskSegment toEntityModel() {
		TimesheetTaskSegmentImpl timesheetTaskSegmentImpl = new TimesheetTaskSegmentImpl();

		timesheetTaskSegmentImpl.setSegmentId(segmentId);
		timesheetTaskSegmentImpl.setTaskId(taskId);

		if (startDate == Long.MIN_VALUE) {
			timesheetTaskSegmentImpl.setStartDate(null);
		}
		else {
			timesheetTaskSegmentImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			timesheetTaskSegmentImpl.setEndDate(null);
		}
		else {
			timesheetTaskSegmentImpl.setEndDate(new Date(endDate));
		}

		timesheetTaskSegmentImpl.setDuration(duration);

		timesheetTaskSegmentImpl.resetOriginalValues();

		return timesheetTaskSegmentImpl;
	}

	public long segmentId;
	public long taskId;
	public long startDate;
	public long endDate;
	public long duration;
}