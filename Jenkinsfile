pipeline {
    agent any
    
    tools {
        maven "mvn"
        jdk 'JDK11'
    }
    
    environment {
        CHROME_BIN = 'C:\\Users\\utkarshsingh01\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe' // Example path to Chrome binary
    }
    
    stages {
        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }
        
        stage('Test - Chrome') {
            steps {
                script {
                    // Set up WebDriverManager for Chrome
                    def factory = new Utils.WebDriverFactory()
                    def driver = factory.initializeDriver('chrome')
                    
                    try {
                        // Execute your test commands using the WebDriver instance
                        driver.get('https://example.com')
                        // Perform test actions...
                    } finally {
                        // Quit WebDriver instance
                        driver.quit()
                    }
                }
            }
        }
        
        stage('Test - IE') {
            steps {
                script {
                    // Set up WebDriverManager for Internet Explorer
                    def factory = new Utils.WebDriverFactory()
                    def driver = factory.initializeDriver('ie')
                    
                    try {
                        // Execute your test commands using the WebDriver instance
                        driver.get('https://example.com')
                        // Perform test actions...
                    } finally {
                        // Quit WebDriver instance
                        driver.quit()
                    }
                }
            }
        }
        
        stage('Deploy') {
            steps {
                echo 'Deploying the application...'
                // Add deployment steps if applicable
            }
        }
        
        stage('Clean Up') {
            steps {
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
