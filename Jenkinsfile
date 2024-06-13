pipeline {
    agent any
    
    tools {
        maven "mvn" // Maven tool named 'mvn'
        jdk 'JDK11' // JDK installation named 'JDK11'
    }
    
    environment {
        CHROME_BIN = 'C:\\Users\\utkarshsingh01\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe' // Path to Chrome binary
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
                // Set up WebDriverManager to handle browser drivers
                script {
                    def driverManager = new io.github.bonigarcia.wdm.WebDriverManager()
                    driverManager.setupChrome()
                }
                
                // Run tests
                bat 'mvn test'
            }
        }
        
        stage('Deploy') {
            steps {
                // Placeholder for deployment steps
                echo 'Deploying the application...'
                // Add actual deployment commands/scripts here
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
