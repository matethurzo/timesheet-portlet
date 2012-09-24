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
 * This class is a wrapper for {@link TimesheetTaskSegmentService}.
 * </p>
 *
 * @author    Mate Thurzo
 * @see       TimesheetTaskSegmentService
 * @generated
 */
public class TimesheetTaskSegmentServiceWrapper
	implements TimesheetTaskSegmentService,
		ServiceWrapper<TimesheetTaskSegmentService> {
	public TimesheetTaskSegmentServiceWrapper(
		TimesheetTaskSegmentService timesheetTaskSegmentService) {
		_timesheetTaskSegmentService = timesheetTaskSegmentService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _timesheetTaskSegmentService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_timesheetTaskSegmentService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _timesheetTaskSegmentService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TimesheetTaskSegmentService getWrappedTimesheetTaskSegmentService() {
		return _timesheetTaskSegmentService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTimesheetTaskSegmentService(
		TimesheetTaskSegmentService timesheetTaskSegmentService) {
		_timesheetTaskSegmentService = timesheetTaskSegmentService;
	}

	public TimesheetTaskSegmentService getWrappedService() {
		return _timesheetTaskSegmentService;
	}

	public void setWrappedService(
		TimesheetTaskSegmentService timesheetTaskSegmentService) {
		_timesheetTaskSegmentService = timesheetTaskSegmentService;
	}

	private TimesheetTaskSegmentService _timesheetTaskSegmentService;
}