DROP TABLE IF EXISTS email CASCADE;
CREATE TABLE IF NOT EXISTS email (
    email_id BIGINT,
    subject VARCHAR(255),
    template SMALLINT,
    status SMALLINT,
    attachment_url VARCHAR(255),
    content TEXT,
    recipient VARCHAR(255),
    sent_time TIMESTAMP NOT NULL,
    PRIMARY KEY (email_id)
    );

DROP TABLE IF EXISTS status CASCADE;
CREATE TABLE IF NOT EXISTS status (
    status_id SMALLINT,
    type VARCHAR(255),
    PRIMARY KEY (status_id)
    );

DROP TABLE IF EXISTS template CASCADE;
CREATE TABLE IF NOT EXISTS template (
    template_id SMALLINT,
    type VARCHAR(255),
    PRIMARY KEY (template_id)
    );
