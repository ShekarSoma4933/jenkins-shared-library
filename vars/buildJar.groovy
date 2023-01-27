#!/usr/bin/env groovy

def call() {
    echo "this is buildJar stage"
    sh "mvn package"
}