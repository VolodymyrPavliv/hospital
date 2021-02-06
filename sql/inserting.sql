INSERT INTO role(id, name) VALUES(1,'PATIENT'),(2,'DOCTOR'),(3,'NURSE'), (4,'ADMIN' );

INSERT INTO user(id, name, surname, email, password, role_id, birthday) VALUE(1, 'patient', 'patient', 'patient@gmail.com','1111', 1, '1999-10-10');
INSERT INTO user(id, name, surname, email, password, role_id, birthday) VALUE(2, 'doctor', 'doctor', 'doctor@gmail.com','1111', 2, '1997-08-11');
INSERT INTO user(id, name, surname, email, password, role_id, birthday) VALUE(3, 'nurse', 'nurse', 'nurse@gmail.com','1111', 3, '1999-08-17');
INSERT INTO user(id, name, surname, email, password, role_id, birthday) VALUE(4, 'admin', 'admin', 'admin@gmail.com','admin', 4, '1996-07-07');

INSERT INTO doctor_info(id, category, user_id) VALUE (1, 'Pediatrician', 2);

INSERT INTO record(id, patient_id, doctor_id, nurse_id, entry_date, initial_diagnosis)
VALUE (1, 1, 1, 3,'2020-01-03', 'Initial Diagnosis');
