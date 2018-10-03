DROP TABLE IF EXISTS batch CASCADE;
CREATE TABLE IF NOT EXISTS batch
(id INTEGER NOT NULL,
name VARCHAR(25) NOT NULL,
start_date TIMESTAMP NOT NULL,
end_date TIMESTAMP NOT NULL,
trainer_id INTEGER,
calendar_curriculum_id INTEGER,
PRIMARY KEY (id));

DROP SEQUENCE IF EXISTS batch_seq;
CREATE SEQUENCE IF NOT EXISTS batch_seq START WITH 5;