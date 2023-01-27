#!/usr/bin/env groovy
package com.example

class Docker implements Serializable{

    def script

    Docker(script){
        this.script = script
    }

    def buildDockerImage(String imageName){
        script.echo "this is push stage"
        script.withCredentials([script.usernamePassword('credentialsId': 'nexus-repo-credentials', 'usernameVariable': 'USER', 'passwordVariable': 'PASS')]) {
            script.sh "docker build -t ${imageName} ."
            script.sh "echo ${script.PASS} | docker login -u ${script.USER} --password-stdin 143.198.43.144:8083"
            script.sh "docker push ${imageName}"
        }
    }

}
