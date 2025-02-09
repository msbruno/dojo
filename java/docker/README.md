# Docker + Java

## Steps
### 1 - Create simple app (Commit *6a10877*)
- Main-Class: 'com.example.App'

```
//build image 
$ docker build -t hello-world .

//run container
$ docker run hello-world
```
Expected output: *Hello, World from Docker!*


### 2 - Add Gradle (Commit *87c3cb8*)
