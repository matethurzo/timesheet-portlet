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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.timesheet.NoSuchTimesheetTaskSegmentException;
import com.liferay.portlet.timesheet.model.TimesheetTaskSegment;
import com.liferay.portlet.timesheet.model.impl.TimesheetTaskSegmentImpl;
import com.liferay.portlet.timesheet.model.impl.TimesheetTaskSegmentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the timesheet task segment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mate Thurzo
 * @see TimesheetTaskSegmentPersistence
 * @see TimesheetTaskSegmentUtil
 * @generated
 */
public class TimesheetTaskSegmentPersistenceImpl extends BasePersistenceImpl<TimesheetTaskSegment>
	implements TimesheetTaskSegmentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TimesheetTaskSegmentUtil} to access the timesheet task segment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TimesheetTaskSegmentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TimesheetTaskSegmentModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetTaskSegmentModelImpl.FINDER_CACHE_ENABLED,
			TimesheetTaskSegmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TimesheetTaskSegmentModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetTaskSegmentModelImpl.FINDER_CACHE_ENABLED,
			TimesheetTaskSegmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TimesheetTaskSegmentModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetTaskSegmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the timesheet task segment in the entity cache if it is enabled.
	 *
	 * @param timesheetTaskSegment the timesheet task segment
	 */
	public void cacheResult(TimesheetTaskSegment timesheetTaskSegment) {
		EntityCacheUtil.putResult(TimesheetTaskSegmentModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetTaskSegmentImpl.class,
			timesheetTaskSegment.getPrimaryKey(), timesheetTaskSegment);

		timesheetTaskSegment.resetOriginalValues();
	}

	/**
	 * Caches the timesheet task segments in the entity cache if it is enabled.
	 *
	 * @param timesheetTaskSegments the timesheet task segments
	 */
	public void cacheResult(List<TimesheetTaskSegment> timesheetTaskSegments) {
		for (TimesheetTaskSegment timesheetTaskSegment : timesheetTaskSegments) {
			if (EntityCacheUtil.getResult(
						TimesheetTaskSegmentModelImpl.ENTITY_CACHE_ENABLED,
						TimesheetTaskSegmentImpl.class,
						timesheetTaskSegment.getPrimaryKey()) == null) {
				cacheResult(timesheetTaskSegment);
			}
			else {
				timesheetTaskSegment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all timesheet task segments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TimesheetTaskSegmentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TimesheetTaskSegmentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the timesheet task segment.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TimesheetTaskSegment timesheetTaskSegment) {
		EntityCacheUtil.removeResult(TimesheetTaskSegmentModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetTaskSegmentImpl.class, timesheetTaskSegment.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TimesheetTaskSegment> timesheetTaskSegments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TimesheetTaskSegment timesheetTaskSegment : timesheetTaskSegments) {
			EntityCacheUtil.removeResult(TimesheetTaskSegmentModelImpl.ENTITY_CACHE_ENABLED,
				TimesheetTaskSegmentImpl.class,
				timesheetTaskSegment.getPrimaryKey());
		}
	}

	/**
	 * Creates a new timesheet task segment with the primary key. Does not add the timesheet task segment to the database.
	 *
	 * @param segmentId the primary key for the new timesheet task segment
	 * @return the new timesheet task segment
	 */
	public TimesheetTaskSegment create(long segmentId) {
		TimesheetTaskSegment timesheetTaskSegment = new TimesheetTaskSegmentImpl();

		timesheetTaskSegment.setNew(true);
		timesheetTaskSegment.setPrimaryKey(segmentId);

		return timesheetTaskSegment;
	}

	/**
	 * Removes the timesheet task segment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param segmentId the primary key of the timesheet task segment
	 * @return the timesheet task segment that was removed
	 * @throws com.liferay.portlet.timesheet.NoSuchTimesheetTaskSegmentException if a timesheet task segment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TimesheetTaskSegment remove(long segmentId)
		throws NoSuchTimesheetTaskSegmentException, SystemException {
		return remove(Long.valueOf(segmentId));
	}

	/**
	 * Removes the timesheet task segment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the timesheet task segment
	 * @return the timesheet task segment that was removed
	 * @throws com.liferay.portlet.timesheet.NoSuchTimesheetTaskSegmentException if a timesheet task segment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimesheetTaskSegment remove(Serializable primaryKey)
		throws NoSuchTimesheetTaskSegmentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TimesheetTaskSegment timesheetTaskSegment = (TimesheetTaskSegment)session.get(TimesheetTaskSegmentImpl.class,
					primaryKey);

			if (timesheetTaskSegment == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTimesheetTaskSegmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(timesheetTaskSegment);
		}
		catch (NoSuchTimesheetTaskSegmentException nsee) {
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
	protected TimesheetTaskSegment removeImpl(
		TimesheetTaskSegment timesheetTaskSegment) throws SystemException {
		timesheetTaskSegment = toUnwrappedModel(timesheetTaskSegment);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, timesheetTaskSegment);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(timesheetTaskSegment);

		return timesheetTaskSegment;
	}

	@Override
	public TimesheetTaskSegment updateImpl(
		com.liferay.portlet.timesheet.model.TimesheetTaskSegment timesheetTaskSegment,
		boolean merge) throws SystemException {
		timesheetTaskSegment = toUnwrappedModel(timesheetTaskSegment);

		boolean isNew = timesheetTaskSegment.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, timesheetTaskSegment, merge);

			timesheetTaskSegment.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(TimesheetTaskSegmentModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetTaskSegmentImpl.class,
			timesheetTaskSegment.getPrimaryKey(), timesheetTaskSegment);

		return timesheetTaskSegment;
	}

	protected TimesheetTaskSegment toUnwrappedModel(
		TimesheetTaskSegment timesheetTaskSegment) {
		if (timesheetTaskSegment instanceof TimesheetTaskSegmentImpl) {
			return timesheetTaskSegment;
		}

		TimesheetTaskSegmentImpl timesheetTaskSegmentImpl = new TimesheetTaskSegmentImpl();

		timesheetTaskSegmentImpl.setNew(timesheetTaskSegment.isNew());
		timesheetTaskSegmentImpl.setPrimaryKey(timesheetTaskSegment.getPrimaryKey());

		timesheetTaskSegmentImpl.setSegmentId(timesheetTaskSegment.getSegmentId());
		timesheetTaskSegmentImpl.setTaskId(timesheetTaskSegment.getTaskId());
		timesheetTaskSegmentImpl.setStartDate(timesheetTaskSegment.getStartDate());
		timesheetTaskSegmentImpl.setEndDate(timesheetTaskSegment.getEndDate());

		return timesheetTaskSegmentImpl;
	}

	/**
	 * Returns the timesheet task segment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the timesheet task segment
	 * @return the timesheet task segment
	 * @throws com.liferay.portal.NoSuchModelException if a timesheet task segment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimesheetTaskSegment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the timesheet task segment with the primary key or throws a {@link com.liferay.portlet.timesheet.NoSuchTimesheetTaskSegmentException} if it could not be found.
	 *
	 * @param segmentId the primary key of the timesheet task segment
	 * @return the timesheet task segment
	 * @throws com.liferay.portlet.timesheet.NoSuchTimesheetTaskSegmentException if a timesheet task segment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TimesheetTaskSegment findByPrimaryKey(long segmentId)
		throws NoSuchTimesheetTaskSegmentException, SystemException {
		TimesheetTaskSegment timesheetTaskSegment = fetchByPrimaryKey(segmentId);

		if (timesheetTaskSegment == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + segmentId);
			}

			throw new NoSuchTimesheetTaskSegmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				segmentId);
		}

		return timesheetTaskSegment;
	}

	/**
	 * Returns the timesheet task segment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the timesheet task segment
	 * @return the timesheet task segment, or <code>null</code> if a timesheet task segment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimesheetTaskSegment fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the timesheet task segment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param segmentId the primary key of the timesheet task segment
	 * @return the timesheet task segment, or <code>null</code> if a timesheet task segment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TimesheetTaskSegment fetchByPrimaryKey(long segmentId)
		throws SystemException {
		TimesheetTaskSegment timesheetTaskSegment = (TimesheetTaskSegment)EntityCacheUtil.getResult(TimesheetTaskSegmentModelImpl.ENTITY_CACHE_ENABLED,
				TimesheetTaskSegmentImpl.class, segmentId);

		if (timesheetTaskSegment == _nullTimesheetTaskSegment) {
			return null;
		}

		if (timesheetTaskSegment == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				timesheetTaskSegment = (TimesheetTaskSegment)session.get(TimesheetTaskSegmentImpl.class,
						Long.valueOf(segmentId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (timesheetTaskSegment != null) {
					cacheResult(timesheetTaskSegment);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TimesheetTaskSegmentModelImpl.ENTITY_CACHE_ENABLED,
						TimesheetTaskSegmentImpl.class, segmentId,
						_nullTimesheetTaskSegment);
				}

				closeSession(session);
			}
		}

		return timesheetTaskSegment;
	}

	/**
	 * Returns all the timesheet task segments.
	 *
	 * @return the timesheet task segments
	 * @throws SystemException if a system exception occurred
	 */
	public List<TimesheetTaskSegment> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the timesheet task segments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of timesheet task segments
	 * @param end the upper bound of the range of timesheet task segments (not inclusive)
	 * @return the range of timesheet task segments
	 * @throws SystemException if a system exception occurred
	 */
	public List<TimesheetTaskSegment> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the timesheet task segments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of timesheet task segments
	 * @param end the upper bound of the range of timesheet task segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of timesheet task segments
	 * @throws SystemException if a system exception occurred
	 */
	public List<TimesheetTaskSegment> findAll(int start, int end,
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

		List<TimesheetTaskSegment> list = (List<TimesheetTaskSegment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TIMESHEETTASKSEGMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TIMESHEETTASKSEGMENT.concat(TimesheetTaskSegmentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<TimesheetTaskSegment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TimesheetTaskSegment>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the timesheet task segments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (TimesheetTaskSegment timesheetTaskSegment : findAll()) {
			remove(timesheetTaskSegment);
		}
	}

	/**
	 * Returns the number of timesheet task segments.
	 *
	 * @return the number of timesheet task segments
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TIMESHEETTASKSEGMENT);

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
	 * Initializes the timesheet task segment persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.portlet.timesheet.model.TimesheetTaskSegment")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TimesheetTaskSegment>> listenersList = new ArrayList<ModelListener<TimesheetTaskSegment>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TimesheetTaskSegment>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TimesheetTaskSegmentImpl.class.getName());
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
	private static final String _SQL_SELECT_TIMESHEETTASKSEGMENT = "SELECT timesheetTaskSegment FROM TimesheetTaskSegment timesheetTaskSegment";
	private static final String _SQL_COUNT_TIMESHEETTASKSEGMENT = "SELECT COUNT(timesheetTaskSegment) FROM TimesheetTaskSegment timesheetTaskSegment";
	private static final String _ORDER_BY_ENTITY_ALIAS = "timesheetTaskSegment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TimesheetTaskSegment exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TimesheetTaskSegmentPersistenceImpl.class);
	private static TimesheetTaskSegment _nullTimesheetTaskSegment = new TimesheetTaskSegmentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TimesheetTaskSegment> toCacheModel() {
				return _nullTimesheetTaskSegmentCacheModel;
			}
		};

	private static CacheModel<TimesheetTaskSegment> _nullTimesheetTaskSegmentCacheModel =
		new CacheModel<TimesheetTaskSegment>() {
			public TimesheetTaskSegment toEntityModel() {
				return _nullTimesheetTaskSegment;
			}
		};
}