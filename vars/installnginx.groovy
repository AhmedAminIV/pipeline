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
                    sh 'sudo rm /etc/nginx/sites-available/default /etc/nginx/sites-enabled/default /var/www/html/index.nginx-debian.html'
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
