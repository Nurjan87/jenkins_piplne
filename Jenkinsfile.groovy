node {
    stage("Say Hello"){
         properties([pipelineTriggers([cron('* * * * * ')])])
        sh "echo Hello ${Name}",
        sh "do something"
    }
}