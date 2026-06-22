CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    EmployeeName VARCHAR2(30),
    DepartmentID NUMBER,
    Salary NUMBER
);
INSERT INTO Employees VALUES (1,'John',10,50000);
INSERT INTO Employees VALUES (2,'David',10,60000);
INSERT INTO Employees VALUES (3,'Mary',20,55000);
COMMIT;
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    dept_id NUMBER,
    bonus_percent NUMBER
)
AS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * bonus_percent/100)
    WHERE DepartmentID = dept_id;

    COMMIT;
END;
/
BEGIN
    UpdateEmployeeBonus(10,10);
END;
/
SELECT * FROM Employees;