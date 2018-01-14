# SimpleAnimation: A Lightweight animation library for Android using ConstraintLayout   
# Sample Output:   
![Sample Output](static/sample.gif)

# Usage   
To use the library you can simply pass a ConstraintLayout along with a secondary layout (where you have defined new constraints) to the the singleton class:   


```
ConstraintLayout layout = findViewById(R.id.layout);
MyAnimation mAnimation = MyAnimation.getInstance();
    mAnimation.with(this).from(R.layout.second_keyframe)
                .animate(layout);

``` 


