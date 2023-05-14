# Gustav 

* create file hashes and store them in the filename
* verify integrity of files using hashes stored in the filename
* strip existing hashes in filename

## Using

```
java -jar gustav.jar create /foo/bar/
java -jar gustav.jar verify /foo/bar/
java -jar gustav.jar cleanup /foo/bar/
```

```
./gradlew run --args="verify /foo/bar/"
```