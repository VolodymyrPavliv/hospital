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

CREATE TABLE IF NOT EXISTS nurse_info (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE IF NOT EXISTS patient_info (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    doctor_info_id INT,
    nurse_info_id INT,
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (doctor_info_id) REFERENCES doctor_info(id),
    FOREIGN KEY (nurse_info_id) REFERENCES nurse_info(id)
);


CREATE TABLE IF NOT EXISTS assignment_type (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(64)
);

CREATE TABLE IF NOT EXISTS hospital_card (
    id INT PRIMARY KEY AUTO_INCREMENT,
    patient_info_id INT,
    entry_date DATE,
    discharge_date DATE,
    initial_diagnosis VARCHAR(512),
    final_diagnosis VARCHAR(512),
    FOREIGN KEY (patient_info_id)
        REFERENCES patient_info(id)
);

CREATE TABLE IF NOT EXISTS assignment (
    id INT PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(512),
    assignment_type_id INT,
    user_id INT,
    date DATE,
    hospital_card_id INT,
    FOREIGN KEY (assignment_type_id)
        REFERENCES assignment_type(id),
    FOREIGN KEY (user_id)
        REFERENCES user(id),
    FOREIGN KEY (hospital_card_id)
        REFERENCES hospital_card(id)
);
