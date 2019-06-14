# JsonLogger
JsonLoggerLibrary is a fast and light tool to print json formatted string in logcat.

## Download
Step 1. Add the JitPack repository to your build file
```groovy
  allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}
```


Step 2. Add the dependency
```groovy
dependencies {
 implementation 'com.github.raychong:JsonLogger:1.0.0'
}
```


## Usage
```groovy
 JsonLogger.logJson("<json-string-here>");
 ```
