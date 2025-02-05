pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }
        stage('Setup Environment') {
            steps {
                sh 'sudo apt update && sudo apt install -y google-chrome-stable'
                sh 'wget -q https://chromedriver.storage.googleapis.com/114.0.5735.90/chromedriver_linux64.zip'
                sh 'unzip chromedriver_linux64.zip && sudo mv chromedriver /usr/local/bin/'
            }
        }
        stage('Build & Run Tests') {
            steps {
                sh 'mvn clean test'
            }
        }
        stage('Publish Reports') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }
    }
}
