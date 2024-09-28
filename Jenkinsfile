pipeline {
    agent any

    tools{
        maven "maven"
        //jdk "java17"
        //docker"docker"
    }

    stages {
        stage('clone it to jenkins') {
            steps {
                //resolveScm source: [$class: 'GitSCMSource', credentialsId: 'YasinDeger48-Github', id: '_', remote: 'https://github.com/YasinDeger48/devops-002-pipeline.git', traits: [gitBranchDiscovery()]], targets: ['master']
                //resolveScm source: [$class: 'GitSCMSource', credentialsId: '', id: '_', remote: 'https://github.com/YasinDeger48/devops-002-pipeline.git', traits: [gitBranchDiscovery()]], targets: ['master']
                //git 'https://github.com/YasinDeger48/devops-002-pipeline.git'
                git credentialsId: 'GITHUB-YasinDeger48', url: 'https://github.com/YasinDeger48/devops-002-pipeline.git'
            }
        }
        stage('build maven project') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('clean up old docker images') {
            steps {
                //kullanılmayan tüm docker imagelarını siliyorum.
                sh 'docker image prune -a -f'
                //sh 'docker rm $(docker ps -a -q --filter "status=exited") || true'
                //sh 'docker rmi $(docker images -f \"dangling=true\" -q) || true'
            }
        }

        stage('build docker image') {
            steps {
                //sh 'docker build -t yasindeger48/devops-002-hello .'
                sh 'docker build --build-arg JAR_FILE=target/devops-app.jar -t yasindeger48/$JOB_NAME:v$BUILD_ID .'
                sh 'docker build --build-arg JAR_FILE=target/devops-app.jar -t yasindeger48/$JOB_NAME:latest .'
                //sh 'docker build --build-arg JAR_FILE=target/devops-app.jar --tag yasindeger48/devops-002-hello .'
            }
        }
        stage('Unit Tests') {
            steps {
                // execute all unit tests
                sh "mvn test"
            }
        }
                stage('Integration Tests') {
            steps {
                // execute all integration tests
                sh "mvn test"
            }
        }
        stage('E2E Tests') {
            steps {
                // execute all E2E tests
                sh "mvn test"
            }
        }


        stage('SpotBugs Analysis') {
            steps {
                // SpotBugs ile kod analizini yapma
                sh 'mvn verify'
            }
        }
        stage('push to docker hub') {
            steps {
              withCredentials([usernamePassword(credentialsId: 'DockerHUB-YasinDeger48', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                    sh 'docker push yasindeger48/$JOB_NAME:v$BUILD_ID'
                    sh 'docker push yasindeger48/$JOB_NAME:latest'
                    }
               }
        }
                stage('Check Files') {
            steps {
                sh 'ls -la'
            }
        }
        stage('push to kubernetes') {
            steps {
                kubernetesDeploy(
                    configs: 'k8s/deployment-service.yaml',
                    kubeconfigId: 'kubeconfig'  // Jenkins Credentials'da tanımladığınız ID
                )
            }

        }
    }
}
