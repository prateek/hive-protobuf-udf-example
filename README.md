# Protobuf Example in Hive #

This example ilustrates how to use a UDF to read a protobuf field contained in a String in Hive.

The UDF can be found at `src/main/java/com/cloudera/sa/examples/udf/GetNumberOfEntries.java`, it takes an input for a base64 encoded version of a protobuf document, described by `src/main/protobuf/addressbook.proto` (based on the Google ProtoBuf Examples), and reads the number of occurences of a repeated field in there (Person).

The UDF can be extended to return multiple values, eg: [Hive’s Split UDF](http://grepcode.com/file/repository.cloudera.com/content/repositories/releases/org.apache.hadoop.hive/hive-exec/0.7.1-cdh3u1/org/apache/hadoop/hive/ql/udf/generic/GenericUDFSplit.java), if desired.

## Usage ##
1. Install the ProtoBuf dependencies from here (for Java) - [Google Download Page](https://code.google.com/p/protobuf/downloads/list)

2. Follow these steps
```sh
# compile the udf jar
$ mvn package

# create the hive table describing the data
hive -f hive-scripts/create.hql

# load a single record sample file
hdfs dfs -put sample-input/sample-hive.csv

# run a test query to validate:
hive -f hive-scripts/udf-test.hql
# if successful, it will return -
# test_address_book, 2
```
