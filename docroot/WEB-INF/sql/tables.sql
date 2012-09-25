create table TS_TimesheetTask (
	taskId LONG not null primary key,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	duration LONG
);

create table TS_TimesheetTaskSegment (
	segmentId LONG not null primary key,
	taskId LONG,
	startDate DATE null,
	endDate DATE null,
	duration LONG
);