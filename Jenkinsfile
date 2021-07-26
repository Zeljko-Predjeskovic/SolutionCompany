pipeline {
    agent any
    tools{
        maven 'Maven3.6.3'
    }
    parameters {
        string(name: 'dbuser')
        string(name: 'dbpassword')
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
                sh "mvn -D${dbuser} -D${dbpassword} test"
            }
        }
        stage("deploy") {
            steps {
                echo 'deploy project...'
            }
        }
    }
}
