ADD JAR target/protobuf-udf-example-1.0.0-jar-with-dependencies.jar ;

CREATE TEMPORARY FUNCTION numEntries as 'com.cloudera.sa.examples.udf.GetNumberOfEntries';

select
    id
  , numEntries( addressbook_base64 )
FROM test_proto_buf.sample;
