INSERT INTO roles(id, name) VALUES(1,'PATIENT'),(2,'DOCTOR'),(3,'ADMIN');

INSERT INTO users(id, name, surname, email, password, role_id) VALUE(1, 'patient', 'patient', 'patient@gmail.com','1111', 1);
INSERT INTO users(id, name, surname, email, password, role_id) VALUE(7, 'doctor', 'doctor', 'doctor@gmail.com','1111', 2);

INSERT INTO users(id, name, surname, email, password, role_id) VALUE(10, 'admin', 'admin', 'admin@gmail.com','admin', 3);