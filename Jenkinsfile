pipeline {
    agent none

    stages {
        stage('Build') {
            agent {
                docker {
                    image 'maven:3.8.4-openjdk-11'
                    args '--workdir=/home/jenkins --volume /c/jenkins-cache:/root/.m2'
                }
            }
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            agent {
                docker {
                    image 'maven:3.8.4-openjdk-11'
                    args '--workdir=/home/jenkins'
                }
            }
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    }
}