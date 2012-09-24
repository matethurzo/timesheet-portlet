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

import com.liferay.portlet.timesheet.model.TimesheetTask;

/**
 * The persistence interface for the timesheet task service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mate Thurzo
 * @see TimesheetTaskPersistenceImpl
 * @see TimesheetTaskUtil
 * @generated
 */
public interface TimesheetTaskPersistence extends BasePersistence<TimesheetTask> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TimesheetTaskUtil} to access the timesheet task persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the timesheet task in the entity cache if it is enabled.
	*
	* @param timesheetTask the timesheet task
	*/
	public void cacheResult(
		com.liferay.portlet.timesheet.model.TimesheetTask timesheetTask);

	/**
	* Caches the timesheet tasks in the entity cache if it is enabled.
	*
	* @param timesheetTasks the timesheet tasks
	*/
	public void cacheResult(
		java.util.List<com.liferay.portlet.timesheet.model.TimesheetTask> timesheetTasks);

	/**
	* Creates a new timesheet task with the primary key. Does not add the timesheet task to the database.
	*
	* @param taskId the primary key for the new timesheet task
	* @return the new timesheet task
	*/
	public com.liferay.portlet.timesheet.model.TimesheetTask create(long taskId);

	/**
	* Removes the timesheet task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taskId the primary key of the timesheet task
	* @return the timesheet task that was removed
	* @throws com.liferay.portlet.timesheet.NoSuchTimesheetTaskException if a timesheet task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.timesheet.model.TimesheetTask remove(long taskId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.timesheet.NoSuchTimesheetTaskException;

	public com.liferay.portlet.timesheet.model.TimesheetTask updateImpl(
		com.liferay.portlet.timesheet.model.TimesheetTask timesheetTask,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the timesheet task with the primary key or throws a {@link com.liferay.portlet.timesheet.NoSuchTimesheetTaskException} if it could not be found.
	*
	* @param taskId the primary key of the timesheet task
	* @return the timesheet task
	* @throws com.liferay.portlet.timesheet.NoSuchTimesheetTaskException if a timesheet task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.timesheet.model.TimesheetTask findByPrimaryKey(
		long taskId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.timesheet.NoSuchTimesheetTaskException;

	/**
	* Returns the timesheet task with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param taskId the primary key of the timesheet task
	* @return the timesheet task, or <code>null</code> if a timesheet task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.timesheet.model.TimesheetTask fetchByPrimaryKey(
		long taskId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the timesheet tasks.
	*
	* @return the timesheet tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.timesheet.model.TimesheetTask> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the timesheet tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of timesheet tasks
	* @param end the upper bound of the range of timesheet tasks (not inclusive)
	* @return the range of timesheet tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.timesheet.model.TimesheetTask> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the timesheet tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of timesheet tasks
	* @param end the upper bound of the range of timesheet tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of timesheet tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.timesheet.model.TimesheetTask> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the timesheet tasks from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of timesheet tasks.
	*
	* @return the number of timesheet tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}