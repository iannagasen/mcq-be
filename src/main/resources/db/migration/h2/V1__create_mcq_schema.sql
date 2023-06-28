CREATE TABLE mcq_question_groups (
  id VARCHAR(255) PRIMARY KEY,
  name VARCHAR(20) NOT NULL
);

CREATE TABLE mcq_questions (
  id VARCHAR(255) PRIMARY KEY,
  group_id VARCHAR(255),
  question VARCHAR(1023) NOT NULL,
  
  FOREIGN KEY (group_id) REFERENCES mcq_question_groups(id)
);

CREATE TABLE mcq_choices (
  id VARCHAR(255) PRIMARY KEY,
  question_id VARCHAR(255),
  choice VARCHAR(1023) NOT NULL,
  explanation VARCHAR(2047),
  
  FOREIGN KEY (question_id) REFERENCES mcq_questions(id)
);

CREATE TABLE mcq_question_answers (
  id VARCHAR(255) PRIMARY KEY,
  question_id VARCHAR2(255),
  answer_id VARCHAR2(255),

  FOREIGN KEY (question_id) REFERENCES mcq_questions(id),  
  FOREIGN KEY (answer_id) REFERENCES mcq_choices(id)  
);

INSERT INTO mcq_question_groups
VALUES ('00000000-0000-0000-0000-000000000000', 'AWS');

INSERT INTO mcq_questions
VALUES(
  '00000000-0000-0000-0000-000000000000', 
  '00000000-0000-0000-0000-000000000000', -- AWS
  'Which of the following is a key feature of Amazon EC2'
);

INSERT INTO mcq_choices 
VALUES 
(
  '00000000-0000-0000-0000-000000000000',
  '00000000-0000-0000-0000-000000000000', -- Q1
  'Auto Scaling',
  'Auto Scaling is a key feature of Amazon EC2 that allows you to automatically adjust the number of instances in an EC2 fleet based on demand. It helps maintain application availability, optimize performance, and reduce costs by scaling up or down as needed'
),
(
  '00000000-0000-0000-0000-000000000001',
  '00000000-0000-0000-0000-000000000000', -- Q1
  'Content Delivery Network (CDN)',
  'CDN is not a key feature of Amazon EC2. It is a separate service offered by Amazon called Amazon CloudFront'
),
(
  '00000000-0000-0000-0000-000000000002',
  '00000000-0000-0000-0000-000000000000', -- Q1
  'Relational Database Service (RDS)',
  'RDS is not a key feature of Amazon EC2. It is a separate managed database service offered by Amazon.'
),
(
  '00000000-0000-0000-0000-000000000003',
  '00000000-0000-0000-0000-000000000000', -- Q1
  'Object Storage Service (S3)',
  'S3 is not a key feature of Amazon EC2. It is a separate storage service offered by Amazon'
);

INSERT INTO mcq_question_answers
VALUES (
  '00000000-0000-0000-0000-000000000000',
  '00000000-0000-0000-0000-000000000000', -- question id
  '00000000-0000-0000-0000-000000000000'  -- choice id
);