node {
    stage("Pull Repo"){
        properties([parameters([string(defaultValue: 'dev', description: '''dev:  18.216.115.132
        prod: 18.223.109.202
        qa: 18.223.119.149''', name: 'Remote_instances', trim: false)])])
        git 'https://github.com/Nurjan87/jenkinsapril.git'
    }
    stage("Install Apache"){
        sh "ssh   ec2-user@${Remote_instances}    sudo yum install httpd -y"
    }
    stage("Create Index.html"){
        sh "scp  index.html  ec2-user@${Remote_instances}:/tmp"
    }
    stage("Move Files"){
        sh "ssh   ec2-user@${Remote_instances}    sudo mv /tmp/index.html  /var/www/html/index.html"
    }
    stage("Restart httpd"){
        sh "ssh   ec2-user@${Remote_instances} sudo systemctl restart  httpd"
    }
}