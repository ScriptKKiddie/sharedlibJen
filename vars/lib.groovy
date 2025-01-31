def build()  {
    // echo "INFO: ${message}"
    node {
        git url: "https://github.com/ScriptKKiddie/javaapp-maven"
        sh "mvn clean package"
        sh "sudo docker rm -f myjavaapp"
        sh "sudo docker build -t webdevprashant/javaapp:${BUILD_NUMBER} ."
        sh "sudo docker run  -d -p 1222:8080 --name myjavaapp webdevprashant/javaapp:${BUILD_NUMBER}" 
    }
}
    
def test()  {
    // echo "INFO: ${message}"
    node {
        sh "curl --silent http://100.25.45.100:1222/java-web-app/ |  grep -i 'Hello'"
    }
    
}

def push()  {
    // echo "INFO: Pushing"
    node {
      def dockerImage = "webdevprashant/javaapp:${BUILD_NUMBER}"
      def dockerHubUsername = "webdevprashant"
      def dockerHubPassword = ${DOCKER_HUB_PASS}

      withDockerRegistry(credentialsId: "docker-hub-credentials", url: "https://index.docker.io/v1/") {
          sh "docker build -t ${dockerImage} ."
          sh "docker login -u ${dockerHubUsername} -p ${dockerHubPassword}"
          sh "docker push ${dockerImage}"
      }
    }
}
