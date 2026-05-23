pipeline {
    agent any

    tools {
        maven 'MAVEN3'
        jdk 'JDK25'
    }

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/pradeeppandey70/selenium_java_framework'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }
}