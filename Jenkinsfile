pipeline {
    agent any
    tools{
        maven 'Maven3.6.3'
        jdk 'JDK 16'
    }
    parameters {
        string(name: 'DBUSER')
        string(name: 'DBPASSWORD')
    }
    stages {
        stage("build") {
            steps {
                bat 'mvn clean'
                bat 'mvn compile'
            }
        }
        stage("test") {
            steps {
                bat "mvn -D${DBUSER} -D${DBPASSWORD} test"
            }
        }
        stage("deploy") {
            steps {
                echo 'deploy project...'
            }
        }
    }
}
