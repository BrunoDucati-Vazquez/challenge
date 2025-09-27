INSERT INTO recipients (id, name, phone, birth_date, created_at, updated_at) VALUES (1, 'Alice', '111111111', '1990-01-01', CURRENT_DATE, CURRENT_DATE);
INSERT INTO recipients (id, name, phone, birth_date, created_at, updated_at) VALUES (2, 'Bob', '222222222', '1985-05-05', CURRENT_DATE, CURRENT_DATE);

INSERT INTO documents (document_type, description, created_at, updated_at, recipient_id) VALUES ('Passport', 'Alice Passport', CURRENT_DATE, CURRENT_DATE, 1);
INSERT INTO documents (document_type, description, created_at, updated_at, recipient_id) VALUES ('ID Card', 'Alice ID Card', CURRENT_DATE, CURRENT_DATE, 1);
INSERT INTO documents (document_type, description, created_at, updated_at, recipient_id) VALUES ('Driver License', 'Bob Driver License', CURRENT_DATE, CURRENT_DATE, 2);
INSERT INTO documents (document_type, description, created_at, updated_at, recipient_id) VALUES ('Work Permit', 'Bob Work Permit', CURRENT_DATE, CURRENT_DATE, 2);
INSERT INTO documents (document_type, description, created_at, updated_at, recipient_id) VALUES ('Residence Card', 'Alice Residence Card', CURRENT_DATE, CURRENT_DATE, 1);
