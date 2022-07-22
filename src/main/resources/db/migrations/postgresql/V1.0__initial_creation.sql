

CREATE TABLE item (
    id VARCHAR(64) NOT NULL,
    message VARCHAR(255),
    CONSTRAINT pk_id PRIMARY KEY(id)
);

-- ALTER TABLE item CONFIGURE ZONE USING gc.ttlseconds = 7200;