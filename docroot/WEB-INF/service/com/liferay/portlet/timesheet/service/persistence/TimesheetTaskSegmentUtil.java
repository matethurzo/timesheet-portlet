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

import com.liferay.portlet.timesheet.model.TimesheetTaskSegment;

import java.util.List;

/**
 * The persistence utility for the timesheet task segment service. This utility wraps {@link TimesheetTaskSegmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mate Thurzo
 * @see TimesheetTaskSegmentPersistence
 * @see TimesheetTaskSegmentPersistenceImpl
 * @generated
 */
public class TimesheetTaskSegmentUtil {
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
	public static void clearCache(TimesheetTaskSegment timesheetTaskSegment) {
		getPersistence().clearCache(timesheetTaskSegment);
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
	public static List<TimesheetTaskSegment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TimesheetTaskSegment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TimesheetTaskSegment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static TimesheetTaskSegment update(
		TimesheetTaskSegment timesheetTaskSegment, boolean merge)
		throws SystemException {
		return getPersistence().update(timesheetTaskSegment, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static TimesheetTaskSegment update(
		TimesheetTaskSegment timesheetTaskSegment, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(timesheetTaskSegment, merge, serviceContext);
	}

	/**
	* Caches the timesheet task segment in the entity cache if it is enabled.
	*
	* @param timesheetTaskSegment the timesheet task segment
	*/
	public static void cacheResult(
		com.liferay.portlet.timesheet.model.TimesheetTaskSegment timesheetTaskSegment) {
		getPersistence().cacheResult(timesheetTaskSegment);
	}

	/**
	* Caches the timesheet task segments in the entity cache if it is enabled.
	*
	* @param timesheetTaskSegments the timesheet task segments
	*/
	public static void cacheResult(
		java.util.List<com.liferay.portlet.timesheet.model.TimesheetTaskSegment> timesheetTaskSegments) {
		getPersistence().cacheResult(timesheetTaskSegments);
	}

	/**
	* Creates a new timesheet task segment with the primary key. Does not add the timesheet task segment to the database.
	*
	* @param segmentId the primary key for the new timesheet task segment
	* @return the new timesheet task segment
	*/
	public static com.liferay.portlet.timesheet.model.TimesheetTaskSegment create(
		long segmentId) {
		return getPersistence().create(segmentId);
	}

	/**
	* Removes the timesheet task segment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param segmentId the primary key of the timesheet task segment
	* @return the timesheet task segment that was removed
	* @throws com.liferay.portlet.timesheet.NoSuchTimesheetTaskSegmentException if a timesheet task segment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.timesheet.model.TimesheetTaskSegment remove(
		long segmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.timesheet.NoSuchTimesheetTaskSegmentException {
		return getPersistence().remove(segmentId);
	}

	public static com.liferay.portlet.timesheet.model.TimesheetTaskSegment updateImpl(
		com.liferay.portlet.timesheet.model.TimesheetTaskSegment timesheetTaskSegment,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(timesheetTaskSegment, merge);
	}

	/**
	* Returns the timesheet task segment with the primary key or throws a {@link com.liferay.portlet.timesheet.NoSuchTimesheetTaskSegmentException} if it could not be found.
	*
	* @param segmentId the primary key of the timesheet task segment
	* @return the timesheet task segment
	* @throws com.liferay.portlet.timesheet.NoSuchTimesheetTaskSegmentException if a timesheet task segment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.timesheet.model.TimesheetTaskSegment findByPrimaryKey(
		long segmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.timesheet.NoSuchTimesheetTaskSegmentException {
		return getPersistence().findByPrimaryKey(segmentId);
	}

	/**
	* Returns the timesheet task segment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param segmentId the primary key of the timesheet task segment
	* @return the timesheet task segment, or <code>null</code> if a timesheet task segment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.timesheet.model.TimesheetTaskSegment fetchByPrimaryKey(
		long segmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(segmentId);
	}

	/**
	* Returns all the timesheet task segments.
	*
	* @return the timesheet task segments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.timesheet.model.TimesheetTaskSegment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.liferay.portlet.timesheet.model.TimesheetTaskSegment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.liferay.portlet.timesheet.model.TimesheetTaskSegment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the timesheet task segments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of timesheet task segments.
	*
	* @return the number of timesheet task segments
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TimesheetTaskSegmentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TimesheetTaskSegmentPersistence)PortletBeanLocatorUtil.locate(com.liferay.portlet.timesheet.service.ClpSerializer.getServletContextName(),
					TimesheetTaskSegmentPersistence.class.getName());

			ReferenceRegistry.registerReference(TimesheetTaskSegmentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(TimesheetTaskSegmentPersistence persistence) {
	}

	private static TimesheetTaskSegmentPersistence _persistence;
}