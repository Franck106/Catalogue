pipeline {

    agent any
    triggers {
        pollSCM 'H/10 * * * *'
    }
    tools {
        maven 'maven'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Franck106/hello_web.git'
            }
        }
        stage('Compile') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                echo "-=- Test Projet -=-"
                sh 'mvn test'
            }

            post {
                success {
                    junit 'target/surefire-reports/*.xml'
                }
            }

        }
        stage('Code coverage') {
            steps {
                jacoco (
                    classPattern: 'target/classes',
                    sourcePattern: 'src/main/java',
                    exclusionPattern: 'src/test*'
                )
            }
        }
        stage('Sanity Check') {
            steps {
                echo "sanity check"
                sh 'mvn --batch-mode checkstyle:checkstyle'
            }
            post {
                always {
                    recordIssues enabledForFailure: true,
                    tools: [checkStyle(), pmdParser(pattern:'**/target/pmd.xml')]
                }
            }
        }
    }
}