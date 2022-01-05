create table user_detail(user_id number generated always as identity(start with 1 increment by 1),
                        user_name varchar2(20) not null,
                        email varchar2(20)not null,
                        password varchar2(10)not null,
                        role varchar2(10) default 'user',
                        constraint pk_user_id primary key(user_id));
 desc user_detail;                       
 select * from user_detail;                      

create table category_detail(category_id number generated always as identity(start with 1 increment by 1),
                            category_name varchar2(20)unique,
                            constraint pk_category_id primary key(category_id));

select * from category_detail;
delete from category_detail where category_id=24;
 desc category_detail;                           
select * from category_detail;
create table section_detail(section_id number generated always as identity(start with 200 increment by 1),
                             section_name varchar2(100) not null,
                             category_id number,
                             rating number(10) default 0,
                             constraint pk_section_id primary key(section_id),
                             constraint fk_category_id foreign key(category_id) references category_detail(category_id));
 select * from section_details;  
commit;
 desc section_details;
 
create table question_details(question_id  number generated always as identity(start with 300 increment by 1),
                              question_description varchar2(200) not null,
                              section_id number,
                              constraint pk_question_id primary key(question_id),
                             constraint fk_section foreign key(section_id) references section_details(section_id));
 desc question_details;                            
select * from question_details;           
delete from question_details;
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
delete from ask_me_questions;
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
drop table comments_by_users;
delete from comment_by_user;
commit;                  

create table answer(answers varchar(1000) not null,question_id number,
constraint fk_ques foreign key(question_id) references question_details(question_id) );
select * from answer;
 select * from section_details;
 delete from section_details;
 select * from category_detail;

select answers from answer where question_id=362;