def build()  {
    node {
        git url: "https://github.com/ScriptKKiddie/javaapp-maven"
        sh "mvn clean package"
        sh "sudo docker rm -f myjavaapp"
        sh "sudo docker build -t webdevprashant/javaapp:${BUILD_NUMBER} ."
        sh "sudo docker run  -d -p 1222:8080 --name myjavaapp webdevprashant/javaapp:${BUILD_NUMBER}" 
        // sh "echo 'Build'"
    }
}
    
def test()  {
    node {
        // echo "INFO: ${message}"
        sh "curl --silent http://34.234.204.200:1222/java-web-app/ |  grep -i 'Hello'"
    }
    
}

def push()  {
    echo "INFO: Pushing"
}
