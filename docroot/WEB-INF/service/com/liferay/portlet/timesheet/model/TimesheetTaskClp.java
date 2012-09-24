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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.timesheet.service.TimesheetTaskLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mate Thurzo
 */
public class TimesheetTaskClp extends BaseModelImpl<TimesheetTask>
	implements TimesheetTask {
	public TimesheetTaskClp() {
	}

	public Class<?> getModelClass() {
		return TimesheetTask.class;
	}

	public String getModelClassName() {
		return TimesheetTask.class.getName();
	}

	public long getPrimaryKey() {
		return _taskId;
	}

	public void setPrimaryKey(long primaryKey) {
		setTaskId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_taskId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public long getTaskId() {
		return _taskId;
	}

	public void setTaskId(long taskId) {
		_taskId = taskId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getAssetCategoryId() {
		return _assetCategoryId;
	}

	public void setAssetCategoryId(long assetCategoryId) {
		_assetCategoryId = assetCategoryId;
	}

	public long getAssetTagId() {
		return _assetTagId;
	}

	public void setAssetTagId(long assetTagId) {
		_assetTagId = assetTagId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public BaseModel<?> getTimesheetTaskRemoteModel() {
		return _timesheetTaskRemoteModel;
	}

	public void setTimesheetTaskRemoteModel(
		BaseModel<?> timesheetTaskRemoteModel) {
		_timesheetTaskRemoteModel = timesheetTaskRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			TimesheetTaskLocalServiceUtil.addTimesheetTask(this);
		}
		else {
			TimesheetTaskLocalServiceUtil.updateTimesheetTask(this);
		}
	}

	@Override
	public TimesheetTask toEscapedModel() {
		return (TimesheetTask)Proxy.newProxyInstance(TimesheetTask.class.getClassLoader(),
			new Class[] { TimesheetTask.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TimesheetTaskClp clone = new TimesheetTaskClp();

		clone.setTaskId(getTaskId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setAssetCategoryId(getAssetCategoryId());
		clone.setAssetTagId(getAssetTagId());
		clone.setName(getName());

		return clone;
	}

	public int compareTo(TimesheetTask timesheetTask) {
		int value = 0;

		if (getTaskId() < timesheetTask.getTaskId()) {
			value = -1;
		}
		else if (getTaskId() > timesheetTask.getTaskId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		TimesheetTaskClp timesheetTask = null;

		try {
			timesheetTask = (TimesheetTaskClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = timesheetTask.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{taskId=");
		sb.append(getTaskId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", assetCategoryId=");
		sb.append(getAssetCategoryId());
		sb.append(", assetTagId=");
		sb.append(getAssetTagId());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portlet.timesheet.model.TimesheetTask");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>taskId</column-name><column-value><![CDATA[");
		sb.append(getTaskId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assetCategoryId</column-name><column-value><![CDATA[");
		sb.append(getAssetCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assetTagId</column-name><column-value><![CDATA[");
		sb.append(getAssetTagId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _taskId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _assetCategoryId;
	private long _assetTagId;
	private String _name;
	private BaseModel<?> _timesheetTaskRemoteModel;
}