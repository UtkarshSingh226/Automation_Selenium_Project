pipeline {
    agent any // Specifies that the pipeline can run on any available agent (Jenkins node)

    tools { // Defines tools required for the pipeline
        maven 'mvn' // Specifies the Maven tool named 'mvn'
        jdk 'JDK11' // Ensure this matches the JDK installation name in Jenkins
    }

    triggers { // Defines triggers for the pipeline
        cron('H H(8-15)/2 * * 1-5') // Cron trigger to run the pipeline every 2 hours between 8 AM and 3 PM, Monday through Friday
    }

    stages { // Defines stages of the pipeline
        stage('Build') { // First stage: Build
            steps { // Steps to be executed in this stage
                bat 'mvn clean' // Executes Maven clean command to build the project
            }
        }

        stage('Test - Chrome') { // Second stage: Test on Chrome
            environment { // Defines environment variables for this stage
                CHROME_DRIVER_PATH = env.CHROME_DRIVER_PATH // Path to ChromeDriver executable
                CHROME_BIN_PATH = env.CHROME_BIN // Path to Chrome executable
            }
            steps { // Steps to be executed in this stage
                script {
                    try {
                        // Set environment variables for ChromeDriver and Chrome binary
                        bat "set WEBDRIVER_CHROME_DRIVER=%CHROME_DRIVER_PATH%"
                        bat "set CHROME_BIN=%CHROME_BIN_PATH%"

                        // Executes Maven test command with Chrome as the browser
                        bat 'mvn test -Dbrowser=chrome'
                    } catch (e) {
                        unstable('Tests failed!') // Sets the build status to unstable if tests fail
                        echo "Tests failed" // Outputs a message indicating test failure
                    } 
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
