use ejnu;

create table office (
	office_id varchar(64) not null,
    office_password varchar(64) comment "密码",
    primary key(office_id)
);

/*----------------------------------------*/

create table major (
	major_id int not null auto_increment,
    major_name varchar(64) not null comment "专业名",
    primary key(major_id)
);

create table student (
	student_id int not null,
    student_name varchar(64) comment "学生名",
	student_password varchar(64) comment "密码",
    student_icon varchar(64) comment "头像链接",
    major_id int not null,
    key (major_id),
    primary key(student_id)
);

create table classes (
	classes_id int not null auto_increment,
    classes_name varchar(64) not null comment "课程名",
    classes_type tinyint(3) not null comment "必修：0/选修：1",
    major_id int not null,
    key (major_id),
    primary key(classes_id)
);

create table teacher (
	teacher_id int not null,
    teacher_name varchar(64) comment "教师名",
	teacher_icon varchar(64) comment "头像链接",
    teacher_password varchar(64) comment "密码",
    major_id int not null,
    key (major_id),
    primary key(teacher_id)
);

/*specific classes*/
create table speclass (
	speclass_id int not null auto_increment,
    speclass_name varchar(64) not null comment "具体课程名",
	speclass_time int comment "6位，aabbcc,表示三次课程的节次，00表示无",
    speclass_loc varchar(64) comment "地点",
    speclass_sidl int comment "需要上这门课程学生学号范围，左区间",
    speclass_sidr int comment "同上，右区间",
    teacher_id int not null,
    classes_id int not null,
    key (teacher_id),
    key (classes_id),
    primary key(speclass_id)
);

create table homework(
	homework_id int not null auto_increment,
    homework_time varchar(64) comment "作业时间",
    homework_info varchar(128) comment "详细内容",
    speclass_id int not null,
    key (speclass_id),
    primary key(homework_id)
);

/*---------------------no relationship entities------------------------*/

create table book (
	book_id int not null auto_increment,
    book_name varchar(64) comment "书名",
	book_info varchar(64) comment "详细信息",
    book_icon varchar(64) comment "封面链接",
    primary key(book_id)
);
create table exam (
	exam_id int not null auto_increment,
    exam_name varchar(64) not null comment "考试名",
    exam_info varchar(64) comment "详细信息",
    exam_time varchar(64) comment "考试时间yyyy-mm-dd",
    primary key(exam_id)
);

create table contest (
	contest_id int not null auto_increment,
    contest_name varchar(64) not null comment "竞赛名",
    contest_info varchar(64) comment "详细信息",
    contest_time varchar(64) comment "竞赛时间yyyy-mm-dd",
    primary key(contest_id)
);