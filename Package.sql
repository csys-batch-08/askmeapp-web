 --Table 1-customerdetails
 --Table 1
 create table cust_detail(cust_id  number generated always as identity(start with 1 increment by 1),
  name varchar2(20),Address varchar2(100),Email_ID varchar2(20),Credit_limit number(10));
  alter table cust_detail add primary key(cust_id);
  --Table 2
  create table emp_detail(emp_id  number generated always as identity(start with 1 increment by 1),
                        first_name varchar2(20),
                        last_name varchar2(20),
                        email varchar2(30),
                        phone_number number(10),
                        hire_Date date,
                        manager_Id varchar2(20),
                        job_title varchar2(20));
--Table 3
create table  prod_detail(product_id number generated always as identity(start with 1 increment by 1) primary key,
                        product_name varchar2(20),
                        description varchar2(100),
                        standard_cost number(10),
                        list_Price number(10),
                        category_id number,foreign key(category_id) REFERENCES prod_category(category_id));
--Table 4
create table ord_detail(order_id number generated always as identity(start with 1 increment by 1)  primary key,
                        cust_id number,
                        status varchar2(20),
                        order_date date,
                        foreign key(cust_id) REFERENCES cust_detail(cust_id));
--Table 5
create table ord_items(item_id number generated always as identity(start with 1 increment by 1)  primary key,
                    order_id number,
                    product_id number,
                    quantity number(10),
                    unit_price number(10),
                    foreign key (order_id) REFERENCES ord_detail(order_id),
                    foreign key (product_id) REFERENCES prod_detail(product_id));
--Table 6
create table prod_category(category_id  number generated always as identity(start with 1 increment by 1) primary key,
                            category_name varchar2(20));
                            

 --PACKAGE
--Specification
--Package creation and procedure and variable declaration
CREATE OR REPLACE PACKAGE SALES AS
--Customer Details
   PROCEDURE addCustomer( 
      c_name cust_detail.name%type, 
      c_address  cust_detail.address%type, 
      c_email cust_detail.email_id%type,
      c_credit   cust_detail.credit_limit%type,
      c_status OUT VARCHAR2,
      c_error OUT VARCHAR2);
--2nd Procedure      
      PROCEDURE delCustomer(c_id  cust_detail.CUST_ID%TYPE,c_status OUT VARCHAR2,
      c_error OUT VARCHAR2);
--EmployeeDetails      
       PROCEDURE addEmployee
      (e_f_name emp_detail.FIRST_NAME%type, 
      e_l_name  emp_detail.LAST_NAME%type, 
      e_email emp_detail.EMAIL%type,
      e_phone_number  emp_detail.PHONE_NUMBER%type,
      e_hire_date  emp_detail.HIRE_DATE%type,
      e_manager_id  emp_detail.MANAGER_ID%type,
      e_job_title  emp_detail.JOB_TITLE%type,
       e_status OUT VARCHAR2,
      e_error OUT VARCHAR2) ;
--2nd Procedure      
      PROCEDURE delEmployee(e_id  employees.EMP_ID%TYPE, e_status OUT VARCHAR2,
      e_error OUT VARCHAR2); 
--Product Details      
       PROCEDURE addProducts
      (p_name  prod_detail.PRODUCT_NAME%type, 
      p_description   prod_detail.DESCRIPTION%type, 
      p_s_cost  prod_detail.STANDARD_COST%type,
      p_l_price  prod_detail.LIST_PRICE%type,
      p_c_id   prod_detail.CATEGORY_ID%type,
       p_status OUT VARCHAR2,
      p_error OUT VARCHAR2);
--2nd Procedure      
      PROCEDURE delProducts(p_id  prod_detail.PRODUCT_ID%TYPE, p_status OUT VARCHAR2,p_error OUT VARCHAR2); 
--Order Details      
   PROCEDURE addOrders
      (o_c_id ord_detail.CUST_ID%type, 
      status  ord_detail.STATUS%type, 
      o_date ord_detail.ORDER_DATE%type,o_status out varchar2,o_error out varchar2);
