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
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Mate Thurzo
 */
public class TimesheetTaskFinderUtil {
	public static java.util.List<java.lang.Object[]> findByC_U(
		java.util.Date currentDate, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByC_U(currentDate, userId);
	}

	public static TimesheetTaskFinder getFinder() {
		if (_finder == null) {
			_finder = (TimesheetTaskFinder)PortletBeanLocatorUtil.locate(com.liferay.portlet.timesheet.service.ClpSerializer.getServletContextName(),
					TimesheetTaskFinder.class.getName());

			ReferenceRegistry.registerReference(TimesheetTaskFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(TimesheetTaskFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(TimesheetTaskFinderUtil.class,
			"_finder");
	}

	private static TimesheetTaskFinder _finder;
}