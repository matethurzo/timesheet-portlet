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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.timesheet.NoSuchTimesheetTaskException;
import com.liferay.portlet.timesheet.model.TimesheetTask;
import com.liferay.portlet.timesheet.model.impl.TimesheetTaskImpl;
import com.liferay.portlet.timesheet.model.impl.TimesheetTaskModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the timesheet task service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mate Thurzo
 * @see TimesheetTaskPersistence
 * @see TimesheetTaskUtil
 * @generated
 */
public class TimesheetTaskPersistenceImpl extends BasePersistenceImpl<TimesheetTask>
	implements TimesheetTaskPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TimesheetTaskUtil} to access the timesheet task persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TimesheetTaskImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(TimesheetTaskModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetTaskModelImpl.FINDER_CACHE_ENABLED,
			TimesheetTaskImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] { String.class.getName() },
			TimesheetTaskModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(TimesheetTaskModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TimesheetTaskModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetTaskModelImpl.FINDER_CACHE_ENABLED,
			TimesheetTaskImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TimesheetTaskModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetTaskModelImpl.FINDER_CACHE_ENABLED,
			TimesheetTaskImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TimesheetTaskModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the timesheet task in the entity cache if it is enabled.
	 *
	 * @param timesheetTask the timesheet task
	 */
	public void cacheResult(TimesheetTask timesheetTask) {
		EntityCacheUtil.putResult(TimesheetTaskModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetTaskImpl.class, timesheetTask.getPrimaryKey(),
			timesheetTask);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { timesheetTask.getName() }, timesheetTask);

		timesheetTask.resetOriginalValues();
	}

	/**
	 * Caches the timesheet tasks in the entity cache if it is enabled.
	 *
	 * @param timesheetTasks the timesheet tasks
	 */
	public void cacheResult(List<TimesheetTask> timesheetTasks) {
		for (TimesheetTask timesheetTask : timesheetTasks) {
			if (EntityCacheUtil.getResult(
						TimesheetTaskModelImpl.ENTITY_CACHE_ENABLED,
						TimesheetTaskImpl.class, timesheetTask.getPrimaryKey()) == null) {
				cacheResult(timesheetTask);
			}
			else {
				timesheetTask.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all timesheet tasks.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TimesheetTaskImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TimesheetTaskImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the timesheet task.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TimesheetTask timesheetTask) {
		EntityCacheUtil.removeResult(TimesheetTaskModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetTaskImpl.class, timesheetTask.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(timesheetTask);
	}

	@Override
	public void clearCache(List<TimesheetTask> timesheetTasks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TimesheetTask timesheetTask : timesheetTasks) {
			EntityCacheUtil.removeResult(TimesheetTaskModelImpl.ENTITY_CACHE_ENABLED,
				TimesheetTaskImpl.class, timesheetTask.getPrimaryKey());

			clearUniqueFindersCache(timesheetTask);
		}
	}

	protected void clearUniqueFindersCache(TimesheetTask timesheetTask) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { timesheetTask.getName() });
	}

	/**
	 * Creates a new timesheet task with the primary key. Does not add the timesheet task to the database.
	 *
	 * @param taskId the primary key for the new timesheet task
	 * @return the new timesheet task
	 */
	public TimesheetTask create(long taskId) {
		TimesheetTask timesheetTask = new TimesheetTaskImpl();

		timesheetTask.setNew(true);
		timesheetTask.setPrimaryKey(taskId);

		return timesheetTask;
	}

	/**
	 * Removes the timesheet task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskId the primary key of the timesheet task
	 * @return the timesheet task that was removed
	 * @throws com.liferay.portlet.timesheet.NoSuchTimesheetTaskException if a timesheet task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TimesheetTask remove(long taskId)
		throws NoSuchTimesheetTaskException, SystemException {
		return remove(Long.valueOf(taskId));
	}

	/**
	 * Removes the timesheet task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the timesheet task
	 * @return the timesheet task that was removed
	 * @throws com.liferay.portlet.timesheet.NoSuchTimesheetTaskException if a timesheet task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimesheetTask remove(Serializable primaryKey)
		throws NoSuchTimesheetTaskException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TimesheetTask timesheetTask = (TimesheetTask)session.get(TimesheetTaskImpl.class,
					primaryKey);

			if (timesheetTask == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTimesheetTaskException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(timesheetTask);
		}
		catch (NoSuchTimesheetTaskException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected TimesheetTask removeImpl(TimesheetTask timesheetTask)
		throws SystemException {
		timesheetTask = toUnwrappedModel(timesheetTask);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, timesheetTask);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(timesheetTask);

		return timesheetTask;
	}

	@Override
	public TimesheetTask updateImpl(
		com.liferay.portlet.timesheet.model.TimesheetTask timesheetTask,
		boolean merge) throws SystemException {
		timesheetTask = toUnwrappedModel(timesheetTask);

		boolean isNew = timesheetTask.isNew();

		TimesheetTaskModelImpl timesheetTaskModelImpl = (TimesheetTaskModelImpl)timesheetTask;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, timesheetTask, merge);

			timesheetTask.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TimesheetTaskModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(TimesheetTaskModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetTaskImpl.class, timesheetTask.getPrimaryKey(),
			timesheetTask);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
				new Object[] { timesheetTask.getName() }, timesheetTask);
		}
		else {
			if ((timesheetTaskModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						timesheetTaskModelImpl.getOriginalName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
					new Object[] { timesheetTask.getName() }, timesheetTask);
			}
		}

		return timesheetTask;
	}

	protected TimesheetTask toUnwrappedModel(TimesheetTask timesheetTask) {
		if (timesheetTask instanceof TimesheetTaskImpl) {
			return timesheetTask;
		}

		TimesheetTaskImpl timesheetTaskImpl = new TimesheetTaskImpl();

		timesheetTaskImpl.setNew(timesheetTask.isNew());
		timesheetTaskImpl.setPrimaryKey(timesheetTask.getPrimaryKey());

		timesheetTaskImpl.setTaskId(timesheetTask.getTaskId());
		timesheetTaskImpl.setUserId(timesheetTask.getUserId());
		timesheetTaskImpl.setUserName(timesheetTask.getUserName());
		timesheetTaskImpl.setCreateDate(timesheetTask.getCreateDate());
		timesheetTaskImpl.setModifiedDate(timesheetTask.getModifiedDate());
		timesheetTaskImpl.setName(timesheetTask.getName());
		timesheetTaskImpl.setDescription(timesheetTask.getDescription());
		timesheetTaskImpl.setDuration(timesheetTask.getDuration());

		return timesheetTaskImpl;
	}

	/**
	 * Returns the timesheet task with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the timesheet task
	 * @return the timesheet task
	 * @throws com.liferay.portal.NoSuchModelException if a timesheet task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimesheetTask findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the timesheet task with the primary key or throws a {@link com.liferay.portlet.timesheet.NoSuchTimesheetTaskException} if it could not be found.
	 *
	 * @param taskId the primary key of the timesheet task
	 * @return the timesheet task
	 * @throws com.liferay.portlet.timesheet.NoSuchTimesheetTaskException if a timesheet task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TimesheetTask findByPrimaryKey(long taskId)
		throws NoSuchTimesheetTaskException, SystemException {
		TimesheetTask timesheetTask = fetchByPrimaryKey(taskId);

		if (timesheetTask == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + taskId);
			}

			throw new NoSuchTimesheetTaskException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				taskId);
		}

		return timesheetTask;
	}

	/**
	 * Returns the timesheet task with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the timesheet task
	 * @return the timesheet task, or <code>null</code> if a timesheet task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimesheetTask fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the timesheet task with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskId the primary key of the timesheet task
	 * @return the timesheet task, or <code>null</code> if a timesheet task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TimesheetTask fetchByPrimaryKey(long taskId)
		throws SystemException {
		TimesheetTask timesheetTask = (TimesheetTask)EntityCacheUtil.getResult(TimesheetTaskModelImpl.ENTITY_CACHE_ENABLED,
				TimesheetTaskImpl.class, taskId);

		if (timesheetTask == _nullTimesheetTask) {
			return null;
		}

		if (timesheetTask == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				timesheetTask = (TimesheetTask)session.get(TimesheetTaskImpl.class,
						Long.valueOf(taskId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (timesheetTask != null) {
					cacheResult(timesheetTask);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TimesheetTaskModelImpl.ENTITY_CACHE_ENABLED,
						TimesheetTaskImpl.class, taskId, _nullTimesheetTask);
				}

				closeSession(session);
			}
		}

		return timesheetTask;
	}

	/**
	 * Returns the timesheet task where name = &#63; or throws a {@link com.liferay.portlet.timesheet.NoSuchTimesheetTaskException} if it could not be found.
	 *
	 * @param name the name
	 * @return the matching timesheet task
	 * @throws com.liferay.portlet.timesheet.NoSuchTimesheetTaskException if a matching timesheet task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TimesheetTask findByName(String name)
		throws NoSuchTimesheetTaskException, SystemException {
		TimesheetTask timesheetTask = fetchByName(name);

		if (timesheetTask == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTimesheetTaskException(msg.toString());
		}

		return timesheetTask;
	}

	/**
	 * Returns the timesheet task where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching timesheet task, or <code>null</code> if a matching timesheet task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TimesheetTask fetchByName(String name) throws SystemException {
		return fetchByName(name, true);
	}

	/**
	 * Returns the timesheet task where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching timesheet task, or <code>null</code> if a matching timesheet task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TimesheetTask fetchByName(String name, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs, this);
		}

		if (result instanceof TimesheetTask) {
			TimesheetTask timesheetTask = (TimesheetTask)result;

			if (!Validator.equals(name, timesheetTask.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_TIMESHEETTASK_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAME_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAME_NAME_2);
				}
			}

			query.append(TimesheetTaskModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				List<TimesheetTask> list = q.list();

				result = list;

				TimesheetTask timesheetTask = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs, list);
				}
				else {
					timesheetTask = list.get(0);

					cacheResult(timesheetTask);

					if ((timesheetTask.getName() == null) ||
							!timesheetTask.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
							finderArgs, timesheetTask);
					}
				}

				return timesheetTask;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (TimesheetTask)result;
			}
		}
	}

	/**
	 * Returns all the timesheet tasks.
	 *
	 * @return the timesheet tasks
	 * @throws SystemException if a system exception occurred
	 */
	public List<TimesheetTask> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<TimesheetTask> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the timesheet tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of timesheet tasks
	 * @param end the upper bound of the range of timesheet tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of timesheet tasks
	 * @throws SystemException if a system exception occurred
	 */
	public List<TimesheetTask> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<TimesheetTask> list = (List<TimesheetTask>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TIMESHEETTASK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TIMESHEETTASK.concat(TimesheetTaskModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<TimesheetTask>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TimesheetTask>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes the timesheet task where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the timesheet task that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public TimesheetTask removeByName(String name)
		throws NoSuchTimesheetTaskException, SystemException {
		TimesheetTask timesheetTask = findByName(name);

		return remove(timesheetTask);
	}

	/**
	 * Removes all the timesheet tasks from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (TimesheetTask timesheetTask : findAll()) {
			remove(timesheetTask);
		}
	}

	/**
	 * Returns the number of timesheet tasks where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching timesheet tasks
	 * @throws SystemException if a system exception occurred
	 */
	public int countByName(String name) throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TIMESHEETTASK_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAME_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAME_NAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of timesheet tasks.
	 *
	 * @return the number of timesheet tasks
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TIMESHEETTASK);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the timesheet task persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.portlet.timesheet.model.TimesheetTask")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TimesheetTask>> listenersList = new ArrayList<ModelListener<TimesheetTask>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TimesheetTask>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(TimesheetTaskImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = TimesheetTaskPersistence.class)
	protected TimesheetTaskPersistence timesheetTaskPersistence;
	@BeanReference(type = TimesheetTaskSegmentPersistence.class)
	protected TimesheetTaskSegmentPersistence timesheetTaskSegmentPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_TIMESHEETTASK = "SELECT timesheetTask FROM TimesheetTask timesheetTask";
	private static final String _SQL_SELECT_TIMESHEETTASK_WHERE = "SELECT timesheetTask FROM TimesheetTask timesheetTask WHERE ";
	private static final String _SQL_COUNT_TIMESHEETTASK = "SELECT COUNT(timesheetTask) FROM TimesheetTask timesheetTask";
	private static final String _SQL_COUNT_TIMESHEETTASK_WHERE = "SELECT COUNT(timesheetTask) FROM TimesheetTask timesheetTask WHERE ";
	private static final String _FINDER_COLUMN_NAME_NAME_1 = "timesheetTask.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "timesheetTask.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(timesheetTask.name IS NULL OR timesheetTask.name = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "timesheetTask.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TimesheetTask exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TimesheetTask exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TimesheetTaskPersistenceImpl.class);
	private static TimesheetTask _nullTimesheetTask = new TimesheetTaskImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TimesheetTask> toCacheModel() {
				return _nullTimesheetTaskCacheModel;
			}
		};

	private static CacheModel<TimesheetTask> _nullTimesheetTaskCacheModel = new CacheModel<TimesheetTask>() {
			public TimesheetTask toEntityModel() {
				return _nullTimesheetTask;
			}
		};
}