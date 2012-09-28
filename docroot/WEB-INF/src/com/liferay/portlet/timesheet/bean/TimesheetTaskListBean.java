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

package com.liferay.portlet.timesheet.bean;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.timesheet.model.TimesheetTask;
import com.liferay.portlet.timesheet.model.TimesheetTaskSegment;
import com.liferay.portlet.timesheet.service.TimesheetTaskLocalServiceUtil;
import com.liferay.portlet.timesheet.service.TimesheetTaskSegmentLocalServiceUtil;
import com.liferay.portlet.timesheet.service.persistence.TimesheetTaskFinderUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mate Thurzo
 */
public class TimesheetTaskListBean {

	public Map<TimesheetTask, List<TimesheetTaskSegment>> getTaskList(
		int day, long userId) {

		Calendar calendar = Calendar.getInstance();

		calendar.set(Calendar.DAY_OF_WEEK, day);

		try {
			List<Object[]> taskListIds = TimesheetTaskFinderUtil.findByC_U(
				calendar.getTime(), userId);

			Map<TimesheetTask, List<TimesheetTaskSegment>> taskListMap =
				new HashMap<TimesheetTask, List<TimesheetTaskSegment>>();

			if (taskListIds.isEmpty()) {
				return taskListMap;
			}

			for (Object[] taskListIdPair : taskListIds) {
				long taskId = (Long)taskListIdPair[0];
				long segmentId = (Long)taskListIdPair[1];

				TimesheetTask task =
					TimesheetTaskLocalServiceUtil.getTimesheetTask(taskId);
				TimesheetTaskSegment taskSegment =
					TimesheetTaskSegmentLocalServiceUtil.
						getTimesheetTaskSegment(segmentId);

				List<TimesheetTaskSegment> segmentList = null;

				if (taskListMap.containsKey(task)) {
					segmentList = taskListMap.get(task);
				}
				else {
					segmentList = new ArrayList<TimesheetTaskSegment>();
				}

				segmentList.add(taskSegment);
			}

			return taskListMap;
		}
		catch (Exception se) {
			return null;
		}
	}

}