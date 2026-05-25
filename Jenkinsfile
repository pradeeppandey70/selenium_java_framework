pipeline {

    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK17'
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
                git 'YOUR_GITHUB_REPO_URL'
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