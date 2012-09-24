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
 * This class is a wrapper for {@link TimesheetTask}.
 * </p>
 *
 * @author    Mate Thurzo
 * @see       TimesheetTask
 * @generated
 */
public class TimesheetTaskWrapper implements TimesheetTask,
	ModelWrapper<TimesheetTask> {
	public TimesheetTaskWrapper(TimesheetTask timesheetTask) {
		_timesheetTask = timesheetTask;
	}

	public Class<?> getModelClass() {
		return TimesheetTask.class;
	}

	public String getModelClassName() {
		return TimesheetTask.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("taskId", getTaskId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("assetCategoryId", getAssetCategoryId());
		attributes.put("assetTagId", getAssetTagId());
		attributes.put("name", getName());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long assetCategoryId = (Long)attributes.get("assetCategoryId");

		if (assetCategoryId != null) {
			setAssetCategoryId(assetCategoryId);
		}

		Long assetTagId = (Long)attributes.get("assetTagId");

		if (assetTagId != null) {
			setAssetTagId(assetTagId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	* Returns the primary key of this timesheet task.
	*
	* @return the primary key of this timesheet task
	*/
	public long getPrimaryKey() {
		return _timesheetTask.getPrimaryKey();
	}

	/**
	* Sets the primary key of this timesheet task.
	*
	* @param primaryKey the primary key of this timesheet task
	*/
	public void setPrimaryKey(long primaryKey) {
		_timesheetTask.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the task ID of this timesheet task.
	*
	* @return the task ID of this timesheet task
	*/
	public long getTaskId() {
		return _timesheetTask.getTaskId();
	}

	/**
	* Sets the task ID of this timesheet task.
	*
	* @param taskId the task ID of this timesheet task
	*/
	public void setTaskId(long taskId) {
		_timesheetTask.setTaskId(taskId);
	}

	/**
	* Returns the user ID of this timesheet task.
	*
	* @return the user ID of this timesheet task
	*/
	public long getUserId() {
		return _timesheetTask.getUserId();
	}

	/**
	* Sets the user ID of this timesheet task.
	*
	* @param userId the user ID of this timesheet task
	*/
	public void setUserId(long userId) {
		_timesheetTask.setUserId(userId);
	}

	/**
	* Returns the user uuid of this timesheet task.
	*
	* @return the user uuid of this timesheet task
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timesheetTask.getUserUuid();
	}

	/**
	* Sets the user uuid of this timesheet task.
	*
	* @param userUuid the user uuid of this timesheet task
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_timesheetTask.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this timesheet task.
	*
	* @return the user name of this timesheet task
	*/
	public java.lang.String getUserName() {
		return _timesheetTask.getUserName();
	}

	/**
	* Sets the user name of this timesheet task.
	*
	* @param userName the user name of this timesheet task
	*/
	public void setUserName(java.lang.String userName) {
		_timesheetTask.setUserName(userName);
	}

	/**
	* Returns the create date of this timesheet task.
	*
	* @return the create date of this timesheet task
	*/
	public java.util.Date getCreateDate() {
		return _timesheetTask.getCreateDate();
	}

	/**
	* Sets the create date of this timesheet task.
	*
	* @param createDate the create date of this timesheet task
	*/
	public void setCreateDate(java.util.Date createDate) {
		_timesheetTask.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this timesheet task.
	*
	* @return the modified date of this timesheet task
	*/
	public java.util.Date getModifiedDate() {
		return _timesheetTask.getModifiedDate();
	}

	/**
	* Sets the modified date of this timesheet task.
	*
	* @param modifiedDate the modified date of this timesheet task
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_timesheetTask.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the asset category ID of this timesheet task.
	*
	* @return the asset category ID of this timesheet task
	*/
	public long getAssetCategoryId() {
		return _timesheetTask.getAssetCategoryId();
	}

	/**
	* Sets the asset category ID of this timesheet task.
	*
	* @param assetCategoryId the asset category ID of this timesheet task
	*/
	public void setAssetCategoryId(long assetCategoryId) {
		_timesheetTask.setAssetCategoryId(assetCategoryId);
	}

	/**
	* Returns the asset tag ID of this timesheet task.
	*
	* @return the asset tag ID of this timesheet task
	*/
	public long getAssetTagId() {
		return _timesheetTask.getAssetTagId();
	}

	/**
	* Sets the asset tag ID of this timesheet task.
	*
	* @param assetTagId the asset tag ID of this timesheet task
	*/
	public void setAssetTagId(long assetTagId) {
		_timesheetTask.setAssetTagId(assetTagId);
	}

	/**
	* Returns the name of this timesheet task.
	*
	* @return the name of this timesheet task
	*/
	public java.lang.String getName() {
		return _timesheetTask.getName();
	}

	/**
	* Sets the name of this timesheet task.
	*
	* @param name the name of this timesheet task
	*/
	public void setName(java.lang.String name) {
		_timesheetTask.setName(name);
	}

	public boolean isNew() {
		return _timesheetTask.isNew();
	}

	public void setNew(boolean n) {
		_timesheetTask.setNew(n);
	}

	public boolean isCachedModel() {
		return _timesheetTask.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_timesheetTask.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _timesheetTask.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _timesheetTask.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_timesheetTask.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _timesheetTask.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_timesheetTask.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TimesheetTaskWrapper((TimesheetTask)_timesheetTask.clone());
	}

	public int compareTo(TimesheetTask timesheetTask) {
		return _timesheetTask.compareTo(timesheetTask);
	}

	@Override
	public int hashCode() {
		return _timesheetTask.hashCode();
	}

	public com.liferay.portal.model.CacheModel<TimesheetTask> toCacheModel() {
		return _timesheetTask.toCacheModel();
	}

	public TimesheetTask toEscapedModel() {
		return new TimesheetTaskWrapper(_timesheetTask.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _timesheetTask.toString();
	}

	public java.lang.String toXmlString() {
		return _timesheetTask.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_timesheetTask.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public TimesheetTask getWrappedTimesheetTask() {
		return _timesheetTask;
	}

	public TimesheetTask getWrappedModel() {
		return _timesheetTask;
	}

	public void resetOriginalValues() {
		_timesheetTask.resetOriginalValues();
	}

	private TimesheetTask _timesheetTask;
}