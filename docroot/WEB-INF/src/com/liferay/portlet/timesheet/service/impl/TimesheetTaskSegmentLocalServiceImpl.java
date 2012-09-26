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
import com.liferay.portlet.timesheet.InvalidTaskSegmentDateException;
import com.liferay.portlet.timesheet.NoSuchTimesheetTaskException;
import com.liferay.portlet.timesheet.model.TimesheetTask;
import com.liferay.portlet.timesheet.model.TimesheetTaskSegment;
import com.liferay.portlet.timesheet.service.base.TimesheetTaskSegmentLocalServiceBaseImpl;

import java.util.Date;

/**
 * The implementation of the timesheet task segment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.portlet.timesheet.service.TimesheetTaskSegmentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mate Thurzo
 * @see com.liferay.portlet.timesheet.service.base.TimesheetTaskSegmentLocalServiceBaseImpl
 * @see com.liferay.portlet.timesheet.service.TimesheetTaskSegmentLocalServiceUtil
 */
public class TimesheetTaskSegmentLocalServiceImpl
	extends TimesheetTaskSegmentLocalServiceBaseImpl {
	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.portlet.timesheet.service.TimesheetTaskSegmentLocalServiceUtil} to access the timesheet task segment local service.
	 */

	public TimesheetTaskSegment addTaskSegment(
			long taskId, Date startDate, Date endDate)
		throws PortalException, SystemException {

		validate(taskId, startDate, endDate);

		long taskSegmentId = counterLocalService.increment();

		TimesheetTaskSegment taskSegment =
			timesheetTaskSegmentPersistence.create(taskSegmentId);

		taskSegment.setTaskId(taskId);
		taskSegment.setStartDate(startDate);
		taskSegment.setEndDate(endDate);

		timesheetTaskSegmentPersistence.update(taskSegment, false);

		return taskSegment;
	}

	public TimesheetTaskSegment updateEndDate(long segmentId, Date endDate)
		throws PortalException, SystemException {

		TimesheetTaskSegment taskSegment =
			timesheetTaskSegmentPersistence.findByPrimaryKey(segmentId);

		taskSegment.setEndDate(endDate);

		long segmentDuration =
			endDate.getTime() - taskSegment.getStartDate().getTime();

		taskSegment.setDuration(segmentDuration);

		timesheetTaskSegmentPersistence.update(taskSegment, false);

		timesheetTaskLocalService.updateDuration(
			taskSegment.getTaskId(), segmentDuration);

		return taskSegment;
	}

	protected void validate(long taskId, Date startDate, Date endDate)
		throws PortalException, SystemException {

		TimesheetTask timesheetTask =
			timesheetTaskLocalService.fetchTimesheetTask(taskId);

		if (timesheetTask == null) {
			throw new NoSuchTimesheetTaskException();
		}

		if ((startDate == null) || ((endDate != null) && (startDate == null))) {
			throw new InvalidTaskSegmentDateException();
		}

		if ((startDate != null) && (endDate != null) &&
			!startDate.before(endDate)) {

			throw new InvalidTaskSegmentDateException();
		}
	}

}