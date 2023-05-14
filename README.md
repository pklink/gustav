# Gustav 

* create file hashes and store them in the filename
* verify integrity of files using hashes stored in the filename
* strip existing hashes in filename

## Using

```
gustav create /foo/bar/
gustav verify /foo/bar/
gustav cleanup /foo/bar/
```

```
./gradlew run --args="verify /foo/bar/"
```