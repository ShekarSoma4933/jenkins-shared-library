#!/usr/bin/env groovy

def call() {
    echo "this is build stage"
    sh "mvn package"
}