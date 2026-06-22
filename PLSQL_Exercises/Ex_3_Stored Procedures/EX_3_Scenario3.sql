CREATE OR REPLACE PROCEDURE TransferFunds(
    from_acc NUMBER,
    to_acc NUMBER,
    amount NUMBER
)
AS
    balance_amt NUMBER;
BEGIN

    SELECT Balance
    INTO balance_amt
    FROM Accounts
    WHERE AccountID = from_acc;

    IF balance_amt >= amount THEN

        UPDATE Accounts
        SET Balance = Balance - amount
        WHERE AccountID = from_acc;

        UPDATE Accounts
        SET Balance = Balance + amount
        WHERE AccountID = to_acc;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Transfer Successful');

    ELSE

        DBMS_OUTPUT.PUT_LINE('Insufficient Balance');

    END IF;

END;
/
SET SERVEROUTPUT ON;

BEGIN
    TransferFunds(1,2,1000);
END;
/
SELECT * FROM Accounts;