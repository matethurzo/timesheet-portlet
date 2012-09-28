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

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portlet.timesheet.model.TimesheetTask;
import com.liferay.portlet.timesheet.model.impl.TimesheetTaskImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author Mate Thurzo
 */
public class TimesheetTaskFinderImpl extends BasePersistenceImpl<TimesheetTask>
	implements TimesheetTaskFinder {

	public static final String FIND_BY_C_U =
		TimesheetTaskFinder.class.getName() + ".findByC_U";

	public List<Object[]> findByC_U(Date currentDate, long userId)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_C_U);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar("taskId", Type.LONG);
			q.addScalar("segmentId", Type.STRING);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);
			qPos.add(currentDate);
			qPos.add(currentDate);

			Iterator<Object[]> itr = q.iterate();

			List<Object[]> resultList = new ArrayList<Object[]>();

			while (itr.hasNext()) {
				resultList.add(itr.next());
			}

			return resultList;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

}