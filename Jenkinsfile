pipeline {
    agent none

    stages {
        stage('Build') {
            agent {
                docker {
                    image 'maven:3.9.6-eclipse-temurin-21'
                    args '-v /c/jenkins-cache:/root/.m2 -u root'
                }
            }
            steps {
                sh 'echo "=== Informações do Container Build ==="'
                sh 'docker ps | grep maven'
                
                sh 'mvn clean compile -B -l build.log'
                
                sh 'cat build.log'
            }
            post {
                always {
                    archiveArtifacts artifacts: 'build.log', fingerprint: true
                }
            }
        }

        stage('Test') {
            agent {
                docker {
                    image 'maven:3.9.6-eclipse-temurin-21'
                    args '-v /c/jenkins-cache:/root/.m2 -u root'
                }
            }
            steps {
                sh 'echo "=== Informações do Container Test ==="'
                sh 'docker ps | grep maven'
                
                sh 'mvn test -B -l test.log'
                
                sh 'cat test.log'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                    archiveArtifacts artifacts: 'test.log', fingerprint: true
                }
            }
        }
    }
}
