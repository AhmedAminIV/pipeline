def call(){
    pipeline {
        agent { label 'ubuntu-ec2' }
        stages {
            stage('install_nginx') { 
                steps {
                    sh 'sudo apt-get install nginx -y'
                }
            }
            stage('enable_firewall') { 
                steps {
                    sh "sudo ufw allow 'Nginx HTTP'"
                }
            }
            stage('Test') { 
                steps {
                    sh 'sudo service nginx status' 
                }
            }
        }
    }
}
