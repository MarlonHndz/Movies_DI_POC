# Movies_DI_POC
POC using latest Architecture components and Dependency Injection 

## Technologies

### Libraries
- **Android ViewModels**
- **Android LiveData**: UI updates from ViewModel to Activity
- **Koin**: Dependency injection
- **Room**: Local database

### Background Strategy:
- **Kotlin Coroutines**

### Code Quiality
- **Code Style**: Added task using [ktlint](https://github.com/pinterest/ktlint) to keep a good code styel. The code style task is run always before the build task.

### View retrieval strategy 
I'm using **Kotlin Synthetic** and **View Binding** to show the both approaches.

### TODO
- **Unit Testing**: Created unit test for each Module.
- **Retrofit**: Implement retrofit for the Remote Data source.

## Branches
- [**Modules**](https://github.com/MarlonHndz/Movies_DI_POC/tree/modules): Here you will find the code of the master branch distributed in different modules as described in the architecture section in a way that further reinforces the idea of Clean Arch.
- [**DI/Hilt_Integration**](https://github.com/MarlonHndz/Movies_DI_POC/tree/DI/Hilt_Integration): Here you will find the **Hilt** library integration for dependency injection.

## Architecture
- Using **Clean Architechture** for the whole application and using **MVVM** for the presentation layer.

![Clean Arch](https://user-images.githubusercontent.com/16215046/122849576-5e7a4000-d2d1-11eb-90a2-556d0bcb5225.png)
