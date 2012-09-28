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

package com.liferay.portlet.timesheet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TimesheetTaskLocalService}.
 * </p>
 *
 * @author    Mate Thurzo
 * @see       TimesheetTaskLocalService
 * @generated
 */
public class TimesheetTaskLocalServiceWrapper
	implements TimesheetTaskLocalService,
		ServiceWrapper<TimesheetTaskLocalService> {
	public TimesheetTaskLocalServiceWrapper(
		TimesheetTaskLocalService timesheetTaskLocalService) {
		_timesheetTaskLocalService = timesheetTaskLocalService;
	}

	/**
	* Adds the timesheet task to the database. Also notifies the appropriate model listeners.
	*
	* @param timesheetTask the timesheet task
	* @return the timesheet task that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.timesheet.model.TimesheetTask addTimesheetTask(
		com.liferay.portlet.timesheet.model.TimesheetTask timesheetTask)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timesheetTaskLocalService.addTimesheetTask(timesheetTask);
	}

	/**
	* Creates a new timesheet task with the primary key. Does not add the timesheet task to the database.
	*
	* @param taskId the primary key for the new timesheet task
	* @return the new timesheet task
	*/
	public com.liferay.portlet.timesheet.model.TimesheetTask createTimesheetTask(
		long taskId) {
		return _timesheetTaskLocalService.createTimesheetTask(taskId);
	}

	/**
	* Deletes the timesheet task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taskId the primary key of the timesheet task
	* @return the timesheet task that was removed
	* @throws PortalException if a timesheet task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.timesheet.model.TimesheetTask deleteTimesheetTask(
		long taskId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _timesheetTaskLocalService.deleteTimesheetTask(taskId);
	}

	/**
	* Deletes the timesheet task from the database. Also notifies the appropriate model listeners.
	*
	* @param timesheetTask the timesheet task
	* @return the timesheet task that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.timesheet.model.TimesheetTask deleteTimesheetTask(
		com.liferay.portlet.timesheet.model.TimesheetTask timesheetTask)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timesheetTaskLocalService.deleteTimesheetTask(timesheetTask);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _timesheetTaskLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timesheetTaskLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _timesheetTaskLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timesheetTaskLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timesheetTaskLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.liferay.portlet.timesheet.model.TimesheetTask fetchTimesheetTask(
		long taskId) throws com.liferay.portal.kernel.exception.SystemException {
		return _timesheetTaskLocalService.fetchTimesheetTask(taskId);
	}

	/**
	* Returns the timesheet task with the primary key.
	*
	* @param taskId the primary key of the timesheet task
	* @return the timesheet task
	* @throws PortalException if a timesheet task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.timesheet.model.TimesheetTask getTimesheetTask(
		long taskId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _timesheetTaskLocalService.getTimesheetTask(taskId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _timesheetTaskLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.liferay.portlet.timesheet.model.TimesheetTask> getTimesheetTasks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timesheetTaskLocalService.getTimesheetTasks(start, end);
	}

	/**
	* Returns the number of timesheet tasks.
	*
	* @return the number of timesheet tasks
	* @throws SystemException if a system exception occurred
	*/
	public int getTimesheetTasksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timesheetTaskLocalService.getTimesheetTasksCount();
	}

	/**
	* Updates the timesheet task in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param timesheetTask the timesheet task
	* @return the timesheet task that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.timesheet.model.TimesheetTask updateTimesheetTask(
		com.liferay.portlet.timesheet.model.TimesheetTask timesheetTask)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timesheetTaskLocalService.updateTimesheetTask(timesheetTask);
	}

	/**
	* Updates the timesheet task in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param timesheetTask the timesheet task
	* @param merge whether to merge the timesheet task with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the timesheet task that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.timesheet.model.TimesheetTask updateTimesheetTask(
		com.liferay.portlet.timesheet.model.TimesheetTask timesheetTask,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timesheetTaskLocalService.updateTimesheetTask(timesheetTask,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _timesheetTaskLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_timesheetTaskLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _timesheetTaskLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link com.liferay.portlet.timesheet.service.TimesheetTaskLocalServiceUtil} to access the timesheet task local service.
	*/
	public com.liferay.portlet.timesheet.model.TimesheetTask addTask(
		long userId, java.lang.String name, java.lang.String description)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _timesheetTaskLocalService.addTask(userId, name, description);
	}

	public java.util.List<java.lang.Object[]> getTaskIdsByDate(
		java.util.Date currentDate, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timesheetTaskLocalService.getTaskIdsByDate(currentDate, userId);
	}

	public com.liferay.portlet.timesheet.model.TimesheetTask getTaskByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _timesheetTaskLocalService.getTaskByName(name);
	}

	public com.liferay.portlet.timesheet.model.TimesheetTask updateDuration(
		long taskId, long duration)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _timesheetTaskLocalService.updateDuration(taskId, duration);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TimesheetTaskLocalService getWrappedTimesheetTaskLocalService() {
		return _timesheetTaskLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTimesheetTaskLocalService(
		TimesheetTaskLocalService timesheetTaskLocalService) {
		_timesheetTaskLocalService = timesheetTaskLocalService;
	}

	public TimesheetTaskLocalService getWrappedService() {
		return _timesheetTaskLocalService;
	}

	public void setWrappedService(
		TimesheetTaskLocalService timesheetTaskLocalService) {
		_timesheetTaskLocalService = timesheetTaskLocalService;
	}

	private TimesheetTaskLocalService _timesheetTaskLocalService;
}