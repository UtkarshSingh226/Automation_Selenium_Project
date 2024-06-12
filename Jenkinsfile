pipeline {
    agent any
    
    tools { // Defines tools required for the pipeline
        maven 'mvn' // Specifies the Maven tool named 'mvn'
        jdk 'JDK11' // Ensure this matches the JDK installation name in Jenkins
    }
    
    triggers { // Defines triggers for the pipeline
        cron('H H(8-15)/2 * * 1-5') // Cron trigger to run the pipeline every 2 hours between 8 AM and 3 PM, Monday through Friday
    }
    
    stages {
        stage('Build') {
            steps {
                script {
                    // Clean previous builds and install dependencies
                    sh 'mvn clean'
                }
            }
        }
        
        stage('Run Tests - Chrome') {
            environment {
                BROWSER = 'chrome'
            }
            steps {
                script {
                    // Run tests on Chrome
                    sh 'mvn test -Dbrowser=chrome'
                }
            }
            post {
                always {
                    // Archive test results and reports
                    junit 'target/surefire-reports/*.xml'
                    archiveArtifacts artifacts: 'logs/*.log', allowEmptyArchive: true
                }
            }
        }
        
        stage('Generate Reports') {
            steps {
                script {
                    // Generate Extent Reports
                    sh 'mvn verify'
                }
            }
            post {
                always {
                    // Archive HTML reports
                    publishHTML([
                        reportName: 'Extent Reports',
                        reportDir: 'target/surefire-reports',
                        reportFiles: 'extent-report.html',
                        alwaysLinkToLastBuild: true,
                        keepAll: true
                    ])
                }
            }
        }
    }
    
    post {
        always {
            // Clean up workspace
            cleanWs()
        }
    }
}
