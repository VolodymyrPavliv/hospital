CREATE TABLE IF NOT EXISTS role (
    id                   INT PRIMARY KEY AUTO_INCREMENT,
    name                 VARCHAR(45) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS user (
    id             INT PRIMARY KEY AUTO_INCREMENT,
    name 		   VARCHAR(64),
    surname        VARCHAR(64),
    email          VARCHAR(64),
    password       VARCHAR(128) NOT NULL,
    role_id        INT,
    birthday       DATE,
    FOREIGN KEY(role_id) REFERENCES role(id)
);

CREATE TABLE IF NOT EXISTS doctor_info (
    id INT AUTO_INCREMENT PRIMARY KEY,
    category VARCHAR(64),
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE IF NOT EXISTS record (
    id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT,
    doctor_id INT,
    nurse_id INT,
    entry_date DATE,
    discharge_date DATE,
    initial_diagnosis VARCHAR(512),
    final_diagnosis VARCHAR(512),
    FOREIGN KEY (patient_id)
        REFERENCES user(id),
    FOREIGN KEY (doctor_id)
        REFERENCES doctor_info(id),
    FOREIGN KEY (nurse_id)
        REFERENCES user(id)
);

CREATE TABLE IF NOT EXISTS assignment (
    id INT PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR(64),
    description VARCHAR(512),
    user_id INT,
    date DATE,
    record_id INT,
    FOREIGN KEY (user_id)
        REFERENCES user(id),
    FOREIGN KEY (record_id)
        REFERENCES record(id)
);
