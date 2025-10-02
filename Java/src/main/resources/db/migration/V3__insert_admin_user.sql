INSERT INTO users (username, password, enabled)
VALUES ('admin', '$2a$10$F0I2r5oQ8wQ2Z8e2k5nU..4d2y7vQk7Xr7Y0s1V8h0Oa6Bv3QeR3C', TRUE)
    ON CONFLICT (username) DO NOTHING;
