DROP DATABASE IF EXISTS ormlearn;
CREATE DATABASE ormlearn;
USE ormlearn;

-- USER TABLE
CREATE TABLE user (
    us_id INT AUTO_INCREMENT PRIMARY KEY,
    us_name VARCHAR(100) NOT NULL
);

-- ATTEMPT TABLE
CREATE TABLE attempt (
    at_id INT AUTO_INCREMENT PRIMARY KEY,
    at_us_id INT,
    attempted_date DATE,
    FOREIGN KEY (at_us_id) REFERENCES user(us_id)
);

-- QUESTION TABLE
CREATE TABLE question (
    qu_id INT AUTO_INCREMENT PRIMARY KEY,
    qu_text VARCHAR(255),
    correct_score DOUBLE
);

-- OPTION TABLE
CREATE TABLE option_table (
    op_id INT AUTO_INCREMENT PRIMARY KEY,
    op_qu_id INT,
    op_text VARCHAR(255),
    is_correct BOOLEAN,
    FOREIGN KEY (op_qu_id) REFERENCES question(qu_id)
);

-- ATTEMPT QUESTION
CREATE TABLE attempt_question (
    aq_id INT AUTO_INCREMENT PRIMARY KEY,
    aq_at_id INT,
    aq_qu_id INT,
    FOREIGN KEY (aq_at_id) REFERENCES attempt(at_id),
    FOREIGN KEY (aq_qu_id) REFERENCES question(qu_id)
);

-- ATTEMPT OPTION
CREATE TABLE attempt_option (
    ao_id INT AUTO_INCREMENT PRIMARY KEY,
    ao_aq_id INT,
    ao_op_id INT,
    FOREIGN KEY (ao_aq_id) REFERENCES attempt_question(aq_id),
    FOREIGN KEY (ao_op_id) REFERENCES option_table(op_id)
);

----------------------------------------------------------
-- SAMPLE DATA
----------------------------------------------------------

INSERT INTO user(us_name)
VALUES ('John');

INSERT INTO attempt(at_us_id, attempted_date)
VALUES (1,'2024-01-10');

INSERT INTO question(qu_text, correct_score)
VALUES
('What is the extension of HTML file?',1),
('Maximum heading tag?',1);

INSERT INTO option_table(op_qu_id, op_text, is_correct)
VALUES
(1,'.html',true),
(1,'.ht',false),
(1,'.xhtml',false),
(1,'.htmx',false),

(2,'3',false),
(2,'4',false),
(2,'5',false),
(2,'6',true);

INSERT INTO attempt_question(aq_at_id, aq_qu_id)
VALUES
(1,1),
(1,2);

INSERT INTO attempt_option(ao_aq_id, ao_op_id)
VALUES
(1,1),
(2,8);