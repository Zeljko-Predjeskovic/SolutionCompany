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
                sh 'mvn clean'
                sh 'mvn install'
            }
        }
        stage("test") {
            steps {
                sh "mvn -D${DBUSER} -D${DBPASSWORD} test"
            }
        }
        stage("deploy") {
            steps {
                echo 'deploy project...'
            }
        }
    }
}
