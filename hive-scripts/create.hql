CREATE DATABASE IF NOT EXISTS test_proto_buf;

DROP TABLE IF EXISTS test_proto_buf.sample;

CREATE TABLE test_proto_buf.sample
(
    id STRING
  , addressbook_base64 STRING
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ",";