--2nd Procedure      
      PROCEDURE delOrders(o_id  ord_detail.ORDER_ID%TYPE,o_status out varchar2,o_error out varchar2); 
--3rd Procedure      
      PROCEDURE updateOrders( status  ord_detail.STATUS%type,o_status out varchar2,o_error out varchar2); 
--Oder_items Details      
       PROCEDURE addOrderItems
      (o_id ord_items.ORDER_ID%type, 
      o_p_id  ord_items.PRODUCT_ID%type, 
      o_quantity ord_items.QUANTITY%type,
      o_u_price  ord_items.UNIT_PRICE%type,i_status out varchar2,i_error out varchar2);
--2nd Procedure      
      PROCEDURE delOrderItems(o_id  ord_items.ITEM_ID%TYPE,i_status out varchar2,i_error out varchar2); 
--Prod_category Deatils
   PROCEDURE addProductCat
      (cat_name  prod_category.category_name%type, 
     cat_status out varchar2,cat_error out varchar2);
--2nd Procedure      
      PROCEDURE delProductCat(o_id  prod_category.CATEGORY_ID%TYPE,cat_status out varchar2,cat_error out varchar2);      
 END SALES;
 / 
 
 
 
 
 --Package Body and Procedure definition
CREATE OR REPLACE PACKAGE BODY SALES AS 
--Customer details
PROCEDURE addCustomer
      (c_name cust_detail.name%type, 
      c_address  cust_detail.address%type, 
      c_email cust_detail.email_id%type,
      c_credit   cust_detail.credit_limit%type,
      c_status OUT VARCHAR2,
      c_error OUT VARCHAR2)      
   IS
   BEGIN 
      INSERT INTO cust_detail(NAME,ADDRESS,EMAIL_ID,CREDIT_LIMIT) 
         VALUES(c_name, c_address, c_email, c_credit); 
         IF SQL%ROWCOUNT>0 THEN
         c_status:='ROW INSERTED';
         END IF;
         COMMIT;
 EXCEPTION 
 WHEN OTHERS THEN
     c_status:='NOT INSERTED';
     c_error:=SQLCODE||SQLERRM;  
   END addCustomer;     
  --delete 
   PROCEDURE delCustomer(c_id  cust_detail.CUST_ID%type,c_status OUT VARCHAR2,
      c_error OUT VARCHAR2) IS 
   BEGIN 
      DELETE FROM cust_detail 
      WHERE CUST_ID = c_id;
      IF SQL%FOUND THEN
       c_status:='CUSTOMER ID NOT DELETED';
        END IF;
       COMMIT;
     EXCEPTION 
     WHEN OTHERS THEN
        c_status:='CUSTOMER ID DELETED';
     c_error:=SQLCODE||SQLERRM;  
   END delCustomer;
--Employee -Insert   
   PROCEDURE addEmployee
      (e_f_name emp_detail.FIRST_NAME%type, 
      e_l_name  emp_detail.LAST_NAME%type,
      e_email emp_detail.EMAIL%type,
      e_phone_number  emp_detail.PHONE_NUMBER%type,
      e_hire_date  emp_detail.HIRE_DATE%type,
      e_manager_id  emp_detail.MANAGER_ID%type,
      e_job_title  emp_detail.JOB_TITLE%type,
       e_status OUT VARCHAR2,
      e_error OUT VARCHAR2)
   IS 
   BEGIN 
      INSERT INTO emp_detail(FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,MANAGER_ID,JOB_TITLE) 
         VALUES(e_f_name,e_l_name,e_email,e_phone_number,e_hire_date,e_manager_id,e_job_title); 
   IF SQL%ROWCOUNT>0 THEN
         e_status:='ROW INSERTED';
         END IF;
         COMMIT;
 EXCEPTION 
 WHEN OTHERS THEN
     e_status:='ROW NOT INSERTED';
     e_error:=SQLCODE||SQLERRM; 
   END addEmployee; 
  --delete 
   PROCEDURE delEmployee(e_id   employees.EMP_ID%type, e_status OUT VARCHAR2,e_error OUT VARCHAR2) IS 
   BEGIN 
      DELETE FROM emp_detail
      WHERE EMP_ID = e_id; 
    IF SQL%FOUND THEN
         e_status:='EMPLOYEE ID DELETED';
         END IF;
         COMMIT;
   EXCEPTION 
   WHEN OTHERS THEN
     e_status:='EMPLOYEE ID NOT DELETED';
     e_error:=SQLCODE||SQLERRM;       
   END delEmployee; 
