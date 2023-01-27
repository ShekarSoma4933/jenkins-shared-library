#!/usr/bin/env groovy

def call() {
    echo "this is push stage"
    withCredentials([usernamePassword('credentialsId': 'nexus-repo-credentials', 'usernameVariable': 'USER', 'passwordVariable': 'PASS')]) {
        sh "docker build -t 143.198.43.144:8083/maven-web-app:2.1 ."
        sh "echo ${PASS} | docker login -u ${USER} --password-stdin 143.198.43.144:8083"
        sh "docker push 143.198.43.144:8083/maven-web-app:2.1"
    }
}