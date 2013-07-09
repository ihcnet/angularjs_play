package com.demo

class Phone {

    String name
    String snippet
    int age
//    String additionalFeature
//    String os
//    String battery
//    String camera
//    String connectivity
//    String description
//    String display
//    String hardware
    Feature additionalFeature

    static hasMany = [providers: Provider, images: Image]

    static mapping = {
        additionalFeature cascade: 'all'
        os cascade: 'all'
        battery cascade: 'all'
        camera cascade: 'all'
        connectivity cascade: 'all'
        description cascade: 'all'
        display cascade: 'all'
        hardware cascade: 'all'
    }
    static constraints = {
        name(nullable: true)
        snippet(nullable: true)
        age(nullable: true)
        os(nullable: true)
        battery(nullable: true)
        connectivity(nullable: true)
        description(nullable: true)
        display(nullable: true)
        hardware(nullable: true)
        additionalFeature(nullable: true)
        camera(nullable: true)
    }

    Android os
    Battery battery
    Camera camera
    Connectivity connectivity
    String description
    Display display
    Hardware hardware


}