--Products details   
   PROCEDURE addProducts
      (p_name prod_detail.PRODUCT_NAME%type, 
      p_description  prod_detail.DESCRIPTION%type, 
      p_s_cost prod_detail.STANDARD_COST%type,
      p_l_price  prod_detail.LIST_PRICE%type,
      p_c_id  prod_detail.CATEGORY_ID%type, 
      p_status OUT VARCHAR2,
      p_error OUT VARCHAR2)
   IS 
   BEGIN 
      INSERT INTO prod_detail(PRODUCT_NAME,DESCRIPTION,STANDARD_COST,LIST_PRICE,CATEGORY_ID) 
         VALUES(p_name,p_description,p_s_cost,p_l_price,p_c_id); 
          IF SQL%ROWCOUNT>0 THEN
         p_status:='ROW INSERTED';
         END IF;
         COMMIT;
   EXCEPTION 
   WHEN OTHERS THEN
     p_status:='ROW NOT INSERTED';
     p_error:=SQLCODE||SQLERRM;     
   END addProducts; 
  --delete 
   PROCEDURE delProducts(p_id  prod_detail.PRODUCT_ID%type,p_status OUT VARCHAR2,
      p_error OUT VARCHAR2) IS 
   BEGIN 
      DELETE FROM  prod_detail 
      WHERE PRODUCT_ID = p_id; 
      IF SQL%FOUND THEN
         p_status:='PRODUCTS ID DELETED';
         END IF;
         COMMIT;
   EXCEPTION 
   WHEN OTHERS THEN
     p_status:='PRODUCTS ID NOT DELETED';
     p_error:=SQLCODE||SQLERRM;        
   END delProducts;  
--Order Details
   PROCEDURE addOrders
      (o_c_id ord_detail.CUST_ID%type, 
      status  ord_detail.STATUS%type, 
      o_date ord_detail.ORDER_DATE%type,
      o_status out varchar2,o_error out varchar2)
   IS 
   BEGIN 
      INSERT INTO ord_detail(CUST_ID,STATUS,ORDER_DATE) 
         VALUES(o_c_id,status,o_date); 
          IF SQL%ROWCOUNT>0 THEN
         o_status:='ROW INSERTED';
         END IF;
         COMMIT;
   EXCEPTION 
   WHEN OTHERS THEN
     o_status:='ROW NOT INSERTED';
     o_error:=SQLCODE||SQLERRM;     
   END addOrders; 
  --delete 
   PROCEDURE delOrders(o_id  ord_detail.ORDER_ID%type,o_status out varchar2,o_error out varchar2)
   IS 
   BEGIN 
      DELETE FROM ord_detail
      WHERE ORDER_ID = o_id; 
     IF SQL%FOUND THEN
         o_status:='ORDER ID DELETED';
         END IF;
         COMMIT;
   EXCEPTION 
   WHEN OTHERS THEN
     o_status:='OREDER ID NOT DELETED';
     o_error:=SQLCODE||SQLERRM;     
   END delOrders;
--Update   
    PROCEDURE updateOrders( status  ord_detail.STATUS%type,o_status out varchar2,o_error out varchar2)
    IS
     BEGIN 
       UPDATE ord_detail SET STATUS='status' WHERE STATUS='shipping';
     IF SQL%ROWCOUNT>0 THEN
         o_status:='ORDER CANCELLED';
         END IF;
         COMMIT;
   EXCEPTION 
   WHEN OTHERS THEN
     o_status:='OREDER NOT CANCELLED';
     o_error:=SQLCODE||SQLERRM;     
   END updateOrders;  
