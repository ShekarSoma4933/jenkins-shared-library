#!/usr/bin/env groovy

def call(String imageName) {
    echo "this is push stage"
    withCredentials([usernamePassword('credentialsId': 'nexus-repo-credentials', 'usernameVariable': 'USER', 'passwordVariable': 'PASS')]) {
        sh "docker build -t ${imageName} ."
        sh "echo ${PASS} | docker login -u ${USER} --password-stdin 143.198.43.144:8083"
        sh "docker push ${imageName}"
    }
}