node {
    stage("Say Hello"){
         properties([pipelineTriggers([cron('* * * * * ')])])
         git 'https://github.com/Nurjan87/jenkinsapril.git'
    }
}