--Order Items   
    PROCEDURE addOrderItems
      (o_id  ord_items.ORDER_ID%type,  
      o_p_id  ord_items.PRODUCT_ID%type, 
      o_quantity ord_items.QUANTITY%type,
      o_u_price  ord_items.UNIT_PRICE%type,i_status out varchar2,i_error out varchar2)
   IS 
   BEGIN 
      INSERT INTO ord_items(ORDER_ID,PRODUCT_ID,QUANTITY,UNIT_PRICE) 
         VALUES(o_id,o_p_id,o_quantity,o_u_price); 
          IF SQL%ROWCOUNT>0 THEN
         i_status:='ORDER ITEM INSERTED';
         END IF;
         COMMIT;
   EXCEPTION 
   WHEN OTHERS THEN
     i_status:='ORDER ITEM NOT INSERTED';
     i_error:=SQLCODE||SQLERRM;  
  END addOrderItems;
--delete 
   PROCEDURE delOrderItems(o_id  ord_items.ITEM_ID%type,i_status out varchar2,i_error out varchar2) IS 
   BEGIN 
      DELETE FROM ord_items 
      WHERE ITEM_ID = o_id; 
      IF SQL%FOUND THEN
         i_status:='ORDER ITEM DELETED';
         END IF;
         COMMIT;
   EXCEPTION 
   WHEN OTHERS THEN
     i_status:='ORDER ITEM NOT DELETED';
     i_error:=SQLCODE||SQLERRM;     
   END delOrderItems;  
--Product Category Deatils
   PROCEDURE addProductCat
      (cat_name  prod_category.category_name%type, 
     cat_status out varchar2,cat_error out varchar2)
   IS 
   BEGIN 
      INSERT INTO prod_category(CATEGORY_NAME) 
         VALUES(cat_name); 
          IF SQL%ROWCOUNT>0 THEN
         cat_status:='CATEGORY INSERTED';
         END IF;
         COMMIT;
   EXCEPTION 
   WHEN OTHERS THEN
     cat_status:='CATEGORY NOT INSERTED';
     cat_error:=SQLCODE||SQLERRM;  
  END addProductCat;
--delete 
   PROCEDURE delProductCat(o_id  prod_category.CATEGORY_ID%type,cat_status out varchar2,cat_error out varchar2) IS 
   BEGIN 
      DELETE FROM prod_category
      WHERE CATEGORY_ID = o_id; 
      IF SQL%FOUND THEN
         cat_status:='CATEGORY ID DELETED';
         END IF;
         COMMIT;
   EXCEPTION 
   WHEN OTHERS THEN
     cat_status:='CATEGORY ID NOT DELETED';
     cat_error:=SQLCODE||SQLERRM;     
   END delProductCat;  
   
END SALES; 
/

SELECT * FROM CUST_DETAIL;
--Method calling
SET SERVEROUTPUT ON
DECLARE 
--Customer
 id_val customers.CUST_ID%type; 
  c_status varchar2(50);
  c_error varchar2(200);
--Employee  
  id_val employees.EMP_ID%type; 
   e_status varchar2(50);
   e_error varchar2(200);
--Product   
   id_val  prod_detail.PRODUCT_ID%type; 
   p_status varchar2(50);
   p_error varchar2(200);
--Order   
   id_val  ord_detail.ORDER_ID%type; 
   status ord_detail.STATUS%type;
   o_status varchar2(50);
   o_error varchar2(200);
--Order Items   
    id_val ord_items.ITEM_ID%type; 
    i_status varchar2(50);
    i_error varchar2(200);
--Product Category    
    id_val prod_category.CATEGORY_ID%type; 
    cat_status varchar2(50);
    cat_error varchar2(200);
