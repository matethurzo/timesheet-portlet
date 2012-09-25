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

package com.liferay.portlet.timesheet.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.portlet.timesheet.model.TimesheetTaskSegment;
import com.liferay.portlet.timesheet.service.TimesheetTaskLocalService;
import com.liferay.portlet.timesheet.service.TimesheetTaskSegmentLocalService;
import com.liferay.portlet.timesheet.service.TimesheetTaskSegmentService;
import com.liferay.portlet.timesheet.service.TimesheetTaskService;
import com.liferay.portlet.timesheet.service.persistence.TimesheetTaskPersistence;
import com.liferay.portlet.timesheet.service.persistence.TimesheetTaskSegmentPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the timesheet task segment local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.portlet.timesheet.service.impl.TimesheetTaskSegmentLocalServiceImpl}.
 * </p>
 *
 * @author Mate Thurzo
 * @see com.liferay.portlet.timesheet.service.impl.TimesheetTaskSegmentLocalServiceImpl
 * @see com.liferay.portlet.timesheet.service.TimesheetTaskSegmentLocalServiceUtil
 * @generated
 */
public abstract class TimesheetTaskSegmentLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements TimesheetTaskSegmentLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.portlet.timesheet.service.TimesheetTaskSegmentLocalServiceUtil} to access the timesheet task segment local service.
	 */

	/**
	 * Adds the timesheet task segment to the database. Also notifies the appropriate model listeners.
	 *
	 * @param timesheetTaskSegment the timesheet task segment
	 * @return the timesheet task segment that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TimesheetTaskSegment addTimesheetTaskSegment(
		TimesheetTaskSegment timesheetTaskSegment) throws SystemException {
		timesheetTaskSegment.setNew(true);

		return timesheetTaskSegmentPersistence.update(timesheetTaskSegment,
			false);
	}

	/**
	 * Creates a new timesheet task segment with the primary key. Does not add the timesheet task segment to the database.
	 *
	 * @param segmentId the primary key for the new timesheet task segment
	 * @return the new timesheet task segment
	 */
	public TimesheetTaskSegment createTimesheetTaskSegment(long segmentId) {
		return timesheetTaskSegmentPersistence.create(segmentId);
	}

	/**
	 * Deletes the timesheet task segment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param segmentId the primary key of the timesheet task segment
	 * @return the timesheet task segment that was removed
	 * @throws PortalException if a timesheet task segment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public TimesheetTaskSegment deleteTimesheetTaskSegment(long segmentId)
		throws PortalException, SystemException {
		return timesheetTaskSegmentPersistence.remove(segmentId);
	}

	/**
	 * Deletes the timesheet task segment from the database. Also notifies the appropriate model listeners.
	 *
	 * @param timesheetTaskSegment the timesheet task segment
	 * @return the timesheet task segment that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public TimesheetTaskSegment deleteTimesheetTaskSegment(
		TimesheetTaskSegment timesheetTaskSegment) throws SystemException {
		return timesheetTaskSegmentPersistence.remove(timesheetTaskSegment);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(TimesheetTaskSegment.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return timesheetTaskSegmentPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return timesheetTaskSegmentPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return timesheetTaskSegmentPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return timesheetTaskSegmentPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public TimesheetTaskSegment fetchTimesheetTaskSegment(long segmentId)
		throws SystemException {
		return timesheetTaskSegmentPersistence.fetchByPrimaryKey(segmentId);
	}

	/**
	 * Returns the timesheet task segment with the primary key.
	 *
	 * @param segmentId the primary key of the timesheet task segment
	 * @return the timesheet task segment
	 * @throws PortalException if a timesheet task segment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TimesheetTaskSegment getTimesheetTaskSegment(long segmentId)
		throws PortalException, SystemException {
		return timesheetTaskSegmentPersistence.findByPrimaryKey(segmentId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return timesheetTaskSegmentPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<TimesheetTaskSegment> getTimesheetTaskSegments(int start,
		int end) throws SystemException {
		return timesheetTaskSegmentPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of timesheet task segments.
	 *
	 * @return the number of timesheet task segments
	 * @throws SystemException if a system exception occurred
	 */
	public int getTimesheetTaskSegmentsCount() throws SystemException {
		return timesheetTaskSegmentPersistence.countAll();
	}

	/**
	 * Updates the timesheet task segment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param timesheetTaskSegment the timesheet task segment
	 * @return the timesheet task segment that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TimesheetTaskSegment updateTimesheetTaskSegment(
		TimesheetTaskSegment timesheetTaskSegment) throws SystemException {
		return updateTimesheetTaskSegment(timesheetTaskSegment, true);
	}

	/**
	 * Updates the timesheet task segment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param timesheetTaskSegment the timesheet task segment
	 * @param merge whether to merge the timesheet task segment with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the timesheet task segment that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TimesheetTaskSegment updateTimesheetTaskSegment(
		TimesheetTaskSegment timesheetTaskSegment, boolean merge)
		throws SystemException {
		timesheetTaskSegment.setNew(false);

		return timesheetTaskSegmentPersistence.update(timesheetTaskSegment,
			merge);
	}

	/**
	 * Returns the timesheet task local service.
	 *
	 * @return the timesheet task local service
	 */
	public TimesheetTaskLocalService getTimesheetTaskLocalService() {
		return timesheetTaskLocalService;
	}

	/**
	 * Sets the timesheet task local service.
	 *
	 * @param timesheetTaskLocalService the timesheet task local service
	 */
	public void setTimesheetTaskLocalService(
		TimesheetTaskLocalService timesheetTaskLocalService) {
		this.timesheetTaskLocalService = timesheetTaskLocalService;
	}

	/**
	 * Returns the timesheet task remote service.
	 *
	 * @return the timesheet task remote service
	 */
	public TimesheetTaskService getTimesheetTaskService() {
		return timesheetTaskService;
	}

	/**
	 * Sets the timesheet task remote service.
	 *
	 * @param timesheetTaskService the timesheet task remote service
	 */
	public void setTimesheetTaskService(
		TimesheetTaskService timesheetTaskService) {
		this.timesheetTaskService = timesheetTaskService;
	}

	/**
	 * Returns the timesheet task persistence.
	 *
	 * @return the timesheet task persistence
	 */
	public TimesheetTaskPersistence getTimesheetTaskPersistence() {
		return timesheetTaskPersistence;
	}

	/**
	 * Sets the timesheet task persistence.
	 *
	 * @param timesheetTaskPersistence the timesheet task persistence
	 */
	public void setTimesheetTaskPersistence(
		TimesheetTaskPersistence timesheetTaskPersistence) {
		this.timesheetTaskPersistence = timesheetTaskPersistence;
	}

	/**
	 * Returns the timesheet task segment local service.
	 *
	 * @return the timesheet task segment local service
	 */
	public TimesheetTaskSegmentLocalService getTimesheetTaskSegmentLocalService() {
		return timesheetTaskSegmentLocalService;
	}

	/**
	 * Sets the timesheet task segment local service.
	 *
	 * @param timesheetTaskSegmentLocalService the timesheet task segment local service
	 */
	public void setTimesheetTaskSegmentLocalService(
		TimesheetTaskSegmentLocalService timesheetTaskSegmentLocalService) {
		this.timesheetTaskSegmentLocalService = timesheetTaskSegmentLocalService;
	}

	/**
	 * Returns the timesheet task segment remote service.
	 *
	 * @return the timesheet task segment remote service
	 */
	public TimesheetTaskSegmentService getTimesheetTaskSegmentService() {
		return timesheetTaskSegmentService;
	}

	/**
	 * Sets the timesheet task segment remote service.
	 *
	 * @param timesheetTaskSegmentService the timesheet task segment remote service
	 */
	public void setTimesheetTaskSegmentService(
		TimesheetTaskSegmentService timesheetTaskSegmentService) {
		this.timesheetTaskSegmentService = timesheetTaskSegmentService;
	}

	/**
	 * Returns the timesheet task segment persistence.
	 *
	 * @return the timesheet task segment persistence
	 */
	public TimesheetTaskSegmentPersistence getTimesheetTaskSegmentPersistence() {
		return timesheetTaskSegmentPersistence;
	}

	/**
	 * Sets the timesheet task segment persistence.
	 *
	 * @param timesheetTaskSegmentPersistence the timesheet task segment persistence
	 */
	public void setTimesheetTaskSegmentPersistence(
		TimesheetTaskSegmentPersistence timesheetTaskSegmentPersistence) {
		this.timesheetTaskSegmentPersistence = timesheetTaskSegmentPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		PersistedModelLocalServiceRegistryUtil.register("com.liferay.portlet.timesheet.model.TimesheetTaskSegment",
			timesheetTaskSegmentLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.liferay.portlet.timesheet.model.TimesheetTaskSegment");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
	}

	protected Class<?> getModelClass() {
		return TimesheetTaskSegment.class;
	}

	protected String getModelClassName() {
		return TimesheetTaskSegment.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = timesheetTaskSegmentPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = TimesheetTaskLocalService.class)
	protected TimesheetTaskLocalService timesheetTaskLocalService;
	@BeanReference(type = TimesheetTaskService.class)
	protected TimesheetTaskService timesheetTaskService;
	@BeanReference(type = TimesheetTaskPersistence.class)
	protected TimesheetTaskPersistence timesheetTaskPersistence;
	@BeanReference(type = TimesheetTaskSegmentLocalService.class)
	protected TimesheetTaskSegmentLocalService timesheetTaskSegmentLocalService;
	@BeanReference(type = TimesheetTaskSegmentService.class)
	protected TimesheetTaskSegmentService timesheetTaskSegmentService;
	@BeanReference(type = TimesheetTaskSegmentPersistence.class)
	protected TimesheetTaskSegmentPersistence timesheetTaskSegmentPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private TimesheetTaskSegmentLocalServiceClpInvoker _clpInvoker = new TimesheetTaskSegmentLocalServiceClpInvoker();
}