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

package com.liferay.portlet.timesheet.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.timesheet.InvalidTimesheetCommandException;
import com.liferay.portlet.timesheet.command.TimesheetCommand;
import com.liferay.portlet.timesheet.command.TimesheetCommandImpl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Daniel Kocsis
 */
public class TimesheetUtil {
	public static TimesheetCommand getCommand(String inputString)
		throws PortalException {

		if (Validator.isNull(inputString)) {
			return null;
		}

		Map<String, String> commandsMap = null;

		commandsMap = tokenize(inputString);

		validate(commandsMap);

		TimesheetCommand command = new TimesheetCommandImpl();

		command.setTitle(commandsMap.get(TimesheetCommand.TOKEN_TITLE));

		Date startDate = getDateValue(
			commandsMap.get(TimesheetCommand.TOKEN_START_TIME), new Date());

		command.setStartDate(startDate);

		Date endDate = getDateValue(
			commandsMap.get(TimesheetCommand.TOKEN_END_TIME), null);

		command.setEndDate(endDate);

		String tags[] = getTags(commandsMap.get(TimesheetCommand.TOKEN_TAGS));

		command.setTags(tags);

		return command;
	}

	protected static Date getDateValue(String stringValue, Date defaultValue) {
		Date resultDate = defaultValue;

		if (Validator.isNotNull(stringValue)) {
			Calendar cal = Calendar.getInstance();

			int timeValue = Integer.valueOf(stringValue);
			cal.set(Calendar.HOUR, (timeValue / 100));
			cal.set(Calendar.MINUTE, timeValue % 100);

			resultDate = cal.getTime();
		}

		return resultDate;
	}

	protected static String[] getTags(String tags) {
		if (Validator.isNull(tags)) {
			return null;
		}

		return StringUtil.trim(tags).split("\\s");
	}

	protected static boolean isValidCommandToken(String token) {
		if (Validator.isNull(token)) {
			return false;
		}

		if (token.equals(TimesheetCommand.TOKEN_END_TIME) ||
			token.equals(TimesheetCommand.TOKEN_START_TIME) ||
			token.equals(TimesheetCommand.TOKEN_TAGS) ||
			token.equals(TimesheetCommand.TOKEN_TITLE)) {

			return true;
		}

		return false;
	}

	protected static Map<String, String> tokenize(String inputString) {
		Pattern re = Pattern.compile(_COMMAND_REGEX, Pattern.CASE_INSENSITIVE);

		Matcher m = re.matcher(inputString);

		Map<String, String> result = new HashMap<String, String>();

		while (m.find()) {
			String _TOKEN = m.group(1);

			if (Validator.isNull(_TOKEN)) {
				_TOKEN = m.group(3);
			}

			String value = m.group(2);

			if (Validator.isNull(value)) {
				value = m.group(4);
			}

			result.put(_TOKEN, value);
		}

		if (result.isEmpty()) {
			result.put(TimesheetCommand.TOKEN_TITLE, inputString);
		}

		return result;
	}

	protected static void validate(Map<String, String> command)
		throws PortalException {

		if (command.size() > 4) {
			throw new InvalidTimesheetCommandException("Too long command!");
		}

		if (!command.containsKey(TimesheetCommand.TOKEN_TITLE)) {
			throw new InvalidTimesheetCommandException("Empty command!");
		}

		for (String commandKey : command.keySet()) {
			if (!isValidCommandToken(commandKey)) {
				throw new InvalidTimesheetCommandException(
					"Not valid token in the command!");
			}

			if (commandKey.equals(TimesheetCommand.TOKEN_END_TIME) ||
				commandKey.equals(TimesheetCommand.TOKEN_START_TIME)) {

				int timeValue = Integer.valueOf(command.get(commandKey));

				if ((timeValue < 0) || (timeValue > 2359)) {
					throw new InvalidTimesheetCommandException("Invalid time!");
				}
			}
		}
	}

	private static final String _COMMAND_REGEX =
		"([setx]):(.+?)(?=\\s*[setx]:)|([setx]):(.+?)(?!\\s*[setx]:)$";

	private static Log _log = LogFactoryUtil.getLog(TimesheetUtil.class);

}