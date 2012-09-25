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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.portlet.timesheet.service.http.TimesheetTaskSegmentServiceSoap}.
 *
 * @author    Mate Thurzo
 * @see       com.liferay.portlet.timesheet.service.http.TimesheetTaskSegmentServiceSoap
 * @generated
 */
public class TimesheetTaskSegmentSoap implements Serializable {
	public static TimesheetTaskSegmentSoap toSoapModel(
		TimesheetTaskSegment model) {
		TimesheetTaskSegmentSoap soapModel = new TimesheetTaskSegmentSoap();

		soapModel.setSegmentId(model.getSegmentId());
		soapModel.setTaskId(model.getTaskId());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setDuration(model.getDuration());

		return soapModel;
	}

	public static TimesheetTaskSegmentSoap[] toSoapModels(
		TimesheetTaskSegment[] models) {
		TimesheetTaskSegmentSoap[] soapModels = new TimesheetTaskSegmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TimesheetTaskSegmentSoap[][] toSoapModels(
		TimesheetTaskSegment[][] models) {
		TimesheetTaskSegmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TimesheetTaskSegmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TimesheetTaskSegmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TimesheetTaskSegmentSoap[] toSoapModels(
		List<TimesheetTaskSegment> models) {
		List<TimesheetTaskSegmentSoap> soapModels = new ArrayList<TimesheetTaskSegmentSoap>(models.size());

		for (TimesheetTaskSegment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TimesheetTaskSegmentSoap[soapModels.size()]);
	}

	public TimesheetTaskSegmentSoap() {
	}

	public long getPrimaryKey() {
		return _segmentId;
	}

	public void setPrimaryKey(long pk) {
		setSegmentId(pk);
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

	private long _segmentId;
	private long _taskId;
	private Date _startDate;
	private Date _endDate;
	private long _duration;
}