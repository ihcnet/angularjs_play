package com.demo

class Camera {
    String cameraType
    static hasMany = [features: Feature]

    static constraints = {
        cameraType(nullable: false)
    }

}
