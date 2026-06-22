CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER
);
INSERT INTO Accounts VALUES (1, 101, 'Savings', 10000);
INSERT INTO Accounts VALUES (2, 102, 'Savings', 20000);
INSERT INTO Accounts VALUES (3, 103, 'Current', 15000);
COMMIT;
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';

    COMMIT;
END;
/
BEGIN
    ProcessMonthlyInterest;
END;
/
SELECT * FROM Accounts;