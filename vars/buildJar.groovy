#!/usr/bin/env groovy

def call() {
    echo "this is buildJar stage for ${BRANCH_NAME} branch"
    sh "mvn package"
}