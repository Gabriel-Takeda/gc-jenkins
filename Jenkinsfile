pipeline {
    agent none

    stages {
        stage('Build') {
            agent {
                docker {
                    image 'maven:3.9.6-eclipse-temurin-21'
                    args "-v ${env.WORKSPACE}/.m2:/root/.m2"
                }
            }
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            agent {
                docker {
                    image 'maven:3.9.6-eclipse-temurin-21'
                    args "-v ${env.WORKSPACE}/.m2:/root/.m2"
                }
            }
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    }
}
