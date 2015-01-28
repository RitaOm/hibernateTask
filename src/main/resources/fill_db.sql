insert into RITA_OM.COUNTRY (ID, NAME) 
select RITA_OM.COUNTRIES_SEQ.nextval, 
'COUNTRY' || to_char(rownum) 
from dual 
connect by level <= 10000;

insert into RITA_OM.CITY (ID, COUNTRY_ID, NAME)
select 
  RITA_OM.CITIES_SEQ.nextval, 
  round(dbms_random.value(1, 10000)),
  'CITY' || to_char(rownum)
from dual
connect by level <= 10000;

insert into RITA_OM.ADDRESS (ID, CITY_ID, NAME)
select 	
  RITA_OM.ADDRESSES_SEQ.nextval, 
  round(dbms_random.value(1, 10000)),
  'ADDRESS' || to_char(rownum)
from dual
connect by level <= 10000;

insert into RITA_OM.EMPLOYEE (ID, ADDRESS_ID , FIRST_NAME, LAST_NAME)
select 
  RITA_OM.EMPLOYEES_SEQ.nextval,
   round(dbms_random.value(1, 10000)),
  'FIRST_NAME' || to_char(rownum),
  'LAST_NAME' || to_char(rownum)
from dual
connect by level <= 10000;

insert into RITA_OM.COMPANY (ID, NAME)
select 
  RITA_OM.COMPANY_SEQ.nextval,
  'COMPANY' || to_char(rownum)
from dual
connect by level <= 10000;

insert into RITA_OM.OFFICE (ID, COMPANY_ID, ADDRESS_ID)
select 
  RITA_OM.OFFICE_SEQ.nextval,
  round(dbms_random.value(1, 10000)),
  round(dbms_random.value(1, 10000))
from dual
connect by level <= 10000;

insert into RITA_OM.POSITION (ID, NAME)
select 
  RITA_OM.POSITION_SEQ.nextval,
  'POSITION' || to_char(rownum)
from dual
connect by level <= 10000;

insert into RITA_OM.WORKPLACE (ID, EMPLOYEE_ID, OFFICE_ID, POSITION_ID)
select 
 RITA_OM.WORKPLACE_SEQ.nextval,
  round(dbms_random.value(1, 10000)),
  round(dbms_random.value(1, 10000)),
  round(dbms_random.value(1, 10000))
from dual
connect by level <= 10000;
