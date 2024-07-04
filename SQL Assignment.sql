-- Write specific queries that perform the following operations

-- 1. Display all employee names in ascending order
	select ENAME from emp order by ENAME;
    
-- 2. Display all employee names, salary, commision of employees in dept 10
	select ENAME , SAL , COMM from emp where DEPTNO = 10;

-- 3. Display all employees in deptno 20 and 30
	select * from emp where DEPTNO in (20,30);
    
-- 4. Display all employees who are managers(job title)
	select * from emp where JOB="MANAGER";

-- 5. Display all employees whose salary is between 2000 to 5000
	select * from emp where SAL between 2000 and 5000;
    
-- 6. Display all employees whose commision is NULL
	select * from emp where COMM IS NULL;
    
-- 7. Display employee name, salary, commission in descending order based on salary
	select ENAME, SAL, COMM from emp order by SAL desc;

-- 8. Display average, max, min and sum of salaries of employees
	select avg(SAL) as average ,MAX(SAL) as max,MIN(SAL) as min,sum(SAL) as sum from emp;

-- 9. Display hire date, current date and tenure(in months) of the employees
-- 9.1 in months format
	select HIREDATE, NOW() as PRESENTDAY, concat(timestampdiff(month,HIREDATE,NOW()),' months') as tenure from emp;
-- 9.2 in years months format
	select HIREDATE, NOW() as PRESENTDAY, concat(timestampdiff(year,HIREDATE,NOW()),' years ', timestampdiff(month,HIREDATE,NOW())%12,' months') as tenure from emp;
    
-- 10. Display all employees whose name starts with 'S'.
	select * from emp where ENAME like "S%";
    
-- 11. Display unique deptno from emp table
	select distinct DEPTNO from emp;
    
-- 12. Display employee's job in lower case
	select lower(JOB) from emp;
    
-- 13. Select top 3 salary earning employees(employees can be more than 3)
	select * from emp order by SAL desc limit 3;

-- 14. Select all clerks and managers in dept 10
	select * from emp where DEPTNO = 10 and JOB in ("CLERK","MANAGER");
    
-- 15. Display all clerks in ascending order of deptno
	select * from emp where JOB="CLERK" order by DEPTNO asc;
    
-- 16. Display all employees department wise
	select e.ENAME, d.DNAME from emp e join dept d on e.DEPTNO=d.DEPTNO order by d.DNAME;
    
-- 17. Display how many employees are there for each job
	select count(*) as No_Of_Employees , JOB  from emp group by JOB;
    
-- 18. Display what jobs are there for each department and number of employees for each job
	select DEPTNO,JOB,count(*) as No_Of_Employees from emp group by JOB,DEPTNO order by DEPTNO;
	select d.DNAME, e.JOB, count(*) as No_Of_Employees from emp e join dept d on e.DEPTNO=d.DEPTNO group by e.JOB, d.DNAME;

-- 19. Display how many employees are there for each department
	select count(*) as No_Of_Employees , DEPTNO as Dept_No from emp group by DEPTNO;
    
-- 20. Display the rank of each employee with respect to their salary (highest salary will be rank 1)
	select ENAME,SAL, rank() over (order by SAL desc) as rankings from emp;