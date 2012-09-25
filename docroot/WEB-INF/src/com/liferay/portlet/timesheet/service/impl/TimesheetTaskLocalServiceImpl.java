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

package com.liferay.portlet.timesheet.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.timesheet.model.TimesheetTask;
import com.liferay.portlet.timesheet.service.base.TimesheetTaskLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the timesheet task local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.portlet.timesheet.service.TimesheetTaskLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mate Thurzo
 * @see com.liferay.portlet.timesheet.service.base.TimesheetTaskLocalServiceBaseImpl
 * @see com.liferay.portlet.timesheet.service.TimesheetTaskLocalServiceUtil
 */
public class TimesheetTaskLocalServiceImpl
	extends TimesheetTaskLocalServiceBaseImpl {
	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.portlet.timesheet.service.TimesheetTaskLocalServiceUtil} to access the timesheet task local service.
	 */

	public TimesheetTask addTask(long userId, String name, String description)
		throws PortalException, SystemException {

		validate(userId, name);

		long taskId = counterLocalService.increment();

		TimesheetTask timesheetTask = timesheetTaskPersistence.create(taskId);

		timesheetTask.setUserId(userId);
		timesheetTask.setName(name);
		timesheetTask.setDescription(description);

		timesheetTaskPersistence.update(timesheetTask, false);

		return timesheetTask;
	}

	public TimesheetTask getTaskByName(String name)
		throws PortalException, SystemException {

		return timesheetTaskPersistence.findByName(name);
	}

	public TimesheetTask updateDuration(long taskId, long duration)
		throws PortalException, SystemException {

		TimesheetTask timesheetTask = timesheetTaskPersistence.findByPrimaryKey(
			taskId);

		long newDuration = duration + timesheetTask.getDuration();

		timesheetTask.setDuration(newDuration);

		timesheetTaskPersistence.update(timesheetTask, false);

		return timesheetTask;
	}

	public List<TimesheetTask> search(Date date, long userId)
		throws PortalException, SystemException {

		return timesheetTaskFinder.findByC_U(date, userId);
	}

	protected void validate(long userId, String name) throws PortalException {
		return;
	}

}