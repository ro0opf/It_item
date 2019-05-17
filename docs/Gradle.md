# Gradle
## Dependencies
- 라이브러리를 추가할때 꼭 외부 라이브러리의 라이센스 고지를 추가한다.
- 라이브러리의 버전은 +로 적지 않고 명시한다.
```java
implementation 'gun0912.ted:tedpermission-rx2:2.2.0' <- O
//implementation 'gun0912.ted:tedpermission-rx2:2.+' <- X
```

- 프로젝트 단 그래들에 버전을 정의해 사용한다.

- gradle(project)
```// Define versions in a single place
ext {
    // Sdk and tools
    // Support library and architecture components support minSdk 14 and above.
    minSdkVersion = 14
    targetSdkVersion = 26
    compileSdkVersion = 26
    buildToolsVersion = '26.0.2'

    // App dependencies
    supportLibraryVersion = '26.1.0'
    guavaVersion = '18.0'
    junitVersion = '4.12'
}
```

- gradle(app)
```android {
    compileSdkVersion rootProject.ext.compileSdkVersion
    buildToolsVersion rootProject.ext.buildToolsVersion

    defaultConfig {
        applicationId "com.example.android.architecture.blueprints.tododatabinding"
        minSdkVersion rootProject.ext.minSdkVersion
        targetSdkVersion rootProject.ext.targetSdkVersion
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner 'android.support.test.runner.AndroidJUnitRunner'
    }

dependencies {
    // App's dependencies, including test
    compile "com.android.support:appcompat-v7:$rootProject.supportLibraryVersion"
    compile "com.google.guava:guava:$rootProject.guavaVersion"

    // Dependencies for local unit tests
    testCompile "junit:junit:$rootProject.ext.junitVersion"
```

