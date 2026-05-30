pipeline {

    agent {
		label 'selenium'
}

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
				git branch: 'main',
                url: 'https://github.com/pradeeppandey70/selenium_java_framework'
            }
        }

       stage('Parallel Browser Execution') {

       	parallel {

        	stage('Chrome') {
            	steps {
	                bat """
	                mvn clean test ^
	                -Dbrowser=chrome ^
	                -DsuiteXmlFile=%SUITE% ^
	                -DexecutionMode=%EXECUTION_MODE%
	                """
	            }
        }

	        stage('Firefox') {
	            steps {
	                bat """
	                mvn clean test ^
	                -Dbrowser=firefox ^
	                -DsuiteXmlFile=%SUITE% ^
	                -DexecutionMode=%EXECUTION_MODE%
	                """
	            }
	        }
	
	        stage('Edge') {
	            steps {
	                bat """
	                mvn clean test ^
	                -Dbrowser=edge ^
	                -DsuiteXmlFile=%SUITE% ^
	                -DexecutionMode=%EXECUTION_MODE%
	                """
	            }
	        }
    	}
	}
	}
    post {
    	always {
        	allure([
            	includeProperties: false,
            	jdk: '',
            	results: [[path: 'target/allure-results']]
        	])
    	}
    	

    success {
        emailext(
            subject: "SUCCESS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
            body: """
                Build SUCCESSFUL
                
                Job Name: ${env.JOB_NAME}
                Build Number: ${env.BUILD_NUMBER}
                
                Check console output:
                ${env.BUILD_URL}
                
                Allure Report:
                ${env.BUILD_URL}allure
            """,
            to: 'pradeepp@thoughtwin.com'
        )
    }

    failure {
        emailext(
            subject: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
            body: """
                Build FAILED
                
                Job Name: ${env.JOB_NAME}
                Build Number: ${env.BUILD_NUMBER}
                
                Check console output:
                ${env.BUILD_URL}
                
                Allure Report:
                ${env.BUILD_URL}allure
            """,
            to: 'pradeepp@thoughtwin.com'
        	)
    	}
 	}
    
	}
}