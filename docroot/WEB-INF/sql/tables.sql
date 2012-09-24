create table TS_TimesheetTask (
	taskId LONG not null primary key,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	assetCategoryId LONG,
	assetTagId LONG,
	name VARCHAR(75) null
);

create table TS_TimesheetTaskSegment (
	segmentId LONG not null primary key,
	taskId LONG,
	startDate DATE null,
	endDate DATE null
);