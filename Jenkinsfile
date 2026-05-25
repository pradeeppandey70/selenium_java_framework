pipeline {

    agent any

    tools {
        maven 'MAVEN3'
        jdk 'JDK25'
    }

    parameters {

        choice(
            name: 'BROWSER',
            choices: ['chrome', 'firefox', 'edge'],
            description: 'Select browser'
        )

        choice(
            name: 'SUITE',
            choices: ['testng.xml', 'smoke.xml', 'regression.xml'],
            description: 'Select suite'
        )

        choice(
            name: 'EXECUTION_MODE',
            choices: ['local', 'grid'],
            description: 'Execution mode'
        )
    }

    stages {

        stage('Checkout') {
            steps {
				branch: 'main',
                git: 'https://github.com/pradeeppandey70/selenium_java_framework'
            }
        }

        stage('Build & Test') {
            steps {

                bat """
                mvn clean test ^
                -Dbrowser=%BROWSER% ^
                -DsuiteXmlFile=%SUITE% ^
                -DexecutionMode=%EXECUTION_MODE%
                """
            }
        }
    }
}