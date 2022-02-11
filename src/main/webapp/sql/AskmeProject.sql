create table user_detail(user_id number generated always as identity(start with 1 increment by 1),
                        user_name varchar2(20) not null,
                        email varchar2(20)not null,
                        password varchar2(10)not null,
                        role varchar2(10) default 'user',
                        subscriber varchar2(5) default 'no',
                        constraint pk_user_id primary key(user_id));

 desc user_detail;                       
 select * from user_detail;                      
commit;

create table category_detail(category_id number generated always as identity(start with 1 increment by 1),
                            category_name varchar2(20)unique,
                            status varchar2(10) default 'active' not null,
                            description varchar2(200),
                            constraint pk_category_id primary key(category_id));

select * from category_detail;

 desc category_detail;    
 commit;

create table section_details(section_id number generated always as identity(start with 200 increment by 1),
                             section_name varchar2(100) unique,
                             category_id number,
                             rating number(10) default 0,
                             status VARCHAR2(10) default 'active' not null,
                             rating_count number(10) default 1 not null,
                             description varchar2(200),
                             constraint pk_section_id primary key(section_id),
                             constraint fk_category_id foreign key(category_id) references category_detail(category_id));

 select * from section_details;  

 
create table question_details(question_id  number generated always as identity(start with 300 increment by 1),
                              question_description varchar2(200) not null,
                              section_id number,
                              status VARCHAR2(10) default 'active' not null,
                              constraint pk_question_id primary key(question_id),
                             constraint fk_section foreign key(section_id) references section_details(section_id));
 desc question_details;                            
select * from question_details;           
alter table question_details add status VARCHAR2(10) default 'active' not null; 
create table ask_me_questions(ask_id   number generated always as identity(start with 500 increment by 1),
                   user_id number,
                   category_id number,
                   section_id number,
                   question_id number,
                   constraint pk_ask primary key (ask_id),
                   constraint fk_user_id foreign key(user_id) references user_detail(user_id),
                   constraint fk_category foreign key(category_id) references category_detail(category_id),
                   constraint fk_sect foreign key(section_id) references section_details(section_id),
                   constraint fk_question_id foreign key(question_id) references question_details(question_id) );
desc ask_me_questions;   
select * from ask_me_questions;

create table comment_by_user(comment_id  number generated always as identity(start with 400 increment by 1),
                     user_id number,
                     category_id number,
                     section_id number,
                     comments varchar2(200) not null,
                     constraint pk_comment primary key(comment_id),
                     constraint fk_user foreign key(user_id) references user_detail(user_id),
                     constraint fk_cat foreign key(category_id) references category_detail(category_id),
                     constraint fk_sec foreign key(section_id) references section_details(section_id));
desc comment_by_user;   
select * from comment_by_user;
delete from comment_by_user;
commit;                  

create table answer(answers varchar(1000) not null,question_id number,
status VARCHAR2(10) default 'active' not null,
constraint fk_ques foreign key(question_id) references question_details(question_id) );
select * from user_detail;
create table subscribe_user(user_id number,
                            section_name varchar2(100),
                            CONSTRAINT  user_fk foreign key(user_id) references user_detail(user_id));
select * from  subscribe_user;  

select * from answer;
select * from question_details;
select * from category_detail;
select * from section_details;
