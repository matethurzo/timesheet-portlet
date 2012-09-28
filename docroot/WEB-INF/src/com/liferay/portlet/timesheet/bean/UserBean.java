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

import com.liferay.portal.model.User;
import com.liferay.portal.service.UserServiceUtil;

import javax.faces.context.FacesContext;

/**
 * @author Mate Thurzo
 */
public class UserBean {

	public User getCurrentUser() {
		if (_currentUser == null) {
			try {
				FacesContext context = FacesContext.getCurrentInstance();

				String userId = context.getExternalContext().getRemoteUser();

				_currentUser = UserServiceUtil.getUserById(
					Long.parseLong(userId));
			}
			catch (Exception e) {
				return null;
			}
		}

		return _currentUser;
	}

	private static User _currentUser;

}