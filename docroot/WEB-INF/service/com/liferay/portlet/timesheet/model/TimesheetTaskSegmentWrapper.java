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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TimesheetTaskSegment}.
 * </p>
 *
 * @author    Mate Thurzo
 * @see       TimesheetTaskSegment
 * @generated
 */
public class TimesheetTaskSegmentWrapper implements TimesheetTaskSegment,
	ModelWrapper<TimesheetTaskSegment> {
	public TimesheetTaskSegmentWrapper(
		TimesheetTaskSegment timesheetTaskSegment) {
		_timesheetTaskSegment = timesheetTaskSegment;
	}

	public Class<?> getModelClass() {
		return TimesheetTaskSegment.class;
	}

	public String getModelClassName() {
		return TimesheetTaskSegment.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("segmentId", getSegmentId());
		attributes.put("taskId", getTaskId());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("duration", getDuration());

		return attributes;
	}

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

	/**
	* Returns the primary key of this timesheet task segment.
	*
	* @return the primary key of this timesheet task segment
	*/
	public long getPrimaryKey() {
		return _timesheetTaskSegment.getPrimaryKey();
	}

	/**
	* Sets the primary key of this timesheet task segment.
	*
	* @param primaryKey the primary key of this timesheet task segment
	*/
	public void setPrimaryKey(long primaryKey) {
		_timesheetTaskSegment.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the segment ID of this timesheet task segment.
	*
	* @return the segment ID of this timesheet task segment
	*/
	public long getSegmentId() {
		return _timesheetTaskSegment.getSegmentId();
	}

	/**
	* Sets the segment ID of this timesheet task segment.
	*
	* @param segmentId the segment ID of this timesheet task segment
	*/
	public void setSegmentId(long segmentId) {
		_timesheetTaskSegment.setSegmentId(segmentId);
	}

	/**
	* Returns the task ID of this timesheet task segment.
	*
	* @return the task ID of this timesheet task segment
	*/
	public long getTaskId() {
		return _timesheetTaskSegment.getTaskId();
	}

	/**
	* Sets the task ID of this timesheet task segment.
	*
	* @param taskId the task ID of this timesheet task segment
	*/
	public void setTaskId(long taskId) {
		_timesheetTaskSegment.setTaskId(taskId);
	}

	/**
	* Returns the start date of this timesheet task segment.
	*
	* @return the start date of this timesheet task segment
	*/
	public java.util.Date getStartDate() {
		return _timesheetTaskSegment.getStartDate();
	}

	/**
	* Sets the start date of this timesheet task segment.
	*
	* @param startDate the start date of this timesheet task segment
	*/
	public void setStartDate(java.util.Date startDate) {
		_timesheetTaskSegment.setStartDate(startDate);
	}

	/**
	* Returns the end date of this timesheet task segment.
	*
	* @return the end date of this timesheet task segment
	*/
	public java.util.Date getEndDate() {
		return _timesheetTaskSegment.getEndDate();
	}

	/**
	* Sets the end date of this timesheet task segment.
	*
	* @param endDate the end date of this timesheet task segment
	*/
	public void setEndDate(java.util.Date endDate) {
		_timesheetTaskSegment.setEndDate(endDate);
	}

	/**
	* Returns the duration of this timesheet task segment.
	*
	* @return the duration of this timesheet task segment
	*/
	public long getDuration() {
		return _timesheetTaskSegment.getDuration();
	}

	/**
	* Sets the duration of this timesheet task segment.
	*
	* @param duration the duration of this timesheet task segment
	*/
	public void setDuration(long duration) {
		_timesheetTaskSegment.setDuration(duration);
	}

	public boolean isNew() {
		return _timesheetTaskSegment.isNew();
	}

	public void setNew(boolean n) {
		_timesheetTaskSegment.setNew(n);
	}

	public boolean isCachedModel() {
		return _timesheetTaskSegment.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_timesheetTaskSegment.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _timesheetTaskSegment.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _timesheetTaskSegment.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_timesheetTaskSegment.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _timesheetTaskSegment.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_timesheetTaskSegment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TimesheetTaskSegmentWrapper((TimesheetTaskSegment)_timesheetTaskSegment.clone());
	}

	public int compareTo(
		com.liferay.portlet.timesheet.model.TimesheetTaskSegment timesheetTaskSegment) {
		return _timesheetTaskSegment.compareTo(timesheetTaskSegment);
	}

	@Override
	public int hashCode() {
		return _timesheetTaskSegment.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.portlet.timesheet.model.TimesheetTaskSegment> toCacheModel() {
		return _timesheetTaskSegment.toCacheModel();
	}

	public com.liferay.portlet.timesheet.model.TimesheetTaskSegment toEscapedModel() {
		return new TimesheetTaskSegmentWrapper(_timesheetTaskSegment.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _timesheetTaskSegment.toString();
	}

	public java.lang.String toXmlString() {
		return _timesheetTaskSegment.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_timesheetTaskSegment.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public TimesheetTaskSegment getWrappedTimesheetTaskSegment() {
		return _timesheetTaskSegment;
	}

	public TimesheetTaskSegment getWrappedModel() {
		return _timesheetTaskSegment;
	}

	public void resetOriginalValues() {
		_timesheetTaskSegment.resetOriginalValues();
	}

	private TimesheetTaskSegment _timesheetTaskSegment;
}