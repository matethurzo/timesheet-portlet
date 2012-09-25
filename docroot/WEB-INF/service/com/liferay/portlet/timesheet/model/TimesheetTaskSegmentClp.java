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

package com.liferay.portlet.timesheet.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.timesheet.service.TimesheetTaskSegmentLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mate Thurzo
 */
public class TimesheetTaskSegmentClp extends BaseModelImpl<TimesheetTaskSegment>
	implements TimesheetTaskSegment {
	public TimesheetTaskSegmentClp() {
	}

	public Class<?> getModelClass() {
		return TimesheetTaskSegment.class;
	}

	public String getModelClassName() {
		return TimesheetTaskSegment.class.getName();
	}

	public long getPrimaryKey() {
		return _segmentId;
	}

	public void setPrimaryKey(long primaryKey) {
		setSegmentId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_segmentId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("segmentId", getSegmentId());
		attributes.put("taskId", getTaskId());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("duration", getDuration());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long segmentId = (Long)attributes.get("segmentId");

		if (segmentId != null) {
			setSegmentId(segmentId);
		}

		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Long duration = (Long)attributes.get("duration");

		if (duration != null) {
			setDuration(duration);
		}
	}

	public long getSegmentId() {
		return _segmentId;
	}

	public void setSegmentId(long segmentId) {
		_segmentId = segmentId;
	}

	public long getTaskId() {
		return _taskId;
	}

	public void setTaskId(long taskId) {
		_taskId = taskId;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public long getDuration() {
		return _duration;
	}

	public void setDuration(long duration) {
		_duration = duration;
	}

	public BaseModel<?> getTimesheetTaskSegmentRemoteModel() {
		return _timesheetTaskSegmentRemoteModel;
	}

	public void setTimesheetTaskSegmentRemoteModel(
		BaseModel<?> timesheetTaskSegmentRemoteModel) {
		_timesheetTaskSegmentRemoteModel = timesheetTaskSegmentRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			TimesheetTaskSegmentLocalServiceUtil.addTimesheetTaskSegment(this);
		}
		else {
			TimesheetTaskSegmentLocalServiceUtil.updateTimesheetTaskSegment(this);
		}
	}

	@Override
	public TimesheetTaskSegment toEscapedModel() {
		return (TimesheetTaskSegment)Proxy.newProxyInstance(TimesheetTaskSegment.class.getClassLoader(),
			new Class[] { TimesheetTaskSegment.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TimesheetTaskSegmentClp clone = new TimesheetTaskSegmentClp();

		clone.setSegmentId(getSegmentId());
		clone.setTaskId(getTaskId());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());
		clone.setDuration(getDuration());

		return clone;
	}

	public int compareTo(TimesheetTaskSegment timesheetTaskSegment) {
		int value = 0;

		if (getSegmentId() < timesheetTaskSegment.getSegmentId()) {
			value = -1;
		}
		else if (getSegmentId() > timesheetTaskSegment.getSegmentId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		TimesheetTaskSegmentClp timesheetTaskSegment = null;

		try {
			timesheetTaskSegment = (TimesheetTaskSegmentClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = timesheetTaskSegment.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{segmentId=");
		sb.append(getSegmentId());
		sb.append(", taskId=");
		sb.append(getTaskId());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", duration=");
		sb.append(getDuration());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portlet.timesheet.model.TimesheetTaskSegment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>segmentId</column-name><column-value><![CDATA[");
		sb.append(getSegmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taskId</column-name><column-value><![CDATA[");
		sb.append(getTaskId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>duration</column-name><column-value><![CDATA[");
		sb.append(getDuration());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _segmentId;
	private long _taskId;
	private Date _startDate;
	private Date _endDate;
	private long _duration;
	private BaseModel<?> _timesheetTaskSegmentRemoteModel;
}