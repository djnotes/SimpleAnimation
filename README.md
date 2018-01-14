# SimpleAnimation: A Lightweight animation library for Android using ConstraintLayout   
# Sample Output:   
![Sample Output](static/sample.gif)

# Download (Gradle)
To use the library, first add the following repository to your list of repositories:  
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Then, add the following dependency to your app module's build.gradle file:  
```
	dependencies {
	        compile 'com.github.djnotes:SimpleAnimation:v1.0.0'
	}
```
# Usage   
To use the library you can simply pass a ConstraintLayout along with a secondary layout (where you have defined new constraints) to the the singleton class:   


```
ConstraintLayout layout = findViewById(R.id.layout);
MyAnimation mAnimation = MyAnimation.getInstance();
    mAnimation.with(this).from(R.layout.second_keyframe)
                .animate(layout);

``` 


