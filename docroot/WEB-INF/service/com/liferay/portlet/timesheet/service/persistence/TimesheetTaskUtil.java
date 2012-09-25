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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.timesheet.model.TimesheetTask;

import java.util.List;

/**
 * The persistence utility for the timesheet task service. This utility wraps {@link TimesheetTaskPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mate Thurzo
 * @see TimesheetTaskPersistence
 * @see TimesheetTaskPersistenceImpl
 * @generated
 */
public class TimesheetTaskUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(TimesheetTask timesheetTask) {
		getPersistence().clearCache(timesheetTask);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TimesheetTask> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TimesheetTask> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TimesheetTask> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static TimesheetTask update(TimesheetTask timesheetTask,
		boolean merge) throws SystemException {
		return getPersistence().update(timesheetTask, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static TimesheetTask update(TimesheetTask timesheetTask,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(timesheetTask, merge, serviceContext);
	}

	/**
	* Caches the timesheet task in the entity cache if it is enabled.
	*
	* @param timesheetTask the timesheet task
	*/
	public static void cacheResult(
		com.liferay.portlet.timesheet.model.TimesheetTask timesheetTask) {
		getPersistence().cacheResult(timesheetTask);
	}

	/**
	* Caches the timesheet tasks in the entity cache if it is enabled.
	*
	* @param timesheetTasks the timesheet tasks
	*/
	public static void cacheResult(
		java.util.List<com.liferay.portlet.timesheet.model.TimesheetTask> timesheetTasks) {
		getPersistence().cacheResult(timesheetTasks);
	}

	/**
	* Creates a new timesheet task with the primary key. Does not add the timesheet task to the database.
	*
	* @param taskId the primary key for the new timesheet task
	* @return the new timesheet task
	*/
	public static com.liferay.portlet.timesheet.model.TimesheetTask create(
		long taskId) {
		return getPersistence().create(taskId);
	}

	/**
	* Removes the timesheet task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taskId the primary key of the timesheet task
	* @return the timesheet task that was removed
	* @throws com.liferay.portlet.timesheet.NoSuchTimesheetTaskException if a timesheet task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.timesheet.model.TimesheetTask remove(
		long taskId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.timesheet.NoSuchTimesheetTaskException {
		return getPersistence().remove(taskId);
	}

	public static com.liferay.portlet.timesheet.model.TimesheetTask updateImpl(
		com.liferay.portlet.timesheet.model.TimesheetTask timesheetTask,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(timesheetTask, merge);
	}

	/**
	* Returns the timesheet task with the primary key or throws a {@link com.liferay.portlet.timesheet.NoSuchTimesheetTaskException} if it could not be found.
	*
	* @param taskId the primary key of the timesheet task
	* @return the timesheet task
	* @throws com.liferay.portlet.timesheet.NoSuchTimesheetTaskException if a timesheet task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.timesheet.model.TimesheetTask findByPrimaryKey(
		long taskId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.timesheet.NoSuchTimesheetTaskException {
		return getPersistence().findByPrimaryKey(taskId);
	}

	/**
	* Returns the timesheet task with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param taskId the primary key of the timesheet task
	* @return the timesheet task, or <code>null</code> if a timesheet task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.timesheet.model.TimesheetTask fetchByPrimaryKey(
		long taskId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(taskId);
	}

	/**
	* Returns the timesheet task where name = &#63; or throws a {@link com.liferay.portlet.timesheet.NoSuchTimesheetTaskException} if it could not be found.
	*
	* @param name the name
	* @return the matching timesheet task
	* @throws com.liferay.portlet.timesheet.NoSuchTimesheetTaskException if a matching timesheet task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.timesheet.model.TimesheetTask findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.timesheet.NoSuchTimesheetTaskException {
		return getPersistence().findByName(name);
	}

	/**
	* Returns the timesheet task where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching timesheet task, or <code>null</code> if a matching timesheet task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.timesheet.model.TimesheetTask fetchByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name);
	}

	/**
	* Returns the timesheet task where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching timesheet task, or <code>null</code> if a matching timesheet task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.timesheet.model.TimesheetTask fetchByName(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name, retrieveFromCache);
	}

	/**
	* Returns all the timesheet tasks.
	*
	* @return the timesheet tasks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.timesheet.model.TimesheetTask> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.liferay.portlet.timesheet.model.TimesheetTask> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.liferay.portlet.timesheet.model.TimesheetTask> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the timesheet task where name = &#63; from the database.
	*
	* @param name the name
	* @return the timesheet task that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.timesheet.model.TimesheetTask removeByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.timesheet.NoSuchTimesheetTaskException {
		return getPersistence().removeByName(name);
	}

	/**
	* Removes all the timesheet tasks from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of timesheet tasks where name = &#63;.
	*
	* @param name the name
	* @return the number of matching timesheet tasks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(name);
	}

	/**
	* Returns the number of timesheet tasks.
	*
	* @return the number of timesheet tasks
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TimesheetTaskPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TimesheetTaskPersistence)PortletBeanLocatorUtil.locate(com.liferay.portlet.timesheet.service.ClpSerializer.getServletContextName(),
					TimesheetTaskPersistence.class.getName());

			ReferenceRegistry.registerReference(TimesheetTaskUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(TimesheetTaskPersistence persistence) {
	}

	private static TimesheetTaskPersistence _persistence;
}