pipeline {
    agent any

 

    environment {
        HEADLESS_MODE = 'true' // Define headless mode in Jenkins pipeline
        DISPLAY = ':99' // Set display variable for headless execution
    }

 

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', credentialsId: 'gitlab-credentials', url: 'http://localhost/user1/myseleniumtest.git'
            }
        }

 

        stage('Setup Headless Environment') {
            steps {
                script {
                    echo "Starting virtual display (Xvfb)..."
                    sh 'Xvfb :99 -screen 0 1920x1080x24 &'
                    sh 'export DISPLAY=:99'
                }
            }
        }

 

        stage('Compile Java') {
            steps {
                script {
                    echo 'Compiling Java code with Selenium dependencies...'
                    sh 'javac -cp .:/selenium/Selenium4.11/* -d . src/WebAutomation.java'
                }
            }
        }

 

        stage('Run Application') {
            steps {
                script {
                    echo "Running Selenium with headless mode: ${env.HEADLESS_MODE}..."
                    sh "export DISPLAY=:99 && java -cp .:/selenium/Selenium4.11/* WebAutomation"
                }
            }
        }
    }

 

    post {
        always {
            echo 'Pipeline execution complete.'
        }
    }
}
