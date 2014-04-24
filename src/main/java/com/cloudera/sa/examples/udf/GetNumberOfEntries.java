package com.cloudera.sa.examples.udf;

import com.cloudera.sa.examples.tutorial.AddressBookProtos.AddressBook;
import com.cloudera.sa.examples.tutorial.AddressBookProtos.Person;

import javax.xml.bind.DatatypeConverter;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

public class GetNumberOfEntries extends UDF {

  // Given a base64 encoded representation of an AddressBook protobuf
  // This returns the number of Person records contained therein
  public Integer evaluate(Text str) {
    if( str == null ) {
      return 0;
    }

    try {
      byte[] decodedString
          = DatatypeConverter.parseBase64Binary( str.toString() );

      AddressBook addressBook =
        AddressBook.parseFrom( decodedString );

      return new Integer( addressBook.getPersonCount() );

    } catch ( Exception e ) {
      //TODO: log e
      return 0;
    }
  }

}
