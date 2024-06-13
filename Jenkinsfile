pipeline {
    agent any
    
    tools {
        maven "mvn" // Maven tool named 'mvn'
        jdk 'JDK11' // JDK installation named 'JDK11'
    }
    
    stages {
        stage('Build') {
            steps {
                // Clean and build the Maven project
                bat 'mvn clean'
            }
            post {
                success {
                    echo 'Build stage executed successfully!'
                }
            }
        }
        
        stage('Test') {
            steps {
                // Run tests
                bat 'mvn clean test -DsuiteXMLFile=testng.xml'
            }
            post {
                success {
                    echo 'Test stage executed successfully!'
                }
            }
        }
        
        stage('Clean Up') {
            steps {
                // Clean up any temporary files or resources
                bat 'mvn clean'
            }
            post {
                success {
                    echo 'Clean Up stage executed successfully!'
                }
            }
        }
    }
    
    post {
        always {
            // Clean up workspace and perform any final actions
            cleanWs()
        }
        
        success {
            echo 'Pipeline executed successfully!'
        }
        
        failure {
            echo 'Pipeline executed successfully!'
        }
    }
}
