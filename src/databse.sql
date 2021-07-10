-- MySQL scripts

-- 1)
CREATE TABLE Teacher (
    id INT PRIMARY KEY AUTO_INCREMENT,
    f_name VARCHAR(30) NOT NULL,
    l_name VARCHAR(30) NOT NULL,
    gender VARCHAR(20) NOT NULL,
    subject VARCHAR(20) NOT NULL
);

CREATE TABLE Pupil (
    id INT PRIMARY KEY AUTO_INCREMENT,
    f_name VARCHAR(30) NOT NULL,
    l_name VARCHAR(30) NOT NULL,
    gender VARCHAR(20) NOT NULL,
    class INT NOT NULL
);

CREATE TABLE Merger (
    id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT,
    teacher_id INT,
    CONSTRAINT st_id_for_key FOREIGN KEY (student_id) REFERENCES Pupil (id),
    CONSTRAINT tch_id_for_key FOREIGN KEY (teacher_id) REFERENCES Teacher (id)
);

-- 2)
SELECT t.id, t.f_name, t.l_name
FROM Teacher t, Merger m, Pupil p
WHERE t.id = m.teacher_id and m.student_id = p.id and p.f_name = "giorgi"
GROUP BY id;