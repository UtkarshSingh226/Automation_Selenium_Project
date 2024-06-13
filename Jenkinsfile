pipeline {
    agent any // Run this pipeline on any available agent
    
    tools { // Define tools required for the pipeline
        maven "mvn" // Use Maven tool named 'mvn'
        jdk 'JDK11' // Use JDK installation named 'JDK11'
    }
    
    stages { // Define stages of the pipeline
        stage('Build') { // Build stage for cleaning and building the Maven project
            steps {
                // Clean and build the Maven project
                bat 'mvn clean'
            }
            post {
                success {
                    echo 'Build stage executed successfully!' // Print success message if build stage completes successfully
                }
            }
        }
        
        stage('Test') { // Test stage for running tests
            steps {
                // Run tests; '|| true' ensures the stage does not fail on test failures
                bat 'mvn clean test -DsuiteXMLFile=testng.xml || true'
            }
            post {
                success {
                    echo 'Test stage executed successfully!' // Print success message if test stage completes successfully
                }
                
                always {
                    // Archive test results for Jenkins to parse and display
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        
        stage('Clean Up') { // Clean Up stage for final cleanup after tests
            steps {
                // Clean up any temporary files or resources
                bat 'mvn clean'
            }
            post {
                success {
                    echo 'Clean Up stage executed successfully!' // Print success message if clean up stage completes successfully
                }
            }
        }
    }
    
    post {
        always {
            // Clean up workspace and perform any final actions after all stages
            cleanWs()
        }
        
        success {
            echo 'Pipeline executed successfully!' // Print success message if entire pipeline completes successfully
        }
        
        failure {
            echo 'Pipeline executed with failures.' // Print failure message if pipeline encounters failures
        }
    }
}
