node {
    stage("Say Hello"){
        properties([parameters([string(defaultValue: 'Dev', description: '''dev:  18.216.115.132
        prod: 18.223.109.202
        qa: 18.223.119.149''', name: 'Remote_instances', trim: false)])])
        git 'https://github.com/Nurjan87/jenkinsapril.git'
    }
}