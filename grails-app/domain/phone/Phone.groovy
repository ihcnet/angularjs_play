package phone

class Phone {

    String name
    String snippet
    int age
    Feature additionalFeature

    static hasMany = [providers:Provider, images:Image]

    Android os
    Battery battery
    Camera camera
    Connectivity connectivity
    String description
    Display display
    Hardware hardware


}
