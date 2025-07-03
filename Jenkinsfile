pipeline {
    agent {
        docker {
            image 'maven:3.8.4-openjdk-11'
            args '-v /c/jenkins-cache:/root/.m2 -v /c/ProgramData/Jenkins/.jenkins/workspace:/home/jenkins/app --workdir=/home/jenkins/app'
        }
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
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
