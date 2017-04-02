# gradle-cumulative

This project contains various Gradle tasks for a typical project baseline that I have experience with at work or how I normally set up a baseline when I do my own personal development. A summary listed below.

1. Printing out useful information about each project
2. Configuring subprojects with project name gradle build file (rather than 'build.gradle')
3. Subproject Java builds include main and test Java sources

... (Others will come as soon as I do a quick clean up of my personal projects)


## Quick Start

Add an include to `simpletasks.gradle` to the **end** of your root project's build file.

```java
// make sure this goes at the end of your root project build.gradle
include from : '/path/to/simpletasks.gradle'
```

> Original project exported from a personal subversion server into a git repository, and pushed to Github.
