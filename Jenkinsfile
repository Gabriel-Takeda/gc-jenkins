pipeline {
    agent none

    stages {
        stage('Build') {
            agent {
                docker {
                    image 'maven:3.8.4-openjdk-11'
                    args '--workdir=/home/jenkins --volume /c/Users/Gabriel/.m2:/root/.m2'
                }
            }
            steps {
                bat 'mvn clean compile'
            }
            post {
                failure {
                    error 'Build falhou! Pipeline abortado.'
                }
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
                success {
                    echo 'Build e testes passaram!'
                }
                unstable {
                    echo 'Build OK, mas testes falharam! Status: UNSTABLE'
                }
                failure {
                    echo 'Erro inesperado durante os testes!'
                }
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    }
}