BEGIN 
--Customer
   id_val:='&cust_id';
   SALES.addcustomer('Rani', 'East street', 'Theni', 100000,c_status,c_error); 
   DBMS_OUTPUT.PUT_LINE(c_status||' '||c_error);
   SALES.delcustomer(id_val,c_status,c_error); 
   DBMS_OUTPUT.PUT_LINE(c_status||' '||c_error);
--Employee 
   id_val:='&EMP_ID';
  SALES.addEmployee('sarvesh', 'poorni', 'sar1210@gmail.com',6576457465,'13-07-2014','MD001','DataAnalyst',e_status,e_error);    
   DBMS_OUTPUT.PUT_LINE(e_status||' '||e_error);
   SALES.delEmployee(id_val,e_status,e_error);
   DBMS_OUTPUT.PUT_LINE(e_status||' '||e_error);
--Products
   id_val:=&PRODUCT_ID;
   SALES.addProducts('FaceSerum','MamaearthSkinCorrect Face Serum with Niacinamide and Ginger Extract for Acne Marks and Scars - 15 ml',349,330,1,p_status,p_error);    
  DBMS_OUTPUT.PUT_LINE(p_status||' '||p_error);
  SALES.delProducts(id_val,p_status,p_error); 
  DBMS_OUTPUT.PUT_LINE(p_status||' '||p_error);
--Order Details
   SALES.addOrders(4,'shipping','22-11-2021',o_status,o_error);
   DBMS_OUTPUT.PUT_LINE(o_status||'   '||o_error);
   id_val:=&ORDER_ID;
   SALES.delOrders(id_val,o_status,o_error); 
  DBMS_OUTPUT.PUT_LINE(o_status||'   '||o_error);
   status:='&STATUS';
  SALES.updateOrders(status,o_status,o_error);
  DBMS_OUTPUT.PUT_LINE(o_status||'   '||o_error);
--Order Items 
   id_val:=&ITEM_ID;
   SALES.addOrderItems(1,24,2,2000,i_status,i_error);
   DBMS_OUTPUT.PUT_LINE(i_status||'   '||i_error);
   SALES.delOrderItems(id_val,i_status,i_error); 
   DBMS_OUTPUT.PUT_LINE(i_status||'   '||i_error);
--Product Category
  id_val:=&CATEGORY_ID;
  SALES.addProductCat('Beauty Products',cat_status,cat_error);
  DBMS_OUTPUT.PUT_LINE(cat_status||'   '||cat_error);
  SALES.delProductCat(id_val,cat_status,cat_error);  
  DBMS_OUTPUT.PUT_LINE(cat_status||'   '||cat_error);
  END;
/ 

select * from cust_detail;
desc cust_detail;

select * from emp_detail;
desc emp_detail;

select * from ord_detail;
desc ord_detail;

select * from ord_items;
desc ord_items;
 
SELECT * FROM prod_category;
desc prod_category;


SELECT * FROM CUSTOMERS;

create table tranaction(cust_id   number generated always as identity(start with 1 increment by 1)primary key,
  name varchar2(20),Address varchar2(100),Email_ID varchar2(20),Credit_limit number(10));
  


--Trigger--
set serveroutput on
CREATE OR REPLACE TRIGGER credit
BEFORE UPDATE ON CUSTOMERS
FOR EACH ROW
BEGIN
 INSERT INTO TRANSACTION( name,Address,Email_ID ,Credit_limit )values(:new.name,:new.address,:new.Email_ID,:new.Credit_limit+:old:Credit_limit); 
END;
/
select * from customers;
desc customers;
commit;
update customers set credit_limit='15000' where cust_id='Cust03';
insert into customers(cust_id,name,address,email_id,credit_limit) values('Cust07','Rani','Madurai','rai01@gmail.com',32000);


--Trigger 1---
SET SERVEROUTPUT ON
CREATE OR REPLACE TRIGGER CUST
BEFORE UPDATE ON CUSTOMER
BEGIN
DBMS_OUTPUT.PUT_LINE('RECORD UPDATED');
END;
/
UPDATE CUSTOMERS SET CREDIT_LIMIT=CREDIT_LIMIT+500 WHERE CUST_ID='Cust04';
