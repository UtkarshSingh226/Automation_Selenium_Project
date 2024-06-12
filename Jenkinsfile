pipeline {
    agent any
    tools {
        maven "mvn"
        jdk 'JDK11'
    }
    
    stages {
        stage('Build') {
            steps {
                // Clean and build the Maven project
                bat 'mvn clean'
            }
        }
        stage('Test') {
            steps {
                // Run tests
                bat 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                // Placeholder for deployment steps
                // Replace this with your deployment script or commands
                echo 'Deploying the application...'
            }
        }
        stage('Clean Up') {
            steps {
                // Clean up any temporary files or resources
                bat 'mvn clean'
            }
        }
    }
    
    post {
        success {
            echo 'Pipeline executed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
