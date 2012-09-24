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

package com.liferay.portlet.timesheet.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.portlet.timesheet.model.TimesheetTaskSegment;

/**
 * The persistence interface for the timesheet task segment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mate Thurzo
 * @see TimesheetTaskSegmentPersistenceImpl
 * @see TimesheetTaskSegmentUtil
 * @generated
 */
public interface TimesheetTaskSegmentPersistence extends BasePersistence<TimesheetTaskSegment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TimesheetTaskSegmentUtil} to access the timesheet task segment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the timesheet task segment in the entity cache if it is enabled.
	*
	* @param timesheetTaskSegment the timesheet task segment
	*/
	public void cacheResult(
		com.liferay.portlet.timesheet.model.TimesheetTaskSegment timesheetTaskSegment);

	/**
	* Caches the timesheet task segments in the entity cache if it is enabled.
	*
	* @param timesheetTaskSegments the timesheet task segments
	*/
	public void cacheResult(
		java.util.List<com.liferay.portlet.timesheet.model.TimesheetTaskSegment> timesheetTaskSegments);

	/**
	* Creates a new timesheet task segment with the primary key. Does not add the timesheet task segment to the database.
	*
	* @param segmentId the primary key for the new timesheet task segment
	* @return the new timesheet task segment
	*/
	public com.liferay.portlet.timesheet.model.TimesheetTaskSegment create(
		long segmentId);

	/**
	* Removes the timesheet task segment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param segmentId the primary key of the timesheet task segment
	* @return the timesheet task segment that was removed
	* @throws com.liferay.portlet.timesheet.NoSuchTimesheetTaskSegmentException if a timesheet task segment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.timesheet.model.TimesheetTaskSegment remove(
		long segmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.timesheet.NoSuchTimesheetTaskSegmentException;

	public com.liferay.portlet.timesheet.model.TimesheetTaskSegment updateImpl(
		com.liferay.portlet.timesheet.model.TimesheetTaskSegment timesheetTaskSegment,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the timesheet task segment with the primary key or throws a {@link com.liferay.portlet.timesheet.NoSuchTimesheetTaskSegmentException} if it could not be found.
	*
	* @param segmentId the primary key of the timesheet task segment
	* @return the timesheet task segment
	* @throws com.liferay.portlet.timesheet.NoSuchTimesheetTaskSegmentException if a timesheet task segment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.timesheet.model.TimesheetTaskSegment findByPrimaryKey(
		long segmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.timesheet.NoSuchTimesheetTaskSegmentException;

	/**
	* Returns the timesheet task segment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param segmentId the primary key of the timesheet task segment
	* @return the timesheet task segment, or <code>null</code> if a timesheet task segment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.timesheet.model.TimesheetTaskSegment fetchByPrimaryKey(
		long segmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the timesheet task segments.
	*
	* @return the timesheet task segments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.timesheet.model.TimesheetTaskSegment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the timesheet task segments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of timesheet task segments
	* @param end the upper bound of the range of timesheet task segments (not inclusive)
	* @return the range of timesheet task segments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.timesheet.model.TimesheetTaskSegment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the timesheet task segments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of timesheet task segments
	* @param end the upper bound of the range of timesheet task segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of timesheet task segments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.timesheet.model.TimesheetTaskSegment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the timesheet task segments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of timesheet task segments.
	*
	* @return the number of timesheet task segments
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}