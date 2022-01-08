## Android Clean Architecture

[![CodeStyle](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg)](https://ktlint.github.io/)
[![Kotlin Version](https://img.shields.io/badge/kotlin-1.6.10-blue.svg)](http://kotlinlang.org/)
[![Gradle](https://img.shields.io/badge/gradle-7.3.1-blue.svg)](https://lv.binarybabel.org/catalog/gradle/latest)
[![API](https://img.shields.io/badge/API-23%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=23)
[![License](https://img.shields.io/badge/License-Apache%202.0-lightgrey.svg)](http://www.apache.org/licenses/LICENSE-2.0)

Android Clean Architecture in Rorty is a sample project that presents modern, approach to [Android](https://www.android.com/) application development using [Kotlin](https://kotlinlang.org/) and latest tech-stack.

The goal of the project is to demonstrate best practices, provide a set of guidelines, and present modern Android
application architecture that is modular, scalable, maintainable and testable. This application may look simple, but it
has all of these small details that will set the rock-solid foundation of the larger app suitable for bigger teams and
long application lifecycle management.

# Rorty-Native-Android

[<img src="https://play.google.com/intl/en_us/badges/static/images/badges/en_badge_web_generic.png" width="200">](https://github.com/developersancho/Rorty.Native.Android)

### Demo Screenshots

| Mode  | Splash                                                   | Characters                                                 | Character Favorite                                        |
|-------|----------------------------------------------------------|------------------------------------------------------------|-----------------------------------------------------------|
| Light | <img src="art/screenshots/splash.png" width="250">       | <img src="art/screenshots/characters.png" width="250">     | <img src="art/screenshots/favorites.png" width="250">     |
| Dark  | <img src="art/screenshots/splash.png" width="250">       | <img src="art/screenshots/characters-dark.png" width="250">| <img src="art/screenshots/favorites-dark.png" width="250">|

| Mode  | Character Detail                                         | Settings                                                   |
|-------|----------------------------------------------------------|------------------------------------------------------------|
| Light | <img src="art/screenshots/detail.png" width="250">       | <img src="art/screenshots/settings.png" width="250">       |
| Dark  | <img src="art/screenshots/detail-dark.png" width="250">  | <img src="art/screenshots/settings-dark.png" width="250">  |

## 🚀 Posts In This Series

![Native Android: 1-) Building a Rorty App from Scratch](https://developersancho.medium.com/native-android-1-building-a-rorty-app-from-scratch-a75937b8c970)
![Native Android: 2-) Application Structure and Tech Stacks](https://developersancho.medium.com/native-android-2-application-structure-and-tech-stacks-e5b9534b4f59)
![Native Android: 3-) Setup Development Environment](https://developersancho.medium.com/native-android-3-setup-development-environment-f19812a8070a)
![Native Android: 4-) Creating App and Enable Git-Version Control System](https://developersancho.medium.com/native-android-4-creating-app-and-enable-git-version-control-system-4efbc7d74cab)
![Native Android: 5-) Creating Projects Modules](https://developersancho.medium.com/native-android-5-creating-projects-modules-5740a5778ade)
![Native Android: 6-) Creating buildSrc for Gradle Dependency Management](https://developersancho.medium.com/native-android-6-creating-buildsrc-for-gradle-dependency-management-52217bafbb7f)
![Native Android: 7-) Building buildSrc for Gradle Dependency Management](https://developersancho.medium.com/native-android-7-building-buildsrc-for-gradle-dependency-management-bd89a94e6788)
![Native Android: 8-) Creating Custom Plugin for Application](https://developersancho.medium.com/native-android-8-creating-custom-plugin-for-app-build-gradle-40a6deb4d906)
![Native Android: 9-) Creating Custom Plugin for Android Library](https://developersancho.medium.com/native-android-9-creating-custom-plugin-for-android-library-33830ef89d4b)
![Native Android: 10-) Migrating Groovy to Kotlin DSL All Modules](https://developersancho.medium.com/native-android-10-migrating-groovy-to-kotlin-dsl-all-modules-8f2cef1773fe)
![Native Android: 11-) Integrating Check Version for Dependencies](https://developersancho.medium.com/native-android-11-integrating-check-version-for-dependencies-bf7a8b432ec5)
![Native Android: 12-) Integrating Ktlint the Workflow](https://developersancho.medium.com/native-android-12-integrating-ktlint-the-workflow-65688caaff12)
![Native Android: 13-) Integrating Spotless Plugin the Workflow](https://developersancho.medium.com/native-android-13-integrating-spotless-plugin-the-workflow-58e3d84799b4)
![Native Android: 14-) Integrating Detekt in the Workflow](https://developersancho.medium.com/native-android-14-integrating-detekt-in-the-workflow-4942bdfc0548)
![Native Android: 15-) Creating Code Analyze Task](https://developersancho.medium.com/native-android-15-creating-code-analyze-task-cb36d308f570)
![Native Android: 16-) Integrating Git Hooks in the Workflow](https://developersancho.medium.com/native-android-16-integrating-git-hooks-in-the-workflow-c9e75b9010ff)
![Native Android: 17-) Preparing Base Structure — navigation module](https://developersancho.medium.com/native-android-17-preparing-base-structure-navigation-module-4b1c29162c06)
![Native Android: 18-) Preparing Base Structure — ProgressDialog](https://developersancho.medium.com/native-android-18-preparing-base-structure-progressdialog-8a7fe6670c09)
![Native Android: 19-) Preparing Base Structure — extension module](https://developersancho.medium.com/native-android-19-preparing-base-structure-extension-module-a89609fb0422)
![Native Android: 20-a ) Preparing Base Structure — framework module](https://developersancho.medium.com/native-android-20-a-preparing-base-structure-framework-module-145fb9f079bd)
![Native Android: 20-b ) Preparing Base Structure — framework module](https://developersancho.medium.com/native-android-20-b-preparing-base-structure-framework-module-89f691ae774)
![Native Android: 20-c ) Preparing Base Structure — framework module-Security CacheManager](https://developersancho.medium.com/native-android-20-c-preparing-base-structure-framework-module-security-cachemanager-fe3529e55064)
![Native Android: 21 ) Building Presentation-App Module Part-1](https://developersancho.medium.com/native-android-21-building-presentation-app-module-part-1-be6617bdb28a)
![Native Android: 22 ) Building Presentation-App Module Part-2](https://developersancho.medium.com/native-android-22-building-presentation-app-module-part-2-52c9461fbf88)
![Native Android: 23 ) Building Light/Dark Theme for The App](https://developersancho.medium.com/native-android-23-building-light-dark-theme-for-the-app-c3fe8bec1049)

## 🤝 Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire,
and create. Any contributions you make are **greatly appreciated**.

1. Open an issue first to discuss what you would like to change.
1. Fork the Project
1. Create your feature branch (`git checkout -b feature/amazing-feature`)
1. Commit your changes (`git commit -m 'Add some amazing feature'`)
1. Push to the branch (`git push origin feature/amazing-feature`)
1. Open a pull request

Please make sure to update tests as appropriate.

## ✍️ Authors

<a href="https://www.linkedin.com/in/mesut-g-33b41030" target="_blank">
  <img src="https://avatars.githubusercontent.com/u/30066734?v=4" width="70" align="left">
</a>

👤 **developersancho**

[![Linkedin](https://img.shields.io/badge/-linkedin-grey?logo=linkedin)](https://www.linkedin.com/in/mesut-g-33b41030/)
[![Medium](https://img.shields.io/badge/-medium-grey?logo=medium)](https://developersancho.medium.com/)

Feel free to ping me 😉

## License

```license
Copyright © 2022 - developersancho

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```