TRUNCATE TABLE patient RESTART IDENTITY;
ALTER TABLE patient ALTER COLUMN patient_name DROP NOT NULL;

INSERT INTO patient (patient_name, birth_date, email, gender, blood_group)
VALUES
('Amit Kumar', '1995-05-12', 'amit.kumar@example.com', 'Male', 'O_POSITIVE'),
('Priya Sharma', '2000-08-22', 'priya.sharma@example.com', 'Female', 'A_POSITIVE'),
('Rahul Verma', '1998-11-03', 'rahul.verma@example.com', 'Male', 'B_NEGATIVE'),
('Sneha Reddy', '2002-01-15', 'sneha.reddy@example.com', 'Female', 'AB_POSITIVE'),
('Ankit Singh', '1997-06-18', 'ankit.singh@example.com', 'Male', 'A_NEGATIVE'),
('Riya Mehta', '1999-12-05', 'riya.mehta@example.com', 'Female', 'B_POSITIVE'),
('Vikram Joshi', '2001-03-22', 'vikram.joshi@example.com', 'Male', 'O_NEGATIVE'),
('Neha Gupta', '2003-07-30', 'neha.gupta@example.com', 'Female', 'AB_NEGATIVE');
