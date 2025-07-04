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
                sh 'mvn clean compile'
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
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'  
                }
            }
        }
        
        stage('Package') {
            agent {
                docker {
                    image 'maven:3.9.6-eclipse-temurin-21'
                    args '-v /c/jenkins-cache:/root/.m2 -u root'
                }
            }
            steps {
                sh 'mvn package' 
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true  
            }
        }
    }
    
    post {
        always {
            cleanWs()  
        }
    }
}
