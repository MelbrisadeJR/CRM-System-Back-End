DROP TABLE IF EXISTS email CASCADE;
CREATE TABLE IF NOT EXISTS email (
    id BIGINT,
    subject VARCHAR(255),
    template SMALLINT,
    status SMALLINT,
    attachment_url VARCHAR(255),
    content TEXT,
    recipient VARCHAR(255),
    sent_time TIMESTAMP NOT NULL,
    PRIMARY KEY (id)
    );

DROP TABLE IF EXISTS status CASCADE;
CREATE TABLE IF NOT EXISTS status (
    id SMALLINT,
    type VARCHAR(255),
    PRIMARY KEY (id)
    );

DROP TABLE IF EXISTS template CASCADE;
CREATE TABLE IF NOT EXISTS template (
    id SMALLINT,
    type VARCHAR(255),
    PRIMARY KEY (id)
    );
