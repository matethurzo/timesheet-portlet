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

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the TimesheetTaskSegment service. Represents a row in the &quot;TS_TimesheetTaskSegment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.timesheet.model.impl.TimesheetTaskSegmentModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.timesheet.model.impl.TimesheetTaskSegmentImpl}.
 * </p>
 *
 * @author Mate Thurzo
 * @see TimesheetTaskSegment
 * @see com.liferay.portlet.timesheet.model.impl.TimesheetTaskSegmentImpl
 * @see com.liferay.portlet.timesheet.model.impl.TimesheetTaskSegmentModelImpl
 * @generated
 */
public interface TimesheetTaskSegmentModel extends BaseModel<TimesheetTaskSegment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a timesheet task segment model instance should use the {@link TimesheetTaskSegment} interface instead.
	 */

	/**
	 * Returns the primary key of this timesheet task segment.
	 *
	 * @return the primary key of this timesheet task segment
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this timesheet task segment.
	 *
	 * @param primaryKey the primary key of this timesheet task segment
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the segment ID of this timesheet task segment.
	 *
	 * @return the segment ID of this timesheet task segment
	 */
	public long getSegmentId();

	/**
	 * Sets the segment ID of this timesheet task segment.
	 *
	 * @param segmentId the segment ID of this timesheet task segment
	 */
	public void setSegmentId(long segmentId);

	/**
	 * Returns the task ID of this timesheet task segment.
	 *
	 * @return the task ID of this timesheet task segment
	 */
	public long getTaskId();

	/**
	 * Sets the task ID of this timesheet task segment.
	 *
	 * @param taskId the task ID of this timesheet task segment
	 */
	public void setTaskId(long taskId);

	/**
	 * Returns the start date of this timesheet task segment.
	 *
	 * @return the start date of this timesheet task segment
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this timesheet task segment.
	 *
	 * @param startDate the start date of this timesheet task segment
	 */
	public void setStartDate(Date startDate);

	/**
	 * Returns the end date of this timesheet task segment.
	 *
	 * @return the end date of this timesheet task segment
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this timesheet task segment.
	 *
	 * @param endDate the end date of this timesheet task segment
	 */
	public void setEndDate(Date endDate);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(TimesheetTaskSegment timesheetTaskSegment);

	public int hashCode();

	public CacheModel<TimesheetTaskSegment> toCacheModel();

	public TimesheetTaskSegment toEscapedModel();

	public String toString();

	public String toXmlString();
}