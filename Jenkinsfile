@Library('original-library') _

pipeline {
    agent any
    // ***** TODO: Identificar em que grupo ficará a aplicação
    environment {
    GRUPO = 'corporativo'
    }

    stages {
        stage ("Checkout"){
            steps {
                originalCheckout()
            }
        }
        stage ("Build") {
            steps {
                originalMavenBuild()
            }
        }
        stage ("Analysis") {
           steps { 
               originalMavenSonarqube()
           }
        }
        stage ("Quality Gate") {
           steps { 
               originalMavenQualityGates()
           }
        }
        stage ("Publish") {
            steps {
                originalMavenPublish()
            }
        }
        stage ("Docker") {
            steps {
                originalDockerBuildMicroservice()
            }
        }
        stage ("Deploy") {
            steps {
                originalDockerDeployMicroserviceCrypto()
            }
        }
    }
}
