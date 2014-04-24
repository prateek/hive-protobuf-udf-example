
# python
#protoc -I=./src --python_out=./src/main/python src/addressbook.proto

protoc -I=./src --java_out=./src/main/java src/main/protobuf/addressbook.proto

# from coreutils 
base64 -i sample_input.proto -o sample_input.proto.64
