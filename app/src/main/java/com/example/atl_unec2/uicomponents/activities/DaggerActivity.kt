package com.example.atl_unec2.uicomponents.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.atl_unec2.R
import dagger.hilt.android.AndroidEntryPoint

/**
 *
 * Using Dagger in Android projects offers several key benefits that make it an attractive choice for dependency injection (DI). Here’s a detailed look at why you should use Dagger:
 *
 * 1. Dependency Injection (DI) Simplification
 * Simplifies Dependency Management:
 *
 * Dagger automates the process of providing and injecting dependencies, reducing boilerplate code.
 * It helps in organizing and managing dependencies in a cleaner, more modular way.
 *
 *
 * 2. Compile-Time Dependency Injection
 * Error Detection:
 *
 * Dagger performs dependency injection at compile time, catching errors early in the development process.
 * This ensures that all dependencies are correctly provided and injected before the application runs.
 * Performance:
 *
 * By generating code at compile time, Dagger eliminates the runtime overhead associated with reflection-based DI frameworks.
 * This leads to better performance and faster application startup times.
 *
 *
 * 3. Scalability
 * Large Project Handling:
 *
 * Dagger is well-suited for large and complex projects with extensive dependency graphs.
 * It efficiently manages dependencies across different modules, promoting a clear and maintainable structure.
 * Multi-Module Support:
 *
 * Dagger supports multi-module projects, allowing each module to manage its own dependencies.
 * This modular approach enhances code separation and reusability.
 *
 *
 * 4. Testability
 * Easier Testing:
 *
 * Dagger facilitates the injection of mock dependencies, making unit and integration testing more straightforward.
 * You can easily swap out real dependencies with mocks or stubs, isolating the components under test.
 * Injectable Mocks:
 *
 * During testing, Dagger allows you to inject mock implementations without modifying the production code.
 * This enhances the reliability and scope of your tests.
 *
 *
 * 5. Integration with Android Components
 * Android-Specific Extensions:
 *
 * Dagger has Android-specific extensions like Dagger-Android that simplify DI in Android components (Activities, Fragments, Services, ViewModels).
 * These extensions reduce boilerplate and make the setup process more intuitive.
 *
 *
 * 6. Maintainability
 * Boilerplate Reduction:
 *
 * Dagger reduces the need for boilerplate code by automatically generating the necessary injection code.
 * This leads to cleaner, more maintainable codebases.
 * Readability:
 *
 * The generated code by Dagger is human-readable, making it easier for developers to understand and debug the DI setup.
 * This transparency helps in maintaining and evolving the codebase.
 *
 *
 * 7. Community and Support
 * Active Maintenance:
 *
 * Dagger is maintained by Google, ensuring it is regularly updated with the latest practices and integrates well with the Android ecosystem.
 * This continuous support makes it a reliable choice for production applications.
 * Documentation and Resources:
 *
 * Dagger has comprehensive documentation and a strong community, providing ample resources for learning and troubleshooting.
 * This support network makes it easier to adopt and effectively use Dagger in projects.
 * Conclusion
 * In summary, Dagger is a powerful DI framework for Android that offers significant benefits in terms of performance, maintainability, testability, and scalability. Its compile-time injection, integration with Android components, and strong community support make it an ideal choice for modern Android development.
 */


@AndroidEntryPoint
class DaggerActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        (application as MyApplication).appComponent.inject(this)
        setContentView(R.layout.activity_dagger)



//        application.applicationContext
    }
}